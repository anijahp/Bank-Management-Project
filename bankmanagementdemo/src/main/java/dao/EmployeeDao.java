package dao;

import pojo.CustomerPojo;
import pojo.EmployeePojo;

import java.util.List;

import pojo.AccountPojo;

public interface EmployeeDao {

	EmployeePojo loginAccount(String userName, String passWord);

	CustomerPojo createCustomeraccount(CustomerPojo customerPojo);
	
	AccountPojo accountInitialize(AccountPojo accountPojo);

	AccountPojo getAccount(int idCustomer);

	List<AccountPojo> getAllAccounts(int idCustomer);

}
