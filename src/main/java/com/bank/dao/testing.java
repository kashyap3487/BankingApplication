package com.bank.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.model.transaction;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankDao dao = new BankDao();
		dao.getConnection();
		
//		User user = new User("lasan", "Jwala", "Jwala", 93939, "a@g.com", "kksksk",false,"ABCDDD");
//		
////		dao.insert(user);
////		System.out.println(dao.getBalance(1));
		transaction t = new transaction(2239, "akib", "callgirl", "stress releave", 20., "22/07");
//		Account acc = new Account(2132, 20.3,"checking", 1);
		
		dao.insertTransaction(t, 1);
//		dao.insertAccount(acc, 1);
//		System.out.println(dao.DisplayAllData());
		System.out.println(dao.DisplayTransactionData(1));
//		System.out.println(dao.DisplayAccountData(1));
		

	    

	   
		
		}

}
