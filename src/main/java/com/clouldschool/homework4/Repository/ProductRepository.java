package com.clouldschool.homework4.Repository;

import com.clouldschool.homework4.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    public void delete(Product product);
}
