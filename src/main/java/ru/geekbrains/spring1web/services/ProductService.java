package ru.geekbrains.spring1web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1web.entities.Product;
import ru.geekbrains.spring1web.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

    public void changePrice(Long id, Integer delta) {
        Product p = productRepository.findById(id);
        p.setPrice(p.getPrice() + delta);
    }
}

