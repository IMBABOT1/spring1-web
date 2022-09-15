package ru.geekbrains.spring1web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1web.entities.Product;
import ru.geekbrains.spring1web.repositories.InMemoryProductRepository;
import ru.geekbrains.spring1web.repositories.ProductDao;
import ru.geekbrains.spring1web.repositories.ProductDaoImpl;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductRepository(ProductDaoImpl productDaoImpl) {
        this.productDao = productDaoImpl;
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }

    public void changePrice(Long id, Integer delta) {
        Product p = productDao.findById(id);
        p.setPrice(p.getPrice() + delta);
        productDao.save(p);
    }
}

