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

<!-- main part of the website -->
<main>
    <div id="tour-placeholder"></div>
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Create tour</h3>
                            <div action="tour" method="get"></div>
                            <form name="tourForm" action="tour" method="post" autocomplete="on" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="mb-4 pb-2 pb-md-0 ">
                                        <div class="form-outline">
                                            <input type="text" id="title" class="form-control form-control-lg" name="title" required/>
                                            <label class="form-label" for="title">title</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="mb-4 pb-2 pb-md-0 ">
                                        <div class="form-outline">
                                            <input type="text" id="description" class="form-control form-control-lg" name="description" required/>
                                            <label class="form-label" for="description">description</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="mb-4 pb-2 pb-md-0 ">
                                        <div class="form-outline">
                                            <input type="number" id="price" class="form-control form-control-lg" name="price" min="0" required/>
                                            <label class="form-label" for="price">price</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="mb-4 pb-2 pb-md-0 ">
                                        <div class="form-outline">
                                            <%--@declare id="img"--%><label class="col-md-4 control-label" for="img">image</label>
                                            <div class="col-md-4">
                                                <input id="img" name="img" class="input-file" type="file">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                    <button type="submit" class="btn btn-primary btn-lg">register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- Footer am schluss der Seite -->
<div id="footer-placeholder"></div>
</body>
<script>
    $.post("tour", function(data){
        $("#tour-placeholder").replaceWith(data);
    });
</script>
</html>
