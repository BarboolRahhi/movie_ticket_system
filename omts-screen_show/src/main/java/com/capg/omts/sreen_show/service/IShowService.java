package com.capg.omts.sreen_show.service;

import java.time.LocalDateTime;
import java.util.List;


import com.capg.omts.sreen_show.model.Show;

public interface IShowService {
	public abstract Show addShow(Show show);
	public abstract Show updateShow(Show show);
	public boolean deleteByShowId(int showId);
	public   Show getShowById(int showId);
	public List<Show> getAllShows();
	public boolean isValidShowId(int showId);
	public boolean isValidShowName(String showName);
	public  boolean isValidShowTime(LocalDateTime start,LocalDateTime end);
}
