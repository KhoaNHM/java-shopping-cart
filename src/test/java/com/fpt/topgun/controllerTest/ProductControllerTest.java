package com.fpt.topgun.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fpt.topgun.controller.ProductController;
import com.fpt.topgun.dto.CategoryOutputDto;
import com.fpt.topgun.dto.ProductInputDto;
import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.repository.ProductRepository;
import com.fpt.topgun.service.ProductService;



@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@InjectMocks
	private ProductController controller;
	
	@Mock
	private ProductService service;

	private MockMvc mockMVC;

	@Before
	public void setup() {
		mockMVC = MockMvcBuilders.standaloneSetup(this.controller).build();
		service.createProduct(mockProductDtoInput());
	}

	

	@MockBean
	private ProductRepository prodRepo;

  private ProductInputDto mockProductDtoInput() {
    ProductInputDto dto = new ProductInputDto();
    dto.setName("IphoneX");
    dto.setPrice(0);
    dto.setQuantity(0);
    dto.setDescription("this ");
    dto.setIdCategory(1);
    return dto;
  }

	private CategoryOutputDto mockCategoryDto() {
		CategoryOutputDto cateDto = new CategoryOutputDto();
		cateDto.setName("Electronic");
		cateDto.setDescription("Using Voltage 220");
		cateDto.setId(1);
		return cateDto;
	}
	@Test
	public void createProduct() {
		String uri = "/product/";
		MvcResult result;
		try {
			result = mockMVC				
					.perform(put(uri).param("", mockProductDtoInput().toString()))
					.andExpect(status().isOk())
					.andReturn();
//			String responseAsJson = "";
//			Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	@Test
	public void getAllProduct() {
		String uri = "/product";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
//			String responseAsJson = "";
//			Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void productsByCategoryId() {
		String uri = "/product/category/2";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
			//String responseAsJson = "";
			//Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void getProductsByOrderId() {
		String uri = "/product/order/1";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
			//String responseAsJson = "";
			//Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void getAllProductByName() {
		String uri = "/product/IphoneX";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
		//	String responseAsJson = "";
		//.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
