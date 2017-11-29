package bank.account.kata.operation;

import java.util.Date;

import org.junit.Test;

public class OperationTest {

	@Test(expected=IllegalArgumentException.class)
	public void when_type_is_null_then_should_throw_exception() {
		new Operation(null, new Date(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void when_date_is_null_then_should_throw_exception() {
		new Operation(Type.DEPOSIT, null, 0);
	}
	
}
