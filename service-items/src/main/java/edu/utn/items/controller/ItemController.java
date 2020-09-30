package edu.utn.items.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.utn.items.model.Item;
import edu.utn.items.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ItemController {
    private final ItemService itemService;

    @HystrixCommand(fallbackMethod = "defaultFindById")
    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id, @RequestParam Integer quantity){
        return itemService.findById(id, quantity);
    }

    private Item defaultFindById(Long id, Integer quantity){
        return Item.getDefaultItem(id, quantity);
    }
}
