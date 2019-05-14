package com.thinkitive.EasyShop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.EasyShop.dto.CategoryDTO;
import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.service.CategoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('ADMIN')")

	public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO categoryDTO) {

//	Category category=categoryService.getCategoryByCategoryId(categoryDTO.getCategoryid());

		Category category = new Category(categoryDTO);
		Date createdDate = new Date();
		category.setCategoryid(categoryDTO.getCategoryid());
		category.setLastUpdate(createdDate);
		;
		categoryService.createCategory(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	Page<Category> getAllCategory(Pageable pageable) {
		return categoryService.getAllCategory(pageable);

	}

	/*
	 * @GetMapping("/getAll") List<Category> getAllCategory() { return
	 * categoryService.getAllCategory(); }
	 */

	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) throws Exception {
		System.out.println("id ::::" + id);

		Category category = categoryService.getCategoryByCategoryId(id);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Category==> GetById " + id);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String name) throws Exception {
		System.out.println("name ::::" + name);
		Category category = categoryService.getCategoryByCategoryName(name);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		} else {
			categoryService.getCategoryByCategoryName(name);
			System.out.println("Category==> GetByName " + name);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/delete/{categoryId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("categoryId") int categoryId) {

		Category category = categoryService.getCategoryByCategoryId(categoryId);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		} else {
			categoryService.deleteCategoryById(categoryId);
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Category> deleteAllCategory() {

		List<Category> category = categoryService.getAllCategory();
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		} else {
			categoryService.deleteAllCategory();
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO categoryDTO) {
		Category category1 = new Category(categoryDTO);

		Category category = categoryService.getCategoryByCategoryId(category1.getCategoryid());
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		} else {
			category.setCategoryid(categoryDTO.getCategoryid());
			category.setCategoryName(categoryDTO.getCategoryName());
			category.setCategoryDescription(categoryDTO.getCategoryDescription());
			category.setLastUpdate(categoryDTO.getLastUpdate());
			categoryService.updateCategory(category, categoryDTO.getCategoryid());

			return new ResponseEntity<Category>(category, HttpStatus.CREATED);

		}
	}

}
