package com.example.gas_station.services;

import com.example.gas_station.model.Item;
import com.example.gas_station.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) throws Exception {
        return itemRepository.findById(id)
                .orElseThrow(() -> new Exception("Item not found"));
    }

    public Item createNewItem(Item item) throws Exception {

        if (item.getIdItem() != null) {
            throw new Exception("Id is not null. Id is decided by DB.");
        }

        return itemRepository.save(item);
    }
    public Item updateItem(Item item, Long id) throws Exception {

        if (! item.getIdItem().equals(id)) {
            throw new Exception("ids doesn't match.");
        }

        Item itemFromDB = this.getItemById(id);

        itemFromDB.setCode(item.getCode());
        itemFromDB.setDescription(itemFromDB.getDescription());
        itemFromDB.setItemType(itemFromDB.getItemType());
        itemFromDB.setPrice(itemFromDB.getPrice());
        itemFromDB.setCost(itemFromDB.getCost());


        return itemRepository.save(itemFromDB);
    }


    public void deleteItem(Long id) throws Exception{

        itemRepository.deleteById(id);
    }




}
