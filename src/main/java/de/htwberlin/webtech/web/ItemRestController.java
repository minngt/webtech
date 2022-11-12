package de.htwberlin.webtech.web;

import de.htwberlin.webtech.persistence.ItemRepository;
import de.htwberlin.webtech.service.ItemService;
import de.htwberlin.webtech.web.api.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/api/v1/items")
    public ResponseEntity<List<Item>> fetchItems(){
        return ResponseEntity.ok(itemService.findAll());
    }
}
