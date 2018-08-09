package com.fpt.topgun.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.topgun.dto.OrderDto;
import com.fpt.topgun.dto.OrderInputDto;
import com.fpt.topgun.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderController {
  
  private static final Logger logger = LogManager.getLogger(OrderController.class);

  private OrderService service;
  
  /**
   * This contructor using to delare service.
   * @param service to use
   */
  @Autowired
  public OrderController(OrderService service) {
    super();
    this.service = service;
  }
  
  /**
   * This method using to create order.
   */
  @ApiOperation(value = "create order", response = OrderDto.class)
  @RequestMapping(value = "/order/", method = RequestMethod.PUT)
  public OrderDto createOrder(@Valid @RequestBody OrderInputDto dto) {
    logger.info("Create Order.");
    return service.createOrder(dto);
  }
  
  /**
   * This method using to get all order.
   */
  @ApiOperation(value = "get all order", response = String.class)
  @RequestMapping(value = "/order", 
      method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<OrderDto> getAllOrder() {
    logger.info("Get all orders.");
    return service.getAllOrder();
  }
  
}

