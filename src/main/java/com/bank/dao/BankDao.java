package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.model.transaction;


public class BankDao {
	public Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/bank_db";

		String user = "root";

		String pwd = "";

		Connection con = null;

		// load the mysql Driver

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Successfull !!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}
	
	public List<User> logIn(String email,String password){
		List<User> stud = new ArrayList<User>();
		try {
			
			Connection con = getConnection();
			 Statement stm = con.createStatement();
			String q = "select * from user where email= \"" +email +"\" and password=\""+ password+"\"";
			System.out.print(q);
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()) {
				User user = new User(rs.getInt("userId"),rs.getString("password"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("contactNumber"), rs.getString("email"), rs.getString("address"),rs. getBoolean("isApproved"),rs.getString("verification_id"));
				stud.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
		
	}
	
	//Display User Infomation admin side
		public List<User> DisplayAdminData(){
			List<User> stud = new ArrayList<User>();
			try {
				
				Connection con = getConnection();
				 Statement stm = con.createStatement();
				String q = "select * from user where isApproved = "+ false;
				ResultSet rs = stm.executeQuery(q);
				while(rs.next()) {
					User user = new User(rs.getInt("userId"),rs.getString("password"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("contactNumber"), rs.getString("email"), rs.getString("address"),rs. getBoolean("isApproved"),rs.getString("verification_id"));
					stud.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stud;
			
		}
	
	//Display User Infomation
	public List<User> DisplayAllData(){
		List<User> stud = new ArrayList<User>();
		try {
			
			Connection con = getConnection();
			 Statement stm = con.createStatement();
			String q = "select * from user";
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()) {
				User user = new User(rs.getInt("userId"),rs.getString("password"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("contactNumber"), rs.getString("email"), rs.getString("address"),rs. getBoolean("isApproved"),rs.getString("verification_id"));
				stud.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
		
	}
	
	public List<User> getId(){
		List<User> stud = new ArrayList<User>();
		try {
			
			Connection con = getConnection();
			 Statement stm = con.createStatement();
			String q = "select *from user ORDER BY userId DESC LIMIT 1";
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()) {
				User user = new User(rs.getInt("userId"),rs.getString("password"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("contactNumber"), rs.getString("email"), rs.getString("address"),rs. getBoolean("isApproved"),rs.getString("verification_id"));
				stud.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
		
	}
	
	public void approvedUser(int id) throws SQLException {
	Connection con = getConnection();
//	String query = "delete from product where id = ?";
	String query = "update user SET isApproved = true where userId= ?";
	PreparedStatement ptst = con.prepareStatement(query);
	ptst.setInt(1, id);
	
	int status = ptst.executeUpdate();
	if(status > 0) {
		System.out.println("User Approved successfully");
		//System.out.println(DisplayAllData());
	}
	else {
		System.out.println("please try again");
	}
}


	
//	
//	public void Delete(int id) throws SQLException {
//		Connection con = getConnection();
//		String query = "delete from product where id = ?";
//		PreparedStatement ptst = con.prepareStatement(query);
//		ptst.setInt(1, id);
//		
//		int status = ptst.executeUpdate();
//		if(status > 0) {
//			System.out.println("Recorded deleted successfully");
//			//System.out.println(DisplayAllData());
//		}
//		else {
//			System.out.println("please try again");
//		}
//	}
//	
	
	
//	User Data Insertion
	public int insert(User product_from_Form) {

		Connection con = getConnection();

		String sql = "insert into user (password,firstName,lastName,contactNumber,email,address,verification_id) values(?,?,?,?,?,?,?)";

		int status = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			

			pstmt.setString(1, product_from_Form.getPassword());
			pstmt.setString(2, product_from_Form.getFirstName());
			pstmt.setString(3, product_from_Form.getLastName());
			pstmt.setInt(4, product_from_Form.getContactNumber());
			pstmt.setString(5, product_from_Form.getEmail());
			pstmt.setString(6, product_from_Form.getAddress());
			pstmt.setString(7, product_from_Form.getVarificationId());
			
			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Inserted Successfully!");
			} else {

				System.out.println("Please Try Again!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	//Insert transaction data
	public int insertTransaction(transaction trans_Form,int user_id) {
//		int transaction_number = (int)(Math.random()*(999999-100000+1)+100000); 
		Connection con = getConnection();
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		String sql = "insert into transaction (transactionId,fromAccount,toAccount,type,amount,dateTime,userId) values(?,?,?,?,?,?,?)";

		int status = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);	

			pstmt.setInt(1, trans_Form.getTransactionId());
			pstmt.setString(2, trans_Form.getFromAccount());
			pstmt.setString(3, trans_Form.getToAccount());
			pstmt.setString(4, trans_Form.getType());
			pstmt.setDouble(5, trans_Form.getAmount());
			pstmt.setString(6, formattedDate);
			pstmt.setInt(7, user_id);
			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Inserted Successfully!");
			} else {

				System.out.println("Please Try Again!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	//Display transaction Infomation of user
	public List<transaction> DisplayTransactionData(int user_id){
		List<transaction> stud = new ArrayList<transaction>();
		try {
			
			Connection con = getConnection();
			 Statement stm = con.createStatement();
			String q = "select * from transaction where userId =" + user_id +" ORDER BY dateTime DESC ";
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()) {
				transaction t = new transaction(rs.getInt("transactionId"),rs.getString("fromAccount"),rs.getString("toAccount"), rs.getString("type"), rs.getDouble("amount"), rs.getString("dateTime"));
				stud.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
		
	}
	
//	public List<User> getBalance(Integer userid){
//		List<User> stud = new ArrayList<User>();
//		try {
//			
//			Connection con = getConnection();
//			 Statement stm = con.createStatement();
//			String q = "select * from user where userID =" + userid;
//			//ptst.setInt(1, id);
//
//			ResultSet rs = stm.executeQuery(q);
//			while(rs.next()) {
//				User user = new User(rs.getInt("userId"),rs.getString("password"),rs.getString("firstName"), rs.getString("lastName"), rs.getInt("contactNumber"), rs.getString("email"), rs.getString("address"));
//				stud.add(user);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return stud;
//		
//	}
	
	//Data Insertion for Account table
	
	public int insertAccount(Account acc_from_Form, int user_id) {

		Connection con = getConnection();

		String sql = "insert into account (	accountNumber,amount,accountType,userID)values(?,?,?,?)";

		int status = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			

			pstmt.setInt(1, acc_from_Form.getAccountNumber());
			pstmt.setDouble(2, acc_from_Form.getAmount());
			pstmt.setString(3, acc_from_Form.getAccountType());
			pstmt.setInt(4, acc_from_Form.getUserId());

		
			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Inserted Successfully!");
			} else {

				System.out.println("Please Try Again!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	// Display account information of user
	public List<Account> DisplayAccountData(int user_id){
		List<Account> stud = new ArrayList<Account>();
		try {
			
			Connection con = getConnection();
			 Statement stm = con.createStatement();
			String q = "select * from account where userId =" + user_id;
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()) {
				Account acc = new Account(rs.getInt("accountNumber"),rs.getDouble("amount"),rs.getString("accountType"),rs.getInt("userId"));
				stud.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
		
	}

	public Account getIndAccount(Integer accNumb) {
		// TODO Auto-generated method stub
		List<Account> stud = new ArrayList<Account>();
		try {
			
			Connection con = getConnection();
			 Statement stm = con.createStatement();
			String q = "select * from account where accountNumber =" + accNumb;
			ResultSet rs = stm.executeQuery(q);
			while(rs.next()) {
				Account acc = new Account(rs.getInt("accountNumber"),rs.getDouble("amount"),rs.getString("accountType"),rs.getInt("userId"));
				stud.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud.get(0);	}
//
	public void depositAmount(Account acc, Double amount) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Double newAmt = acc.getAmount() + amount;
//		String query = "delete from product where id = ?";
		String query = "update account SET amount = "+ newAmt+" where accountNumber= ?";
		PreparedStatement ptst = con.prepareStatement(query);
		ptst.setInt(1, acc.getAccountNumber());
		
		int status = ptst.executeUpdate();
		if(status > 0) {
			System.out.println("Deposit  successfully");
			//System.out.println(DisplayAllData());
		}
		else {
			System.out.println("please try again");
		}	
	}
	
	public boolean checkAccount(int accountNumber) throws SQLException {
		List<Account> stud = new ArrayList<Account>();
		Connection con = getConnection();
		Statement stm = con.createStatement();
		String q = "select * from account where accountNumber =" + accountNumber;
		ResultSet rs = stm.executeQuery(q);
		while(rs.next()) {
			Account acc = new Account(rs.getInt("accountNumber"),rs.getDouble("amount"),rs.getString("accountType"),rs.getInt("userId"));
			stud.add(acc);
		}
		
		if(stud.size()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void withdrawAmount(Account acc, Double amount) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Double newAmt = acc.getAmount() - amount;
//		String query = "delete from product where id = ?";
		String query = "update account SET amount = "+ newAmt+" where accountNumber= ?";
		PreparedStatement ptst = con.prepareStatement(query);
		ptst.setInt(1, acc.getAccountNumber());
		
		int status = ptst.executeUpdate();
		if(status > 0) {
			System.out.println("Withdraw  successfully");
			//System.out.println(DisplayAllData());
		}
		else {
			System.out.println("please try again");
		}	
	}
}
