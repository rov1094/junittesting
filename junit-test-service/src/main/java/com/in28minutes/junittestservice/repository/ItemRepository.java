package com.in28minutes.junittestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.junittestservice.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
