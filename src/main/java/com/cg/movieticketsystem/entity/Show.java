package com.cg.movieticketsystem.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "show_id")
    private Long showId;

    @Column(name="show_name")
    private String showName;

    @Column(name = "show_start_time")
    private LocalTime showStartTime;

    @Column(name = "show_end_time")
    private LocalTime showEndTime;

    @OneToMany(mappedBy = "show")
    private List<Seat> seats =new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="screen_id", nullable = false)
    private Screen screen;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="theater_id", nullable = false)
    private Theater theater;

    public Show() {

    }

    public Show(String showName, LocalTime showStartTime, LocalTime showEndTime, Screen screen, Movie movie, Theater theater) {
        this.showName = showName;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.screen = screen;
        this.movie = movie;
        this.theater = theater;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public LocalTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public LocalTime getShowEndTime() {
        return showEndTime;
    }

    public void setShowEndTime(LocalTime showEndTime) {
        this.showEndTime = showEndTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Screen getScreen() {
        return screen;
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

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
