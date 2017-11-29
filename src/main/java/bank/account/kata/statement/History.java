package bank.account.kata.statement;

import java.io.PrintStream;
import java.util.List;

public interface History<E> {

	public List<E> getAll();

	public void add(E record);
	
	public void print(PrintStream printer);
	
}
