package bank.account.kata.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import bank.account.kata.account.BankAccount;
import bank.account.kata.exception.NegativeAmountException;
import bank.account.kata.operation.Operation;
import bank.account.kata.operation.Type;
import bank.account.kata.statement.Statement;
import bank.account.kata.statement.Statements;

public class BankAccountTest {

	BankAccount bankAccount;
	
	@Before
	public void init() {

		bankAccount = new BankAccount(0, new Statements());
	}
	
	@Test
	public void when_1000_are_deposited_then_account_balance_increases_by_1000() throws NegativeAmountException {

		double oldBalance = bankAccount.getBalance();
		bankAccount.deposit(1000);
		
		assertThat(bankAccount.getBalance() - oldBalance).isEqualTo(1000);
	}
	
	@Test
	public void when_1000_are_withdrawed_then_account_balance_decreases_by_1000() throws NegativeAmountException {

		double oldBalance = bankAccount.getBalance();
		bankAccount.withdraw(1000);
		
		assertThat(oldBalance - bankAccount.getBalance()).isEqualTo(1000);
	}

	@Test(expected=NegativeAmountException.class)
	public void when_negative_amount_is_supplied_for_deposit_then_should_throw_exception() throws NegativeAmountException {

		bankAccount.deposit(-1000);
	}
	
	@Test(expected=NegativeAmountException.class)
	public void when_negative_amount_is_supplied_for_withdraw_then_should_throw_exception() throws NegativeAmountException {

		bankAccount.withdraw(-1000);
	}
	
	@Test
	public void when_1000_are_deposited_then_account_history_contains_deposit_operation_of_1000_with_corresponding_balance() throws NegativeAmountException {
		
		bankAccount.deposit(1000);
		
		Operation operation = new Operation(Type.DEPOSIT, new Date(), 1000);
		Statement expectedStatement = new Statement(operation, 1000);
		
		assertThat(bankAccount.getHistory()).containsExactly(expectedStatement);
	}
	
	@Test
	public void when_1000_are_withdrawed_then_account_history_contains_withdraw_operation_of_1000_with_corresponding_balance() throws NegativeAmountException {
		
		bankAccount.withdraw(1000);
		
		Operation operation = new Operation(Type.WITHDRAW, new Date(), 1000);
		Statement expectedStatement = new Statement(operation, -1000);
		
		assertThat(bankAccount.getHistory()).containsExactly(expectedStatement);
	}
}
