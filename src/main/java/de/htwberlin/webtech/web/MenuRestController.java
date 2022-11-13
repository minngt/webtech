package de.htwberlin.webtech.web;


import de.htwberlin.webtech.service.MenuService;
import de.htwberlin.webtech.web.api.Menu;
import de.htwberlin.webtech.web.api.MenuManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MenuRestController {

    private final MenuService menuService;

    public MenuRestController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping(path = "/api/v1/menus")
    public ResponseEntity<List<Menu>> fetchMenus(){
        return ResponseEntity.ok(menuService.findAll());
    }

    @GetMapping(path="/api/v1/menus/{id}")
    public ResponseEntity<Menu> fetchMenuById(@PathVariable Long id){
        var menu = menuService.findById(id);
        return menu != null ? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/menus")
    public  ResponseEntity<Void> createMenu(@RequestBody MenuManipulationRequest request) throws URISyntaxException {
        var menu = menuService.create(request);
        URI uri = new URI("api/v1/menus/" + menu.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/menus/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody MenuManipulationRequest request){
        var menu = menuService.update(id, request);
        return menu != null? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/menus/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id){
        boolean successful = menuService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
