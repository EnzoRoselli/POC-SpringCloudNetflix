package edu.utn.items.service;

import edu.utn.items.feign.ProductClient;
import edu.utn.items.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ProductClient productClient;

    public Item findById(Long id, Integer quantity) {
        return Item.builder().product(productClient.getById(id)).quantity(quantity).build();
    }
}
