package de.htwberlin.webtech.web;

import de.htwberlin.webtech.persistence.IngredientEntity;
import de.htwberlin.webtech.service.IngredientService;
import de.htwberlin.webtech.web.api.Ingredient;
import de.htwberlin.webtech.web.api.IngredientManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class IngredientRestController {

    private final IngredientService ingredientService;

    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping(path= "/api/v1/ingredients")
    public ResponseEntity<List<Ingredient>> fetchIngredients(){
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @PostMapping(path = "/api/v1/ingredients")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientManipulationRequest request) throws URISyntaxException {
        var ingredient = ingredientService.create(request);
        URI uri = new URI("/api/v1/ingredients/" + ingredient.getId());
        return ResponseEntity.created(uri).build();
    }
}
