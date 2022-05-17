package com.myecommapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myecommapp.dao.ProductDAO;
import com.myecommapp.model.Product;
import com.myecommapp.utility.DBConnection;

public class ProductRepository implements ProductDAO {
	DBConnection db;
	Connection con;
	
	
	public ProductRepository() {
		super();
		db = new DBConnection();
		con = db.getConnection();
	}

	@Override
	public Product getProductByName(String productName) {
		Product prod = new Product();
		try {
			final String SQL_QUERY = "select * from products where product_name = ?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, productName);
			ResultSet rs = stmt.executeQuery();
			if (!rs.first()) {
				return null;
			} else {
				prod.setProductId(rs.getString(1));
				prod.setProductName(rs.getString(2));
				prod.setCategoryId(rs.getString(3));
				prod.setProductPrice(rs.getFloat(4));
				prod.setProductImage(rs.getString(5));
				prod.setProductAvailableQty(rs.getString(6));
				return prod;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		try {
			final String SQL_QUERY = "insert into products (product_name, category_id, product_price, product_image, product_available_qty)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getCategoryId());
			stmt.setFloat(3, product.getProductPrice());
			stmt.setString(4, product.getProductImage());
			stmt.setString(5, product.getProductAvailableQty());
			stmt.executeQuery();
			con.close();
			System.out.println("Product has been successfully added..");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			final String SQL_QUERY = "update products set product_name = ?, category_id = ?, product_price = ?, product_image = ?, "
					+ "product_available_qty = ? where product_id = ? ";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getCategoryId());
			stmt.setFloat(3, product.getProductPrice());
			stmt.setString(4, product.getProductImage());
			stmt.setString(5, product.getProductAvailableQty());
			stmt.setString(6, product.getProductId());
			stmt.executeQuery();
			con.close();
			System.out.println("Product has been successfully updated..");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			final String SQL_QUERY = "delete from products where product_id = ? ";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, product.getProductId());
			stmt.executeQuery();
			con.close();
			System.out.println("Product has been successfully deleted..");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
