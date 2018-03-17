<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" href="/Inventory/resources/login.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"/></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Inventory Management</title>
</head>
<body>
<div class="form">
      
      <ul class="tab-group">
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
       <div id="login">   
          <h1>Welcome Back!</h1>
          
          
           <c:url var="login" value="/login" />
        	<form:form action="${login}" method="post">
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="text" name="email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          
          <input type="submit"/>
          </form:form>
          

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
</body>
<script type="text/javascript">
$('.form').find('input, textarea').on('keyup blur focus', function (e) {
	  
	  var $this = $(this),
	      label = $this.prev('label');

		  if (e.type === 'keyup') {
				if ($this.val() === '') {
	          label.removeClass('active highlight');
	        } else {
	          label.addClass('active highlight');
	        }
	    } else if (e.type === 'blur') {
	    	if( $this.val() === '' ) {
	    		label.removeClass('active highlight'); 
				} else {
			    label.removeClass('highlight');   
				}   
	    } else if (e.type === 'focus') {
	      
	      if( $this.val() === '' ) {
	    		label.removeClass('highlight'); 
				} 
	      else if( $this.val() !== '' ) {
			    label.addClass('highlight');
				}
	    }

	});

	$('.tab a').on('click', function (e) {
	  
	  e.preventDefault();
	  
	  $(this).parent().addClass('active');
	  $(this).parent().siblings().removeClass('active');
	  
	  target = $(this).attr('href');

	  $('.tab-content > div').not(target).hide();
	  
	  $(target).fadeIn(600);
	  
	});</script>
</html>
