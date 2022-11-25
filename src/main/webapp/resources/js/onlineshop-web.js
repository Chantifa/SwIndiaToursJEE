$.get("navbar.jsp", function (data) {
    $("#nav-placeholder").replaceWith(data);
    $.post("Navbar", function (data){
        $("#navbar-items").replaceWith(data);
    });
});

$.get("footer.jsp", function (data) {
    $("#footer-placeholder").replaceWith(data);
});