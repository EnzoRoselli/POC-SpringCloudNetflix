package edu.utn.items.model;

import edu.utn.commonsproduct.entity.Product;
import lombok.*;

@Data
@Builder
public class Item {
    private Product product;
    private Integer quantity;

    public Double getTotal(){
        return product.getPrice() * quantity.doubleValue();
    }

    public static Item getDefaultItem(Long id, Integer quantity){
        return Item.builder().product(Product.builder().id(id).name("Default product").price(0.0).build())
                .quantity(quantity).build();
    }
}
