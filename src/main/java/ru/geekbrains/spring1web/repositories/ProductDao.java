package ru.geekbrains.spring1web.repositories;
import ru.geekbrains.spring1web.entities.Product;
import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    void deleteProduct(Long id);
    Product findById(Long id);

    void save(Product p);
}
