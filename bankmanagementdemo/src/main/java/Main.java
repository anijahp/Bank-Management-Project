
import dao.EmployeeDao;
import dao.EmployeeDaoJdbcImpl;
import pojo.EmployeePojo;
import pojo.CustomerPojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) //main class of bank
        throws IOException
    {
 
        BufferedReader sc = new BufferedReader(
            new InputStreamReader(System.in));
        
        String userName = "";
        String passWord = "";
        Scanner scan = new Scanner(System.in);
        int ch;
        char continueApp = 'y';
        EmployeeService employeeService = new EmployeeServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        
        while (continueApp == 'y' || continueApp == 'Y') {
            System.out.println(
                "\n ->||    WELCOME TO OMEGA BANK SYSTEMS    ||<- \n");
            System.out.println("1)EMPLOYEE LOGIN");
            System.out.println("2)CUSTOMER LOGIN");
            System.out.println("3)EXIT PROGRAM");
 
            try {
                System.out.print("\n    Enter Input:"); //user input
                ch = Integer.parseInt(sc.readLine());
 
                switch (ch) {
                case 1:
                    try {
                        System.out.print("Enter Employee UserName:");
                        String fetchUserName = sc.readLine();
                        System.out.print( "Enter Employee Password:"); 
                        String fetchPassWord = sc.readLine();
                        EmployeePojo loggedInEmployee;
                        loggedInEmployee = employeeService.loginAccount(fetchUserName,fetchPassWord);
                        
                        
							if(loggedInEmployee == null) {
							    System.out.println(
							        "ERR : Login Failed!\n");
							}else {
								
						
							}
                    }
							  catch (Exception e) {
			                        System.out.println(
			                            " ERR : Enter Valid Data::Login Failed!\n");
			                    }
                    break;
                case 2:
                    try {
                    	System.out.print("Enter Your UserName:");
                        String fetchUserName = sc.readLine();
                        System.out.print( "Enter Your Password:"); 
                        String fetchPassWord = sc.readLine();
                        CustomerPojo loggedIn;
                        loggedIn = customerService.loginAccountCx(fetchUserName,fetchPassWord);
                        
                       
                        if(loggedIn == null) {
						    System.out.println(
						        "ERR : Login Failed!\n");
                        }else {
                            
                        }
                    }
                    catch (Exception e) {
                        System.out.println(
                            " ERR : Enter Valid Data::Login Failed!\n");
                    }
 
                    break;
                case 3:
    				System.out.println("*************************************************");
    				System.out.println("THANK YOU FOR USING OMEGA BANK SYSTEMS!!");
    				System.out.println("*************************************************");
    				System.exit(0);
    				break;
 
                default:
                    System.out.println("Invalid Entry!\n");
                }
                
        
 
//                if (ch == 5) {
//                    System.out.println(
//                        "Exited Successfully!\n\n Thank You :)");
//                    break;
//                }

                System.out.println("*************************************************");
    			System.out.println("Do you want to continue(y/n) ?");
    			continueApp = scan.next().charAt(0); 
    			
            
            
    		
            }
            catch (Exception e) {
                System.out.println("ENTER MENU NUMBER ** YOUR ENTRY IS INVALID");
            }
        }
        System.out.println("*************************************************");
		System.out.println("THANK YOU FOR USING OMEGA BANK SYSTEMS!!");
		System.out.println("*************************************************");
        sc.close();
    }
    
}



