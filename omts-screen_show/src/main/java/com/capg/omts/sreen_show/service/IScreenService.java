package com.capg.omts.sreen_show.service;

import java.util.List;

import com.capg.omts.sreen_show.model.Screen;

public interface IScreenService {
public abstract Screen addScreen(Screen screen);
public abstract Screen updateScreen(Screen screen);
public boolean deleteByScreenId(int screenId);
public   Screen getScreenById(int screenId);
public List<Screen> getAllScreens();
public boolean isValidScreenId(int screenId);
public boolean isValidScreenName(String screenName);
}
