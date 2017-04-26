package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.objects.Customer;
import com.market.objects.Product;

@Service
public interface MarketService {

	public boolean addItem(Customer customer, Product product);

	public List<Product> getItemList(Customer customer);
	
	public List<Customer> searchCustomer(Customer customer);

}
