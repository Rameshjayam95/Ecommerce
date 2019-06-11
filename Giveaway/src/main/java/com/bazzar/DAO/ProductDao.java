package com.bazzar.DAO;

import java.util.List;

import com.bazzar.model.Product;

public interface ProductDao 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProduct();
}
