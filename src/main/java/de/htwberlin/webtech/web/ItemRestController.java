package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemRestController {

    private List<Item> items;

    public ItemRestController() {
        items = new ArrayList<>();
        items.add(new Item(1, "Pork", "gram", 400));
        items.add(new Item(2, "Broccoli", "gram", 500));
    }

    @GetMapping(path = "/api/v1/items")
    public ResponseEntity<List<Item>> fetchItems(){
        return ResponseEntity.ok(items);
    }
}
