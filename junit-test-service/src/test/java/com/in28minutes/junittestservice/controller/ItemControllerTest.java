package com.in28minutes.junittestservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.junittestservice.dto.Item;
import com.in28minutes.junittestservice.service.ItemBusinessService;

@WebMvcTest(value = ItemController.class)
class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService itemBusinessService;

	@Test
	void dummyItemTest() throws Exception {
		//call Get "dummy-item" application/json
		RequestBuilder request=MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}"))
				.andReturn();
		
	}
	
	@Test
	void itemFromBusinessService() throws Exception {
		
		when(itemBusinessService.hardCodedeItem()).thenReturn(new Item(2, "Item2", 10, 100));
		//call Get "dummy-item" application/json
		RequestBuilder request=MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,quantity:100}"))
				.andReturn();
		
	}
	
	@Test
	void itemsFromDB() throws Exception {
		
		when(itemBusinessService.allItemFromDB()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100),new Item(3, "Item3", 10, 100)));
		//call Get "dummy-item" application/json
		RequestBuilder request=MockMvcRequestBuilders.get("/all-items-from-db").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:Item2,quantity:100},{id:3,name:Item3,price:10.0}]"))
				.andReturn();
		
	}

}
