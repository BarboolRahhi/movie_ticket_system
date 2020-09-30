package com.cg.movieticketsystem.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movieticketsystem.entity.Movie;
import com.cg.movieticketsystem.entity.Screen;
import com.cg.movieticketsystem.entity.Show;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.MovieRepository;
import com.cg.movieticketsystem.repository.ScreenRepository;
import com.cg.movieticketsystem.repository.ShowRepository;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;

@Service
@Transactional
public class AdminShowServiceImpl implements AdminShowService {

	@Autowired
	ShowRepository showRepository;

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Show addItem(Show model) {
		Screen screen = screenRepository.findById(model.getScreen().getScreenId())
				.orElseThrow(() -> new NotFoundException(Constants.SCREEN_NOT_FOUND));

		Theater theater = theaterRepository.findById(model.getTheater().getTheaterId())
				.orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));
		model.setScreen(screen);
		model.setTheater(theater);
		return showRepository.save(model);
	}

	@Override
	public Show updateItem(Long id, Show model) throws NotFoundException {

		Show show = showRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.SHOW_NOT_FOUND));

		Movie movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.MOVIE_NOT_FOUND));

		Screen screen = screenRepository.findById(model.getScreen().getScreenId())
				.orElseThrow(() -> new NotFoundException(Constants.SCREEN_NOT_FOUND));

		Theater theater = theaterRepository.findById(model.getTheater().getTheaterId())
				.orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));

		show.setShowName(model.getShowName());
		show.setShowStartTime(model.getShowStartTime());
		show.setShowEndTime(model.getShowEndTime());
		show.setTheater(theater);
		show.setScreen(screen);
		show.setMovie(movie);

		return showRepository.save(show);
	}

	@Override
	public void deleteItem(Long id) throws NotFoundException {
		Show show = showRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.SHOW_NOT_FOUND));
		showRepository.deleteById(show.getShowId());
	}

	@Override
	public List<Show> getItems() {
		return showRepository.findAll();
	}

	@Override
	public Show getItem(Long id) {

		return null;
	}

}
