<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ page import="java.util.* , com.bank.model.*" %>  
    <% Object title = session.getAttribute("title");
    Account acc = (Account)session.getAttribute("acc");
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
   <form action=<%=title+"Post" %> method="post">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-white text-black" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2"><%=title %></h2>
              

              <div class="form-outline form-white mb-4">
                <input type="number" id="typeEmailX" name="amount" class="form-control form-control-lg" placeholder="Enter Amount" required min="1" <%if (title == "Withdraw"){out.print("max="+acc.getAmount());} %> />
                <label class="form-label fw-bold"  for="typeEmailX">Amount</label>
              </div>

              <button class="btn btn-outline-dark btn-lg px-5" type="submit"><%=title %></button>


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