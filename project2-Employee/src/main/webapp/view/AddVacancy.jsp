<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Add Vacancy</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>

	<div class="row">
		<div class="col-md-12 location_icon_bottum">
			<div class="row">
				<div class="col-md-8 ">
					<div class="menu-area">
						<div class="limit-box">
							<nav class="main-menu">
								<ul class="menu-area-main">
									 <li class="active"> 
									 <li class="active"> <a href="employer/home">Home</a> </li>
                                                 <li> <a href="#about">About</a> </li>
                                                <li><a href="/employer/JobSeekersDetails">See JobSeekers</a></li>
                                                <li><a href="/employer/addNewJob">Add vacancies</a></li>
                                                <li><a href="/employer/ContactUs">Contact Us</a></li>

								</ul>
							</nav>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="main">

		<div class="container">
			<form method="POST"  action="saveData" class="appointment-form" id="appointment-form">
				<h2>Post A Job</h2>
				<div class="form-group-1">
				<b>Title:</b>
					<input type="text" name="title" id="title" placeholder="Title" required />
					<b>Company Name:</b>
					 <input type="text" name="name" id="name" placeholder="Enter your Company Name" required /> 
					<b> Email:</b>
					 <input type="text" name="email" id="email" placeholder="Email" required />
					<b> Phone Number:</b>
					  <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone number" required />
					  <b>Position:</b>
						<input type="text"name="position" id="Position" placeholder="Enter Job Positon" required />
						
					
				</div>
				
				<div class="form-check">
					<input type="checkbox" name="agree-term" id="agree-term"
						class="agree-term" /> <label for="agree-term"
						class="label-agree-term"><span><span></span></span>I agree
						to the <a href="#" class="term-service">Terms and Conditions</a></label>
				</div>
				
				<div class="form-submit">
					<input type="submit" name="submit" id="submit" class="submit"
						value="Post" />
				</div>
			</form>
		</div>

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>