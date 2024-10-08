package com.wakefit.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wakefit.ecommerce.entity.Category;
import com.wakefit.ecommerce.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/Category/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/Category/{catId}")
    public Category getCategoryById(@PathVariable Long catId) {
        return categoryService.getCategoryById(catId);
    }

    @GetMapping("/Category/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping("/Category/update")
    public Category updateCategory(@PathVariable Long catId, @RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/Category/delete/{catId}")
    public void deleteCategory(@PathVariable Long catId) {
        categoryService.deleteCategory(catId);
    }
}
