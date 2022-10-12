package pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionPojo {
	
	private int idTransaction;
	private int fromAccount;
	private int toAccount;
	private double amount;
	private Timestamp date;
	
	
	public TransactionPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionPojo(int idTransaction, double amount, Timestamp timestamp, int fromAccount, int toAccount) {
		super();
		this.idTransaction = idTransaction;
		this.amount = amount;
		this.date = timestamp;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	@Override
	public String toString() {
		return "TransactionPojo [idTransaction=" + idTransaction + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", amount=" + amount + ", date=" + date + "]";
	}

	
}
