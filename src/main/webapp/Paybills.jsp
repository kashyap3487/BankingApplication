<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.* , com.bank.model.*" %>  
     <%
     Double c_balance;
    List<User> users = (List<User>)session.getAttribute("user");
    User user = users.get(0);
   List<Account> accs = (List<Account>)session.getAttribute("accs");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" type="text/css" href="login.css">
<style type="text/css">
body{ 
 background-image:url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');
 background-repeat: repeat-y;
}
</style>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
   <form action="paybillsPost" method="post">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-white text-black" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 ">Bills Payment</h2>
            

              <div class="form-outline form-white mb-4" style="margin-top:20px;">
              <!-- <input type="email" id="typeEmailX" name="email" class="form-control form-control-lg" required/> -->  
              	<label class="form-label fw-bold"  for="typeEmailX">From:</label>
              	
              	<select name="fromAccountNumber" >
              		<%
		 for (Account acc : accs){
			 if(acc.getAccountType().equals("Checking")){
				 out.print("<option value="+acc.getAccountNumber()+">"+acc.getAccountType()+"(<b>**"+acc.getAccountNumber()+"</b>)"+"</option>");
				  c_balance=acc.getAmount();
			 }
			
		 }
		%>
              	</select>
                
              </div>

			 <div class="form-outline form-white mb-4">
              <!-- <input type="email" id="typeEmailX" name="accountNumber" class="form-control form-control-lg" required/> -->  
              	<label class="form-label fw-bold"  for="typeEmailX">To: </label>
              	<select name="paybills">
              		<option value="Hydro Bills">Hydro Bills</option>
              		<option value="Phone Bills">Phone Bills</option>
					<option value="Water Bills">Water Bills</option>
					<option value="Miscellaneous">Miscellaneous</option>              		              		
              	
              	</select>
              </div>	
				
              <div class="form-outline form-black mb-4">
                <input type="number" id="typePasswordX" name="amount" class="form-control form-control-lg" placeholder="Enter Tranfer Amount" <%
               		 for (Account acc : accs){
            			 if(acc.getAccountType().equals("Checking")){
            				 out.print("max="+acc.getAmount());
            				 
            			 }
            			
            		 }
            		%>  required />
                <label class="form-label fw-bold"  for="typePasswordX">Amount</label>
              </div>

              <button class="btn btn-outline-dark btn-lg px-5" type="submit">Transfer</button>


            </div>

            <div>
              <p class="mb-0"> <a href="Home.jsp" class="text-black-50 fw-bold">Go To Home Page</a>
              </p>
            </div>

          </div>
        </div>
      </div>
    </div>
    </form>
  </div>
</section>
</body>
</html>