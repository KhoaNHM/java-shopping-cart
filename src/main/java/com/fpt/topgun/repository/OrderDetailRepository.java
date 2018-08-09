package com.fpt.topgun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.topgun.entity.Order;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findOrderDetailByProduct(Product idProduct);
	
	List<OrderDetail> findAllOrderDetailByOrder(Order order);
	
	
}
