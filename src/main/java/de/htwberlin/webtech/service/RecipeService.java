package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.RecipeEntity;
import de.htwberlin.webtech.persistence.RecipeRepository;
import de.htwberlin.webtech.web.api.Recipe;
import de.htwberlin.webtech.web.api.RecipeManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeTransformer recipeTransformer;

    public RecipeService(RecipeRepository recipeRepository, RecipeTransformer recipeTransformer) {
        this.recipeRepository = recipeRepository;
        this.recipeTransformer = recipeTransformer;
    }

    public List<Recipe> findAll(){
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipeTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long id){
        var recipeEntity = recipeRepository.findById(id);
        return recipeEntity.map(recipeTransformer::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request){
        var category = Category.valueOf(request.getCategory());
        var recipeEntity = new RecipeEntity(request.getRecipeName(),
                                        category,
                                        request.getIngredients(),
                                        request.getPortion(),
                                        request.getTotalTime(),
                                        request.getDirection());
        recipeEntity = recipeRepository.save(recipeEntity);
        return recipeTransformer.transformEntity(recipeEntity);
    }

    public Recipe update(Long id, RecipeManipulationRequest request) {
        var recipeEntityOptional = recipeRepository.findById(id);
        if (recipeEntityOptional.isEmpty()) {
            return null;
        }

        var recipeEntity = recipeEntityOptional.get();
        recipeEntity.setRecipeName(request.getRecipeName());
        recipeEntity.setCategory(Category.valueOf(request.getCategory()));
        recipeEntity.setIngredients(request.getIngredients());
        recipeEntity.setPortion(request.getPortion());
        recipeEntity.setTotalTime(request.getTotalTime());
        recipeEntity.setDirection(request.getDirection());
        recipeEntity = recipeRepository.save(recipeEntity);

        return recipeTransformer.transformEntity(recipeEntity);
    }

    public boolean deleteById(Long id) {
        if (!recipeRepository.existsById(id)) {
            return false;
        }

        recipeRepository.deleteById(id);
        return true;
    }
}
