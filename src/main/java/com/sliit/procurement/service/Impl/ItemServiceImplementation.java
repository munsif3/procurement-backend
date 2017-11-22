package com.sliit.procurement.service.Impl;

import com.sliit.procurement.model.Item;
import com.sliit.procurement.repository.ItemRepository;
import com.sliit.procurement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
@Service
public class ItemServiceImplementation implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems(){ return itemRepository.findAll();}
}
