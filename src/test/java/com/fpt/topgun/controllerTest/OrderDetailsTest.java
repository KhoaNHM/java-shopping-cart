package com.fpt.topgun.controllerTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.topgun.controller.OrderDetailController;

@RunWith(MockitoJUnitRunner.class)
public class OrderDetailsTest {
	@InjectMocks
	private OrderDetailController controller;

	private MockMvc mockMVC;

	@Before
	public void setup() {
		mockMVC = MockMvcBuilders.standaloneSetup(this.controller).build();
	}
	
	@Test
	public void getAllOrderDetails() {
		String uri = "/order-detail";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
		//	String responseAsJson = "";
			//Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getByProduct() {
		String uri = "/order-detail/product/2";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
		//	String responseAsJson = "";
			//Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
