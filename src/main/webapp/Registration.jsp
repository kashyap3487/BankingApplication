<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" type="text/css" href="register.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>'
<style type="text/css">
body{ 
 background-image:url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');
 background-repeat: repeat-y;
}
</style>
</head>
<body>
<section class="vh-100 bg-image">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Create an account</h2>

              <form action="signup_register" method="post">

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="firstName" required/>
                  <label class="form-label" for="form3Example1cg">First Name</label>
                </div>
                
                 <div class="form-outline mb-4">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="lastName" required/>
                  <label class="form-label" for="form3Example1cg">Last Name</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="email" id="form3Example3cg" class="form-control form-control-lg" name="email" required/>
                  <label class="form-label" for="form3Example3cg">Your Email</label>
                </div>
                
                <div class="form-outline mb-4">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="contact" required/>
                  <label class="form-label" for="form3Example1cg">Contact</label>
                </div>
                <div class="form-outline mb-4">
                  <textarea id="w3review" name="address" class="form-control form-control-lg" rows="2" cols="50"></textarea>
                  <label class="form-label" for="form3Example1cg">Address</label>
                </div>
                
                 <div class="form-outline mb-4">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" name="verification_id" required/>
                  <label class="form-label" for="form3Example1cg">Verification Identification</label>
                </div>
                <span>Select account types:</span>
                <div class="form-check d-flex  mb-5">
            
                  <label class="form-check-label" for="form2Example3g">
                  <input class="form-check-input me-2" type="checkbox" value="Saving" name="saving" id="form2Example3cg" checked />Saving</label>
                  
                  <label class="form-check-label" for="form2Example3g">
                  <input class="form-check-input me-2" type="checkbox" value="Cheking" name="checking" style="margin-left:5px;" id="form2Example3cg" checked />Checking</label>
                   
                  
                  <label class="form-check-label" for="form2Example3g">
                  <input class="form-check-input me-2" type="checkbox" value="TSA" name="TSA" style="margin-left:5px;" id="form2Example3cg" />TSA</label>
                  
                  <label class="form-check-label" for="form2Example3g"> 
                  <input class="form-check-input me-2" type="checkbox" value="RSA" name="RSA" style="margin-left:5px;" id="form2Example3cg"/>RSA</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" id="form3Example4cg" class="form-control form-control-lg" name="password" required/>
                  <label class="form-label" for="form3Example4cg">Password</label>
                </div>

                

                <div class="form-check d-flex justify-content-center mb-5">
                  <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" required/>
                  <label class="form-check-label" for="form2Example3g">
                    I agree all statements in <a href="#!" class="text-body"><u>Terms of service</u></a>
                  </label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit"
                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                </div>

                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="Login.jsp"
                    class="fw-bold text-body"><u>Login here</u></a></p>

              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>	
</body>
</html>