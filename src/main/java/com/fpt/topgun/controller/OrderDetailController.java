package com.fpt.topgun.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.topgun.dto.OrderDetailDto;
import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.service.OrderDetailService;
import com.fpt.topgun.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderDetailController {
  
  private static final Logger logger = LogManager.getLogger(OrderDetailController.class);
  
	private OrderDetailService service;
	
	private ProductService productService;

	/**
	 * This contructor using to delare service.
	 * 
	 * @param service
	 *            to use
	 */
	@Autowired
	public OrderDetailController(OrderDetailService service, ProductService productService) {
		this.service = service;
		this.productService = productService;
	}

	/**
	 * This method using to get all orderDetail.
	 */
	@ApiOperation(value = "get all orderDetail", response = String.class)
	@RequestMapping(value = "/order-detail", 
					method = RequestMethod.GET, 
					produces = "application/json")
	@ResponseBody
	public List<OrderDetailDto> getAllOrderDetail() {
	  logger.info("Get all details.");
		return service.getAllOrderDetail();
	}

	/**
	 * This method using to get all orderDetail by orderId.
	 */
	@ApiOperation(value = "get all orderDetail by orderId", response = String.class)
	@RequestMapping(value = "/order-detail/order", 
					method = RequestMethod.GET, 
					produces = "application/json")
	@ResponseBody
	public List<OrderDetailDto> getAllOrDeByOrId(@RequestParam int id) {
	  logger.info("Get all orders by Id.");
	  return service.getAllOrDeByOrId(id);
	}

	@ApiOperation(value = "get all orderDetail by product", response = String.class)
	@RequestMapping(value = "/order-detail/product/{id}", 
					method = RequestMethod.GET, 
					produces = "application/json")
	@ResponseBody
	public List<OrderDetailDto> getByProduct(@PathVariable int id) {
	  logger.info("Get all orders by productId.");
	  return service.getAllOrDeByProdId(id);
	}

}
