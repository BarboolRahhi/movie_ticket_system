package com.cg.movieticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movieticketsystem.Service.admin.AdminMovieService;
import com.cg.movieticketsystem.Service.admin.AdminMovieServiceImpl;
import com.cg.movieticketsystem.Service.admin.AdminTheaterService;
import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.MovieRepository;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;

@SpringBootTest
public class AdminMovieServiceTests {
	
	
	@Mock
	private MovieRepository movieRepository;

	@Mock
	private TheaterRepository theaterRepository;

	@InjectMocks
	private AdminMovieServiceImpl movieService;
	
	
	@Test
    void add_test() {
        
        Theater theater= new Theater(
                12L,
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        
        Movie movie = new Movie();
        movie.setMovieName("avenger");
        movie.setMovieGenre("dc");
        movie.setLanguages( new HashSet<String>(Arrays.asList("English", "Hindi")));
        movie.setMovieLength(4);
        movie.setMovieReleaseDate(LocalDate.of(2020, 11, 12));
        movie.setTheater(theater);
        
        Movie returnMovie = new Movie();
        returnMovie.setMovieId(14L);
        returnMovie.setMovieName("avenger");
        returnMovie.setMovieGenre("dc");
        returnMovie.setLanguages( new HashSet<String>(Arrays.asList("English", "Hindi")));
        returnMovie.setMovieLength(4);
        returnMovie.setMovieReleaseDate(LocalDate.of(2020, 11, 12));
        returnMovie.setTheater(theater);
        
        when(theaterRepository.findById(any(Long.class))).thenReturn(Optional.of(theater));
        when(movieRepository.save(any(Movie.class))).thenReturn(returnMovie);
        

        assertEquals(movieService.addItem(movie).getMovieId(), 14L);
    }

    @Test
    void update_exception_test() {
        doThrow(new NotFoundException(Constants.MOVIE_NOT_FOUND)).when(movieRepository).findById(10L);
        
        Exception ex = assertThrows(NotFoundException.class, () -> {
            movieService.updateItem(10L, any(Movie.class));
        });
        assertEquals(Constants.MOVIE_NOT_FOUND, ex.getMessage());
        verify(movieRepository, never()).save(any(Movie.class));
    }

    @Test
    void delete_test() {
        doNothing().when(movieRepository).deleteById(anyLong());
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(new Movie()));
        movieService.deleteItem(anyLong());
        verify(movieRepository, times(1)).deleteById(anyLong());
    }

}
