package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminTheaterService;
import com.cg.movieticketsystem.dto.response.MessageResponse;
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
 * AdminTheaterController implements BaseAdminController Where all rest methods
 * are defined.
 */
@RestController
@RequestMapping("/api/admin/theaters")
public class AdminTheaterController implements BaseAdminController<Theater, Long> {

	@Autowired
	AdminTheaterService adminTheaterService;

	/**
	 * End Points -> /api/admin/theater and Method -> Post
	 * 
	 * @param model contain payload theater
	 * @return ResponseEntiy with status 201 and theater object
	 */
	@Override
	public ResponseEntity<?> addItem(Theater model) {
		return ResponseEntity.status(HttpStatus.CREATED).body(adminTheaterService.addItem(model));
	}

	/**
	 * End Points -> /api/admin/theater/{id} and Method -> PUT
	 * 
	 * @param model contain payload theater
	 * @param id    is PathVariable contain id for updating Theater
	 * @return ResponseEntiy with status 200 and Theater response
	 */
	@Override
	public ResponseEntity<?> updateItem(Long id, Theater model) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(adminTheaterService.updateItem(id, model));
	}

	/**
	 * End Points -> /api/admin/theater/{id} and Method -> DELETE
	 * 
	 * @param id is PathVariable contain id for Deleting theater
	 * @return ResponseEntiy with status 200 and Message Theater
	 */
	@Override
	public ResponseEntity<?> deleteItem(Long id) throws NotFoundException {
		adminTheaterService.deleteItem(id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
	}

	/**
	 * End Points -> /api/admin/theater and Method -> GET
	 * 
	 * @return ResponseEntiy with status 200 and List Of Theater response
	 */
	@Override
	public ResponseEntity<List<Theater>> getItems() {
		return ResponseEntity.status(HttpStatus.OK).body(adminTheaterService.getItems());
	}

	@Override
	public ResponseEntity<Theater> getItem(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(adminTheaterService.getItem(id));
	}

}
