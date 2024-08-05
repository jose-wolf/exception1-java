package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int numero = Integer.parseInt(br.readLine());
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(br.readLine(), dtf1);
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(br.readLine(), dtf1);
			
			Reservation reservation = new Reservation(numero, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("\nEnter Data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(br.readLine(), dtf1);
			
			System.out.print("check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(br.readLine(), dtf1);
			
			
			LocalDate dataAtual = LocalDate.now();
			if(checkIn.isBefore(dataAtual) || checkOut.isBefore(dataAtual)){
				System.out.println("Error in reservation: Reservation dates for update must be future dates ");
			}else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}catch(DateTimeParseException e) {
			System.out.println("Data formatada inválida");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
			
		
		
		
		br.close();
	}

}
