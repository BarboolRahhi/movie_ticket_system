package com.cg.movieticketsystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_date", columnDefinition = "DATE")
    private LocalDate bookingDate;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "total_cost")
    private double totalCost;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @OneToOne(mappedBy = "booking")
    private Ticket ticket;

    public Booking() {
    }

    public Booking(LocalDate bookingDate, Integer transactionId, double totalCost, Movie movie, Show show, Ticket ticket) {
        this.bookingDate = bookingDate;
        this.transactionId = transactionId;
        this.totalCost = totalCost;
        this.movie = movie;
        this.show = show;
        this.ticket = ticket;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
