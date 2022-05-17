package com.myecommapp.dao;

import com.myecommapp.model.Product;

public interface ProductDAO {
	Product getProductByName(String productName);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
}
