package pojo;

import java.sql.Date;
import java.time.LocalDate;

public class AccountPojo {
	
	private int idAccount;
	private Date openDate;
	private double balance;
	private String name;
	private int idCustomer;
//	private Date printDate;
	
	
	public AccountPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountPojo(int idAccount, Date date, double balance, String name, int idCustomer) {
		super();
		this.idAccount = idAccount;
		this.openDate = date;
		this.balance = balance;
		this.name = name;
		this.idCustomer = idCustomer;
//		this.printDate = printDate;
		
	}



	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Override
	public String toString() {
		return "AccountPojo [idAccount=" + idAccount + ", openDate=" + openDate + ", balance=" + balance + ", name="
				+ name + ", idCustomer=" + idCustomer + "]";
	}
	

//	public Date getPrintDate() {
//		return printDate;
//	}
//
//	public void setPrintDate(Date printDate) {
//		this.printDate = printDate;
//	}

	

	

	
	



	
	
}
