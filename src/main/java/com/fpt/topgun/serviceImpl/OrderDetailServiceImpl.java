package com.fpt.topgun.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.topgun.controller.CategoryController;
import com.fpt.topgun.dto.OrderDetailDto;
import com.fpt.topgun.entity.Order;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;
import com.fpt.topgun.exception.ProductException;
import com.fpt.topgun.repository.OrderDetailRepository;
import com.fpt.topgun.repository.OrderRepository;
import com.fpt.topgun.repository.ProductRepository;
import com.fpt.topgun.service.OrderDetailService;
import com.fpt.topgun.utils.AdapEntityDto;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

  private static final Logger logger = LogManager.getLogger(OrderDetailServiceImpl.class);

	@Autowired
	private OrderDetailRepository orderDetailRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<OrderDetailDto> getAllOrderDetail() {
	  logger.info("OrderDetailServiceImpl - getAllOrderDetail");
		try {
		List<OrderDetail> orderDetails = new ArrayList<>();
		List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
		orderDetails = orderDetailRepo.findAll();
		if (orderDetails.size() > 0) {
			for (OrderDetail orderDetail : orderDetails) {
			  Order order = orderRepo.findOne(orderDetail.getIdorder());
				OrderDetailDto orderDetailDto = new OrderDetailDto();
				orderDetail.setOrder(order);
				Product prod = productRepository.findOne(orderDetail.getIdProduct());
				orderDetail.setProduct(prod);
				orderDetailDto = AdapEntityDto.adaptOrderDetailEntityToDto(orderDetail);
				orderDetailDtos.add(orderDetailDto);
			}
			return orderDetailDtos;
		}
		return new ArrayList<OrderDetailDto>();
		}catch (Exception e) {
		  logger.error("OrderDetailServiceImpl - getAllOrderDetail error: ", e);
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public List<OrderDetailDto> getAllOrDeByOrId(int id) {
	  logger.info("OrderDetailServiceImpl - getAllOrderByOrderId");
		try {
		Order order = orderRepo.findOne(id);
		List<OrderDetail> orderDetails = new ArrayList<>();
		List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
		orderDetails = orderDetailRepo.findAllOrderDetailByOrder(order);
		if (orderDetails.size() > 0) {
			for (OrderDetail orderDetail : orderDetails) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetail.setOrder(order);
        Product prod = productRepository.findOne(orderDetail.getIdProduct());
        orderDetail.setProduct(prod);
        orderDetailDto = AdapEntityDto.adaptOrderDetailEntityToDto(orderDetail);
        orderDetailDtos.add(orderDetailDto);
			}
			return orderDetailDtos;
		}
		return new ArrayList<OrderDetailDto>();
		}catch (Exception e) {
		  logger.error("OrderDetailServiceImpl - getAllOrderByOrderId error: ", e);
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public List<OrderDetailDto> getAllOrDeByProdId(int id) {
		try {
		Product product = productRepository.findOne(id);
		List<OrderDetail> orderDetails = new ArrayList<>();
		List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
		orderDetails = orderDetailRepo.findOrderDetailByProduct(product);
		if (orderDetails.size() > 0) {
			for (OrderDetail orderDetail : orderDetails) {
			  Order order = orderRepo.findOne(orderDetail.getIdorder());
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetail.setOrder(order);
        orderDetailDto = AdapEntityDto.adaptOrderDetailEntityToDto(orderDetail);
        orderDetailDtos.add(orderDetailDto);
			}
			return orderDetailDtos;
		}
		return new ArrayList<OrderDetailDto>();
		}catch (Exception e) {
		  logger.error("OrderDetailServiceImpl - getAllOrDeByProdId error: ", e);
			throw new ProductException(e.getMessage());
		}
	}
}
