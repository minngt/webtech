package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Course;
import de.htwberlin.webtech.persistence.IngredientEntity;
import de.htwberlin.webtech.persistence.MenuEntity;
import de.htwberlin.webtech.web.api.Menu;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuTransformer {
    public Menu transformEntity(MenuEntity menuEntity){
        var course = menuEntity.getCourse() != null ? menuEntity.getCourse().name() : Course.OTHER.name();
        var ingsIds = menuEntity.getIngredients().stream().map(IngredientEntity::getId).collect(Collectors.toList());
        return new Menu(
                menuEntity.getId(),
                menuEntity.getMenuName(),
                menuEntity.getUnit(),
                menuEntity.getQuantity(),
                course,
                ingsIds
        );
    }

}
