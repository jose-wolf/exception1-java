package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate  checkIn;
	private LocalDate checkOut;
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut)  throws DomainException {
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}


	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {		
		long diferencaDeDias = ChronoUnit.DAYS.between(checkIn, checkOut);
		return diferencaDeDias;
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		
		LocalDate dataAtual = LocalDate.now();
		
		if(checkIn.isBefore(dataAtual) || checkOut.isBefore(dataAtual)) {
			throw new DomainException("Reservtion dates for update must be future dates");
		}
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber +
				", check-in: " + dtf.format(checkIn) +
				", check-out: " + dtf.format(checkOut) +
				", " + duration() + " nighets";
	}
	
}
