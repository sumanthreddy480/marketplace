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
import com.market.objects.Product;

@Repository
public class MarketDaoImpl implements MarketDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addItem(String customerName, Product product) {

		int addedItem = 0;

		StringBuffer sql = new StringBuffer();

		try {
			sql.append("	INSERT INTO itemlist(itemid, item, price)	")
			   .append("		VALUES(?, ?, ?)							");

			addedItem = jdbcTemplate.update(sql.toString(),
					new Object[] { product.getProductId(), product.getProductName(), product.getProductPrice() });

		} catch (Exception e) {
			MarketExceptionLog.catchException(
					"Exception In MarketDaoImpl.addItem() : " + MarketExceptionLog.getStackTraceAsString(e));
		}

		return addedItem;
	}

	@Override
	public List<Product> getItemList() {
		
		List<Product> itemList = null;
		
		StringBuffer sql = new StringBuffer();
		
		try {
			sql.append("	SELECT itemid, item, price		")
			   .append("		FROM itemlist				");
			
			itemList = jdbcTemplate.query(sql.toString(), new RowMapper<Product>() {

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

}
