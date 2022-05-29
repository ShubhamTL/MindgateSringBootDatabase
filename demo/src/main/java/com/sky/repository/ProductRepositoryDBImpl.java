package com.sky.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.domain.Product;

@Repository("ProductRepositoryDBImpl")
public class ProductRepositoryDBImpl implements ProductRepository {
	
	private static String INSERT_PRODUCT_SQL = "insert into product (PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE) values(?,?,? )";
	private static String ALL_PRODUCT_SQL = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE FROM PRODUCT";
	private static String GET_PRODUCT_BY_ID="SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE FROM PRODUCT WHERE PRODUCT_ID=?";
	private static String DELETE_PRODUCT_BY_ID="DELETE FROM PRODUCT WHERE PRODUCT_ID=?";
	private static String UPDATE_PRODUCT="UPDATE PRODUCT SET PRODUCT_NAME=?,PRODUCT_PRICE=? WHERE PRODUCT_ID=?";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addProduct(Product product) {
		jdbcTemplate.update(INSERT_PRODUCT_SQL, product.getProductId(), product.getProductName(), product.getPrice());			
	}
	

	@Override
	public List<Product> getProduct() {

		return this.jdbcTemplate.query(ALL_PRODUCT_SQL, new ProductRowmapper());
	}
	private static final class ProductRowmapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new  Product();
			product.setProductId(rs.getString("PRODUCT_ID"));
			product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setPrice(rs.getInt("PRODUCT_PRICE"));
			return product;
		}
		
	}

	@Override
	public Product getProductById(String id) {

		return this.jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, new Object[] {id}, new ProductRowmapper());
	}

	@Override
	public void deleteProductById(String id) {

		 this.jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
	}

	@Override
	public Product updateProduct(Product newporduct) {

		
		this.jdbcTemplate.update(UPDATE_PRODUCT,new Object[] { newporduct.getProductName(), newporduct.getPrice(), newporduct.getProductId()});
	return null;
	}

}
