package edu.utn.items.feign;

import edu.utn.commonsproduct.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-products")
public interface ProductClient {
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id);
}
