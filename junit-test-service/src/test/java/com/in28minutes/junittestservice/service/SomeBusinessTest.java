package com.in28minutes.junittestservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	@Test
	void caculateSum_basic() {
		SomeBusiness someBusiness=new SomeBusiness();
		int actualValue=someBusiness.calculateSum(new int[] {1,2,3});
		int expectedValue=6;
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	void caculateSum_EmptyValue() {
		SomeBusiness someBusiness=new SomeBusiness();
		int actualValue=someBusiness.calculateSum(new int[] {});
		int expectedValue=0;
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	void caculateSum_SingleValue() {
		SomeBusiness someBusiness=new SomeBusiness();
		int actualValue=someBusiness.calculateSum(new int[] {1});
		int expectedValue=1;
		assertEquals(expectedValue,actualValue);
	}

}
