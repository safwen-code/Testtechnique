// CategoryService.java

package com.example.test.service;

import com.example.test.entity.Category;
import com.example.test.Repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategorieRepo;

    public List<Category> getAllCategories() {
        return CategorieRepo.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return CategorieRepo.findById(id);
    }

    public categories saveCategory(categories category) {
        return CategorieRepo.save(category);
    }

    public void deleteCategory(Long id) {
        CategorieRepo.deleteById(id);
    }
     public List<Subcategory> getAllSubcategoriesForCategory(Long categoryId) {
        // Validate that the category exists
        Category category = getCategoryById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        // Retrieve all subcategories for the given category
        return category.getSubcategories();
    }
}
