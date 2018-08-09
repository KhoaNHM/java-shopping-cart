package com.fpt.topgun.utils;

import java.util.Date;

import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.dto.CategoryOutputDto;
import com.fpt.topgun.dto.OrderDetailDto;
import com.fpt.topgun.dto.OrderDto;
import com.fpt.topgun.dto.OrderInputDto;
import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.entity.Category;
import com.fpt.topgun.entity.Order;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;

public class AdapEntityDto {

  public static Product adaptProductInfoToEntity(ProductOutputDto prodDto) {
    Product prod = new Product();
    if (prodDto != null) {
      prod.setName(prodDto.getName());
      prod.setDescription(prodDto.getDescription());
      Category cate = AdapEntityDto.adaptCateDtoToEntity(prodDto.getCategoryDto());
      prod.setCategory(cate);
      prod.setIdCategory(prodDto.getIdCategory());
      prod.setPrice(prodDto.getPrice());
      prod.setQuantity(prodDto.getQuantity());
      prodDto.setImage_id(prod.getImage_id());
      prodDto.setImage_Name(prod.getImage_Name());
      prod.setCreated_date(new Date());
    }
    return prod;
  }

  public static ProductOutputDto adaptProductEntityToDto(Product prod) {
    ProductOutputDto prodDto = new ProductOutputDto();
    if (prod != null) {
      prodDto.setName(prod.getName());
      prodDto.setDescription(prod.getDescription());
      CategoryOutputDto cateDto = adaptCategoryEntityToDto(prod.getCategory());
      prodDto.setCategoryDto(cateDto);
      prodDto.setPrice(prod.getPrice());
      prodDto.setQuantity(prod.getQuantity());
      prodDto.setCreated_date(prod.getCreated_date());
      prodDto.setIdCategory(prod.getIdCategory());
      prodDto.setIdProduct(prod.getIdProduct());
      prodDto.setImage_id(prod.getImage_id());
      prodDto.setImage_Name(prod.getImage_Name());
    }
    return prodDto;
  }

  public static Category adaptCateDtoToEntity(CategoryOutputDto cateDto) {
    if (cateDto != null) {
      Category cate = new Category();
      cate.setIdCategory(cateDto.getId());
      cate.setName(cateDto.getName());
      cate.setDescription(cateDto.getDescription());
      return cate;
    }
    return new Category();
  }

  public static CategoryOutputDto adaptCategoryEntityToDto(Category cate) {
    if (cate != null) {
      CategoryOutputDto cateDto = new CategoryOutputDto();
      cateDto.setId(cate.getIdCategory());
      cateDto.setName(cate.getName());
      cateDto.setDescription(cate.getDescription());
      return cateDto;
    }
    return new CategoryOutputDto();
  }

  public static Order adaptOrderDtoToEntity(OrderDto orderDto) {
    if (orderDto != null) {
      Order order = new Order();
      order.setIdorder(orderDto.getIdorder());
      order.setOrderName(orderDto.getOrderName());
      order.setAmount(orderDto.getAmount());
      order.setOrderAddress(orderDto.getOrderAddress());
      order.setOrderDetail(orderDto.getOrderDetail());
      order.setOrderEmail(orderDto.getOrderEmail());
      order.setOrderPhone(orderDto.getOrderPhone());
      order.setCreated_time(new Date());
      return order;
    }
    return new Order();
  }

  public static OrderDto adaptOrderEntityToDto(Order order) {
    if (order != null) {
      OrderDto orderDto = new OrderDto();
      orderDto.setIdorder(order.getIdorder());
      orderDto.setOrderName(order.getOrderName());
      orderDto.setAmount(order.getAmount());
      orderDto.setOrderAddress(order.getOrderAddress());
      orderDto.setOrderDetail(order.getOrderDetail());
      orderDto.setOrderEmail(order.getOrderEmail());
      orderDto.setOrderPhone(order.getOrderPhone());
      return orderDto;
    }
    return new OrderDto();
  }

  public static OrderDetailDto adaptOrderDetailEntityToDto(OrderDetail orderDetail) {
    if (orderDetail != null) {
      OrderDetailDto orderDetailDto = new OrderDetailDto();
      orderDetailDto.setId(orderDetail.getId());
      orderDetailDto.setAmount(orderDetail.getAmount());
      orderDetailDto.setOrderDto(adaptOrderEntityToDto(orderDetail.getOrder()));
      orderDetailDto.setPrice(orderDetail.getPrice());
      orderDetailDto.setProductDto(adaptProductEntityToDto(orderDetail.getProduct()));
      return orderDetailDto;
    }
    return new OrderDetailDto();
  }

  public static OrderDetail adaptOrderDetailDtoToEntity(OrderDetailDto orderDetailDto) {
    if (orderDetailDto != null) {
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setId(orderDetailDto.getId());
      orderDetail.setAmount(orderDetailDto.getAmount());
      orderDetail.setOrder(adaptOrderDtoToEntity(orderDetailDto.getOrderDto()));
      orderDetail.setPrice(orderDetailDto.getPrice());
      orderDetail.setProduct(adaptProductInfoToEntity(orderDetailDto.getProductDto()));
      return orderDetail;
    }
    return new OrderDetail();
  }

  public static Product adaptProductIinputToEntity(ProductInputDto prodDto) {
    Product prod = new Product();
    if (prodDto != null) {
      prod.setName(prodDto.getName());
      prod.setDescription(prodDto.getDescription());
      prod.setIdCategory(prodDto.getIdCategory());
      prod.setPrice(prodDto.getPrice());
      prod.setQuantity(prodDto.getQuantity());
      prod.setCreated_date(new Date());
      prod.setImage_id(prodDto.getImage_id());
      prod.setImage_Name(prodDto.getImage_Name());
    }
    return prod;
  }

  public static Category adaptCateInputDtoToEntity(CategoryInputDto cateDto) {
    if (cateDto != null) {
      Category cate = new Category();
      cate.setName(cateDto.getName());
      cate.setDescription(cateDto.getDescription());
      return cate;
    }
    return new Category();
  }

  public static Order adaptOrderInputDtoToEntity(OrderInputDto orderInputDto) {
 if(orderInputDto!=null) {
   Order order = new Order();
   order.setOrderAddress(orderInputDto.getOrderAddress());
   order.setOrderEmail(orderInputDto.getOrderEmail());
   order.setOrderName(orderInputDto.getOrderName());
   order.setOrderPhone(orderInputDto.getOrderPhone());
   order.setCreated_time(new Date());
   return order;
 }
 return new Order();
  }
}
