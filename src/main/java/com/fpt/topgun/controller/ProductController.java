package com.fpt.topgun.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {

  private static final Logger logger = LogManager.getLogger(ProductController.class);

  private ProductService prodService;

  /**
   * This contructor using to delare service.
   * 
   * @param service
   *          to use
   */
  @Autowired
  public ProductController(ProductService prodService) {
    this.prodService = prodService;
  }

  /**
   * This method using to get all product.
   */
  @ApiOperation(value = "get all product", response = String.class)
  @RequestMapping(value = "/product", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<ProductOutputDto> getAllProduct() {
    logger.info("Get all products.");
    return prodService.getAllProduct();
  }

  /**
   * This method using to get all product by name.
   */
  @ApiOperation(value = "get all product by name", response = String.class)
  @RequestMapping(value = "/product/{name}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<ProductOutputDto> getAllProductByName(@Valid @PathVariable String name) {
    logger.info("Get all products by name.");
    return prodService.getAllProductByName(name);
  }

  /**
   * This method using to get all product by orderId.
   */
  @ApiOperation(value = "get all product by orderId", response = String.class)
  @RequestMapping(value = "/product/order/{idOrder}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<ProductOutputDto> getAllProductByOrderId(@PathVariable int idOrder) {
    logger.info("Get all product by OrderId.");
    return prodService.getAllProductByOrderId(idOrder);
  }

  /**
   * This method using to get all product by categoryId.
   */
  @ApiOperation(value = "get all product by categoryId", response = String.class)
  @RequestMapping(value = "/product/category/{idCategory}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<ProductOutputDto> getAllProductByCateId(@PathVariable int idCategory, @PathVariable int page) {
    logger.info("Get all products by categoryId.");
    return prodService.getAllProductByCateId(idCategory, page);
  }

  /**
   * This method using to create product.
   */
  @ApiOperation(value = "create product", response = ProductOutputDto.class)
  @RequestMapping(value = "/product/", method = RequestMethod.PUT)
  public ProductOutputDto createProduct(@Valid @RequestBody ProductInputDto dto) {
    logger.info("Create product{}.", dto.getImage_Name());
    return prodService.createProduct(dto);
  }

}
