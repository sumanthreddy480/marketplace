package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.common.Utilities;
import com.market.dao.MarketDao;
import com.market.logging.MarketExceptionLog;
import com.market.objects.Product;
import com.market.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService {

	@Autowired
	private MarketDao marketDao;

	@Override
	public boolean addItem(String customerName, Product product) {

		boolean isItemAdded = false;

		String itemId = Utilities.generateRandom(5);

		product.setProductId(itemId);

		try {
			int addedItem = marketDao.addItem(customerName, product);

			if (addedItem >= 1) {
				isItemAdded = true;
			}
		} catch (Exception e) {
			MarketExceptionLog.catchException("Exception In MarketServiceImpl.addItem() : " + MarketExceptionLog.getStackTraceAsString(e));
		}

		return isItemAdded;
	}

	@Override
	public List<Product> getItemList() {

		return marketDao.getItemList();
	}

}
