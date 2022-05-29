package com.sky.repository;

import java.util.List;

import com.sky.domain.Product;

public interface ProductRepository {

	
	public void addProduct( Product porduct);
	public List<Product> getProduct();
	public Product getProductById(String id);
	public void deleteProductById(String id);
	public Product updateProduct( Product newporduct);
}
