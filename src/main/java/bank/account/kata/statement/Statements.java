package bank.account.kata.statement;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Statements implements History<Statement> {

	private List<Statement> accountStatements = new ArrayList<Statement>();
	
	public Statements() {
	}
	
	@Override
	public List<Statement> getAll() {
		return accountStatements;
	}

	@Override
	public void add(Statement statement) {
		if (statement != null) {
			accountStatements.add(statement);
		}
	}
	
	@Override
	public void print(PrintStream printer) {
		for (Statement statement : accountStatements) {
			statement.print(printer);
		}
	}
}
