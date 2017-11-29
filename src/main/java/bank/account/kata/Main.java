package bank.account.kata;

import bank.account.kata.account.BankAccount;
import bank.account.kata.exception.NegativeAmountException;
import bank.account.kata.statement.Statements;

public class Main {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount(0, new Statements());
		
		try {
			bankAccount.deposit(1500);
			bankAccount.deposit(1500);
			bankAccount.withdraw(1500);
			bankAccount.print(System.out);
		
		} catch (NegativeAmountException e) {
			System.out.println("Please supply only positive amounts");
		}
	}
	
}
