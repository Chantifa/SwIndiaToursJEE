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
		
		<h1>basket</h1>
		<div id="basket-placeholder"></div>
		
		</main>
		
		<!-- Footer at the end of the site -->
		<div id="footer-placeholder"></div>
	</body>
	<script>
		$.post("basketGet", function(data){
			$("#basket-placeholder").replaceWith(data);
		});
	</script>
</html>
