package bank.account.kata.operation;

import java.util.Date;

public class Operation {
	
	private final Type type;
	private final Date date;
	private final double amount;
	
	public Operation(Type type, Date date, double amount) {
		if (type == null) {
			throw new IllegalArgumentException("Type can't be null");
		}
		if (date == null) {
			throw new IllegalArgumentException("Date can't be null");
		}
		
		this.type = type;
		this.date = date;
		this.amount = amount;
	}

	public Type getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Operation other = (Operation) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operation [type=" + type + ", date=" + date + ", amount=" + amount + "]";
	}
}
