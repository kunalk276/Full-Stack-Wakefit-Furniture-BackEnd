package com.wakefit.ecommerce.service;

import java.util.List;

import com.wakefit.ecommerce.entity.Category;

public interface CategoryService {

    Category addCategory(Category category);

    Category getCategoryById(Long categoryId);

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);

	List<Category> getAllCategories();

  
}
