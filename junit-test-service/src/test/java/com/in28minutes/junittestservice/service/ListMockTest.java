package com.in28minutes.junittestservice.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListMockTest {
	
	List mock=Mockito.mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	public void returnwithDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnwithParameterValues() {
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes",mock.get(0));
		assertEquals(null,mock.get(1));
		
	}

}
