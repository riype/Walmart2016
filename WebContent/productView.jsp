<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Rank Order List</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/1-col-portfolio.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/clientUI">Home</a></li>
					<li><a href=" http://careers.walmart.com/about-us/">About</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="container-fluid text-center">
			<div class="row content">

				<div class="container">
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3">
							<div id="imaginary_container">
								<form method="post" action="process">
									<div class="input-group stylish-input-group">
										<input type="text" class="form-control" placeholder="Search"
											name="userSearch"> <span class="input-group-addon">
											<button type="submit">
												<span class="glyphicon glyphicon-search"></span>
											</button>
										</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Walmart's Recommendations</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Project One -->
		<div class="row">
			<c:forEach items="${listAllProduct}" var="listAllProduct" begin="0"
				end="9" varStatus="loop">
				<div class="col-md-3 portfolio-item">



					<img class="img-responsive" src="${listAllProduct.mediumImage}"
						alt="">

					<h5>
						<font color="blue">Name:</font> ${listAllProduct.name}
					</h5>
					<h5>
						<font color="blue">Item Id:</font> ${listAllProduct.itemId}
					</h5>
					<h5>
						<font color="blue">Average Overall Rating:</font>
						${listAllProduct.itemRating}
					</h5>

				</div>
			</c:forEach>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Pagination -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Rishal Iype 2016</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
