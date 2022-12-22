package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.ExtraEntity;
import de.htwberlin.webtech.persistence.ExtraRepository;
import de.htwberlin.webtech.persistence.MenuRepository;
import de.htwberlin.webtech.web.api.Extra;
import de.htwberlin.webtech.web.api.ExtraManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtraService {
    private final ExtraRepository extraRepository;
    private final MenuRepository menuRepository;
    private final MenuTransformer menuTransformer;

    public ExtraService(ExtraRepository extraRepository, MenuRepository menuRepository, MenuTransformer menuTransformer) {
        this.extraRepository = extraRepository;
        this.menuRepository = menuRepository;
        this.menuTransformer = menuTransformer;
    }

    public List<Extra> findAll() {
        List<ExtraEntity> extras = extraRepository.findAll();
        return extras.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Extra create(ExtraManipulationRequest request) {
        var category = Category.valueOf(request.getCategory());
        var meal = menuRepository.findById(request.getMealId()).orElseThrow();
        var extraEntity = new ExtraEntity(request.getExtraName(), category, meal);
        extraEntity = extraRepository.save(extraEntity);
        return transformEntity(extraEntity);
    }

    private Extra transformEntity(ExtraEntity extraEntity) {
        var category = extraEntity.getCategory() != null ? extraEntity.getCategory().name() : Category.OTHER.name();
        return new Extra(
                extraEntity.getId(),
                extraEntity.getExtraName(),
                category,
                menuTransformer.transformEntity(extraEntity.getMeal()));
    }
}
