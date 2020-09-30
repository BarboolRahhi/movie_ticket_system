package com.cg.movieticketsystem.controller.admin;

import java.util.List;

import javax.validation.Valid;

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

import com.cg.movieticketsystem.Service.admin.AdminShowService;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Show;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;

@RestController
@RequestMapping("/api/admin/show")
public class AdminShowController {
	
	@Autowired
	private AdminShowService showService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	ResponseEntity<List<Show>> getItems() {
		return ResponseEntity.status(HttpStatus.OK).body(showService.getItems());
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	ResponseEntity<Show> addItem(@Valid @RequestBody Show show){
		return ResponseEntity.status(HttpStatus.CREATED).body(showService.addItem(show));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	ResponseEntity<Show> updateItem(@PathVariable("id") Long id, @Valid @RequestBody Show show) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(showService.updateItem(id, show));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	ResponseEntity<MessageResponse> deleteItem(@PathVariable("id") Long id) throws NotFoundException {
		showService.deleteItem(id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
	}
}
