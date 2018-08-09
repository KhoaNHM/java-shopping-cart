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

import com.fpt.topgun.controller.OrderController;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@InjectMocks
	private OrderController controller;

	private MockMvc mockMVC;

	@Before
	public void setup() {
		mockMVC = MockMvcBuilders.standaloneSetup(this.controller).build();
	}
	
	@Test
	public void getAllOrders() {
		String uri = "/order";
		MvcResult result;
		try {
			result = mockMVC.perform(MockMvcRequestBuilders.get(uri))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
			//String responseAsJson = "";
			//Assert.assertEquals("Result: ", result.getResponse().getContentAsString(), responseAsJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
