/**
	* Project Name : Online Movie Ticket System
	*
	* 
**/


package com.capg.omts.sreen_show.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * The Screen Model class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@Entity
@Table(name="screen")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Screen {
    @Id
	private int screenId;
    @Column(name="screen_name")
    private String screenName;
    @Column(name = "rows_details")
    private int rows;
    @Column(name = "columns_details")
    private int columns;
    
    @OneToMany( mappedBy = "screen",fetch = FetchType.LAZY, cascade = CascadeType.ALL)//
  // @JoinTable(name="testscreen_show",joinColumns = @JoinColumn(name="screen_id"),inverseJoinColumns = @JoinColumn(name="show_id"))
    private List<Show> showList =new ArrayList<>();
   
   
    
    
    
    
    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="theatreId")
//    @JsonBackReference
    private Theatre theatre;
    
   @JsonManagedReference
   
	public List<Show> getShowList() {
		return showList;
	}
    
	public Screen() {
		super();
	
	}
	


	public Screen(int screenId, String screenName, int rows, int columns) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
	}
	


	public Screen(int screenId, String screenName, int rows, int columns, List<Show> showList, Theatre theatre) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
		this.showList = showList;
		this.theatre = theatre;
	}


	public int getScreenId() {
		return screenId;
	}


	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}




	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}


	public Theatre getTheatre() {
		return theatre;
	}


	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}


	

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", rows=" + rows + ", columns=" + columns
				+ ", showList=" + showList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columns;
		result = prime * result + rows;
		result = prime * result + screenId;
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
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
		Screen other = (Screen) obj;
		if (columns != other.columns)
			return false;
		if (rows != other.rows)
			return false;
		if (screenId != other.screenId)
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		return true;
	}
		
}
