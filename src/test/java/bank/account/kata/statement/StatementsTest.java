package bank.account.kata.statement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import bank.account.kata.operation.Operation;
import bank.account.kata.operation.Type;
import bank.account.kata.statement.History;
import bank.account.kata.statement.Statement;
import bank.account.kata.statement.Statements;

public class StatementsTest {

	History<Statement> statements;
	
	@Before
	public void init() {

		statements = new Statements();
	}
	
	@Test
	public void when_adding_new_statement_line_then_statements_container_should_contain_statement_line() {
	
		Operation operation = new Operation(Type.DEPOSIT, new Date(), 1000);
		Statement statement = new Statement(operation, 1599);
		
		statements.add(statement);
		
		assertThat(statements.getAll()).containsExactly(statement);
	}
}
