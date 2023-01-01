package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.IngredientEntity;
import de.htwberlin.webtech.persistence.MenuEntity;
import de.htwberlin.webtech.web.api.Menu;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuTransformer {
    public Menu transformEntity(MenuEntity menuEntity){
        var category= menuEntity.getCategory() != null ? menuEntity.getCategory().name() : Category.OTHER.name();
        var ingsNames = menuEntity.getIngredients().stream().map(IngredientEntity::getIngsName).collect(Collectors.toList());
        return new Menu(
                menuEntity.getId(),
                menuEntity.getMenuName(),
                category,
                ingsNames
        );
    }

}
