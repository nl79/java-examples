package com.nazar.product.bo;

import com.nazar.product.dto.Product;

public interface ProductBO {
	
	public void create(Product product);
	
	public Product find(int id);

}
