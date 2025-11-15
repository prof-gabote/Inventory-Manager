/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanager.controller;

import inventorymanager.model.Product;
import inventorymanager.repository.ProductRepository;
import java.util.List;

/**
 *
 * @author Gabote
 */
public class ProductController {
    
    ProductRepository repository;

    public ProductController() {
        this.repository = new ProductRepository();
    }
    
    public Product getProductById(int id){
        return repository.findProductById(id);
    }
    
    public List<Product> getAllProducts(){
        return repository.findAllProducts();
    }
    
    public int countProducts(){
        return repository.countProducts();
    }
    
    public boolean addProduct(Product product){
        return repository.insertProduct(product);
    }
    
    public boolean updateProduct(int oldId, Product newProduct){
        return repository.updateProduct(oldId, newProduct);
    }
    
    public boolean deleteProduct(int id){
        return repository.deleteProductById(id);
    }
    
}
