package com.nazar.product.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nazar.product.dto.Product;

public class ProductDAOImplTest {

	@Test
	public void createShouldCreateProduct() {
		ProductDAO dao = new ProductDAOImpl();
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDescription("Its awesome");
		product.setPrice(800);
		
		dao.create(product);
		
		Product result = dao.read(1);
		assertNotNull(result);
		assertEquals("Iphone", result.getName());
	}

}
