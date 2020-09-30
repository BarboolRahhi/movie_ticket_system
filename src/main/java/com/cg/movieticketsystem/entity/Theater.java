package com.cg.movieticketsystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "theater_id")
    private Long theaterId;

    @Column(name = "theater_name")
    private String theaterName;

    @Column(name = "theater_city")
    private String theaterCity;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_contact")
    @Pattern(regexp = "[0-9]+", message = "Contact must contains only numbers")
    @Size(min = 10, max = 10, message = "Contact must contain 10 digit only")
    private String managerContact;
   

    public Theater() {

    }
    

	public Theater(Long theaterId, String theaterName, String theaterCity, String managerName, String managerContact) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.theaterCity = theaterCity;
        this.managerName = managerName;
        this.managerContact = managerContact;
    }

    public Theater(String theaterName, String theaterCity, String managerName, String managerContact) {
        this.theaterName = theaterName;
        this.theaterCity = theaterCity;
        this.managerName = managerName;
        this.managerContact = managerContact;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterCity() {
        return theaterCity;
    }

    public void setTheaterCity(String theaterCity) {
        this.theaterCity = theaterCity;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theater)) return false;
        Theater theater = (Theater) o;
        return getTheaterId().equals(theater.getTheaterId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTheaterId());
    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", theaterCity='" + theaterCity + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerContact='" + managerContact + '\'' +
                '}';
    }
}
