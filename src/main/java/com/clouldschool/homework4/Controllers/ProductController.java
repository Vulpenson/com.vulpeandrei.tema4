package com.clouldschool.homework4.Controllers;

import com.clouldschool.homework4.Model.Product;
import com.clouldschool.homework4.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    // Method to get all products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Method to get a product by id
    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable(value = "id") Integer productId) {
        return productService.getProductById(productId);
    }

    // Method to insert a new product
    @PostMapping
    public void insertProduct(@RequestBody Product product) {
        productService.insertProduct(product);
    }

    // Method to update a pre-existent product
    @PostMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,
                                 @RequestBody Product product) {
        return productService.updateProduct(product, id);
    }

    // Method to delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }
}
