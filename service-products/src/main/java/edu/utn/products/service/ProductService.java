package edu.utn.products.service;

import edu.utn.commonsproduct.entity.Product;
import edu.utn.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
