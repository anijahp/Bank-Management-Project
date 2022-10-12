package dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import pojo.CustomerPojo;
import pojo.TransactionPojo;
import pojo.AccountPojo;

public interface CustomerDao {

	public static boolean transferMoney(int fromAccount, int toAccount, double amount) throws SQLException{
		return false;
		
	}


	CustomerPojo loginAccountCx(String userName, String passWord);


	TransactionPojo logTrans(TransactionPojo transactionPojo);
	
	List <AccountPojo> getAllAccounts(int idCustomer);


	List<TransactionPojo> getTransaction(int fromAccount);


	List<TransactionPojo> getDeposit(int toAccount);
}
