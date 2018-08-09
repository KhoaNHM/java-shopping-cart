package com.fpt.topgun.serviceImplTest;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.dto.CategoryOutputDto;
import com.fpt.topgun.dto.OrderDetailDto;
import com.fpt.topgun.dto.OrderDto;
import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.entity.Category;
import com.fpt.topgun.entity.Order;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;
import com.fpt.topgun.repository.CategoryRepository;
import com.fpt.topgun.repository.OrderDetailRepository;
import com.fpt.topgun.repository.OrderRepository;
import com.fpt.topgun.repository.ProductRepository;
import com.fpt.topgun.service.OrderDetailService;
import com.fpt.topgun.utils.AdapEntityDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailServiceImplTest {

  @Autowired
  private OrderDetailService service;

  @Autowired
  private OrderDetailRepository orderDetailRepo;

  @Autowired
  private ProductRepository prodRepo;

  @Autowired
  private CategoryRepository cateRepo;

  @Autowired
  private OrderRepository orderRepo;

  private Product prodCheck;

  private ProductOutputDto productDto;

  private ProductInputDto productInputDto;

  private CategoryInputDto cateDto;

  private OrderDetailDto orderDetailDto;

  private OrderDto orderDto;

  private Order order;

  private int idorder;

  @Before
  public void setUp() {
    productInputDto = mockProductDtoInput();
    cateDto = mockCategoryInputDto();
    List<Category> cateChecks = cateRepo.findByname(cateDto.getName());
    if (cateChecks.size() == 0) {
      cateRepo.save(AdapEntityDto.adaptCateInputDtoToEntity(cateDto));
    }
    Category cateCheck2 = cateRepo.findByname(cateDto.getName()).get(0);
    List<Product> prods = prodRepo.findAllProductByCategory(cateCheck2);
    if (prods.size() == 0) {
      productInputDto.setIdCategory(cateCheck2.getIdCategory());
      prodRepo.save(AdapEntityDto.adaptProductIinputToEntity(productInputDto));
    }
    Order orderActually = null;
    orderDto = mockOrderDto();
    orderDetailDto = mockOrderDetailDto();
    order = AdapEntityDto.adaptOrderDtoToEntity(orderDto);
    OrderDetail orderDetail = AdapEntityDto.adaptOrderDetailDtoToEntity(orderDetailDto);
    Order orderCheck = orderRepo.findOne(order.getIdorder());
    if (orderCheck == null) {
      orderRepo.save(order);
    }
    OrderDetail orderDetailCheck = orderDetailRepo.findOne(orderDetail.getId());
    if (orderDetailCheck == null) {
      orderActually = orderRepo.findAll().get(0);
      orderDetail.setOrder(orderActually);
      Product prodActually = prodRepo.findAll().get(0);
      if (orderActually != null) {
        idorder = orderActually.getIdorder();
        orderDetail.setIdorder(orderActually.getIdorder());
      } else {
        idorder = order.getIdorder();
        orderDetail.setIdorder(order.getIdorder());
      }
      if (prodCheck != null) {
        orderDetail.setIdProduct(prodCheck.getIdProduct());
      } else {
        orderDetail.setIdProduct(prodActually.getIdProduct());
      }
      orderDetail.setProduct(prodActually);
      orderDetailRepo.save(orderDetail);
    }
  }

  @After
  public void tearDown() {
    orderDetailRepo.deleteAll();
    orderRepo.deleteByOrderName(orderDto.getOrderName());
    prodRepo.deleteByName(productInputDto.getName());
    cateRepo.deleteByName(cateDto.getName());
  }

  @Test
  public void getAllOrderDetailTest() {
    OrderDetailDto dto = service.getAllOrderDetail().get(0);
    assertDto(dto, orderDetailDto);
  }

  @Test
  public void getAllOrDeByOrIdTest() {
    OrderDetailDto dto = service.getAllOrDeByOrId(idorder).get(0);
    assertDto(dto, orderDetailDto);
  }

  @Test
  public void getAllOrDeByProdIdTest() {
    OrderDetailDto dto = service.getAllOrDeByOrId(idorder).get(0);
    assertDto(dto, orderDetailDto);
  }

  private void assertDto(OrderDetailDto dto, OrderDetailDto orderDetailDto2) {
    // Assert.assertEquals(dto.getAmount(), orderDetailDto2.getAmount());
    Assert.assertEquals(dto.getPrice(), orderDetailDto2.getPrice());

  }

  private ProductInputDto mockProductDtoInput() {
    ProductInputDto dto = new ProductInputDto();
    dto.setName("IphoneX");
    dto.setPrice(120);
    dto.setQuantity(100);
    dto.setDescription("this ");
    dto.setIdCategory(1);
    return dto;
  }


  private CategoryInputDto mockCategoryInputDto() {
    CategoryInputDto cateDto = new CategoryInputDto();
    cateDto.setName("Electronic");
    cateDto.setDescription("Using Voltage 220");
    return cateDto;
  }

  private OrderDetailDto mockOrderDetailDto() {
    OrderDetailDto orderDetailDto = new OrderDetailDto();
    orderDetailDto.setId(1);
    orderDetailDto.setAmount(1250);
    orderDetailDto.setPrice(100);
    orderDetailDto.setProductDto(productDto);
    orderDetailDto.setOrderDto(mockOrderDto());
//    orderDetailDto.setProductDto(mockProductDto());
    return orderDetailDto;
  }

  private OrderDto mockOrderDto() {
    OrderDto orderDto = new OrderDto();
    orderDto.setIdorder(1);
    orderDto.setAmount(124);
    orderDto.setOrderAddress("com.fpt");
    orderDto.setOrderEmail("com.fpt");
    orderDto.setOrderName("topgun");
    orderDto.setOrderPhone("0909090909");
    return orderDto;
  }
}
