<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
			<div id="search-placeholder"></div>

		</main>
		
		<!-- Footer am schluss der Seite -->
		<div id="footer-placeholder"></div>
	</body>
	<script>
		const params = new URLSearchParams(window.location.search);
		const query = params.get("query");
		$.get("TourSearch?query=" + query, function(data){
			$("#search-placeholder").replaceWith(data);
		});
	</script>
</html>
