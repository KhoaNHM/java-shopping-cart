package com.fpt.topgun.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.topgun.dto.Items;
import com.fpt.topgun.dto.OrderDto;
import com.fpt.topgun.dto.OrderInputDto;
import com.fpt.topgun.entity.Order;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;
import com.fpt.topgun.exception.ProductException;
import com.fpt.topgun.repository.OrderDetailRepository;
import com.fpt.topgun.repository.OrderRepository;
import com.fpt.topgun.repository.ProductRepository;
import com.fpt.topgun.service.OrderService;
import com.fpt.topgun.utils.AdapEntityDto;

@Service
public class OrderServiceImpl implements OrderService {

  private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

  @Autowired
  private OrderRepository orderRepo;

  @Autowired
  private ProductRepository prodRepo;

  @Autowired
  private OrderDetailRepository orderDetailRepo;

  @Override
  public OrderDto createOrder(OrderInputDto orderInputDto) {
    try {
      if (orderInputDto != null) {
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orderDetails = new ArrayList<>();
        List<Items> items = orderInputDto.getItems();
        Order order = AdapEntityDto.adaptOrderInputDtoToEntity(orderInputDto);
        Double amount = new Double(0);
        for (Items item : items) {
          Product prod = prodRepo.findOne(item.getIdProduct());
          if(item.getQuantity()>prod.getQuantity()) {
            return new OrderDto();
          }
          Double amountItem = prod.getPrice() * item.getQuantity();
          amount += amountItem;
          orderDetail.setAmount(amount);
          orderDetail.setIdProduct(prod.getIdProduct());
          orderDetail.setOrder(order);
          orderDetail.setPrice((int) prod.getPrice());
          orderDetail.setProduct(prod);
          orderDetails.add(orderDetail);
        }
        order.setAmount(amount);
        Order orderSaved = orderRepo.save(order);
        List<OrderDetail> orderDetailGetIns = new ArrayList<>();
        for (OrderDetail orderDetail2 : orderDetails) {
          orderDetail2.setIdorder(orderSaved.getIdorder());
          OrderDetail orderDetailSaved = orderDetailRepo.save(orderDetail2);
          orderDetailGetIns.add(orderDetailSaved);
        }
        OrderDto dto = AdapEntityDto.adaptOrderEntityToDto(orderSaved);
        dto.setOrderDetail(orderDetailGetIns);
        return dto;
      }
      return new OrderDto();
    } catch (Exception e) {
      logger.error("OrderServiceImpl - createOrder error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

  @Override
  public List<OrderDto> getAllOrder() {
    try {
      List<Order> orders = new ArrayList<Order>();
      List<OrderDto> orderDtos = new ArrayList<OrderDto>();
      orders = orderRepo.findAll();
      for (Order order : orders) {
        OrderDto orderDto = new OrderDto();
        orderDto = AdapEntityDto.adaptOrderEntityToDto(order);
        orderDtos.add(orderDto);
      }
      return orderDtos;
    } catch (Exception e) {
      logger.error("OrderServiceImpl - getAllOrder error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

}
