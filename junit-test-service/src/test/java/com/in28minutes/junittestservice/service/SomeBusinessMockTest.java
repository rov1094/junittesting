package com.in28minutes.junittestservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SomeBusinessMockTest {
	
	SomeBusiness someBusiness=new SomeBusiness();
	//Mocking 
	SomeDataService someDataServiceMocked= mock(SomeDataService.class);
	
	
	@BeforeEach
	public void beforeEach() {
		someBusiness.setSomeDataService(someDataServiceMocked);
	}

	@Test
	void calculateSumUsingDataService_basic() {
		
		when(someDataServiceMocked.retrieveAllData()).thenReturn(new int[] {1,2,3});
		int actualValue=someBusiness.calculateSumUsingDataService();
		int expectedValue=6;
		assertEquals(expectedValue,actualValue);
	}

	@Test
	void calculateSumUsingDataService_EmptyValue() {
		when(someDataServiceMocked.retrieveAllData()).thenReturn(new int[] {});
		int actualValue=someBusiness.calculateSumUsingDataService();
		int expectedValue=0;
		assertEquals(expectedValue,actualValue);
	}

	@Test
	void calculateSumUsingDataService_SingleValue() {
		when(someDataServiceMocked.retrieveAllData()).thenReturn(new int[] {1});
		int actualValue=someBusiness.calculateSumUsingDataService();
		int expectedValue=1;
		assertEquals(expectedValue,actualValue);
	}

}
