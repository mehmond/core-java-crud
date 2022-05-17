package com.myecommapp.model;

import java.util.HashMap;

import com.myecommapp.validator.Validator;

public class Product extends Validator {
	private String productId;
	private String productName;
	private String categoryId;
	private Float productPrice;
	private String productImage;
	private String productAvailableQty;
	public Product() {
		super();
		errorMessage = new HashMap<String, String>();
	}
	
	public Product(String productId, String productName, String categoryId, Float productPrice, String productImage,
			String productAvailableQty) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productAvailableQty = productAvailableQty;
	}

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductAvailableQty() {
		return productAvailableQty;
	}

	public void setProductAvailableQty(String productAvailableQty) {
		this.productAvailableQty = productAvailableQty;
	}

	public HashMap<String, String> validate() {
		String message;
		String field;
		String emptyField = "Field cannot be empty";
		Validator validator = new Validator();
		if (this.getProductName().isEmpty()) {
			message = "Field can't be empty";
			field = "product name";
			errorMessage.put(field, emptyField);
		}
		if (this.getCategoryId().isEmpty()) {
			message = "Field can't be empty";
			field = "Category Id";
			errorMessage.put(field, emptyField);
		}

		return errorMessage;
	}

}
