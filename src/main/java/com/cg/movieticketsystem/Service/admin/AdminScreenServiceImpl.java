package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.entity.Screen;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.ScreenRepository;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminScreenServiceImpl implements AdminScreenService {

	private static final Logger logger = LoggerFactory.getLogger(AdminTheaterServiceImpl.class);

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	/**
	 * This method add Screen. if theater id not exists then throw NotFoundException
	 * 
	 * @return Movie with newly created id
	 */
	@Override
	public Screen addItem(Screen model) {
		Theater theater = theaterRepository.findById(model.getTheater().getTheaterId())
				.orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));
		model.setTheater(theater);
		logger.info("Adding Theater...");
		return screenRepository.save(model);
	}

	/**
	 * This method update screen entity. if screen id not exists then throw
	 * NotFoundException. if theater id not exists then throw NotFoundException
	 * 
	 * @param id    for updating screen
	 * @param model is Screen entity
	 * @return updated Screen
	 */
	@Override
	public Screen updateItem(Long id, Screen model) throws NotFoundException {
		Screen screen = screenRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(Constants.SCREEN_NOT_FOUND));

		Theater theater = theaterRepository.findById(model.getTheater().getTheaterId())
				.orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));

		screen.setScreenName(model.getScreenName());
		screen.setColumns(model.getColumns());
		screen.setRows(model.getRows());
		screen.setTheater(theater);
		logger.info("Updating Screen... with Id: {}", id);
		return screenRepository.save(screen);
	}

	/**
	 * This method Delete screen if theater id not exists then throw Exception
	 * 
	 * @param id for deleting screen
	 */
	@Override
	public void deleteItem(Long id) throws NotFoundException {
		Screen screen = screenRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(Constants.SCREEN_NOT_FOUND));
		logger.info("Deleting Theater... with Id: {}", id);
		screenRepository.deleteById(screen.getScreenId());
	}

	@Override
	public List<Screen> getItems() {
		return screenRepository.findAll();
	}

	@Override
	public Screen getItem(Long id) {

		return screenRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.SCREEN_NOT_FOUND));
	}

}
