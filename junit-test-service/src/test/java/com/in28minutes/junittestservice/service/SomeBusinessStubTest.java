package com.in28minutes.junittestservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
	
}

class SomeDataServiceStubEmptyValue implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}

class SomeDataServiceStubSingleValue implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1};
	}
	
}

class SomeBusinessStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusiness someBusiness=new SomeBusiness();
		someBusiness.setSomeDataService(new SomeDataServiceStub());
		int actualValue=someBusiness.calculateSumUsingDataService();
		int expectedValue=6;
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	void calculateSumUsingDataService_EmptyValue() {
		SomeBusiness someBusiness=new SomeBusiness();
		someBusiness.setSomeDataService(new SomeDataServiceStubEmptyValue());
		int actualValue=someBusiness.calculateSumUsingDataService();
		int expectedValue=0;
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	void calculateSumUsingDataService_SingleValue() {
		SomeBusiness someBusiness=new SomeBusiness();
		someBusiness.setSomeDataService(new SomeDataServiceStubSingleValue());
		int actualValue=someBusiness.calculateSumUsingDataService();
		int expectedValue=1;
		assertEquals(expectedValue,actualValue);
	}

}
