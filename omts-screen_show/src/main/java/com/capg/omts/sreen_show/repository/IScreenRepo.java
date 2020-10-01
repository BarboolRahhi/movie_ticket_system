package com.capg.omts.sreen_show.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.omts.sreen_show.model.Screen;
/**
 * IScreenRepo interface
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
public interface IScreenRepo extends JpaRepository<Screen, Integer> {

}
