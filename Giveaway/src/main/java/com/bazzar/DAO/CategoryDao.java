package com.bazzar.DAO;

import java.util.List;

import com.bazzar.model.Category;

public interface CategoryDao

{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
}