<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.* , com.bank.model.*" %>  
     
     <%
    List<User> users = (List<User>)session.getAttribute("user");
    User user = users.get(0);
   List<Account> accs = (List<Account>)session.getAttribute("accs");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="Home.css">
</head>
<body>
		<div class="container" style="border:1px solid black;font-size:20px">
			<div class="nav-bar">
				<nav class="navbar navbar-default" style="background:#d3edf2;">
				  <div class="container-fluid" style="border:1px solid black;">
				    <div class="navbar-header">
				      <a style="display:block;text-decoration:none;font-size:20px;" class="navbar-brand" href="Home.jsp"><b>BankApplication</b></a>
				    </div>
				    <ul class="nav navbar-nav" style="display:block;text-decoration:none;font-size:20px;">
				      <li class="active"><a href="Home.jsp">Home</a></li>
				      <li><a href="transaction">View Statement</a></li>
				       <li><a href="internalTransfer.jsp">Internal Transfer</a></li>
				      <li><a href="Transfer.jsp">External Transfer</a></li>
				      <li><a href="Paybills.jsp">Pay Bills</a></li>
				      <li><a href="logout">Log Out</a></li>
				    </ul>
				  </div>
				</nav>
		</div >
		
		<%
		 for (Account acc : accs){
			out.print("<div class=\"card\" style=\"width: 30rem;\">"
			  +"<div class=\"card-body\" style=\"width: 90rem;\">"
			    +"<label>"+acc.getAccountType()+":</label>"
				+"<div class=\"input-group mb-3\" style=\"font-size:20px;\">"
				  +"<div class=\"input-group-prepend\">"
				    +"<span class=\"input-group-text\"  style=\"font-size:17px;\">$</span>"
				  +"</div>"
				  +"<input type=\"text\" class=\" col-lg-2\" value ="+ acc.getAmount()+"  style=\"font-size:17px;font-weight:bold;\" readonly size=50 aria-label=\"Amount (to the nearest dollar)\">"
				  +"<div class=\"input-group-append\">"
				    +"<span class=\"input-group-text\" style=\"font-size:17px;\">.00</span>"
				  +"</div>"
			+"</div>"
			+ "<button class=\"btn btn-success\"><a style=\"text-decoration:none;color:white;\" href= 'deposit?id="+acc.getAccountNumber()+"'>Deposit</a></button>"
					+ "&nbsp;<button class=\"btn btn-success\"><a style=\"text-decoration:none;color:white;\" href= 'withdraw?id="+acc.getAccountNumber()+"'>Withdraw</a></button>"
			 +"</div>"
			+"</div>");
		 }
		%>
			
			<footer>
				<span>@copyright 2022</span>
			</footer>
		</div>
			
			
		
		
</body>
</html>