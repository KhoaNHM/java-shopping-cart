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
import com.fpt.topgun.repository.CategoryRepository;
import com.fpt.topgun.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

  @Autowired
  private CategoryService cateService;
  
  @Autowired
  private CategoryRepository cateRepo;
  
  private CategoryOutputDto dtoOutput;
  
  private CategoryInputDto dto;
  
  @Before
  public void setUp() {
   dto = mockCategoryInputDto();
  }
  
  @After
  public void tearDown() {
    cateRepo.deleteByName(dto.getName());
  }
  
  @Test
  public void createCategoryTest() {
    dtoOutput = cateService.createCategory(dto);
    assertDto(dto,dtoOutput);
  }
  
  
  @Test
  public void getAllCategoryTest() {
    dtoOutput = cateService.createCategory(dto);
    assertDto(dto,dtoOutput);
  }
  
  private CategoryInputDto mockCategoryInputDto() {
    CategoryInputDto cateDto = new CategoryInputDto();
    cateDto.setName("Electronic");
    cateDto.setDescription("Using Voltage 220");
    return cateDto;
  }
  
  private void assertDto(CategoryInputDto dtoExpect,CategoryOutputDto dtoActually) {
    Assert.assertEquals(dtoExpect.getName(), dtoActually.getName());
    Assert.assertEquals(dtoExpect.getDescription(), dtoActually.getDescription()); 
  }
}
