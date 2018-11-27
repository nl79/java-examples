package com.nazar.product.bo;

import com.nazar.product.dao.ProductDAO;
import com.nazar.product.dto.Product;

public class ProductBOImpl implements ProductBO {

	private ProductDAO dao;
	@Override
	public void create(Product product) {
		dao.create(product);
	}

	@Override
	public Product find(int id) {
		return dao.read(id);
	}

	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

}
