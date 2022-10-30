<%--
  Created by IntelliJ IDEA.
  User: chant
  Date: 10/09/2022
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>SwIndia Tours – Taxi Services and Tour Bookings</title>
</head>
<body>
<div id="topbar">  <img src="img/logo.png" class="img_logo" alt="SwIndiaTours" width="300" /></div>
<header>

  <a href="index.jsp" class="logo">Taxi Services & <br> Tour Bookings</a>

  <nav id="topnav">
    <ul>
      <li><a href="airportpickup_drop.jsp">Airport pickup & drop</a></li>
      <li><a href="orders.jsp">Rajasthan</a></li>
      <li><a href="javascript:void(0);" class="icon" onclick="menuOnAndOff()">
        <i class="fa fa-bars"></i>
      </a></li>
    </ul>
  </nav>
</header>
<main>
  <div class="panel">
    <?html if(!empty($errors)):?>
    <div class="error">
      <ul><li><?html echo implode('</li> <li>', $errors)?></li></ul>
    </div>
    <?html endif; ?>
  </div>
  <ul class="container">
    <ol>
      <img src="img/airportpickup_drop.png" width="300px" alt="Airport pickup"/>
    </ol>
    <ol>
      <h2>Airport pickup & drop</h2>
      <small>if you have any package tour booked with us, Airport pick up and drop is free</small>
      <form action="formcontact.html" method="post">
        <fieldset id="contact">
          <label style="font-size: 1.5em">Please enter your contact information</label>
          <fieldset>
            <%--@declare id="name"--%><label for="name" tabindex="1">Your Name *</label>
            <input type="text" name="name" autocomplete="off" tabindex="1" placeholder="Enter Name" >
          </fieldset>
          <fieldset>
            <%--@declare id="email"--%><label for="email" tabindex="2">Your Email address * </label>
            <label>
              <input type="email" name="email" autocomplete="off" tabindex="2" placeholder="Enter Email">
            </label>
          </fieldset>
          <fieldset>
            <%--@declare id="tel"--%><label for="tel" tabindex="3">Your Mobile No. * </label>
            <label>
              <input type="tel" name="tel" autocomplete="off" tabindex="3"  placeholder="Enter Mobile No.">
            </label>
          </fieldset>
          <fieldset>
            <label for="options" tabindex="4">please submit your demand to get a proper offer</label>
            <div>
              <select name="options[]" id="options" multiple>
                <option value="pickup">pick up</option>
                <option value="drop">drop</option>
              </select>
              <p class="price">from 1000 RS.</p>
            </div>
          </fieldset>
          <fieldset>
            <%--@declare id="message"--%><label for="message" >Your Message *</label>
            <label for="comment"></label><textarea tabindex="5" rows="8" id="comment" name="message"></textarea>
            <button name="submit" type="submit" id="contact-submit"  class="btn btn-primary">Submit</button>
          </fieldset>
        </fieldset>
      </form>
    </ol>
  </ul>
</main>
<footer>
  <div id="opening-hours">
    <h3>Booking</h3>
    <p>24/24</p>
    <p>365/365</p>
    <p>we respond to your booking in 24 hours</p>
  </div>
  <div>
    <lo>
      <li><a href="about.html">About SwIndia Tours</a></li>
      <li><a href="feedback.html">Give us feedback & check customers feedback</a></li>
      <li><a href="contact.html">Contact us</a></li>
    </lo>
  </div>
  <div id="quote">
    <blockquote>
      An experience I will never forget, so lovely people and let you feel that you are a part of the country. I got the real taste of India.
      Definitely I will come back again. SwIndia Tours took care about everything, thank you so much.
    </blockquote>
    <cite>– Hanna (Sweden)</cite>
  </div>

  <div id="address">
    <h3>Address:</h3>
    <p>SwIndia Tours</p>
    <p>9818 Street No 8, Multani Dhanda, Pahar Ganj</p>
    <p>New Delhi, 110055, India</p>
    <p><a href="mailto:info@swindiatours.com">info@swindiatours.com</a></p>
    <p>+91 98 99293313</p>
  </div>
  <div>
    Copyright Ⓒ 2019 SwIndia Tours. All Right Reserved
  </div>
</footer>
<script src="js/bookings.js"></script>
<script src="js/ajax.js"></script>
</body>
</html>
