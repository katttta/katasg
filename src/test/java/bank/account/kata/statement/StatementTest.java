package bank.account.kata.statement;

import java.util.Date;

import org.junit.Test;

import bank.account.kata.operation.Operation;
import bank.account.kata.operation.Type;

public class StatementTest {

	@Test(expected=IllegalArgumentException.class)
	public void when_operation_is_null_then_should_throw_exception() {
		new Statement(null, 1599);
	}
	
	@Test
	public void when_statement_is_printed_then_should_print_value_in_printer() {
		
		Operation operation = new Operation(Type.DEPOSIT, new Date(), 1000);
		Statement statement = new Statement(operation, 1599);
		statement.print(System.out);
	}
}
