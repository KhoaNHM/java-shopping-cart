package com.fpt.topgun.service;

import java.util.List;

import com.fpt.topgun.dto.OrderDto;
import com.fpt.topgun.dto.OrderInputDto;

public interface OrderService {
 
  OrderDto createOrder(OrderInputDto orderDto);
  
  List<OrderDto> getAllOrder();
}
