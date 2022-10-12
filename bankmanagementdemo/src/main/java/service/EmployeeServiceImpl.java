package service;

import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoJdbcImpl;
import pojo.AccountPojo;
import pojo.CustomerPojo;
import pojo.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoJdbcImpl();
	}

	@Override
	public EmployeePojo loginAccount(String userName, String passWord) {
		// TODO Auto-generated method stub
		return employeeDao.loginAccount(userName,passWord);
	}

	@Override
	public CustomerPojo createCustomeraccount(CustomerPojo customerPojo) {
		// TODO Auto-generated method stub
		return employeeDao.createCustomeraccount(customerPojo);
	}
	
	@Override
	public AccountPojo getAccount(int idCustomer) {
		
		return employeeDao.getAccount(idCustomer);
	}

	@Override
	public List<AccountPojo> getAllAccounts(int idCustomer) {
		// TODO Auto-generated method stub
		return employeeDao.getAllAccounts(idCustomer);
	}


}
