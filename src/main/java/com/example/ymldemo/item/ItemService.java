package com.example.ymldemo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public List<Item> findByName(String name){
        return itemRepository.findByName(name);
    }

    public void save(Item item){
        itemRepository.save(item);
    }
}
