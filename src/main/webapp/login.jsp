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

<!-- Main part-->
<main>
    <section class="vh-100" style="background-color: #eee;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                    <p class="text-center h1 fw-bold mb-4 mx-1 mx-md-4 mt-4">login</p>

                                    <form class="mx-1 mx-md-4" action="login" method="post">

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="email"
                                                       id="email"
                                                       name="email"
                                                       placeholder="enter your email"
                                                       class="form-control" required/>
                                                <label
                                                        class="form-label"
                                                        for="email">email</label>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password"
                                                       id="password"
                                                       name="password"
                                                       placeholder="password login"
                                                       class="form-control"
                                                       title="6-20 simbols"
                                                       pattern=".{6,20}" required/>
                                                <label
                                                        class="form-label"
                                                        for="password">password</label>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                            <button type="submit" class="btn btn-primary m-2">submit</button>
                                            <button type="reset" class="btn btn-warning m-2">reset</button>
                                            <a class="btn btn-success m-2" href="register.jsp">register</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<div id="footer-placeholder"></div>
</body>
</html>
