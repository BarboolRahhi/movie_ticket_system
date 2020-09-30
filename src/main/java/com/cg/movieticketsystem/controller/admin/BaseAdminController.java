package com.cg.movieticketsystem.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.exception.NotFoundException;

/**
 * Each method have security which is access by only ADMIN
 * 
 * @param <T> it represent Entity class or model
 * @param <V> it represent id or primary key of class
 */
public interface BaseAdminController<T, V> {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	ResponseEntity<List<T>> getItems();
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	ResponseEntity<?> getItem(@PathVariable("id") V id);

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	ResponseEntity<?> addItem(@Valid @RequestBody T model);

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	ResponseEntity<?> updateItem(@PathVariable("id") V id, @Valid @RequestBody T model) throws NotFoundException;

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteItem(@PathVariable("id") V id) throws NotFoundException;
}
