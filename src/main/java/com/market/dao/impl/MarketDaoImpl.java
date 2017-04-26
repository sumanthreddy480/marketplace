package com.market.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.market.dao.MarketDao;
import com.market.logging.MarketExceptionLog;
import com.market.objects.Customer;
import com.market.objects.Product;

@Repository
public class MarketDaoImpl implements MarketDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addItem(Customer customer, Product product) {

		int addedItem = 0;

		StringBuffer sql = new StringBuffer();

		try {
			sql.append("	INSERT INTO mrktcustomer(customerid, customername) VALUES(?, ?)		");
			
			int customerCount = jdbcTemplate.update(sql.toString(), customer.getCustomerId(), customer.getCustomerName());
			
			if (customerCount > 0) {
				sql.delete(0, sql.length());
				sql.append("	INSERT INTO itemlist(customerid, itemid, item, price)	")
				   .append("		VALUES(?, ?, ?, ?)									");

				addedItem = jdbcTemplate.update(sql.toString(), new Object[] { customer.getCustomerId(),
						product.getProductId(), product.getProductName(), product.getProductPrice() });
			}

		} catch (Exception e) {
			MarketExceptionLog.catchException(
					"Exception In MarketDaoImpl.addItem() : " + MarketExceptionLog.getStackTraceAsString(e));
		}

		return addedItem;
	}

	@Override
	public List<Product> getItemList(Customer customer) {
		
		List<Product> itemList = null;
		
		StringBuffer sql = new StringBuffer();
		
		try {
			
			sql.delete(0, sql.length());
			sql.append("	SELECT customerid, itemid, item, price		")
			   .append("		FROM itemlist WHERE customerid = ?		");
			
			itemList = jdbcTemplate.query(sql.toString(), new Object[]{customer.getCustomerId()}, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int no) throws SQLException {
					
					Product prod1 = new Product();
					
					prod1.setProductId(rs.getString("itemid"));
					prod1.setProductName(rs.getString("item"));
					prod1.setProductPrice(rs.getString("price"));
					 
					return prod1;
				}
			});
		} catch (Exception e) {
			MarketExceptionLog.catchException(
					"Exception In MarketDaoImpl.getItemList() : " + MarketExceptionLog.getStackTraceAsString(e));
		}
		
		return itemList;
	}

	@Override
	public List<Customer> searchCustomer(Customer customer) {
		
		List<Customer> listCustomer = null;
		
		StringBuffer sql = new StringBuffer();
		
		try { 
			
			sql.append("	SELECT customerid, customername FROM mrktcustomer 			")
			   .append("	WHERE customername like ?	"); 
			
			 listCustomer = jdbcTemplate.query(sql.toString(), new Object[]{"%"+customer.getCustomerName()+"%"}, new RowMapper<Customer>() {

				@Override
				public Customer mapRow(ResultSet rs, int no) throws SQLException {
					
					Customer custmr = new Customer();
					
					custmr.setCustomerId(rs.getString("customerid"));
					custmr.setCustomerName(rs.getString("customername"));
					System.out.println(custmr.getCustomerName());
					return custmr;
				}
			});
		} catch (Exception e) {
				MarketExceptionLog.catchException(
						"Exception In MarketDaoImpl.searchCustomer() : " + MarketExceptionLog.getStackTraceAsString(e));
		}
		
		
		return listCustomer;
	}

}
