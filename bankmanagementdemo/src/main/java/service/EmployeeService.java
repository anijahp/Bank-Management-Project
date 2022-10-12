package service;

import java.util.List;

import pojo.AccountPojo;

import pojo.CustomerPojo;
import pojo.EmployeePojo;

public interface EmployeeService {

  EmployeePojo loginAccount(String userName, String passWord);
	CustomerPojo createCustomeraccount(CustomerPojo customerPojo);
	AccountPojo getAccount(int idCustomer);
	List<AccountPojo> getAllAccounts(int idCustomer);
	
	
	
}
