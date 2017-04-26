package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.objects.Product;

@Service
public interface MarketService {

	public boolean addItem(String customerName, Product product);

	public List<Product> getItemList();

}
