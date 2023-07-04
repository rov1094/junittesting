package com.in28minutes.junittestservice.service;

public class SomeBusiness {
	
	private SomeDataService someDataService;
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}


	public int calculateSum(int[] data) {
		int result=0;
		for(int value:data) {
			result+=value;
		}
		return result;
	}

	
	public int calculateSumUsingDataService() {
		int[] data=someDataService.retrieveAllData();
		int result=0;
		for(int value:data) {
			result+=value;
		}
		return result;
	}

}
