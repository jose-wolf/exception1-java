package exercicio.exceptions.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exercicio.exceptions.model.entities.Account;
import exercicio.exceptions.model.exceptions.TransacaoException;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Entre account data: ");
		System.out.print("Number: ");
		int number = Integer.parseInt(br.readLine());
		
		System.out.print("Holder: ");
		String holder = br.readLine();
		
		System.out.print("Initial balance: ");
		double balance = Double.parseDouble(br.readLine());
		
		System.out.print("Withdraw limit: ");
		double withdraw = Double.parseDouble(br.readLine());

		Account conta = new Account(number, holder, balance, withdraw);
		
		System.out.print("\nEnter amount for withdraw: ");
		double amount = Double.parseDouble(br.readLine());
		
		
		try {
		conta.withdraw(amount);
		System.out.printf("Novo saldo: %.2f%n", conta.getBalance());
		}catch(TransacaoException e){
			System.out.println(e.getMessage());
		}
		
		br.close();
		
	}

}
