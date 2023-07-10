package com.in28minutes.junittestservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = HelloWorldController.class)
class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWorld() throws Exception {
		//call Get "hello-world" application/json
		RequestBuilder request=MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		
		//verify Hello-World
		assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}

}
