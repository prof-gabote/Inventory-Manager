/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanager.controller;

import inventorymanager.model.Category;
import inventorymanager.repository.CategoryRepository;
import java.util.List;

/**
 *
 * @author Gabote
 */
public class CategoryController {
    
    private CategoryRepository cr;

    public CategoryController() {
        this.cr = new CategoryRepository();
    }
    
    public List<Category> getAllCategories(){
        return cr.findAllCategories();
    }
    
}
