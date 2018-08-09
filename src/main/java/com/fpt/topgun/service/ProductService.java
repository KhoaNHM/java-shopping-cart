package com.fpt.topgun.service;

import java.util.List;

import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.dto.ProductOutputDto;

public interface ProductService {

  ProductOutputDto createProduct(ProductInputDto prodDto);
  
  List<ProductOutputDto> getAllProductByName(String name);
  
  List<ProductOutputDto> getAllProductByCateId(int idCategory);
  
  List<ProductOutputDto> getAllProduct();
  
  List<ProductOutputDto> getAllProductByOrderId(int idOrder);

  List<ProductOutputDto> getAllProductByCateId(int idCategory, int page);
}
