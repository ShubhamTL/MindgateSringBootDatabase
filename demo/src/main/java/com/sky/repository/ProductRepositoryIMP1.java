package com.sky.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.domain.Product;
@Repository
public class ProductRepositoryIMP1 implements ProductRepository {

	private static List<Product> products= new ArrayList<Product>();
	@Override
	public void addProduct(Product porduct) {

		System.out.println("in reposuitrory");
		products.add(porduct);
	}

	@Override
	public List<Product> getProduct() {
		
		return products;
	}

	@Override
	public Product getProductById(String id) {
		for (Product product : products) {
			if(id.equals(product.getProductId())) {
				return product;
			}
				else
					return null;
			}
		return null;
		}

	@Override
	public void deleteProductById(String id) {
	 
		int index = 0;
		for (Product product : products) {
			if(product.getProductId().equals(id))
			{
				products.remove(index);
				
			}
			index++;
		}
	}

	@Override
	public Product updateProduct(Product newporduct) {
		int index = 0;
		for (Product product : products) {
			if(product.getProductId().equals(newporduct.getProductId()))
			{
				products.set(index, newporduct);
				return newporduct;
			}
			index++;
		}
		
		return null;
		
		
	}

	

	
	

}
