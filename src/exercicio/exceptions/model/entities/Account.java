package exercicio.exceptions.model.entities;

import exercicio.exceptions.model.exceptions.TransacaoException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	
	
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount){
		validatWithdraw(amount);
		balance -= amount;
	}
	

	private void validatWithdraw(Double amount) {
		if(amount > getWithDrawLimit()) {
			throw new TransacaoException("Erro de saque: a quantia excede o limite de saque");
		}
		if(amount > getBalance()) {
			throw new TransacaoException("Erro de saque: saldo insuficiente");
		}
		
	}
	
	@Override
	public String toString() {
		return "New balance: ";
	}
	
	
}
