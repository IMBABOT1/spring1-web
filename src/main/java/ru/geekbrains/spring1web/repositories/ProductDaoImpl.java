package ru.geekbrains.spring1web.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1web.entities.Product;
import ru.geekbrains.spring1web.utils.SessionFactoryUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @PostConstruct
    public void init() {
        sessionFactoryUtils.init();
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> list = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return list;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product p = session.get(Product.class, id);
            session.delete(p);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
