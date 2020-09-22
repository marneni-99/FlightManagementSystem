package com.cg.fms.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bookingdetails")
public class Booking {
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="book_seq")
	@SequenceGenerator(name="book_seq",sequenceName="bookingdetails_s1",allocationSize=1)
	long bookingId;
	@OneToOne
	@JoinColumn(name="username")
	Users users;
	@OneToOne
	@JoinColumn(name="sched_id")
	FlightSchedule flightSchedule;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id")
	List<Passengers> passengers;
	@Column(name="booking_date")
	LocalDate bookingDate;
	@Column(name="travel_date")
	LocalDate travelDate;
	public Booking() {}
	public Booking(long bookingId, Users users, FlightSchedule flightSchedule, List<Passengers> passengers,
			LocalDate bookingDate, LocalDate travelDate) {
		this.bookingId = bookingId;
		this.users = users;
		this.flightSchedule = flightSchedule;
		this.passengers = passengers;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	public List<Passengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	

}

