package com.nazar.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
