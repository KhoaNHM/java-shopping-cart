package com.fpt.topgun.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.topgun.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {


  List<Order> findAllByOrderNameAndOrderPhone(String orderName,String orderPhone);

  @Transactional
  void deleteByOrderName(String orderName);
  
  
  
  
}
