// SubcategoryController.java

package com.example.test.controller;

import com.example.test.entity.Subcategory;
import com.example.test.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/{id}")
    public Optional<Subcategory> getSubcategoryById(@PathVariable Long id) {
        return subcategoryService.getSubcategoryById(id);
    }

    @PostMapping
    public Subcategory saveSubcategory(@RequestBody Subcategory subcategory) {
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("image") String image,
            @RequestParam("category") Long categoryId) {

        // Validate and process the file
        byte[] imageBytes;
        try {
            imageBytes = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to process the uploaded file.", e);
        }

        // Create Subcategory object with imageBytes
        Subcategory subcategory = new Subcategory(name, image, categorieService.getCategoryById(categoryId).orElse(null));
        subcategory.setImageBytes(imageBytes);

        // Save the Subcategory to the database
        return subcategoryService.saveSubcategory(subcategory);}

    @DeleteMapping("/{id}")
    public void deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
