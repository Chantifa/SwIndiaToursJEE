<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="de">
	<head>
		<meta charset="UTF-8" />
	   	<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
		<script src="resources/js/jquery-3.6.0.min.js"></script>
		<script src="resources/js/onlineshop-web.js"></script>
		<link rel="stylesheet" href="resources/css/styles.css">
		<title>SwIndia Tours</title>
	</head>
	<body>

		<!--Navigation bar-->
		<div id="nav-placeholder"></div>
		
		
		<!-- Hauptteil der Seite -->
		<main>
		
		<h2>profile</h2><br>
		<div id="account-placeholder"></div>
		
		</main>
		
		<!-- Footer am schluss der Seite -->
		<div id="footer-placeholder"></div>
	</body>
	<script>
		$.post("customerAccountGet", function(data){
			$("#account-placeholder").replaceWith(data);
		});
	</script>
</html>
