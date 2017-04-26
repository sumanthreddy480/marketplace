package com.market.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.market.objects.Customer;
import com.market.objects.Product;

@Repository
public interface MarketDao {
	
	public int addItem(Customer customer, Product product);

	public List<Product> getItemList(Customer customer);

	public List<Customer> searchCustomer(Customer customer);

}
