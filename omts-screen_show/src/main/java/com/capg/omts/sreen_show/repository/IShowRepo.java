package com.capg.omts.sreen_show.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.omts.sreen_show.model.Show;
/**
 * IShowRepo interface
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
public interface IShowRepo extends JpaRepository<Show, Integer> {

	@Query(value = "SELECT show FROM Show show")
	List<Show> findAllShows();

}
