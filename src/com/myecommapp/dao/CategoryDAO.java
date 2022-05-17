package com.myecommapp.dao;

import com.myecommapp.model.Category;

public interface CategoryDAO {
	Category getByName(String categoryName);
	boolean add(Category category);
	boolean delete(Category category);
	boolean update(Category category);
}
