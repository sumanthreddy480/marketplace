package com.market.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.market.objects.Product;

@Repository
public interface MarketDao {
	
	public int addItem(String customerName, Product product);

	public List<Product> getItemList();

}
