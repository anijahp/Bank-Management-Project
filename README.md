# Bank-Management-Project
This java console bank management system supports multiple banks, multiple users, and a full range of transactions. Customers can transfer money between accounts, and view transaction history. Employees can create customer accounts, and view customer information and account details.

This is a basic console app that shows the Java skills I have learned so far during my time in Revature, this is not meant to be used as an actual bank management system as it does not have actual password security and does not fully incorporate the constraints a traditional bank app would have. I plan to complete these security features in a later version after I have taught myself web servlets and controllers so  I can convert this  into a web app.

Essentially, I created a simple Java bank management console application where I am able to monitor bank transactions including the balance, deposits, and withdrawals for any account. I also added functionality where I can add new accounts, view existing accounts, and deposit and withdraw money from an account. The data is stored in a Postgresql database which I created using rules and constraints with simple SQL statements. This was a great learning experience that taught me how to create a basic full-stack web application that interacts with databases instead of only relying on hard-coded values.

Here are the project requirements:

Employees must be able to 
- Login
- Create Customer Account
- View Customer Information
- Logout

Customers must be able to:
- Login
- Transfer Money
- View Account Balance
- View Transaction History
- Logout

![image (1)](https://user-images.githubusercontent.com/75582893/195463233-7d5e68df-a12e-429d-8b31-dce1b9cbe5aa.png)

Here is the database schema this is the first thing I did.

Data integrity is maintained by the auto generated primary keys.  

One bank has many branches and no foreign keys, so it is the parent of each branch and its entities. This database set up allows for a software that works with multiple banks. As the database administrator, I can add and remove banks, employees, and customers. Employees can add customers, but they can't remove them from the console app.

A branch can have multiple employees, and each employee must have a unique username. The branch ID is the foreign key for the employee table. Employees are identified, by their bank ID and branch ID.

A branch can have many customers, each customer must have a unique username. The branch ID is also the foreign key for the customer table. In the console app, only employees can create a customer account. The branch ID for a customer will be the branch ID of the employee who created it. Customer information will be shown based on their bank ID and branch ID.

There can be many accounts for one customer. The customer ID is the foreign key.

I created a transaction table to record transactions. Each account can have many transactions. There are two foreign keys for the transaction table. The foreign keys are both the account ID of the account that sent the money and the account ID of the account that received the money. 


 **Starting Menu**
 
<img width="697" alt="Screen Shot 2022-10-12 at 6 17 50 PM" src="https://user-images.githubusercontent.com/75582893/195458500-54095efd-a35a-403d-926b-c8859ad45ce9.png">


**Employee Menu**

<img width="794" alt="Screen Shot 2022-10-12 at 6 40 56 PM" src="https://user-images.githubusercontent.com/75582893/195461154-fa61a4fa-ab6a-4b1a-aeec-1daf6af40bec.png">



The employee menu allows employees to access their bank account information. Only employees should access this menu and as the menu loads the employee will see all of their information such as their bank name, branch number, and current balance. From here employees can select 4 options: create customer information, create a customer account, view all customers, or log out.


**Create Customer Information Option**

<img width="388" alt="Screen Shot 2022-10-13 at 12 51 56 PM" src="https://user-images.githubusercontent.com/75582893/195657668-4efbf91e-2634-4aef-9187-a261dc6ee463.png">

The create customer information option will allow employees to input customer information such as name, address, and password. This information can then be used to track customer records and contact them in case of an issue with their account. This will also help the bank gain more accurate data about their customers and allow them to easily search for this information later on.


**Create Account Information Option**


<img width="584" alt="Screen Shot 2022-10-13 at 12 54 17 PM" src="https://user-images.githubusercontent.com/75582893/195658159-15056e2b-70cc-43da-8427-61be8f778971.png">

The create customer account option allows employees to enter the account balance of a new customer and also what type of account they have (checking or savings). 


**Read Customer Information Option**

<img width="642" alt="Screen Shot 2022-10-13 at 12 37 26 PM" src="https://user-images.githubusercontent.com/75582893/195655129-ecbd99c5-9c4f-421d-9c76-fa5fca3b7366.png">

Once this information is entered into the system it will automatically generate an application form that can be viewed in the console. Employees can view customer information using option three.



**Customer Menu**

<img width="665" alt="Screen Shot 2022-10-13 at 12 42 16 PM" src="https://user-images.githubusercontent.com/75582893/195655812-2a63444c-eb20-4e8b-9902-4793ba63832f.png">

The customer menu option shows customer information and a menu when you log in. The customer interface includes information such as their bank name and address. Also, the account includes balance, account name, and account open date. The menu allows customers to transfer money, view transaction history, and logout. 


**Transfer Money Option**

<img width="623" alt="Screen Shot 2022-10-13 at 12 49 02 PM" src="https://user-images.githubusercontent.com/75582893/195657125-2734d88a-5b85-44b2-8c68-468282487775.png">

Customers can use the transfer money function to withdraw money from their account and sent it to another account. If the cx account doesn't have enough money or if the database loses connection, the transaction won't go through and the user will get an error. 


**Transaction History Option**

<img width="597" alt="Screen Shot 2022-10-13 at 12 59 45 PM" src="https://user-images.githubusercontent.com/75582893/195659261-4d3b208d-1ab9-4f2f-843d-140d592f1faf.png">

Once the customer has completed the transaction successfully. The transaction will be added to the transaction table. Customers can see their transaction history by choosing option 2.


<img width="374" alt="Screen Shot 2022-10-13 at 1 10 40 PM" src="https://user-images.githubusercontent.com/75582893/195661930-585024c7-675c-4c65-a558-6dcb4bb5143e.png">

Enjoy, more updates to come!

Anijah Phillip





