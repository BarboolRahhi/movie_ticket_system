package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminScreenService;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.entity.Screen;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminScreenController implements BaseAdminController and inherit all rest
 * method from it
 * 
 * @author Rahhi Barbool
 *
 */
@RestController
@RequestMapping("/api/admin/screens")
public class AdminScreenController implements BaseAdminController<Screen, Long> {

	@Autowired
	private AdminScreenService screenService;

	/**
	 * End Points -> /api/admin/screen/ and Method -> Post
	 * 
	 * @param model contain payload screen
	 * @return ResponseEntiy with status 201 and Screen response
	 */
	@Override
	public ResponseEntity<?> addItem(Screen model) {
		return ResponseEntity.status(HttpStatus.CREATED).body(screenService.addItem(model));
	}

	/**
	 * End Points -> /api/admin/screen/{id} and Method -> PUT
	 * 
	 * @param model contain payload screen
	 * @param id    is PathVariable contain id for updating Screen
	 * @return ResponseEntiy with status 200 and Screen response
	 */
	@Override
	public ResponseEntity<?> updateItem(Long id, Screen model) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(screenService.updateItem(id, model));
	}

	/**
	 * End Points -> /api/admin/screen/{id} and Method -> DELETE
	 * 
	 * @param id is PathVariable contain id for Deleting Screen
	 * @return ResponseEntiy with status 200 and Message response
	 */
	@Override
	public ResponseEntity<?> deleteItem(Long id) throws NotFoundException {
		screenService.deleteItem(id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
	}

	/**
	 * End Points -> /api/admin/screen and Method -> GET
	 * 
	 * @return ResponseEntiy with status 200 and List Of Screen response
	 */
	@Override
	public ResponseEntity<List<Screen>> getItems() {
		return ResponseEntity.status(HttpStatus.OK).body(screenService.getItems());
	}
	
	@Override
	public ResponseEntity<Screen> getItem(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(screenService.getItem(id));
	}



}