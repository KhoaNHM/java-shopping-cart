package com.fpt.topgun.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.topgun.dto.CategoryOutputDto;
import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.entity.Category;
import com.fpt.topgun.entity.Order;
import com.fpt.topgun.entity.OrderDetail;
import com.fpt.topgun.entity.Product;
import com.fpt.topgun.exception.ProductException;
import com.fpt.topgun.repository.CategoryRepository;
import com.fpt.topgun.repository.OrderDetailRepository;
import com.fpt.topgun.repository.OrderRepository;
import com.fpt.topgun.repository.ProductRepository;
import com.fpt.topgun.service.ProductService;
import com.fpt.topgun.utils.AdapEntityDto;

@Service
public class ProductServiceImpl implements ProductService {

  private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

  @Autowired
  private ProductRepository productRepo;

  @Autowired
  private CategoryRepository categoryRepo;

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Autowired
  private OrderRepository orderRepository;

  /**
   * 
   */
  public ProductServiceImpl() {
    super();
  }

  @Override
  public List<ProductOutputDto> getAllProduct() {
    try {
      List<Product> prods = productRepo.findAll();
      List<ProductOutputDto> prodDtos = new ArrayList<ProductOutputDto>();
      for (Product prod : prods) {
        ProductOutputDto prodDto = new ProductOutputDto();
        prodDto = AdapEntityDto.adaptProductEntityToDto(prod);
        prodDtos.add(prodDto);
      }
      return prodDtos;
    } catch (Exception e) {
      logger.error("ProductServiceImpl - getAllProduct error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

  @Override
  public List<ProductOutputDto> getAllProductByName(String name) {
    try {
      if (name != null) {
        List<Product> prods = productRepo.findAllProductByName(name);
        List<ProductOutputDto> prodDtos = new ArrayList<ProductOutputDto>();
        for (Product prod : prods) {
          ProductOutputDto prodDto = new ProductOutputDto();
          prodDto = AdapEntityDto.adaptProductEntityToDto(prod);
          prodDtos.add(prodDto);
        }
        return prodDtos;
      } else {
        return new ArrayList<ProductOutputDto>();
      }
    } catch (Exception e) {
      logger.error("ProductServiceImpl - getAllProductByName error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

  @Override
  public List<ProductOutputDto> getAllProductByCateId(int idCategory, int page) {
    return getAllProductByCateId(idCategory);

  }

  @Override
  public List<ProductOutputDto> getAllProductByCateId(int idCategory) {
    try {
      Category cate = categoryRepo.findByidCategory(idCategory);
      List<Product> prods = productRepo.findAllProductByCategory(cate);
      List<ProductOutputDto> prodDtos = new ArrayList<ProductOutputDto>();
      if (prods != null) {
        for (Product prod : prods) {
          ProductOutputDto prodDto = new ProductOutputDto();
          prodDto = AdapEntityDto.adaptProductEntityToDto(prod);
          prodDtos.add(prodDto);
        }
        return prodDtos;
      } else {
        return new ArrayList<ProductOutputDto>();
      }
    } catch (Exception e) {
      logger.error("ProductServiceImpl - getAllProductByCateId error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

  @Override
  public List<ProductOutputDto> getAllProductByOrderId(int idOrder) {
    try {
      Order order = orderRepository.findOne(idOrder);
      List<OrderDetail> orderDetails = orderDetailRepository.findAllOrderDetailByOrder(order);
      List<Product> prods = new ArrayList<>();
      for (OrderDetail orderDetail : orderDetails) {
        List<Product> prodByOrderDetail = productRepo.findAllProductByOrderDetail(orderDetail);
        prods.addAll(prodByOrderDetail);
      }
      List<ProductOutputDto> prodDtos = new ArrayList<ProductOutputDto>();
      for (Product prod : prods) {
        ProductOutputDto prodDto = new ProductOutputDto();
        prodDto = AdapEntityDto.adaptProductEntityToDto(prod);
        prodDtos.add(prodDto);
      }
      return prodDtos;
    } catch (Exception e) {
      logger.error("ProductServiceImpl - getAllProductByOrderId error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

  @Override
  public ProductOutputDto createProduct(ProductInputDto prodDto) {
    try {
      Product prod = AdapEntityDto.adaptProductIinputToEntity(prodDto);
      Product prodGetIn = productRepo.save(prod);
      Category category = categoryRepo.findOne(prodDto.getIdCategory());
      CategoryOutputDto cateDto = AdapEntityDto.adaptCategoryEntityToDto(category);
      ProductOutputDto prodOutput = new ProductOutputDto();
      prodOutput = AdapEntityDto.adaptProductEntityToDto(prodGetIn);
      prodOutput.setCategoryDto(cateDto);
      return prodOutput;
    } catch (Exception e) {
      logger.error("ProductServiceImpl - createProduct error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

}
