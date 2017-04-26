package com.market.objects;

import java.util.List;

public class Customer {

	private String customerId;
	private String customerName;
	private int customerAge;
	private List<Product> customerProduct;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public List<Product> getCustomerProduct() {
		return customerProduct;
	}

	public void setCustomerProduct(List<Product> customerProduct) {
		this.customerProduct = customerProduct;
	}

}
