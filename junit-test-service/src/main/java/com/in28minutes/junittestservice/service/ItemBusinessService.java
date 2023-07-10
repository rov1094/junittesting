package com.in28minutes.junittestservice.service;

import org.springframework.stereotype.Service;

import com.in28minutes.junittestservice.dto.Item;

@Service
public class ItemBusinessService {

	public Item handCodedeItem() {
		return new Item(1, "Ball", 10, 100);
	}

}
