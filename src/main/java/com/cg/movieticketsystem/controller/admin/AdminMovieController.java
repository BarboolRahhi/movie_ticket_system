package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminMovieService;
import com.cg.movieticketsystem.Service.admin.AdminMovieServiceImpl;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.MovieRepository;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/movie")
public class AdminMovieController implements BaseAdminController<Movie, Long> {

    @Autowired
    private AdminMovieService adminMovieService;

    @Override
    public ResponseEntity<?> addItem(@Valid Movie model) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(adminMovieService.addItem(model));
    }

    @Override
    public ResponseEntity<?> updateItem(Long id, Movie model) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminMovieService.updateItem(id, model));
    }

    @Override
    public ResponseEntity<?> deleteItem(Long id) throws NotFoundException {
        adminMovieService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
    }
}
