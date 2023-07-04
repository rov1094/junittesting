package com.in28minutes.junittestservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
	
	@InjectMocks // Where all the mocks will be injected
	SomeBusiness someBusiness;
	//Mocking 
	@Mock
	SomeDataService someDataServiceMocked;
	
//	Automaticallu setter is called
//	@BeforeEach
//	public void beforeEach() {
//		someBusiness.setSomeDataService(someDataServiceMocked);
//	}

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
