<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Hotel</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!-- Google fonts - Popppins for copy-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
        <!-- orion icons-->
        <link rel="stylesheet" href="css/orionicons.css">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.png?3">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body onload="load()">
        <!-- navbar-->
        <header class="header">
            <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead"><i class="fas fa-align-left"></i></a><a href="customer.jsp" class="navbar-brand font-weight-bold text-uppercase text-base">Hotel Management System</a>
                <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
                    <li class="nav-item">
                        <form id="searchForm" class="ml-auto d-none d-lg-block">
                            <div class="form-group position-relative mb-0">
                                <button type="submit" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0"><i class="o-search-magnify-1 text-gray text-lg"></i></button>
                                <input type="search" placeholder="Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
                            </div>
                        </form>
                    </li>
                    <li class="nav-item dropdown ml-auto"><a id="userInfo" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle"><img src="img/avatar-6.jpg" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></a>
                        <div aria-labelledby="userInfo" class="dropdown-menu"><a href="#" class="dropdown-item"><strong class="d-block text-uppercase headings-font-family">${userfullname}</strong><small>${usertype}</small></a>
                            <div class="dropdown-divider"></div><a href="logout.jsp" class="dropdown-item">Logout</a>
                        </div>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="d-flex align-items-stretch">
            <div id="sidebar" class="sidebar py-3">
                <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">MAIN</div>
                <ul class="sidebar-menu list-unstyled">
                    <li class="sidebar-list-item"><a href="customer.jsp" class="sidebar-link text-muted"><i class="o-user-details-1 mr-3 text-gray"></i><span>Customer</span></a></li>
                    <li class="sidebar-list-item"><a href="event.jsp" class="sidebar-link text-muted"><i class="o-survey-1 mr-3 text-gray"></i><span>Event</span></a></li>
                    <li class="sidebar-list-item"><a href="stock.jsp" class="sidebar-link text-muted"><i class="o-database-1 mr-3 text-gray"></i><span>Stock</span></a></li>
                    <li class="sidebar-list-item"><a href="grn.jsp" class="sidebar-link text-muted"><i class="o-document-1 mr-3 text-gray"></i><span>GRN</span></a></li>
                    <li class="sidebar-list-item"><a href="supplier.jsp" class="sidebar-link text-muted"><i class="o-user-details-1 mr-3 text-gray"></i><span>Supplier</span></a></li>
                    <li class="sidebar-list-item"><a href="tours.jsp" class="sidebar-link text-muted active"><i class="o-earth-globe-1 mr-3 text-gray"></i><span>Tours</span></a></li>
                    <li class="sidebar-list-item"><a href="tour_booking.jsp" class="sidebar-link text-muted"><i class="o-table-content-1 mr-3 text-gray"></i><span>Tour Booking</span></a></li>
                    <li class="sidebar-list-item"><a href="employee.jsp" class="sidebar-link text-muted"><i class="o-user-details-1 mr-3 text-gray"></i><span>Employee</span></a></li>
                    <li class="sidebar-list-item"><a href="invoice.jsp" class="sidebar-link text-muted"><i class="o-letter-1 mr-3 text-gray"></i><span>Invoice</span></a></li>
                    <li class="sidebar-list-item"><a href="housekeeping.jsp" class="sidebar-link text-muted"><i class="o-clock-1 mr-3 text-gray"></i><span>HouseKeeping</span></a></li>
                    <li class="sidebar-list-item"><a href="room.jsp" class="sidebar-link text-muted"><i class="o-home-1 mr-3 text-gray"></i><span>Room</span></a></li>
                    <li class="sidebar-list-item"><a href="reservation.jsp" class="sidebar-link text-muted"><i class="o-table-content-1 mr-3 text-gray"></i><span>Reservation</span></a></li>
                </ul>
                <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">Admin Area</div>
                <ul class="sidebar-menu list-unstyled">
                    <li class="sidebar-list-item"><a href="user.jsp" class="sidebar-link text-muted"><i class="o-user-1 mr-3 text-gray"></i><span>User Management</span></a></li>
                    <li class="sidebar-list-item"><a href="logout.jsp" class="sidebar-link text-muted"><i class="o-exit-1 mr-3 text-gray"></i><span>Logout</span></a></li>
                </ul>
            </div>
            <div class="page-holder w-100 d-flex flex-wrap">
                <div class="container-fluid px-xl-5">

                    <section class="forms">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">Tours</h3>
                                        </div>
                                        <div class="card-body">
                                            <form class="form-horizontal">
                                                <div class="form-group row">
                                                    <div class="col-sm-9">
                                                        <input id="tours" type="hidden"	value="0" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Category</label>
                                                    <div class="col-sm-9">
                                                        <input id="category" type="text"	placeholder="category" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Name</label>
                                                    <div class="col-sm-9">
                                                        <input id="name" type="text"	placeholder="name" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Start Location</label>
                                                    <div class="col-sm-9">
                                                        <input id="start_location" type="text"	placeholder="start location" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">End Location</label>
                                                    <div class="col-sm-9">
                                                        <input id="end_location" type="text"	placeholder="end location" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Price</label>
                                                    <div class="col-sm-9">
                                                        <input id="price" type="text"	placeholder="price" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Special</label>
                                                    <div class="col-sm-9">
                                                        <input id="special" type="text"	placeholder="special" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Description</label>
                                                    <div class="col-sm-9">
                                                        <input id="description" type="text"	placeholder="description" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Status</label>
                                                    <div class="col-sm-9">
                                                        <input id="status" type="text"	placeholder="status" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9">
                                                        <input id="date_time" type="hidden"	value="date time" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9 offset-sm-3">
                                                        <input onclick="save()" type="button" value="Save" class="btn btn-primary">
                                                        <input onclick="update()" type="button" value="Update" class="btn btn-primary">
                                                        <input onclick="delet()" type="button" value="Delete" class="btn btn-primary">
                                                        <input type="reset" value="Reset" class="btn btn-primary">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">History</h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-hover" id="table">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>tours</th>
                                                            <th>category</th>
                                                            <th>name</th>
                                                            <th>start location</th>
                                                            <th>end location</th>
                                                            <th>price</th>
                                                            <th>special</th>
                                                            <th>description</th>
                                                            <th>status</th>
                                                            <th>date time</th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>


                </div>
                <footer class="footer bg-white shadow align-self-end py-3 px-xl-5 w-100">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6 text-center text-md-left text-primary">
                                <p class="mb-2 mb-md-0">SLIIT &copy; 2018-2020</p>
                            </div>
                            <div class="col-md-6 text-center text-md-right text-gray-400">
                                <p class="mb-0">Design by <a href="#" class="external text-gray-400">SLIIT</a></p>
                                <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <!-- JavaScript files-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
        <script src="js/front.js"></script>
        <script src="ajax/jquery.3.2.1.min.js" type="text/javascript"></script>
        <script src="ajax/ajax.js" type="text/javascript"></script>
        <script src="ajax/ToursJS.js" type="text/javascript"></script>

    </body>
</html>