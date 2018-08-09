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
import com.fpt.topgun.service.ProductService;
import com.fpt.topgun.utils.AdapEntityDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

  @Autowired
  private ProductService prodService;

  @Autowired
  private ProductRepository prodRepo;

  @Autowired
  private CategoryRepository cateRepo;

  @Autowired
  private OrderRepository orderRepo;

  @Autowired
  private OrderDetailRepository orderDetailRepo;

  private ProductOutputDto productDto;

  private CategoryOutputDto cateDto;

  private Category cate;

  private OrderDetailDto orderDetailDto;

  private OrderDto orderDto;

  private Product prodCheck;

  private ProductInputDto productInputDto;

//  @Before
//  public void setUp() {
//    productInputDto = mockProductDtoInput();
//    cateDto = mockCategoryDto();
//    cate = AdapEntityDto.adaptCateDtoToEntity(cateDto);
//    List<Category> cateChecks = cateRepo.findByname(cate.getName());
//    if (cateChecks.size() == 0) {
//      cateRepo.save(cate);
//    }
//    Category cateCheck2 = cateRepo.findByname(cate.getName()).get(0);
//    List<Product> prods = prodRepo.findAllProductByCategory(cateCheck2);
//    if (prods.size() == 0) {
//      productInputDto.setIdCategory(cateCheck2.getIdCategory());
//      prodRepo.save(AdapEntityDto.adaptProductIinputToEntity(productInputDto));
//    }
//  }

//  @After
//  public void tearDown() {
//    prodRepo.deleteByName(productInputDto.getName());
//    cateRepo.deleteByName(cateDto.getName());
//  }

//  @Test
//  public void createProductTest() {
//    ProductOutputDto prodOutput = prodService.createProduct(productInputDto);
//    assertDto(productInputDto, prodOutput);
//  }
//
//  @Test
//  public void getAllProductTest() {
//    ProductOutputDto prodOutput = prodService.createProduct(productInputDto);
//    List<ProductOutputDto> dtos = prodService.getAllProduct();
//    ProductOutputDto dtoActual = dtos.get(0);
//    assertDto(productInputDto, dtoActual);
//  }
//
//  @Test
//  public void getProductByNameTest() {
//    ProductOutputDto prodOutput = prodService.createProduct(productInputDto);
//    List<ProductOutputDto> dtos = prodService.getAllProductByName("IphoneX");
//    ProductOutputDto dtoActual = dtos.get(0);
//    assertDto(productInputDto, dtoActual);
//  }
//
//  @Test
//  public void getProductByCategoryIdTest() {
//    ProductOutputDto prodOutput = prodService.createProduct(productInputDto);
//    List<ProductOutputDto> dtos = prodService.getAllProductByCateId(prodOutput.getIdCategory());
//    ProductOutputDto dtoActual = dtos.get(0);
//    assertDto(productInputDto, dtoActual);
//  }
//
//  @Test
//  public void getAllProductByOrderIdTest() {
//    List<Product> products = prodRepo.findAllProductByName(productInputDto.getName());
//    ProductOutputDto prodOutput = null;
//    if (products.size() == 0) {
//      prodOutput = prodService.createProduct(productInputDto);
//    }
//    Order orderActually = null;
//    orderDto = mockOrderDto();
//    orderDetailDto = mockOrderDetailDto();
//    Order order = AdapEntityDto.adaptOrderDtoToEntity(orderDto);
//    OrderDetail orderDetail = AdapEntityDto.adaptOrderDetailDtoToEntity(orderDetailDto);
//    Order orderCheck = orderRepo.findOne(order.getIdorder());
//    if (orderCheck == null) {
//      orderRepo.save(order);
//    }
//    OrderDetail orderDetailCheck = orderDetailRepo.findOne(orderDetail.getId());
//    if (orderDetailCheck == null) {
//      orderActually = orderRepo.findAll().get(0);
//      orderDetail.setOrder(orderActually);
//      Product prodActually = prodRepo.findAll().get(0);
//      if (orderActually != null) {
//        orderDetail.setIdorder(orderActually.getIdorder());
//      } else {
//        orderDetail.setIdorder(order.getIdorder());
//      }
//      if (prodCheck != null) {
//        orderDetail.setIdProduct(prodCheck.getIdProduct());
//      } else {
//        orderDetail.setIdProduct(prodActually.getIdProduct());
//      }
//      orderDetail.setProduct(prodActually);
//      orderDetailRepo.save(orderDetail);
//    } else {
//
//    }
//    List<ProductOutputDto> dtos = prodService.getAllProductByOrderId(orderActually.getIdorder());
//    ProductOutputDto dtoActual = dtos.get(0);
//    assertDto(productInputDto, dtoActual);
//    orderDetailRepo.deleteAll();
//    orderRepo.deleteByOrderName(orderDto.getOrderName());
//  }
//
//  private ProductInputDto mockProductDtoInput() {
//    ProductInputDto dto = new ProductInputDto();
//    dto.setName("IphoneX");
//    dto.setPrice(100);
//    dto.setQuantity(100);
//    dto.setDescription("this ");
//    dto.setIdCategory(1);
//    return dto;
//  }
//
//  private ProductOutputDto mockProductDto() {
//    ProductOutputDto dto = new ProductOutputDto();
//    dto.setIdProduct(1);
//    dto.setName("IphoneX");
//    dto.setPrice(100);
//    dto.setQuantity(123);
//    dto.setDescription("this ");
//    dto.setCategoryDto(mockCategoryDto());
//    dto.setIdCategory(dto.getCategoryDto().getId());
//    return dto;
//  }
//
//  private CategoryOutputDto mockCategoryDto() {
//    CategoryOutputDto cateDto = new CategoryOutputDto();
//    cateDto.setName("Electronic");
//    cateDto.setDescription("Using Voltage 220");
//    cateDto.setId(1);
//    return cateDto;
//  }
//
//  private OrderDetailDto mockOrderDetailDto() {
//    OrderDetailDto orderDetailDto = new OrderDetailDto();
//    orderDetailDto.setId(1);
//    orderDetailDto.setAmount(127);
//    orderDetailDto.setPrice(15);
//    orderDetailDto.setProductDto(productDto);
//    orderDetailDto.setOrderDto(mockOrderDto());
//    orderDetailDto.setProductDto(mockProductDto());
//    return orderDetailDto;
//  }
//
//  private OrderDto mockOrderDto() {
//    OrderDto orderDto = new OrderDto();
//    orderDto.setIdorder(1);
//    orderDto.setAmount(4);
//    orderDto.setOrderAddress("com.fpt");
//    orderDto.setOrderEmail("com.fpt");
//    orderDto.setOrderName("topgun");
//    orderDto.setOrderPhone("0909090909");
//    return orderDto;
//  }
//
//  private void assertDto(ProductInputDto dtoExpect, ProductOutputDto dtoActually) {
//    Assert.assertEquals(dtoExpect.getName(), dtoActually.getName());
//    Assert.assertEquals(dtoExpect.getQuantity(), dtoActually.getQuantity());
//    Assert.assertEquals(dtoExpect.getDescription(), dtoActually.getDescription());
//  }

  @Test
  public void createProduct() {
    
    for (int i = 0; i < 15; i++) {
      ProductInputDto dto = new ProductInputDto();
      dto.setName("Bravia" + i);
      dto.setPrice(100);
      dto.setQuantity(100);
      dto.setDescription("this ");
      dto.setIdCategory(5);
      dto.setImage_id(i);
      dto.setImage_Name("Bravia"+i);
      prodService.createProduct(dto);
    }
    
   
  }
}
