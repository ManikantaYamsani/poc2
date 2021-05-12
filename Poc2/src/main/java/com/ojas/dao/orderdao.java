package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.Order;
@Repository
public interface orderdao extends JpaRepository<Order, Integer>{

}
