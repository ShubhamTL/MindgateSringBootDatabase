package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sky.domain.Product;
import com.sky.repository.ProductRepository;

@Service
public class ProductServiceIMP1 implements ProductService{

	@Autowired
	@Qualifier("ProductRepositoryDBImpl")
	private ProductRepository productRepository;
	@Override
	public void addProduct(Product product) {

		System.out.println("in Service");
		if(product.getPrice()>20) {
			productRepository.addProduct(product);
		}
	}

	@Override
	public List<Product> getProduct() {
		
		return productRepository.getProduct();
	}

	@Override
	public Product getProductById(String id) {
		return productRepository.getProductById(id);
	}

	@Override
	public void deleteProductById(String id) {
		
		 productRepository.deleteProductById(id);
	}

	@Override
	public Product updateProduct(Product newporduct) {

		return productRepository.updateProduct(newporduct);
	}

}
