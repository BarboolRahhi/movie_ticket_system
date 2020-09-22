package com.cg.movieticketsystem.entity;

import javax.persistence.*;

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
    private String managerContact;

    public Theater() {

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
