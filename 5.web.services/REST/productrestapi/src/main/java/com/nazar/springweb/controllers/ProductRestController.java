package com.nazar.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.springweb.entities.Product;
import com.nazar.springweb.repos.ProductRepository;

import java.util.List;

@RestController
public class ProductRestController {

	@Autowired
	ProductRepository repository;
	
	@RequestMapping(value="/products/", method=RequestMethod.GET)
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/products/", method = RequestMethod.POST)
	public Product createProduct(Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/", method = RequestMethod.PUT)
	public Product updateProduct(Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
	
	
	
}
