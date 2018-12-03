package com.nazar.springweb;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.nazar.springweb.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductrestapiApplicationTests {
	
	@Value("${productrestapi.services.url}")
	private String baseUrl;

	@Test
	public void testGetProduct() {
		System.out.println("BaseUrl: " + baseUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject( baseUrl + "/1", Product.class);
		
		assertNotNull(product);
		assertEquals("IPHone", product.getName());
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("Its awesome");
		product.setPrice(10000);
		Product newProduct = restTemplate.postForObject(baseUrl, product, Product.class);
		
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung", newProduct.getName());
	}
	
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl + "/1", Product.class);
		product.setPrice(1400);
		restTemplate.put(baseUrl, product);
		
	}
	
	

}
