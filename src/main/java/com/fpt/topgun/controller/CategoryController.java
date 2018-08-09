package com.fpt.topgun.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.topgun.ShoppingCartApplication;
import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.dto.CategoryOutputDto;
import com.fpt.topgun.service.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CategoryController {
  
  private static final Logger logger = LogManager.getLogger(CategoryController.class);

  private CategoryService service;

  /**
   * This contructor using to delare service.
   * 
   * @param service
   *          to use
   */
  @Autowired
  public CategoryController(CategoryService service) {
    this.service = service;
  }

  /**
   * This method using to get all category.
   */
  @ApiOperation(value = "get all categories", response = String.class)
  @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<CategoryOutputDto> getAllCategory() {
    logger.info("Get all category.");
    return service.getAllCate();
  }

  /**
   * This method using to create category.
   */
  @ApiOperation(value = "create category", response = String.class)
  @RequestMapping(value = "/category/", method = RequestMethod.PUT)
  public CategoryOutputDto createCategory(@Valid @RequestBody CategoryInputDto dto) {
    logger.info("Create category.");
    return service.createCategory(dto);
  }

}
