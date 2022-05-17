package com.myecommapp.model;

import java.util.HashMap;

import com.myecommapp.validator.Validator;



public class Category extends Validator {
	private String categoryId;
	private String categoryName;

	public Category() {
		super();
		errorMessage=new HashMap<String,String>();
	}

	public Category(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public HashMap<String, String> validate()
    {
        String message;
        String field;
        String emptyField="Field cannot be empty";
        Validator validator = new Validator();
        if(this.getCategoryName().isEmpty())
        {
            message="Field can't be empty";
            field="Category Name";
            errorMessage.put(field,emptyField);
        }        
                
        return errorMessage;
    }

}
