package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.common.Utilities;
import com.market.dao.MarketDao;
import com.market.logging.MarketExceptionLog;
import com.market.objects.Customer;
import com.market.objects.Product;
import com.market.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService {

	@Autowired
	private MarketDao marketDao;

	@Override
	public boolean addItem(Customer customer, Product product) {

		boolean isItemAdded = false;

		String customerId = Utilities.generateRandom(8);
		customer.setCustomerId(customerId);

		String itemId = Utilities.generateRandom(5);
		product.setProductId(itemId);

		try {
			int addedItem = marketDao.addItem(customer, product);

			if (addedItem >= 1) {
				isItemAdded = true;
			}
		} catch (Exception e) {
			MarketExceptionLog.catchException(
					"Exception In MarketServiceImpl.addItem() : " + MarketExceptionLog.getStackTraceAsString(e));
		}

		return isItemAdded;
	}

	@Override
	public List<Product> getItemList(Customer customer) {

		return marketDao.getItemList(customer);
	}

	@Override
	public List<Customer> searchCustomer(Customer customer) {

		return marketDao.searchCustomer(customer);
	}

}
