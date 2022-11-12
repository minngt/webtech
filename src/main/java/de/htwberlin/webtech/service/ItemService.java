package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.ItemEntity;
import de.htwberlin.webtech.persistence.ItemRepository;
import de.htwberlin.webtech.web.api.Item;
import de.htwberlin.webtech.web.api.ItemCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll(){
        List<ItemEntity> items = itemRepository.findAll();
        return items.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Item create(ItemCreateRequest request){
        var itemEntity = new ItemEntity(request.getItemName(), request.getUnit(), request.getQuantity());
        itemEntity = itemRepository.save(itemEntity);
        return transformEntity(itemEntity);
    }

    private Item transformEntity(ItemEntity itemEntity){
        return new Item(
                itemEntity.getId(),
                itemEntity.getItemName(),
                itemEntity.getUnit(),
                itemEntity.getQuantity()
        );
    }
}
