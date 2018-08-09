package com.fpt.topgun.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.topgun.controller.CategoryController;
import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.dto.CategoryOutputDto;
import com.fpt.topgun.entity.Category;
import com.fpt.topgun.exception.ProductException;
import com.fpt.topgun.repository.CategoryRepository;
import com.fpt.topgun.service.CategoryService;
import com.fpt.topgun.utils.AdapEntityDto;

@Service
public class CategoryServiceImpl implements CategoryService {
  
  private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

  @Autowired
  private CategoryRepository cateRepo;

  @Override
  public CategoryOutputDto createCategory(CategoryInputDto cateDto) {
    logger.info("Create category - serviceImpl.");
    try {
      CategoryOutputDto cateOutput = new CategoryOutputDto();
      if (cateDto != null) {
        Category cate = new Category();
        cate = AdapEntityDto.adaptCateInputDtoToEntity(cateDto);
        Category cateGetin = cateRepo.save(cate);
        cateOutput = AdapEntityDto.adaptCategoryEntityToDto(cateGetin);
      }
      return cateOutput;
    } catch (Exception e) {
      logger.error("Serviceimpl - Create category error: ", e);
      throw new ProductException(e.getMessage());
    }
  }

  @Override
  public List<CategoryOutputDto> getAllCate() {
    logger.info("ServiceImpl - getAllCategory");
    try {
      List<Category> cates = cateRepo.findAll();
      List<CategoryOutputDto> cateDtos = new ArrayList<CategoryOutputDto>();
      for (Category cate : cates) {
        CategoryOutputDto cateDto = new CategoryOutputDto();
        cateDto = AdapEntityDto.adaptCategoryEntityToDto(cate);
        cateDtos.add(cateDto);
      }
      return cateDtos;
    } catch (Exception e) {
      logger.error("Serviceimpl - Create category error: ", e);
      throw new ProductException(e.getMessage());
    }
  }
}
