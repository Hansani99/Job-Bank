<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Job Seeker</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout ">
    <!-- loader  -->
    <div class="loader_bg">
        <div class="loader"><img src="images/loading.gif" alt="#" /></div>
    </div>
    <!-- end loader -->
    <!-- header -->
    <header>
        <!-- header inner -->
        <div class="header">

            <div class="container">
                <div class="row">
                    <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col logo_section">
                        <div class="full">
                            <div class="center-desk">
                                <div class="logo">
                                    <a href="index.html"><img src="images/employee.png" alt="#"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                        <div class="location_icon_bottum_tt">
                            <ul>
                                <li><img src="icon/loc1.png" />Location</li>
                                <li><img src="icon/email1.png" />JobSeeker@gmail.com</li>

                                <li><img src="icon/call1.png" />(+71)9876543109</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 location_icon_bottum">
                       <div class="row">
                            <div class="col-md-8 ">
                                <div class="menu-area">
                                    <div class="limit-box">
                                        <nav class="main-menu">
                                            <ul class="menu-area-main">
                                                <li class="active"> 
                                                <a href="/jobseeker/home">Home</a> </li>
                                                 <li> <a href="#about">About</a> 
                                               <li> <a href="/jobseeker/apply">Apply</a> </li>
                                                <li><a href="/jobseeker/searchJobs">Vacancy</a></li>
                                                <li><a href="/jobseeker/ContactUs">Contact Us</a></li>

                                            </ul>
                                        </nav>
                                    </div>
                                </div>

                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4">
                                <form class="search">
                                    <input class="form-control" type="text" placeholder="Search">
                                    <button><img src="images/search_icon.png"></button>
                                </form>
                            </div>
                       </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end header inner -->
    </header>
    <!-- end header -->

  <div class="offer">
     <div class="container">
        <div class="row">
           <form class="form-inline" action="/action_page.php">
              <div class="form-group">
                 <label for="jobTitle">Job Title:</label>
                 <input type="text" class="form-control" id="jobTitle">
              </div>
              <div class="form-group">
                 <label for="companyName">Company Name:</label>
                 <input type="text" class="form-control" id="companyName">
              </div>
        </div>
        <div class="row">
        <div class="form-group">
        <label for="jobType">Job Type:</label>
        <select class="form-select" name="jobType" id="jobType">
        <option value="0">---Please Select---</option>

        <c:forEach items="${jobTypeVOList}" var="jobTypeVO">
        <option value="${jobTypeVO.id}">${jobTypeVO.name}</option>
        </c:forEach>

        </select>
        </div>
        <div class="form-group">
        <label for="industry">Industry:</label>
        <select class="form-select" name="industry" id="industry">
        <option value="0">---Please Select---</option>

        <c:forEach items="${jobIndustryVOList}" var="jobIndustryVO">
        <option value="${jobIndustryVO.id}">${jobIndustryVO.name}</option>
        </c:forEach>

        </select>
        </div>
        <div class="form-group">
        <label for="expLevel">Experience Level:</label>
        <select class="form-select" name="expLevel" id="expLevel">
        <option value="0">---Please Select---</option>

        <c:forEach items="${experienceLevelVOList}" var="experienceLevelVO">
        <option value="${experienceLevelVO.id}">${experienceLevelVO.name}</option>
        </c:forEach>

        </select>
        </div>

        <input type="button" id="btnSearch" class="btn btn-default" value="Search"/>
        </form>
        </div>
     </div>
  </div>

  <div class="offer">
       <div class="container">
          <div class="row">

          <table id="tblSearchResult" class="table table-hover">
            <tr>
              <th>Posted Date</th>
              <th>Job Title</th>
              <th>Company Name</th>
              <th>Job Type</th>
              <th>Industry</th>
              <th>Experience Level</th>
              <th>View</th>
            </tr>

          </table>

          </div>
       </div>

  </div>
  
    <!-- end for_box -->
    <!-- offer -->
    <div class="offer">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="title">
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="offer-bg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 ">
                        <div class="offer_box">
                            
                            <h3>JobSekkerPayment </h3>
                            <figure><img src="images/emp1.jpg" alt="img" /></figure>
                            
                            <p>Financial help if you're between 22 and Age Person Age and looking for work it's also 
                            for when you're sick or injured and can't do your usual work for a short time</p>

                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 margin_ttt">
                        <div class="offer_box">
                            <h3>Your Allowance for job seekers</h3>
                            <figure><img src="images/emp2.jpg" alt="img" /></figure>
                            <p>Financial help if you're 21 or younger and lokking for work,or temporarily unable to work</p>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 margin-lkk">
                        <div class="offer_box">
                            <h3>Parenting Payment</h3>
                            <figure><img src="images/emp3.jpg" alt="img" /></figure>
                            <p>The main income support payment while you're a young child's main Carer</p>
                        </div>
                    </div>

                    <div class="col-md-12">
                       
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- end offer -->

    <!-- product -->
    

    <!-- end product -->
    <!-- clients -->
                          
    <!-- end clients -->
    <!-- contact -->

    
    <!-- end contact -->

    <!-- footer -->
    <!--  footer -->
   <footer>
        <div class="footer top_layer ">
            <div class="container">

                <div class="row">
                    <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                        <div class="address">
                            <a href="index.html"> <img src="images/employee.png" alt="logo" /></a>
                            
                        </div>
                    </div>
                   

                    <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                        <div class="address">
                            <h3>Contact Us</h3>

                            <ul class="loca">
                                <li>
                                    <a href="#"><img src="icon/loc.png" alt="#" /></a>Srilanka
                                    <br>Colombo </li>
                                <li>
                                    <a href="#"><img src="icon/email.png" alt="#" /></a>Jobseker@gmail.com </li>
                                <li>
                                    <a href="#"><img src="icon/call.png" alt="#" /></a>+9456216531 </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     
        <div class="copyright">
            <div class="container">
                <p>© 2019 All Rights Reserved. Design By<a href="https://html.design/"> </a></p>
           
        </div>
        </div>
    </footer>

    <!-- end footer -->
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.0.0.min.js"></script>
    <!-- sidebar -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- javascript -->
    <script src="js/owl.carousel.js"></script>
    <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    <script src="js/jobseeker.js"></script>

    <script>
        $(document).ready(function() {
            $(".fancybox").fancybox({
                openEffect: "none",
                closeEffect: "none"
            });

            $(".zoom").hover(function() {

                $(this).addClass('transition');
            }, function() {

                $(this).removeClass('transition');
            });
        });
    </script>
    <script>
        // This example adds a marker to indicate the position of Bondi Beach in Sydney,
        // Australia.
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 11,
                center: {
                    lat: 40.645037,
                    lng: -73.880224
                },
            });

            var image = 'images/maps-and-flags.png';
            var beachMarker = new google.maps.Marker({
                position: {
                    lat: 40.645037,
                    lng: -73.880224
                },
                map: map,
                icon: image
            });
        }
    </script>
    <!-- google map js -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8eaHt9Dh5H57Zh0xVTqxVdBFCvFMqFjQ&callback=initMap"></script>
    <!-- end google map js -->


</body>

</html>

