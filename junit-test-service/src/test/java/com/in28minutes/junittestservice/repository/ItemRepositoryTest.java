package com.in28minutes.junittestservice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.in28minutes.junittestservice.dto.Item;

@DataJpaTest
class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;

	@Test
	void findAllItemTest() {
		List<Item> items=itemRepository.findAll();
		assertEquals(3, items.size());
	}

}
