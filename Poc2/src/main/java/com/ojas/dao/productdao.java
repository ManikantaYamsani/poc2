package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.Product;

@Repository
public interface productdao extends JpaRepository<Product, Integer>{

}
