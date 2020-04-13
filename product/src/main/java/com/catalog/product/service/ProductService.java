package com.catalog.product.service;

import com.catalog.product.model.Product;
import com.catalog.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository repo;
    public List<Product> listAll() {
        return repo.findAll();
    }

    public void save(Product product){
        repo.save(product);
    }

    public Product get(long id){
        return repo.findById(id).get();
    }
    public void delete(long id){
        repo.deleteById(id);
    }


}

