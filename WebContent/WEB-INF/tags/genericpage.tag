<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/img/favicon.png">

<title>Foodscanner</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet">

<!-- Fonts from Google Fonts -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,900'
	rel='stylesheet' type='text/css'>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->    
</head>

<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><b>FOODSCANNER</b></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="doc/">Documentation</a></li>
					<li><a href="impressum.html">Impressum</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div id="headerwrap">
		<div class="container">
						 <h1><jsp:invoke fragment="header"/></h1>					
		</div>
		<!-- /container -->
	</div>
	<!-- /headerwrap -->
	
	<div class="container">		     
			<div class="row mt centered">
			     <div class="col-lg-6 col-lg-offset-3">
							 <jsp:doBody/>
				 </div>
			</div>
	</div>
	
	<div class="container">
		<hr>
		<div class="row centered">
			<div class="col-lg-6 col-lg-offset-3">
				<form class="form-inline" role="form" name="form" method="get" action="${pageContext.request.contextPath}/product.jsp">
						<div class="form-group">
							<input type="text" class="form-control" name="ean" id="ean" 
								placeholder="Geben sie hier eine EAN ein...">
						</div>
						<button type="submit" class="btn btn-warning btn-lg">Jetzt
							suchen</button>
					</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
		<!-- /row -->
		<hr>
		<p class="centered">ANMAI Server - Copyright 2014</p>
	</div>
	<!-- /container -->
	
	

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>
