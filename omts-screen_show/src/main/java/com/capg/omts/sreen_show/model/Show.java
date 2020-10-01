/**
	* Project Name : Online Movie Ticket System
	*
	* 
**/
package com.capg.omts.sreen_show.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * The Show Model class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@Entity
@Table(name="show")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Show {
	    @Id
		private int showId;
	    @Column(name="show_name")
	    private String showName;
	    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
	    @Column(length = 20)
	    private LocalDateTime showStartTime;
	    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
	    @Column(length = 20)
	    private LocalDateTime showEndTime;
	     
	    @OneToMany
	    private List<Seat> seats =new ArrayList<>();                                                                                                // @ElementCollection
	    
	   
	

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="screen_screenId")
 
	   private Screen screen;
	    @ManyToOne
	    private Movie movie; 
	    @ManyToOne 
	    private Theatre theatre;
	  
	    @JsonBackReference
	    
		public Screen getScreen() {
			return screen;
		}
		public Show() {
			super();
			
		}

		public Show(int showId, String showName, LocalDateTime showStartTime, LocalDateTime showEndTime) {
			super();
			this.showId = showId;
			this.showName = showName;
			this.showStartTime = showStartTime;
			this.showEndTime = showEndTime;
		}
		

		public Show(int showId, String showName, LocalDateTime showStartTime, LocalDateTime showEndTime,
				List<Seat> seats, Screen screen, Movie movie, Theatre theatre) {
			super();
			this.showId = showId;
			this.showName = showName;
			this.showStartTime = showStartTime;
			this.showEndTime = showEndTime;
			this.seats = seats;
			this.screen = screen;
			this.movie = movie;
			this.theatre = theatre;
		}
	

		public int getShowId() {
			return showId;
		}

		public void setShowId(int showId) {
			this.showId = showId;
		}

		public String getShowName() {
			return showName;
		}

		public void setShowName(String showName) {
			this.showName = showName;
		}

		public LocalDateTime getShowStartTime() {
			return showStartTime;
		}

		public void setShowStartTime(LocalDateTime showStartTime) {
			this.showStartTime = showStartTime;
		}

		public LocalDateTime getShowEndTime() {
			return showEndTime;
		}

		public void setShowEndTime(LocalDateTime showEndTime) {
			this.showEndTime = showEndTime;
		}

		public List<Seat> getSeats() {
			return seats;
		}

		public void setSeats(List<Seat> seats) {
			this.seats = seats;
		}
		

		public void setScreen(Screen screen) {
			this.screen = screen;
		}

		public Movie getMovie() {
			return movie;
		}

		public void setMovie(Movie movie) {
			this.movie = movie;
		}

		public Theatre getTheatre() {
			return theatre;
		}

		public void setTheatre(Theatre theatre) {
			this.theatre = theatre;
		}



		@Override
		public String toString() {
			return "Show [showId=" + showId + ", showName=" + showName + ", showStartTime=" + showStartTime
					+ ", showEndTime=" + showEndTime + ", seats=" + seats + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((seats == null) ? 0 : seats.hashCode());
			result = prime * result + ((showEndTime == null) ? 0 : showEndTime.hashCode());
			result = prime * result + showId;
			result = prime * result + ((showName == null) ? 0 : showName.hashCode());
			result = prime * result + ((showStartTime == null) ? 0 : showStartTime.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Show other = (Show) obj;
			if (seats == null) {
				if (other.seats != null)
					return false;
			} else if (!seats.equals(other.seats))
				return false;
			if (showEndTime == null) {
				if (other.showEndTime != null)
					return false;
			} else if (!showEndTime.equals(other.showEndTime))
				return false;
			if (showId != other.showId)
				return false;
			if (showName == null) {
				if (other.showName != null)
					return false;
			} else if (!showName.equals(other.showName))
				return false;
			if (showStartTime == null) {
				if (other.showStartTime != null)
					return false;
			} else if (!showStartTime.equals(other.showStartTime))
				return false;
			return true;
		}
				
		}
