<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.* , com.bank.model.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<%
    List<User> users = (List<User>)session.getAttribute("users");
%>
<body>
	<div class="container">
		<div style="margin-top:10px;display:flex;align-items:centre;">
			 <button type="button" class="btn btn-default btn-sm"><a href="logout">
         		  Log out</a>
       		 </button>
		</div>
		<div style="margin-top:15px;">
				<table id="example" class="table table-striped" style="width:100%">
		        <thead>
		            <tr>
		                <th>Name</th>
		                <th>Identification Number</th>
		                <th>Email</th>
		                <th>Contact</th>
		                <th>Address</th>
		            </tr>
		        </thead>
		        <tbody>
		        		
		        	 <% 
   for(int i=0;i<users.size();i++)
   {   
       out.print("<tr> <td>"+users.get(i).getFirstName()+" "+users.get(i).getLastName()+"</td> <td>"+users.get(i).getVarificationId()+"</td> <td>"+users.get(i).getEmail()+"</td> <td>"+users.get(i).getContactNumber()+"</td><td>"+users.get(i).getAddress()+"</td> <td><button class=\"btn btn-success\"><a style=\"text-decoration:none;color:white;\" href= 'edit?id="+users.get(i).getUserId()+"'>Approved</a></button></td>  </tr>");   
   }
   %>     
		        
		        
		        
		                        
		    </table>	
    </div>
	</div>
</body>
</html>