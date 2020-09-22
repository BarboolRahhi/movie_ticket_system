package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminMovieServiceImpl;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.MovieRepository;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/movie")
public class AdminMovieController implements BaseAdminController<Movie, Long> {

    @Autowired
    private AdminMovieServiceImpl adminMovieService;

    @Override
    public Movie addItem(Movie model) {
        System.out.println("Movie get: " + model);
        return adminMovieService.addItem(model);
    }

    @Override
    public Movie updateItem(Long id, Movie model) throws NotFoundException {
        return adminMovieService.updateItem(id, model);
    }

    @Override
    public MessageResponse deleteItem(Long id) throws NotFoundException {
        adminMovieService.deleteItem(id);
        return new MessageResponse(Constants.DELETE_SUCCESSFULLY);
    }
}
