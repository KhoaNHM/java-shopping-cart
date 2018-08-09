package com.fpt.topgun.service;

import java.util.List;

import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.dto.CategoryOutputDto;

public interface CategoryService  {

  CategoryOutputDto createCategory(CategoryInputDto cateDto);
 
  List<CategoryOutputDto> getAllCate();
}
