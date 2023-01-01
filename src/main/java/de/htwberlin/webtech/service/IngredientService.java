package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.IngredientEntity;
import de.htwberlin.webtech.persistence.IngredientRepository;
import de.htwberlin.webtech.persistence.MenuRepository;
import de.htwberlin.webtech.web.api.Ingredient;
import de.htwberlin.webtech.web.api.IngredientManipulationRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final MenuRepository menuRepository;
    private final MenuTransformer menuTransformer;

    public IngredientService(IngredientRepository ingredientRepository, MenuRepository menuRepository, MenuTransformer menuTransformer) {
        this.ingredientRepository = ingredientRepository;
        this.menuRepository = menuRepository;
        this.menuTransformer = menuTransformer;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> ingredients = ingredientRepository.findAll();
        return ingredients.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Ingredient create(IngredientManipulationRequest request) {
        var category = Category.valueOf(request.getCategory());
        var meal = menuRepository.findById(request.getMealId()).orElseThrow();
        var ingredientEntity = new IngredientEntity(request.getIngsName(), request.getQuantity(), request.getUnit(), category, meal);
        ingredientEntity = ingredientRepository.save(ingredientEntity);
        return transformEntity(ingredientEntity);
    }
    public Ingredient update(Long id, IngredientManipulationRequest request) {
        var ingredientEntityOptional = ingredientRepository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }

        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setIngsName(request.getIngsName());
        ingredientEntity.setUnit(request.getUnit());
        ingredientEntity.setQuantity(request.getQuantity());
        ingredientEntity.setCategory(Category.valueOf(request.getCategory()));
        ingredientEntity = ingredientRepository.save(ingredientEntity);

        return transformEntity(ingredientEntity);
    }

    public boolean deleteById(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return false;
        }

        ingredientRepository.deleteById(id);
        return true;
    }

    private Ingredient transformEntity(IngredientEntity ingredientEntity) {
        var category = ingredientEntity.getCategory() != null ? ingredientEntity.getCategory().name() : Category.OTHER.name();
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getIngsName(),
                ingredientEntity.getQuantity(),
                ingredientEntity.getUnit(),
                category,
                menuTransformer.transformEntity(ingredientEntity.getMeal()));
    }
}
