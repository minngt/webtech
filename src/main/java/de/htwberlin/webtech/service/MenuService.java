package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Course;
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

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAll(){
        List<MenuEntity> menus = menuRepository.findAll();
        return menus.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Menu findById(Long id){
        var menuEntity = menuRepository.findById(id);
        return menuEntity.map(this::transformEntity).orElse(null);
    }

    public Menu create(MenuManipulationRequest request){
        var course = Course.valueOf(request.getCourse());
        var menuEntity = new MenuEntity(request.getMenuName(), request.getUnit(), request.getQuantity(), course);
        menuEntity = menuRepository.save(menuEntity);
        return transformEntity(menuEntity);
    }

    private Menu transformEntity(MenuEntity menuEntity){
        var course = menuEntity.getCourse() != null ? menuEntity.getCourse().name() : Course.OTHER.name();
        return new Menu(
                menuEntity.getId(),
                menuEntity.getMenuName(),
                menuEntity.getUnit(),
                menuEntity.getQuantity(),
                course
        );
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
        menuEntity.setCourse(Course.valueOf(request.getCourse()));
        menuEntity = menuRepository.save(menuEntity);

        return transformEntity(menuEntity);
    }

    public boolean deleteById(Long id) {
        if (!menuRepository.existsById(id)) {
            return false;
        }

        menuRepository.deleteById(id);
        return true;
    }
}
