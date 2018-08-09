package com.fpt.topgun.service;

import java.util.List;

import com.fpt.topgun.dto.OrderDetailDto;

public interface OrderDetailService {

  List<OrderDetailDto> getAllOrderDetail();
  
  List<OrderDetailDto> getAllOrDeByOrId(int id);

  List<OrderDetailDto> getAllOrDeByProdId(int id);
}
