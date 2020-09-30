package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for Managing Theater Entity
 * 
 * @author Rahhi Barbool
 *
 */
@Service
@Transactional
public class AdminTheaterServiceImpl implements AdminTheaterService {

	private static final Logger logger = LoggerFactory.getLogger(AdminTheaterServiceImpl.class);

	@Autowired
	private TheaterRepository theaterRepository;

	/**
	 * This method add theater return theater with theater id
	 */
	@Override
	public Theater addItem(Theater model) {
		logger.info("Adding Theater...");
		return theaterRepository.save(model);
	}

	/**
	 * This method update theater if theater id not exists then throw Exception
	 */
	@Override
	public Theater updateItem(Long id, Theater model) throws NotFoundException {
		Theater theater = theaterRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));

		theater.setTheaterName(model.getTheaterName());
		theater.setTheaterCity(model.getTheaterCity());
		theater.setManagerName(model.getManagerName());
		theater.setManagerContact(model.getManagerContact());

		logger.info("Updating Theater... with Id: {}", id);
		return theaterRepository.save(theater);
	}

	/**
	 * This method Delete theater if theater id not exists then throw Exception
	 */
	@Override
	public void deleteItem(Long id) throws NotFoundException {
		theaterRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));
		logger.info("Deleting Theater... with ID: {}", id);
		theaterRepository.deleteById(id);
	}

	/**
	 * return List of theater
	 */
	@Override
	public List<Theater> getItems() {
		return theaterRepository.findAll();
	}

	@Override
	public Theater getItem(Long id) {
		return theaterRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.THEATER_NOT_FOUND));
	}

}
