package com.in28minutes.junittestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.junittestservice.dto.Item;
import com.in28minutes.junittestservice.service.ItemBusinessService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService itemBusinessService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item serviceItem() {
		return itemBusinessService.handCodedeItem();
	}

}
