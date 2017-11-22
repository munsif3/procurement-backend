package com.sliit.procurement.controller;

import com.sliit.procurement.model.Item;
import com.sliit.procurement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 22/11/2017.
 */
@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
