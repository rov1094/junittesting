package com.in28minutes.junittestservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.junittestservice.dto.Item;
import com.in28minutes.junittestservice.repository.ItemRepository;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository itemReporsitory;

	public Item hardCodedeItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> allItemFromDB() {
		List<Item> items= itemReporsitory.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		return items;
	}

}
