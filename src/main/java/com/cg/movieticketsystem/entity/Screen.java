package com.cg.movieticketsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long screenId;

    @Column(name="screen_name")
    private String screenName;

    @Column(name = "rows_details")
    private Integer rows;

    @Column(name = "columns_details")
    private Integer columns;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> showList =new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    public Screen() {

    }

    public Screen(String screenName, Integer rows, Integer columns, Theater theater) {
        this.screenName = screenName;
        this.rows = rows;
        this.columns = columns;
        this.theater = theater;
    }

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
