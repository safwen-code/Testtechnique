// CategoryController.java

package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Category;
import com.example.springbootproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categorieService;

    @GetMapping
    public List<Category> getAllCategories() {
        return CategoryService.getAllCategories();
    }

    @GetMapping("/{id}/subcategory")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getAllSubcategoriesForCategory(id);
    }

    @PostMapping
    public Category saveCategory(@RequestBody categories category) {
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("image") String image) {

        // go to file
        byte[] imageBytes;
        try {
            imageBytes = file.getBytes();
        } catch (IOException e) {
            //  exception 
            throw new RuntimeException("Failed to process  file.", e);
        }

        // Create Category object with imageBytes
        //some problem ??
        Category category = new Category(name, image);
        category.setImageBytes(imageBytes);

        // Save the Category 
        return categoryService.saveCategory(category);    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        CategoryService.deleteCategory(id);
    }
}
