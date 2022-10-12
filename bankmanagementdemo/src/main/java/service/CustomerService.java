package service;

import java.sql.SQLException;
import java.util.List;

import dao.CustomerDao;
import pojo.AccountPojo;
import pojo.CustomerPojo;
import pojo.TransactionPojo;

public interface CustomerService {

	CustomerPojo loginAccountCx(String userName, String passWord);
	public static boolean transferMoney(int fromAccount, int toAccount, double amount) throws SQLException {
		return false;
	} // transfer
	TransactionPojo logTrans(TransactionPojo transactionPojo);

	List <AccountPojo> getAllAccounts(int idCustomer);
	List<TransactionPojo> getTransaction(int fromAccount);
	List<TransactionPojo> getDeposit(int toAccount);
}
