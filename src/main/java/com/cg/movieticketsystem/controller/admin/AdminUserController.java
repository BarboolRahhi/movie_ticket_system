package com.cg.movieticketsystem.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movieticketsystem.Service.admin.AdminUserService;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.entity.User;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;

@RestController
@RequestMapping("/api/admin/users/")
public class AdminUserController {

	@Autowired
	private AdminUserService userService;

	/**
	 * End Points -> /api/admin/users/ and Method -> Post
	 * 
	 * @param model contain payload User
	 * @return ResponseEntiy with status 201 and User object
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<User> addItem(@RequestBody User model) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addItem(model));
	}

	/**
	 * End Points -> /api/admin/users/{id} and Method -> PUT
	 * 
	 * @param model contain payload user
	 * @param id    is PathVariable contain id for updating User
	 * @return ResponseEntiy with status 200 and User response
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<User> updateItem(@PathVariable Long id, @RequestBody User model) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateItem(id, model));
	}
	

	/**
	 * End Points -> /api/admin/users/{id} and Method -> DELETE
	 * 
	 * @param id is PathVariable contain id for Deleting Users
	 * @return ResponseEntiy with status 200 and Message response
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> deleteItem(@PathVariable Long id) throws NotFoundException {
		userService.deleteItem(id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
	}

	/**
	 * End Points -> /api/admin/users/ and Method -> GET
	 * 
	 * @return ResponseEntiy with status 200 and List Of User response
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<User>> getItems() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getItems());
	}

	/**
	 * End Points -> /api/admin/users/{id} and Method -> GET
	 * 
	 * @param id is PathVariable contain id for getting single User
	 * @return ResponseEntiy with status 200 and User response
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<User> getItem(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getItem(id));
	}

}
