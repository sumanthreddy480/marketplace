package com.market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.market.objects.Customer;
import com.market.objects.Product;
import com.market.service.MarketService;

@Controller
public class MarketController {

	@Autowired
	private MarketService marketService;

	@RequestMapping(value = "/market", method = RequestMethod.GET)
	public ModelAndView getMarketHomePage(HttpServletRequest request, HttpServletResponse response) {

		// List<Product> productList = marketService.getItemList();
		//
		// request.setAttribute("productList", productList);

		return new ModelAndView("/markethome");
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView addProductToMarketPlace(HttpServletRequest request, HttpServletResponse response,
			Customer customer, Product product) {

		boolean itemadded = marketService.addItem(customer, product);

		if (itemadded == true) {
			request.setAttribute("message", "Item Added Successfully");
		} else {
			request.setAttribute("message", "Problem Adding an Item, Try Again");
		}

		List<Product> productList = marketService.getItemList(customer);

		request.setAttribute("productList", productList);

		return new ModelAndView("/productlist");
	}

	@RequestMapping(value = "/searchcustomer", method = RequestMethod.POST)
	public ModelAndView searchCustomerByName(HttpServletRequest request, HttpServletResponse response,
			Customer customer) {

		List<Customer> listCustomer = marketService.searchCustomer(customer);
		request.setAttribute("listCustomer", listCustomer);

		return new ModelAndView("/customerlist");
	}
}
