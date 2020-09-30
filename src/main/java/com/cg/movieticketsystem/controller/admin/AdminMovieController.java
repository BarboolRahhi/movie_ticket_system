package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminMovieService;
import com.cg.movieticketsystem.Service.admin.AdminMovieServiceImpl;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.MovieRepository;
import com.cg.movieticketsystem.util.Constants;

import net.bytebuddy.implementation.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.xml.stream.events.EndDocument;

/**
 * AdminMovieController implements BaseAdminController and inherit all rest
 * method from it
 * 
 * @author Rahhi Barbool
 *
 */
@RestController
@RequestMapping("/api/admin/movies")
public class AdminMovieController implements BaseAdminController<Movie, Long> {

	@Autowired
	private AdminMovieService adminMovieService;

	/**
	 * End Points -> /api/admin/movies/ and Method -> Post
	 * 
	 * @param model contain payload movie
	 * @return ResponseEntiy with status 201 and movie object
	 */
	@Override
	public ResponseEntity<?> addItem(@Valid Movie model) {
		return ResponseEntity.status(HttpStatus.CREATED).body(adminMovieService.addItem(model));
	}

	/**
	 * End Points -> /api/admin/movies/{id} and Method -> PUT
	 * 
	 * @param model contain payload movie
	 * @param id    is PathVariable contain id for updating Movie
	 * @return ResponseEntiy with status 200 and Movie response
	 */
	@Override
	public ResponseEntity<?> updateItem(Long id, Movie model) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(adminMovieService.updateItem(id, model));
	}

	/**
	 * End Points -> /api/admin/movies/{id} and Method -> DELETE
	 * 
	 * @param id is PathVariable contain id for Deleting Movie
	 * @return ResponseEntiy with status 200 and Message response
	 */
	@Override
	public ResponseEntity<?> deleteItem(Long id) throws NotFoundException {
		adminMovieService.deleteItem(id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
	}

	/**
	 * End Points -> /api/admin/movies and Method -> GET
	 * 
	 * @return ResponseEntiy with status 200 and List Of Movie response
	 */
	@Override
	public ResponseEntity<List<Movie>> getItems() {
		return ResponseEntity.status(HttpStatus.OK).body(adminMovieService.getItems());
	}
	

	/**
	 * End Points -> /api/admin/movies/{id} and Method -> GET
	 * 
	 * @param id is PathVariable contain id for getting single Movie
	 * @return ResponseEntiy with status 200 and Movie response
	 */
	@Override
	public ResponseEntity<Movie> getItem(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(adminMovieService.getItem(id));
	}


}
