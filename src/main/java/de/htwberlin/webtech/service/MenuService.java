package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.MenuEntity;
import de.htwberlin.webtech.persistence.MenuRepository;
import de.htwberlin.webtech.web.api.Menu;
import de.htwberlin.webtech.web.api.MenuManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuTransformer menuTransformer;

    public MenuService(MenuRepository menuRepository, MenuTransformer menuTransformer) {
        this.menuRepository = menuRepository;
        this.menuTransformer = menuTransformer;
    }

    public List<Menu> findAll(){
        List<MenuEntity> menus = menuRepository.findAll();
        return menus.stream()
                .map(menuTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Menu findById(Long id){
        var menuEntity = menuRepository.findById(id);
        return menuEntity.map(menuTransformer::transformEntity).orElse(null);
    }

    public Menu create(MenuManipulationRequest request){
        var category = Category.valueOf(request.getCategory());
        var menuEntity = new MenuEntity(request.getMenuName(), request.getUnit(), request.getQuantity(), category);
        menuEntity = menuRepository.save(menuEntity);
        return menuTransformer.transformEntity(menuEntity);
    }

    public Menu update(Long id, MenuManipulationRequest request) {
        var menuEntityOptional = menuRepository.findById(id);
        if (menuEntityOptional.isEmpty()) {
            return null;
        }

        var menuEntity = menuEntityOptional.get();
        menuEntity.setMenuName(request.getMenuName());
        menuEntity.setUnit(request.getUnit());
        menuEntity.setQuantity(request.getQuantity());
        menuEntity.setCategory(Category.valueOf(request.getCategory()));
        menuEntity = menuRepository.save(menuEntity);

        return menuTransformer.transformEntity(menuEntity);
    }

    public boolean deleteById(Long id) {
        if (!menuRepository.existsById(id)) {
            return false;
        }

        menuRepository.deleteById(id);
        return true;
    }
}
