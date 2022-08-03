package com.clouldschool.homework4.Service;

import com.clouldschool.homework4.Model.Product;
import com.clouldschool.homework4.Repository.ProductRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> aux = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Product getProductById(Integer id) {
        Product aux = new Product();
        if (productRepository.findById(id).isPresent()) {
            aux = productRepository.findById(id).get();
        }
        return aux;
    }

    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    public Product updateProduct(Product product, Integer productId) {
        Product tmp = productRepository.findById(productId).get();
        tmp.setName(product.getName());
        tmp.setPrice(product.getPrice());
        return productRepository.save(tmp);
    }

    public void deleteById(Integer productId) {
        productRepository.deleteById(productId);
    }
}
