<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css_style/index_style.css">
<title>NoteTaker</title>
<link rel="icon"
	href="data:image/png;base64,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"
	type="image/x-icon">
</head>
<body>
	<div class="banner">
		<!-- navbar -->
		<nav class="navbar-default"
			style="color: black; background-color: #20dbc2; height: 10%;">
			<div class="container" style="width: 100%">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#menu">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<h3>
						<i class="fa-solid fa-box-archive"></i><u>NoteTaker</u>
					</h3>
				</div>
				<div class="collapse navbar-collapse" id="menu" style>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Login.jsp"
							style="font-size: 15px; color: black;"><i
								class="fa-solid fa-right-to-bracket" style="margin-right: 5px;">
							</i>SIGN-IN</a></li>
						<li><a href="Login.jsp" style="font-size: 15px; color: black"><i
								class="fa-solid fa-book-open"> </i> My Notes</a></li>
						<li><a href="About_Us.jsp"
							style="font-size: 15px; color: black;"><i
								class="fa-solid fa-address-card"> </i> Contact</a></li>
						<li><a href="Help.jsp" style="font-size: 15px; color: black;"><i
								class="fa-solid fa-circle-info"> </i> Help</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- home page -->
		<div class="content">
			<h1>Welcome in NoteTaker</h1>

			<p>
				Unlock productivity with our user-friendly platform for seamlessly
				capturing, storing, and accessing daily notes and goals. <br>Simplify
				your routine and stay on top of tasks effortlessly."
			</p>

			<div>
				<a href="About_Us.jsp">
					<button type="button">
						<span></span>Watch More
					</button>
				</a> <a href="register.jsp">
					<button type="button">
						<span></span> Sign Up
					</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>