package service;

import java.sql.SQLException;
import java.util.List;

import dao.CustomerDao;
import dao.CustomerDaoJdbcImpl;
import pojo.AccountPojo;
import pojo.CustomerPojo;
import pojo.TransactionPojo;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		customerDao = new CustomerDaoJdbcImpl();
	}
	
	@Override
	public CustomerPojo loginAccountCx(String userName, String passWord) {
		// TODO Auto-generated method stub
		return customerDao.loginAccountCx(userName,passWord);
	}
	public boolean transferMoney(int fromAccount, int toAccount, double amount) throws SQLException {
		// TODO Auto-generated method stub
		return false;
		}

	@Override
	public TransactionPojo logTrans(TransactionPojo transactionPojo) {
		// TODO Auto-generated method stub
		return customerDao.logTrans(transactionPojo);
	}

	@Override
	public List<AccountPojo> getAllAccounts(int idCustomer) {
		// TODO Auto-generated method stub
		return customerDao.getAllAccounts(idCustomer);
	}
	@Override
	public List <TransactionPojo> getTransaction (int fromAccount) {
		// TODO Auto-generated method stub
		return customerDao.getTransaction(fromAccount);
	}
	@Override
	public List <TransactionPojo> getDeposit (int toAccount) {
		// TODO Auto-generated method stub
		return customerDao.getTransaction(toAccount);
	}


}
