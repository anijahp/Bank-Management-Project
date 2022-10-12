package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import helper.src.net.efabrika.util.DBTablePrinter;
import pojo.AccountPojo;

import pojo.CustomerPojo;
import pojo.EmployeePojo;
import pojo.TransactionPojo;

public class CustomerDaoJdbcImpl implements CustomerDao {
	private static final int NULL = 0;
	
	public CustomerPojo loginAccountCx(String userName, String passWord) {
		
		{

			Connection connection = DBUtil.makeConnection();
			Statement stmt = null;
			CustomerPojo customerPojo = null;
			try {
				// validation
				if (userName == "" || passWord == "") {
					System.out.println("All Field Required!");

				}
				// query
				stmt = connection.createStatement();
				String query = "SELECT * FROM customer WHERE username='" + userName + "'" + " AND password='" + passWord
						+ "'";

				ResultSet rs = stmt.executeQuery(query);

				// Execution
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

//	            stmt = connection.createStatement();
//	            String queryThree = "SELECT * FROM bank WHERE idbank='"
//	                  + rs.getString("idbranch") + "'";
//	          
//	            ResultSet rsThree = stmt.executeQuery(queryThree);

				if (rs.next()) {
					// after login menu driven interface method

					int ch = 4;
//	                stmt = connection.createStatement();
//		            String queryThree = "SELECT * FROM bank WHERE idbank='"
//		                  + rs.getString("idbranch") + "'";
//		          
//		            ResultSet rsThree = stmt.executeQuery(queryThree);
//		           

					while (true) {
						try {

							stmt = connection.createStatement();
							String queryTwo = "SELECT * FROM branch WHERE idbranch='" + rs.getString("idbranch") + "'";

							ResultSet rsTwo = stmt.executeQuery(queryTwo);

							rsTwo.next();
//	    		            rsThree.next();
//	    		            
							System.out.println("=============================");
							System.out.println("CUSTOMER ID : " + rs.getString("idcustomer"));
							System.out.println("YOUR LOCAL ZIPCODE: " + rs.getString("zipcode"));

							Statement bank = connection.createStatement();
							stmt = connection.createStatement();
							String queryThree = "SELECT * FROM bank WHERE idbank='" + rsTwo.getString("idbank") + "'";
							ResultSet rsThree = bank.executeQuery(queryThree);
							rsThree.next();
							System.out.println("YOUR BANK : " + rsThree.getString("name"));
							System.out.println("YOUR BRANCH STREET NUMBER : " + rsTwo.getString("street_number"));
							System.out.println("YOUR BRANCH STREET NAME : " + rsTwo.getString("street_name"));
							System.out.println("=============================");
							CustomerDaoJdbcImpl customerDaoJdbcImplDisplay = new CustomerDaoJdbcImpl();
							
							List<AccountPojo> fetchedAllAccountsPrint = null;
							try {
								fetchedAllAccountsPrint = customerDaoJdbcImplDisplay.getAllAccounts(rs.getInt("idcustomer"));
							} catch (Exception e) {
								
							}
							
							System.out.println("=============================================================================");
	        				System.out.println("ID\tOPEN DATE\tBALANCE\t\tNAME");
	        				System.out.println("=============================================================================");
	        				for(int i=0;i<fetchedAllAccountsPrint.size();i++) {
	        					System.out.println(fetchedAllAccountsPrint.get(i).getIdAccount() + "\t"+ fetchedAllAccountsPrint.get(i).getOpenDate()+ "\t" + fetchedAllAccountsPrint.get(i).getBalance() + "\t" +  fetchedAllAccountsPrint.get(i).getName());
	        				}
	        				System.out.println("=============================================================================");
	        				
							
							
							System.out.println("Hello, " + rs.getString("name"));
							System.out.println("1)Transfer Money");
							System.out.println("2)View Transaction History");
							System.out.println("3)LogOut");
							System.out.print("Enter Choice:");

							ch = Integer.parseInt(sc.readLine());
							if (ch == 1) {
								
								CustomerDaoJdbcImpl customerDaoJdbcImpl = new CustomerDaoJdbcImpl();
								
								List<AccountPojo> fetchedAllAccounts = null;
								try {
									fetchedAllAccounts = customerDaoJdbcImpl.getAllAccounts(rs.getInt("idcustomer"));
								} catch (Exception e) {
									
								}
								System.out.println("=============================================================================");
		        				System.out.println("ID\tOPEN DATE\tBALANCE\t\tNAME");
		        				System.out.println("=============================================================================");
		        				for(int i=0;i<fetchedAllAccounts.size();i++) {
		        					System.out.println(fetchedAllAccountsPrint.get(i).getIdAccount() + "\t"+ fetchedAllAccountsPrint.get(i).getOpenDate()+ "\t" + fetchedAllAccountsPrint.get(i).getBalance() + "\t" +  fetchedAllAccountsPrint.get(i).getName());
		        				}
		        				System.out.println("=============================================================================");
		        				
								
								System.out.println("Enter Your Acc No:");
								Integer fromAcc = Integer.parseInt(sc.readLine());
								
								System.out.print("Enter Receiver  Acc No:");
								Integer toAcc = Integer.parseInt(sc.readLine());
								System.out.print("Enter Amount:");
								Double amt = Double.parseDouble(sc.readLine());
								
								TransactionPojo newTrans = new TransactionPojo();
								newTrans.setAmount(amt);
								LocalDateTime localDate = LocalDateTime.now();
		                        Timestamp sqlDate = java.sql.Timestamp.valueOf( localDate );
								newTrans.setDate(sqlDate);
								newTrans.setFromAccount(fromAcc);
								newTrans.setToAccount(toAcc);
							
								
								
								if (CustomerDaoJdbcImpl.transferMoney(fromAcc,toAcc,amt)){
									
									System.out.println("MSG : Money Sent Successfully!\n");
								}
								else {
	                                System.out.println(
	                                    "ERR :  Failed!\n");
	                            }

							} else if (ch == 2) {
								
								stmt = connection.createStatement();
								String queryFour = "SELECT * FROM account WHERE idcustomer='" + rs.getString("idcustomer") + "'";

								ResultSet rsFour = stmt.executeQuery(queryFour);
								rsFour.next();
								
							int fromAccId = rsFour.getInt("idaccount");	
							int toAccId = rsFour.getInt("idaccount");
							List<TransactionPojo> gotTransaction;
							List<TransactionPojo> gotDeposit;
	        				try {
	        					gotTransaction = getTransaction(fromAccId);
	        				} catch(Exception e) {
	                        	e.printStackTrace();
	                        	break;
	                        }
	        				System.out.println("=============================================================================");
	        				System.out.println("\t\t\tTRANSACTION HISTORY");
	        				System.out.println("=============================================================================");
	        				
	        				System.out.println("=============================================================================");
	        				System.out.println("TRANSACTIONS YOU HAVE SENT");
	        				System.out.println("=============================================================================");
	        				
	        				System.out.println("=============================================================================");
	        				System.out.println("ID\t\tTIMESTAMP\t\t\tAMOUNT\tSENDER-ID RECEIVER-ID");
	        				System.out.println("=============================================================================");
	        				for(int i=0;i<gotTransaction.size();i++) {
	        					System.out.println(gotTransaction.get(i).getIdTransaction() + "\t"+ gotTransaction.get(i).getDate()+"\t"+ "\t" + gotTransaction.get(i).getAmount() +"\t"+ "\t" +  gotTransaction.get(i).getFromAccount() + "\t" + gotTransaction.get(i).getToAccount());
	        				}
	        				System.out.println("=============================================================================");
							
	        				
	        				
	        				try {
	        					gotDeposit = getDeposit(toAccId);
	        				} catch(Exception e) {
	                        	e.printStackTrace();
	                        	break;
	                        }
	        				System.out.println("=============================================================================");
	        				System.out.println("TRANSACTIONS YOU HAVE RECIEVED");
	        				System.out.println("=============================================================================");
	        				
	        				System.out.println("=============================================================================");
	        				System.out.println("ID\t\tTIMESTAMP\t\t\tAMOUNT\tSENDER-ID RECEIVER-ID");
	        				System.out.println("=============================================================================");
	        				for(int i=0;i<gotDeposit.size();i++) {
	        					System.out.println(gotDeposit.get(i).getIdTransaction() + "\t"+ gotDeposit.get(i).getDate()+"\t"+ "\t" + gotDeposit.get(i).getAmount() +"\t"+ "\t" +  gotDeposit.get(i).getFromAccount() + "\t" + gotDeposit.get(i).getToAccount());
	        				}
	        				System.out.println("=============================================================================");
	        				
	        				
						

							} else if (ch == 3) {
								break;
							} else {
								System.out.println("Err : Enter Valid input!\n");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {

				}
				// return

			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Username Not Available!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			return customerPojo;
		}
	}


public static boolean transferMoney(int fromAccount, int toAccount, double amount) throws SQLException // transfer
																						// money method
	{
// validation
		Connection connection = DBUtil.makeConnection();
		String sql = "";
		
		if (fromAccount == NULL || toAccount == NULL) {
			System.out.println("All Field Required!");
			return false;
		}
	
		try {
			connection.setAutoCommit(false);
			sql = "SELECT * FROM account where idaccount=" + fromAccount;
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getInt("balance") < amount) {
					System.out.println("Insufficient Balance!");
					return false;
				}
			}

			Statement st = connection.createStatement();

// debit
			connection.setSavepoint();

			sql = "UPDATE account set balance=balance-" + amount + " where idaccount=" + fromAccount;
			if (st.executeUpdate(sql) == 1) {
				System.out.println("Amount Debited!");
			}

// credit
			sql = "UPDATE account set balance=balance+" + amount + " where idaccount=" + toAccount;
			st.executeUpdate(sql);
			
			TransactionPojo transactionPojo = new TransactionPojo();
			
			sql = "INSERT INTO transaction (amount, date, from_account, to_account) VALUES ('" + amount  + "','" + LocalDateTime.now()+ "', '" + fromAccount + "', '" + toAccount + "') RETURNING idtransaction";

			ResultSet rsTwo = st.executeQuery(sql);
			rsTwo.next();
			int autoTransId = rsTwo.getInt(1);
			
			transactionPojo.setIdTransaction(autoTransId);
			
			
			connection.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		}
// return
		return false;
		
		
	}

@Override
		public TransactionPojo logTrans(TransactionPojo transactionPojo) {
			Connection connection = DBUtil.makeConnection();
			
			String q1 = "INSERT INTO transaction (amount, date, from_account, to_account) VALUES ('" + transactionPojo.getAmount() + "','" + LocalDateTime.now()+ "', '" + transactionPojo.getFromAccount() + "', '" + transactionPojo.getAmount() + "') RETURNING idtransaction";
			
			try {
				Statement stmt = connection.createStatement();
				ResultSet rsTwo = stmt.executeQuery(q1);
				rsTwo.next();
				int autoTransId  = rsTwo.getInt(1);
				transactionPojo.setIdTransaction(autoTransId);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return transactionPojo;
			
		}
		
@Override
		
		public List <AccountPojo> getAllAccounts(int idCustomer) {
	     Connection connection = DBUtil.makeConnection();
	     List <AccountPojo> allAccounts = new ArrayList<AccountPojo>();
	     
	
			try {
				
				Statement stmt = connection.createStatement();
				String query = "SELECT * FROM account WHERE idcustomer=" + idCustomer; //try to grab from result set in customer login ..
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					// creating a book pojo object and copying each record from the result set into
					// the book pojo
					AccountPojo accountPojo = new AccountPojo(rs.getInt(1),rs.getDate(3), rs.getDouble(2),rs.getString(4),rs.getInt(5));
					// adding the book pojo to the collection
					allAccounts.add(accountPojo);

				}
				
				
			}
			 catch (Exception e) {
					e.printStackTrace();
					
				}
			return allAccounts;
		
		}

@Override

public List <TransactionPojo> getTransaction(int fromAccount) {
 Connection connection = DBUtil.makeConnection();
 List <TransactionPojo> getTransaction = new ArrayList<TransactionPojo>();
 

	try {
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM transaction WHERE from_account=" + fromAccount; //try to grab from result set in customer login ..
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			// creating a book pojo object and copying each record from the result set into
			// the book pojo
			TransactionPojo transactionPojo = new TransactionPojo(rs.getInt(1),rs.getDouble(2), rs.getTimestamp(3),rs.getInt(4),rs.getInt(5));
			// adding the book pojo to the collection
			getTransaction.add(transactionPojo);

		}
		
		
	}
	 catch (Exception e) {
			e.printStackTrace();
			
		}
	return getTransaction;

}

@Override

public List <TransactionPojo> getDeposit(int toAccount) {
 Connection connection = DBUtil.makeConnection();
 List <TransactionPojo> getDeposit = new ArrayList<TransactionPojo>();
 

	try {
		
		Statement stmt = connection.createStatement();
		String query = "SELECT * FROM transaction WHERE to_account=" + toAccount; //try to grab from result set in customer login ..
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			// creating a book pojo object and copying each record from the result set into
			// the book pojo
			TransactionPojo transactionPojo = new TransactionPojo(rs.getInt(1),rs.getDouble(2), rs.getTimestamp(3),rs.getInt(4),rs.getInt(5));
			// adding the book pojo to the collection
			getDeposit.add(transactionPojo);

		}
		
		
	}
	 catch (Exception e) {
			e.printStackTrace();
			
		}
	return getDeposit;

}




}
