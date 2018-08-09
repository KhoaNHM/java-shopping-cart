package com.fpt.topgun.serviceImplTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.dto.Items;
import com.fpt.topgun.dto.OrderDto;
import com.fpt.topgun.dto.OrderInputDto;
import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.entity.Category;
import com.fpt.topgun.entity.Product;
import com.fpt.topgun.repository.CategoryRepository;
import com.fpt.topgun.repository.OrderDetailRepository;
import com.fpt.topgun.repository.OrderRepository;
import com.fpt.topgun.repository.ProductRepository;
import com.fpt.topgun.service.OrderService;
import com.fpt.topgun.utils.AdapEntityDto;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

  @Autowired
  private OrderService service;

  @Autowired
  private OrderRepository orderRepo;

  @Autowired
  private CategoryRepository cateRepo;

  @Autowired
  private ProductRepository prodRepo;
  
  @Autowired
  private OrderDetailRepository orderDetailRepo;

  private OrderInputDto dtoInput;

  private ProductInputDto prodInputDto;

  private Category cate;

  private CategoryInputDto cateDto;


  @Before
  public void setUp() {
    prodInputDto = mockProductDtoInput();
    cateDto = mockCategoryDto();
    cate = AdapEntityDto.adaptCateInputDtoToEntity(cateDto);
    List<Category> cateChecks = cateRepo.findByname(cate.getName());
    if (cateChecks.size() == 0) {
      cateRepo.save(cate);
    }
    Category cateCheck2 = cateRepo.findByname(cate.getName()).get(0);
    List<Product> prods = prodRepo.findAllProductByCategory(cateCheck2);
    Items item = new Items();
    List<Items> items = new ArrayList<>();
    if (prods.size() == 0) {
      prodInputDto.setIdCategory(cateCheck2.getIdCategory());
      Product prod = prodRepo.save(AdapEntityDto.adaptProductIinputToEntity(prodInputDto));
      item.setIdProduct(prod.getIdProduct());
      item.setQuantity(3);
      items.add(item);
    }
    else {
      item.setIdProduct(prods.get(0).getIdProduct());
      item.setQuantity(3);
      items.add(item);
    }
    dtoInput = mockOrderInputDto();
    dtoInput.setItems(items);
  }

  @After
  public void tearDown() {
    orderDetailRepo.deleteAll();
    orderRepo.deleteByOrderName(dtoInput.getOrderName());
    prodRepo.deleteByName(prodInputDto.getName());
    cateRepo.deleteByName(cateDto.getName());
  }

  @Test
  public void createOrderTest() {
   OrderDto dto = service.createOrder(dtoInput);
    List<OrderDto> dtos = service.getAllOrder();
    OrderDto dtoActual = dtos.get(0);
    assertDto(dto, dtoActual);
  }

  @Test
  public void getAllOrderTest() {
    OrderDto dto = service.createOrder(dtoInput);
    List<OrderDto> dtos = service.getAllOrder();
    OrderDto dtoActual = dtos.get(0);
    assertDto(dto, dtoActual);
  }

  @SuppressWarnings("deprecation")
  private void assertDto(OrderDto dto, OrderDto dtoActual) {
    Assert.assertEquals(dto.getAmount(), dtoActual.getAmount());
    Assert.assertEquals(dto.getOrderAddress(), dtoActual.getOrderAddress());
    Assert.assertEquals(dto.getOrderEmail(), dtoActual.getOrderEmail());
    Assert.assertEquals(dto.getOrderName(), dtoActual.getOrderName());
    Assert.assertEquals(dto.getOrderPhone(), dtoActual.getOrderPhone());
  }

  private ProductInputDto mockProductDtoInput() {
    ProductInputDto dto = new ProductInputDto();
    dto.setName("IphoneX");
    dto.setPrice(100);
    dto.setQuantity(100);
    dto.setDescription("this ");
    dto.setIdCategory(1);
    return dto;
  }

  private OrderInputDto mockOrderInputDto() {
    Items item = new Items();
    OrderInputDto dto = new OrderInputDto();
    dto.setOrderAddress("fpttphcmVietNam");
    dto.setOrderEmail("com.email");
    dto.setOrderName("hoang@gmail.com");
    dto.setOrderPhone("0909090909");
    return dto;
  }

  private CategoryInputDto mockCategoryDto() {
    CategoryInputDto cateDto = new CategoryInputDto();
    cateDto.setName("Electronic");
    cateDto.setDescription("Using Voltage 220");
    return cateDto;
  }
}
