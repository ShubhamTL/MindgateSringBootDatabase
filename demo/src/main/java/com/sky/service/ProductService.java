package com.sky.service;

import java.util.List;

import com.sky.domain.Product;

public interface ProductService {
	
	public void addProduct( Product porduct);
	public List<Product> getProduct();
	public Product getProductById(String id);
	public void deleteProductById(String id);
	public Product updateProduct( Product newporduct);
}
