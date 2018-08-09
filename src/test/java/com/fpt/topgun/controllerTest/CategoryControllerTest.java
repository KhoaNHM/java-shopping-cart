package com.fpt.topgun.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fpt.topgun.controller.CategoryController;
import com.fpt.topgun.dto.CategoryInputDto;
import com.fpt.topgun.service.CategoryService;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
	@InjectMocks
	private CategoryController controller;

	private MockMvc mockMVC;
	
	@Mock
	private CategoryService service;

	@Before
	public void setup() {
		mockMVC = MockMvcBuilders.standaloneSetup(this.controller).build();
		service.createCategory(mockCategoryInputDto());
	}

	private CategoryInputDto mockCategoryInputDto() {
		CategoryInputDto cateDto = new CategoryInputDto();
		cateDto.setName("Electronic");
		cateDto.setDescription("Using Voltage 220");
		return cateDto;
	}

	@Test
	public void createCategory() {
		String uri = "/category/";
		MvcResult result;
		try {
			result = mockMVC.perform(put(uri).param("", mockCategoryInputDto().toString())).andExpect(status().isOk())
					.andReturn();
			// String responseAsJson = "";
			// Assert.assertEquals("Result: ",
			// result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void getAllCategory() {
		String uri = "/category";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
			// String responseAsJson = "";
			// Assert.assertEquals("Result: ",
			// result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
