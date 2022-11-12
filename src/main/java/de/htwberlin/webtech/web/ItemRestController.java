package de.htwberlin.webtech.web;


import de.htwberlin.webtech.service.ItemService;
import de.htwberlin.webtech.web.api.Item;
import de.htwberlin.webtech.web.api.ItemCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path = "/api/v1/items")
    public  ResponseEntity<Void> createItem(@RequestBody ItemCreateRequest request) throws URISyntaxException {
        var item = itemService.create(request);
        URI uri = new URI("api/v1/items/" + item.getId());
        return ResponseEntity.created(uri).build();
    }

}
