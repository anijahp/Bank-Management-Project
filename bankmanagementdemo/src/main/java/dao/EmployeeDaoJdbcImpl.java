package dao;

import pojo.CustomerPojo;
import pojo.EmployeePojo;
import pojo.AccountPojo;

import helper.src.net.efabrika.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;






public class EmployeeDaoJdbcImpl implements EmployeeDao {

   
    

	public EmployeePojo loginAccount(String userName, String passWord) {
		{
			
			Connection connection = DBUtil.makeConnection();
	        Statement stmt = null;
	        EmployeePojo employeePojo = null;
	        try {
	            // validation
	            if (userName == "" || passWord == "") {
	                System.out.println("All Field Required!");
	                
	            }
	            // query
	            stmt = connection.createStatement();
	            String query = "SELECT * FROM employee WHERE username='"
	                  + userName +"'"+ " AND password='" + passWord +"'";
	          
	            ResultSet rs = stmt.executeQuery(query);
	            
	            // Execution
	            BufferedReader sc = new BufferedReader(
	                new InputStreamReader(System.in));
	           
	            
	            
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
	         	            String queryTwo = "SELECT * FROM branch WHERE idbranch='"
	         	                  + rs.getString("idbranch") + "'";
	         	          
	         	            ResultSet rsTwo = stmt.executeQuery(queryTwo);
	         	            
	    		            rsTwo.next();
//	    		            rsThree.next();
//	    		            
	                    	System.out.println("=============================");
							System.out.println("EMPLOYEE ID : " +  rs.getString("idemployee"));
							System.out.println("EMPLOYEE FIRST NAME : " + rs.getString("name"));
							System.out.println("EMPLOYEE LAST NAME : " + rs.getString("surname"));
							System.out.println("EMPLOYEE POSITION : " + rs.getString("position"));
							
							Statement bank = connection.createStatement();
							 stmt = connection.createStatement();
					            String queryThree = "SELECT * FROM bank WHERE idbank='"
					                  + rsTwo.getString("idbank") + "'";
					         ResultSet rsThree = bank.executeQuery(queryThree);    
					         rsThree.next();
							System.out.println("EMPLOYEE BANK : " + rsThree.getString("name"));
							System.out.println("EMPLOYEE BRANCH STREET NUMBER : " + rsTwo.getString("street_number"));
							System.out.println("EMPLOYEE BRANCH STREET NAME : " + rsTwo.getString("street_name"));
							System.out.println("=============================");
	                        System.out.println(
	                        		
	                            "Hello, "
	                            + rs.getString("name"));
	                        System.out.println(
	                            "1)Create Customer Information");
	                        System.out.println("2)Create Customer Account");
	                        System.out.println("3)View all customers");
	                        System.out.println("4)LogOut");
	 
	                        System.out.print("Enter Choice:");
	                        
	                        ch = Integer.parseInt(
	                            sc.readLine());
	                        if (ch == 1) {
	                            EmployeeDaoJdbcImpl employeeDaoJdbcImpl = new EmployeeDaoJdbcImpl();
								
								System.out.println("Please enter cx first name");
		                        String fetchName = sc.readLine();
		                        System.out.println("Please enter cx last name");
		                        String fetchSurName = sc.readLine();
		                        System.out.println("Please enter cx username");
		                        String fetchCxUserName = sc.readLine();
		                        System.out.println("Please enter cx password");
		                        String fetchCxPassword = sc.readLine();
		                        System.out.println("Please enter cx zipcode");
		                        String fetchZipcode = sc.readLine();
		                        
		                     
		                        CustomerPojo newCust = new CustomerPojo();
		                        newCust.setName(fetchName);
		                        newCust.setSurName(fetchSurName);
		                        newCust.setUserName(fetchCxUserName);
		                        newCust.setPassWord(fetchCxPassword);
		                        newCust.setzipcode(fetchZipcode);
		                        newCust.setIdbranch(rsTwo.getInt("idbranch"));
//		                        newCust.setIdbranch(rsTwo.getInt("idbranch"));
		                        CustomerPojo newCustwID;
		                        try {
		                        newCustwID = createCustomeraccount(newCust);
		                       
		                        } catch(Exception e) {
		                        	e.printStackTrace();
		                        	break;
		                        }
		                        System.out.println("*************************************************");
		        				System.out.println("New Customer with ID " + newCustwID.getIdCustomer() + " is added!! ");
	                        }
	                        else if (ch == 2) {
	                        	
	                        	System.out.println("Please enter account balance");
		                        Double fetchBalance = Double.parseDouble(sc.readLine());
		                        System.out.println("Please enter account name");
		                        String fetchName = sc.readLine();
		                        
		                        
		                        stmt = connection.createStatement();
		         	            String queryFive = "SELECT * FROM customer WHERE idbranch='"
		         	                  + rs.getString("idbranch") + "'";
		         	          
		         	            ResultSet rsFive = stmt.executeQuery(queryFive);
		         	            
		    		            rsTwo.next();
		    		            
		                        DBTablePrinter.printResultSet(rsFive);
		                        
		                        System.out.println("Please enter customer ID");
		                        Integer fetchCxId = Integer.parseInt(sc.readLine());
		                        
		                        
	                        	
		                        AccountPojo newAcc = new AccountPojo();
		                       
		                        newAcc.setBalance(fetchBalance);
		                        
		                        LocalDate localDate = LocalDate.now();
		                        java.sql.Date sqlDate = java.sql.Date.valueOf( localDate );
		                        newAcc.setOpenDate(sqlDate);
		                        newAcc.setName(fetchName);
		                        newAcc.setIdCustomer(fetchCxId);
		                        
		                        AccountPojo newAccwId;
		                        
		                        try {
			                        newAccwId = accountInitialize(newAcc);
			                       
			                        } catch(Exception e) {
			                        	e.printStackTrace();
			                        	System.out.println(e.getMessage());
			                        	break;
			                        }
		                        	
			                        System.out.println("*************************************************");
			        				System.out.println("New Account with ID " + newAccwId.getIdAccount() + " is added!! ");
	                        	
	                        	
		                        
	                        }else if(ch == 3) {
	                        	
			         	       	  
			         	           
	                        	stmt = connection.createStatement();
		         	            String querySeven = "SELECT * FROM customer WHERE idbranch='"
		         	                  + rs.getString("idbranch") + "'";
		         	          
		         	            ResultSet rsNew = stmt.executeQuery(querySeven);
		         	            
		                        DBTablePrinter.printResultSet(rsNew);
		                        
//		                       
		                        System.out.println("Please enter Customer ID to view their account details: ");
		        				int fetchCxId = Integer.parseInt(sc.readLine());
//		        				AccountPojo returnedAccountPojo;
		        				List<AccountPojo> gotAllAccounts;
		        				try {
		        					gotAllAccounts = getAllAccounts(fetchCxId);
		        				} catch(Exception e) {
		                        	e.printStackTrace();
		                        	break;
		                        }
		        				
		        				System.out.println("=============================================================================");
		        				System.out.println("ID\tOPEN DATE\tBALANCE\t\tNAME");
		        				System.out.println("=============================================================================");
		        				for(int i=0;i<gotAllAccounts.size();i++) {
		        					System.out.println(gotAllAccounts.get(i).getIdAccount() + "\t"+ gotAllAccounts.get(i).getOpenDate()+ "\t" + gotAllAccounts.get(i).getBalance() + "\t" +  gotAllAccounts.get(i).getName());
		        				}
		        				System.out.println("=============================================================================");
		        				
//		        				if(returnedAccountPojo == null) {
//		        					// the book with the id is not found
//		        					System.out.println("Customer with ID " + fetchCxId + " does not exist!!");
//		        				} else {
//		        					// the with with the id has been found
//		        					// so display the book information
//		        					
//		        					System.out.println("=============================");
//		        					System.out.println("ACCOUNT ID : " + returnedAccountPojo.getIdAccount());
//		        					System.out.println("ACCOUNT BALANCE : " + returnedAccountPojo.getBalance());
//		        					System.out.println("ACCOUNT OPEN DATE : " + returnedAccountPojo.getPrintDate());
//		        					System.out.println("ACCOUNT NAME : " + returnedAccountPojo.getName());
//		        					System.out.println("=============================");
//		        				
//		        				}
		                       
						
	
	                        }
			         	       
		         	        

	                    		
				         	       
			                        
	                        	
			                        
		                        
	                        
	                        
	                        else if (ch == 4) {
	                            break;
	                        }
	                        else {
	                            System.out.println(
	                                "Err : Enter Valid input!\n");
	                        }
	                    }
	                    catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	            else {
	               
	            }
	            // return
	           
	        }
	        catch (SQLIntegrityConstraintViolationException e) {
	            System.out.println("Username Not Available!");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	    
		return employeePojo;
		}
	}
	@Override
	public CustomerPojo createCustomeraccount(CustomerPojo customerPojo) {
		Connection connection = DBUtil.makeConnection(); // step 1 and 2 is done in this
		
		// String query = "INSERT INTO book_details(book_title, book_author, book_genre,
		// book_cost, book_image_url) VALUES(?, ?, ?, ?, ?)";
		String query = "INSERT INTO customer(name, surname, username, password, zipcode, idbranch) VALUES('"
				+ customerPojo.getName() + "','" + customerPojo.getSurName() + "','" + customerPojo.getUserName() + "','"
				+ customerPojo.getPassWord() + "','"+ customerPojo.getZipcode() +"','"+ customerPojo.getIdbranch() +   "') RETURNING idcustomer";
		
		
		try {
			// PreparedStatement pstmt = connection.prepareStatement(query);
			Statement stmt = connection.createStatement();

			// pstmt.executeUpdate();

			// what is pending is , get the auto generated book id and set it into the
			// bookPojo and return the book pojo - completed
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int autoGeneratedCxId = rs.getInt(1);
			
			customerPojo.setIdCustomer(autoGeneratedCxId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return customerPojo;

}
	@Override
	public AccountPojo accountInitialize(AccountPojo accountPojo) {
		Connection connection = DBUtil.makeConnection(); // step 1 and 2 is done in this
		
		
		String query = "INSERT INTO account(balance, open_date, name, idcustomer) VALUES ('" + accountPojo.getBalance() + "','" + LocalDate.now()  + "','" + accountPojo.getName() +"','" + accountPojo.getIdCustomer() + "') RETURNING idaccount";
		
		
		try {
			// PreparedStatement pstmt = connection.prepareStatement(query);
			Statement stmt = connection.createStatement();

			// pstmt.executeUpdate();

			// what is pending is , get the auto generated book id and set it into the
			// bookPojo and return the book pojo - completed
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int autoAccountId = rs.getInt(1);
			
			accountPojo.setIdAccount(autoAccountId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return accountPojo;

}
	@Override
	public AccountPojo getAccount(int idCustomer) {
		

		Connection connection = DBUtil.makeConnection();
		Statement stmt = null;
		AccountPojo accountPojo = null;
		try {
			stmt = connection.createStatement();
			String query = "SELECT * FROM account WHERE idcustomer=" + idCustomer;
			ResultSet rs = stmt.executeQuery(query);
			// traverse the rs
			// as i traverse i would copy the contents into a book pojo object
			while (rs.next()) {
				accountPojo = new AccountPojo();
				accountPojo.setIdAccount(rs.getInt(1));
				accountPojo.setBalance(rs.getDouble(2));
				
				accountPojo.setName(rs.getString(4));
				
				
                

				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}
	
	@Override
	public List<AccountPojo> getAllAccounts(int idCustomer) {
		Connection connection = DBUtil.makeConnection();
		List <AccountPojo> allAccounts = new ArrayList<AccountPojo>();
		try {
			
			
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM account WHERE idcustomer=" + idCustomer;
			ResultSet rs = stmt.executeQuery(query);
			
		
			
			while (rs.next()) {
				
				AccountPojo accountPojo = new AccountPojo(rs.getInt(1), rs.getDate(3) , rs.getDouble(2), rs.getString(4), rs.getInt(5));
				allAccounts.add(accountPojo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return allAccounts;
		
	}
	
	
								
	
}
								
								
								
								
								
			
