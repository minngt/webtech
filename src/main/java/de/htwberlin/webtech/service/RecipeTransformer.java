package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.RecipeEntity;
import de.htwberlin.webtech.web.api.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeTransformer {
    public Recipe transformEntity(RecipeEntity recipeEntity) {
        var category = recipeEntity.getCategory() != null ? recipeEntity.getCategory().name() : Category.OTHER.name();
        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getRecipeName(),
                category,
                recipeEntity.getIngredients(),
                recipeEntity.getPortion(),
                recipeEntity.getTotalTime(),
                recipeEntity.getDirection()

        );
    }

}
