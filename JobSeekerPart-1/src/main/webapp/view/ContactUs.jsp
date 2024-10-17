<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Contact Us</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="css/style2.css">
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
<div class="row">
	<div class="col-md-12 location_icon_bottum">
		<div class="row">
			<div class="col-md-8 ">
				<div class="menu-area">
					<div class="limit-box">
						<nav class="main-menu">
							<ul class="menu-area-main">
								<li class="active"> <a href="/jobseeker/home">Home</a> </li>
                                                 <li> <a href="#about">About</a> </li>
                                                <li><a href="/jobseeker/apply">Apply Job</a></li>
                                                <li><a href="/jobseeker/searchJobs">Vacancy</a></li>
                                                <li><a href="/jobseeker/ContactUs">Contact Us</a></li>

							</ul>
						</nav>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<body>

	<div class="wrapper">
		<div class="inner">
			<form action="ContactData" method="post">
				<h3>Contact Us</h3>
				<p>Fill This Form</p>
				<label class="form-group"> <input type="text" name="name"
					class="form-control" required> <span>Your Name</span> <span
					class="border"></span>
				</label> <label class="form-group"> <input type="text" name="mail"
					class="form-control" required> <span for="">Your
						Mail</span> <span class="border"></span>
				</label> <label class="form-group"> <textarea name="message"
						id="mesage" class="form-control" required></textarea> <span for="">Your
						Message</span> <span class="border"></span>

				</label> <input type="submit" value="Save"> <i
					class="zmdi zmdi-arrow-right"></i>

			</form>
		</div>
	</div>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>