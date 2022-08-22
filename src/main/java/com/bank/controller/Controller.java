package com.bank.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.BankDao;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.model.transaction;



/**
 * Servlet implementation class Controller
 */

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BankDao db=new BankDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("Text/html");
		out.print("<h3 style='color:red;text-align:center'>Welcome</h3>");
		
		String url=request.getServletPath();
		System.out.println(url);
		
		
		switch(url) {
		case("/signup"):{
			out.print("Insert information to sign up");
			signup(request, response);
			break;
		}
		case("/signup_register"):{
//			out.print("Request sent to admin");
			
			signup_register(request, response);
			break;
		}
		
		case("/deposit"):{
			out.print("deposit Page redirect");
			deposit(request, response);
			break;
		}
		case("/withdraw"):{
			out.print("withdraw Page redirect");
			withdraw(request, response);
			break;
		}
		case("/WithdrawPost"):{
			out.print("after withdraw");
			try {
				withdrawPost(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case("/paybillsPost"):{
			out.print("after withdraw");
			try {
				paybillsPost(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case("/DepositPost"):{
			out.print("after deposit");
			try {
				depositPost(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case("/read"):{
			out.print("Welcome to display all record feature");
//			display(request,response);
			break;
		}
		case("/logIn"):{
			out.print("Welcome to update all record feature");
			logIn(request, response);
			break;
		}
		case("/logIn_page"):{
			logIn_page(request, response);
			break;
		}
		case("/transferPost"):{
			try {
				transferPost(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case("/logout"):{
			out.print("Welcome to update all record feature");
			logOut(request, response);
			break;
		}
		case("/transaction"):{
			out.print("Welcome to delete all record feature");
			displayTransaction(request,response);
			break;
		}
		case("/edit"):{
			out.print("Welcome to Edit record feature");
			try {
				edit(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		default:{
			out.print("*****Invalid Url Please check your URL**********");
			break;
		}
		}
		
	}
	
	private void paybillsPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Integer faccountNumber=Integer.parseInt(request.getParameter("fromAccountNumber"));
		String to=request.getParameter("paybills");
		HttpSession session=request.getSession(false);
		Account acc = (Account) session.getAttribute("acc");
		String type="Bill Payment";
		
//		db.withdrawAmount(acc, amount);
		Account fromaccount=db.getIndAccount(faccountNumber);
		db.withdrawAmount(fromaccount, amount);
//		
		
		int transaction_number = (int)(Math.random()*(999999-100000+1)+100000);
		transaction tr=new transaction(transaction_number,String.valueOf(fromaccount.getAccountNumber()),to,type,amount,null);
		int status=db.insertTransaction(tr, fromaccount.getUserId());
		System.out.print("Satus"+status);
		List<Account> accs = new ArrayList<>();
		accs = db.DisplayAccountData(fromaccount.getUserId());
		session.setAttribute("accs", accs);
		response.sendRedirect("BillSuccess.jsp");
		
	}

	private void transferPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Integer accountNumber=Integer.parseInt(request.getParameter("toAccount"));
		Integer faccountNumber=Integer.parseInt(request.getParameter("fromAccountNumber"));
		HttpSession session=request.getSession(false);
		List<Account> accs = (List<Account>) session.getAttribute("accs");
		Account facc = null;
		Integer c_account = null;
		Integer u_id = 0;
		String type="";
		for (Account acc : accs){
			 if(acc.getAccountType().equals("Checking")){
				 facc = acc;
//				  c_account=acc.getAccountNumber();
//				  u_id=acc.getUserId();
//				  System.out.print(acc);
			 }
			
		 }
		
	System.out.print(" here "+ 1);
		if(db.checkAccount(accountNumber))
		{
			Account fromaccount=db.getIndAccount(faccountNumber);
			db.withdrawAmount(facc, amount);
			
//			db.depositAmount(acc, amount);
			Account toaccount=db.getIndAccount(accountNumber);
			db.depositAmount(toaccount, amount);
			
			if(fromaccount.getUserId()==toaccount.getUserId()) {
					type="Internal Transfer";
			}	
			else {
				type="External Transfer";
			}
			int transaction_number = (int)(Math.random()*(999999-100000+1)+100000);
			transaction tr=new transaction(transaction_number,String.valueOf(faccountNumber),String.valueOf(accountNumber),type,amount,null);
					int status=db.insertTransaction(tr, fromaccount.getUserId());
					System.out.println(u_id);
					
					List<Account> accs1 = new ArrayList<>();
					accs1 = db.DisplayAccountData(facc.getUserId());
					session.setAttribute("accs", accs1);
					response.sendRedirect("TransferSuccess.jsp");
		}
		else {
			response.sendRedirect("NoAccountFound.jsp");	
		}
		
		
		
		
		
	}

	private void withdrawPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		HttpSession session=request.getSession(false);
		Account acc = (Account) session.getAttribute("acc");
		String type="Withdraw";
		db.withdrawAmount(acc, amount);
		
		System.out.println(acc.getUserId());
		
		int transaction_number = (int)(Math.random()*(999999-100000+1)+100000);
		transaction tr=new transaction(transaction_number,String.valueOf(acc.getAccountNumber()),"-",type,amount,null);
		int status=db.insertTransaction(tr, acc.getUserId());
		System.out.print("Satus"+status);
		List<Account> accs = new ArrayList<>();
		accs = db.DisplayAccountData(acc.getUserId());
		session.setAttribute("accs", accs);
		response.sendRedirect("Home.jsp");
		
	}

	private void withdraw(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer accNumb = Integer.parseInt(request.getParameter("id"));
		System.out.print(accNumb);
		HttpSession session=request.getSession(false);
		Account acc = db.getIndAccount(accNumb);
		session.setAttribute("acc", acc);
		String title = "Withdraw";
	
		session.setAttribute("title",title );
		System.out.print(acc);
		response.sendRedirect("WithdrawDeposit.jsp");
		
	}

	private void depositPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		HttpSession session=request.getSession(false);
		Account acc = (Account) session.getAttribute("acc");
		db.depositAmount(acc, amount);
		String type="Deposit";
		System.out.println(acc.getUserId());
		int transaction_number = (int)(Math.random()*(999999-100000+1)+100000);
		transaction tr=new transaction(transaction_number,"-",String.valueOf(acc.getAccountNumber()),type,amount,null);
		int status=db.insertTransaction(tr, acc.getUserId());
		List<Account> accs = new ArrayList<>();
		accs = db.DisplayAccountData(acc.getUserId());
		session.setAttribute("accs", accs);
		response.sendRedirect("Home.jsp");
	}

	private void deposit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer accNumb = Integer.parseInt(request.getParameter("id"));
		System.out.print(accNumb);
		HttpSession session=request.getSession(false);
		Account acc = db.getIndAccount(accNumb);
		session.setAttribute("acc", acc);
		String title = "Deposit";
		
		session.setAttribute("title",title );
		System.out.print(acc);
		response.sendRedirect("WithdrawDeposit.jsp");
	}

	protected void displayTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		List<transaction> trans=new ArrayList<>();
		List<User> users = (List<User>)session.getAttribute("user");
	    User user = users.get(0);
		trans = db.DisplayTransactionData(user.getUserId());
		
		System.out.println(trans);
		session.setAttribute("trans", trans);
		response.sendRedirect("transaction.jsp");
	}
	// Log in page
	protected void logIn_page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}
	//LogIn Condition	
	protected void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.print(email+" "+password);
		List<User> users=new ArrayList<>();
		users=db.logIn(email, password);
		String db_email=users.get(0).getEmail();
		String db_password=users.get(0).getPassword();
		
		if(db_email.equals("admin@admin")) {
			List<User> user=new ArrayList<>();
			user=db.DisplayAdminData();
			System.out.println(user);
			HttpSession session=request.getSession();
			session.setAttribute("users", user);
			response.sendRedirect("Admin.jsp");
		}
		else {
			
			if (!users.get(0).getIsApproved()) {
				response.sendRedirect("ApprovedInfo.jsp");
			}else {
				List<Account> accs = new ArrayList<>();
				accs = db.DisplayAccountData(users.get(0).getUserId());
				HttpSession session=request.getSession();
				session.setAttribute("user", users);
				session.setAttribute("accs", accs);
				response.sendRedirect("Home.jsp");
			}
			
		}
		
	}
	protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
// get sign up page
	
protected void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.sendRedirect("signup.jsp");
}

//Post sign up page

protected void signup_register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String email=request.getParameter("email");
	Integer contact=Integer.parseInt(request.getParameter("contact"));
	String address=request.getParameter("address");
	String verification_id=request.getParameter("verification_id");
	String saving=request.getParameter("saving");
	String checking=request.getParameter("checking");
	String tsa=request.getParameter("TSA");
	String rsa=request.getParameter("RSA");
	String password=request.getParameter("password");
	User user=new User(password,firstName,lastName,contact,email,address,false,verification_id);
	db.insert(user);
	List<User> users=new ArrayList<>();
	users=db.getId();
	int user_id=users.get(0).getUserId();
//	int c=2;
	
	if(!(tsa == null)) {
		int account_number = (int)(Math.random()*(999999-100000+1)+100000);  
		Account ac=new Account(account_number,0.0,tsa,user_id);
		db.insertAccount(ac, user_id);
		
	}
	if(!(rsa == null)) {
		int account_number = (int)(Math.random()*(999999-100000+1)+100000);  
		Account ac=new Account(account_number,0.0,rsa,user_id);
		db.insertAccount(ac, user_id);
	}

	for(int i=0;i<2;i++) {
	
		int account_number = (int)(Math.random()*(999999-100000+1)+100000);  
		String Account_type;
		if(i==0) {
			Account_type="Saving";
		}
		else {
			Account_type="Checking";
		}
		Account ac=new Account(account_number,0.0,Account_type,user_id);
		db.insertAccount(ac, user_id);
		
	}
	System.out.print(users.get(0).getUserId());
	System.out.println(firstName+" "+lastName+" "+email+" "+contact+" "+address+" "+verification_id+" "+saving+" "+checking+" "+tsa+" "+rsa+" "+password);
	
	response.sendRedirect("ApprovedInfo.jsp");
}


protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//get id coming from approve button as request parameter
		int id_Updated=Integer.parseInt(request.getParameter("id"));
		
		//Use this id as a method parameter in Dao class method to get Rec of this employee
//		User user_to_be_updated=db.approvedUser(id_Updated);
//		Employee emp_to_be_updated = db.getRecById(id_Updated);
//		System.out.print(emp_to_be_updated);
		//Put this Employee in session object in HTTP Session to be available in edit.jsp page
//		HttpSession session = request.getSession();
		
		//Set the emp_to_be_updated as an attribute
//		session.setAttribute("emp_tobe_updated",emp_to_be_updated );	
//		response.sendRedirect("edit.jsp");
		db.approvedUser(id_Updated);
		display(request,response);
		
	}
	

//	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		int e_id=Integer.parseInt(request.getParameter("id"));
//		//	Use this id in delete method of Dao class to delete record from database
//		db.delete(e_id);
//		display(request,response);
//		
//	}

	private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> user=new ArrayList<>();
		user=db.DisplayAdminData();
		System.out.println(user);
		HttpSession session=request.getSession();
		session.setAttribute("users", user);
		response.sendRedirect("Admin.jsp");
	}
//	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
