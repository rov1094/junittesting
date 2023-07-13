package com.in28minutes.junittestservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.junittestservice.dto.Item;
import com.in28minutes.junittestservice.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService itemBusinessService;
	
	@Mock
	private ItemRepository itemRepository;

	@Test
	void testDummyItem() {
		Item expectedItem=new Item(1, "Ball", 10, 100);
		Item actualItem=itemBusinessService.hardCodedeItem();
		assertEquals(expectedItem,actualItem);
	}
	
	
	@Test
	void allItemFromDB() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "Item1", 10, 100),new Item(2, "Item2", 10, 100)));
		List<Item> expectedItem=Arrays.asList(new Item(1, "Item1", 10, 100),new Item(2, "Item2", 10, 100));
		for (Item item : expectedItem) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		List<Item> actualItem=itemBusinessService.allItemFromDB();
		assertEquals(expectedItem,actualItem);
	}
	

}
