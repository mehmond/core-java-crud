package com.myecommapp.repository;

import com.myecommapp.dao.CategoryDAO;
import com.myecommapp.model.Category;
import com.myecommapp.utility.DBConnection;

import java.sql.*;

public class CategoryRepository implements CategoryDAO {
	DBConnection db;
	Connection con;

	public CategoryRepository() {
		super();
		db = new DBConnection();
		con = db.getConnection();
	}

	@Override
	public Category getByName(String categoryName) {
		Category cat = new Category();
		try {
			final String SQL_QUERY = "select * from categoies where category_name = ?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, categoryName);
			ResultSet rs = stmt.executeQuery();
			if (!rs.first()) {
				return null;
			} else {
				cat.setCategoryId(rs.getString(1));
				cat.setCategoryName(rs.getString(2));
				return cat;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(Category category) {
		try {
			final String SQL_QUERY = "insert into categories ( category_name ) values (?)";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, category.getCategoryName().trim());
			stmt.executeUpdate();
			con.close();
			System.out.println("Category Added!");
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Category category) {
		try {
			final String SQL_QUERY = "delete from categories where category_id = ?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			stmt.setString(1, category.getCategoryId().trim());
			stmt.executeQuery();
			con.close();
			System.out.println("Category Deleted");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Category category) {
		try {
			final String SQL_QUERY = "UPDATE categories SET category_name=? WHERE category_id=?";
			PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
			System.out.println(category.getCategoryName());
			stmt.setString(1, category.getCategoryName().trim());
			stmt.setString(2, category.getCategoryId().trim());
			stmt.executeUpdate();
			con.close();
			System.out.println("Product has been succecfully updated!");
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

}
