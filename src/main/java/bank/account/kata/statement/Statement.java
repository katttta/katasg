package bank.account.kata.statement;

import java.io.PrintStream;

import bank.account.kata.operation.Operation;

public class Statement {

	private final Operation operation;
	private final double currentBalance;
	
	public Statement(Operation operation, double currentBalance) {
		if (operation == null) {
			throw new IllegalArgumentException("Operation can't be null");
		}
		
		this.operation = operation;
		this.currentBalance = currentBalance;
	}
	
	public void print(PrintStream printer) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(operation.getType());
		builder.append("  ");
		builder.append(operation.getDate());
		builder.append("  ");
		builder.append(operation.getAmount());
		builder.append("  ");
		builder.append(currentBalance);
		
		printer.println(builder.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(currentBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		if (Double.doubleToLongBits(currentBalance) != Double.doubleToLongBits(other.currentBalance))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatementLine [operation=" + operation + ", currentBalance=" + currentBalance + "]";
	}
}
