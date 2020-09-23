package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.MovieRepository;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminMovieServiceImpl implements AdminMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Movie addItem(Movie model) {
        Theater theater = theaterRepository.findById(model.getTheater().getTheaterId())
                .orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));
        model.setTheater(theater);
        return movieRepository.save(model);
    }

    @Override
    public Movie updateItem(Long id, Movie model) throws NotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.MOVIE_NOT_FOUND));
        Theater theater = theaterRepository.findById(model.getTheater().getTheaterId())
                .orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));
        movie.setMovieName(model.getMovieName());
        movie.setMovieLength(model.getMovieLength());
        movie.setLanguages(model.getLanguages());
        movie.setMovieDirector(model.getMovieDirector());
        movie.setMovieGenre(model.getMovieGenre());
        movie.setMovieReleaseDate(model.getMovieReleaseDate());
        movie.setTheater(theater);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteItem(Long id) throws NotFoundException {
        movieRepository.deleteById(id);
    }
}
