package com.example.gas_station.Controllers;


import com.example.gas_station.model.Item;
import com.example.gas_station.repositories.ItemRepository;
import com.example.gas_station.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;
    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemService itemService,ItemRepository itemRepository){
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @GetMapping("")
    public List<Item> getAllItems() {

        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return itemService.getItemById(id);
    }
    @PostMapping("")
    public Item createItem(@RequestBody Item item) throws Exception {


        //code that gets user by id from database
        return itemService.createNewItem(item);
    }
    @PutMapping("/{id}")
    public Item updateItem(@RequestBody Item item, @PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return itemService.updateItem(item,id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) throws Exception{
        itemService.deleteItem(id);
    }

}
