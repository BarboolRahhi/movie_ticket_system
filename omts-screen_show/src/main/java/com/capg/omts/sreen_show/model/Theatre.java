package com.capg.omts.sreen_show.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="theatre")
public class Theatre {

	@Id
	private Integer theatreId;
	private String theatreName;
	private String theatreCity;
	@ElementCollection
	private List<Integer> movies;
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL,fetch = FetchType.EAGER)

	private List<Screen> listOfScreens;
	private String managerName;
	private String managerContact;

	public Theatre(Integer theatreId, String theatreName, String theatreCity, List<Integer> movies,
			List<Screen> listOfScreens, String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.movies = movies;
		this.listOfScreens = listOfScreens;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public Theatre() {
		
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public List<Integer> getMovies() {
		return movies;
	}

	public void setMovies(List<Integer> movies) {
		this.movies = movies;
	}

	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(List<Screen> listOfScreens) {

		
		
  for (Screen screen : listOfScreens) { screen.setTheatre(this); }
		 	 
		this.listOfScreens = listOfScreens;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
				+ ", movies=" + movies + ", listOfScreens=" + listOfScreens + ", managerName=" + managerName
				+ ", managerContact=" + managerContact + "]";
	}

	
}
