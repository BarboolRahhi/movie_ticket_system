package com.cg.movieticketsystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_genre")
    private String movieGenre;

    @Column(name = "movie_director")
    private String movieDirector;

    @Column(name = "movie_length")
    private Integer movieLength;

    @ElementCollection
    @CollectionTable(name = "movie_languages", joinColumns = @JoinColumn(name = "movie_id"))
    private Set<String> languages;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "movie_release_date", columnDefinition = "DATE")
    private LocalDate movieReleaseDate;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @NotNull(message = "Theater must not be Blank")
    private Theater theater;

    public Movie() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    public LocalDate getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(LocalDate movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMovieId().equals(movie.getMovieId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieId());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieLength=" + movieLength +
                ", languages=" + languages +
                ", movieReleaseDate=" + movieReleaseDate +
                ", theater=" + theater +
                '}';
    }
}
