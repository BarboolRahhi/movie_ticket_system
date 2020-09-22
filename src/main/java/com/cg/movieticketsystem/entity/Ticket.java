package com.cg.movieticketsystem.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "no_of_seats")
    private Integer noOfSeats;

    @Column(name = "ticket_status")
    private Boolean ticketStatus;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "booking_id")
    private Booking booking;

    public Ticket() {
    }

    public Ticket(Integer noOfSeats, Boolean ticketStatus, Booking booking) {
        this.noOfSeats = noOfSeats;
        this.ticketStatus = ticketStatus;
        this.booking = booking;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Boolean getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
