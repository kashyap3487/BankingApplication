<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.* , com.bank.model.*" %>  
        <%
    List<transaction> trans = (List<transaction>)session.getAttribute("trans");
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				      <a class="navbar-brand" href="Home.jsp">BankApplication</a>
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
<div style="margin-top:15px;">
				<table id="example" class="table table-striped" style="width:100%">
		        <thead>
		            <tr>
		                <th>Transaction ID</th>
		                <th>From</th>
		                <th>To</th>
		                <th>Type</th>
		                <th>Amount</th>
		                <th>TimeStamp</th>
		            </tr>
		        </thead>
		        <tbody>
		        		
		        	 <% 
   for(int i=0;i<trans.size();i++)
   {   
       out.print("<tr> <td>"+trans.get(i).getTransactionId()+"</td> <td>"+trans.get(i).getFromAccount()+"</td> <td>"+trans.get(i).getToAccount()+"</td> <td>"+trans.get(i).getType()+"</td> <td>"+trans.get(i).getAmount()+"</td><td>"+trans.get(i).getDateTime()+"</td>   </tr>");   

   }
   %>     
		        
		        
		        
		                        
		    </table>	
    </div>
</body>
</html>