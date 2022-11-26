<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
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
<main><h1><%= "Welcome to Swindia Tours" %></h1>
    <div id="tour-placeholder"></div>
</main>
<nav><a href="register">please register</a></nav>
<div id="status"> </div>
<!-- Footer am schluss der Seite -->
<div id="footer-placeholder"></div>
</body>
<script>
    $.get("ToursGet", function(data){
        $("#tour-placeholder").replaceWith(data);
    });

    function order(tourId){
        fetch('TourBooking', {
            method: 'POST',
            body: new URLSearchParams({
                'tourId': tourId,
            })
        });
        document.getElementById("status").innerText = "book!";
        setTimeout(function (){document.getElementById("status").innerText =" ";}, 500);
    }
</script>
</html>