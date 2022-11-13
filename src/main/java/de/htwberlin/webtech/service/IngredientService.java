package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Course;
import de.htwberlin.webtech.persistence.IngredientEntity;
import de.htwberlin.webtech.persistence.IngredientRepository;
import de.htwberlin.webtech.persistence.MenuRepository;
import de.htwberlin.webtech.web.api.Ingredient;
import de.htwberlin.webtech.web.api.IngredientManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final MenuRepository menuRepository;

    public IngredientService(IngredientRepository ingredientRepository, MenuRepository menuRepository) {
        this.ingredientRepository = ingredientRepository;
        this.menuRepository = menuRepository;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> pets = ingredientRepository.findAll();
        return pets.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Ingredient create(IngredientManipulationRequest request) {
        var course = Course.valueOf(request.getCourse());
        var meal = menuRepository.findById(request.getMealId()).orElseThrow();
        var ingredientEntity = new IngredientEntity(request.getIngsName(), course, meal);
        ingredientEntity = ingredientRepository.save(ingredientEntity);
        return transformEntity(ingredientEntity);
    }

    private Ingredient transformEntity(IngredientEntity ingredientEntity) {
        var course = ingredientEntity.getCourse() != null ? ingredientEntity.getCourse().name() : Course.OTHER.name();
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getIngsName(),
                course,
                ingredientEntity.getMeal().getId());
    }
}
