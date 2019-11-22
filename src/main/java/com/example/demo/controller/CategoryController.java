package com.example.demo.controller;

import com.example.demo.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.CategoryRepository;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepositor) {
        super();
        this.categoryRepository = categoryRepositor;
    }

    @GetMapping("/categories")
    Collection<Category>categories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/category")
    ResponseEntity<Category>createCategory(@Valid @RequestBody Category category)
    throws URISyntaxException {
        Category result = categoryRepository.save(category);
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
    }
    @PutMapping("/category/{id}")
    ResponseEntity<Category>updateCategory(@Valid @RequestBody Category category){
        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/category/{id}")
    ResponseEntity<Category>deleteCategory(){
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
