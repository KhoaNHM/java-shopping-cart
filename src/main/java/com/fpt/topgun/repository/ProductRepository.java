package com.fpt.topgun.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.topgun.entity.Category;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findAllProductByName(String name);

  List<Product> findAllProductByCategory(Category category);
  
  List<Product> findAllProductByOrderDetail(OrderDetail idorder);
  
  @Transactional
  void deleteByName(String name);
}
