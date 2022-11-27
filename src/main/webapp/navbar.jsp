<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light"
     style="width:100%; background-image: linear-gradient(135deg,  #FF7417, #ffffff,#008000);">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">SwIndia Tours</a>
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navBarDropdown"
                aria-controls="navBarDropdown"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navBarDropdown">
            <div id ="navbar-items"></div>
        </div>
        <form class="d-flex" action="search.jsp">
            <input class="form-control me-2" type="search" placeholder="Suche..." aria-label="Suche" name="query">
        </form>
    </div>
</nav>
