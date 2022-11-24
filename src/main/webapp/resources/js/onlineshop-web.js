$.get("navbar.html", function (data) {
    $("#nav-placeholder").replaceWith(data);
    $.post("Navbar", function (data){
        $("#navbar-items").replaceWith(data);
    });
});

$.get("footer.html", function (data) {
    $("#footer-placeholder").replaceWith(data);
});