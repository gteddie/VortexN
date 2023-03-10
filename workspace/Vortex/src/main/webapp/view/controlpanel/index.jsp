<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Vortex Backend</title>

    <!-- Bootstrap -->
    <link href="/Vortex/assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/Vortex/assets/vendors/fontawesome/css/all.min.css" rel="stylesheet">

    <!-- NProgress -->
    <link href="/Vortex/assets/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/Vortex/assets/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="/Vortex/assets/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="/Vortex/assets/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="/Vortex/assets/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/Vortex/assets/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.jsp" class="site_title"><i class="fa fa-tornado"></i> <span>Vortex</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_info">
                <span>Welcome,</span>
                <h2 style="display: inline;">${sessionScope.name}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Database Management</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-user"></i> User <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/Vortex/view/controlpanel/userTables.jsp">Table Views</a></li>
                      <li><a href="/Vortex/view/controlpanel/userEdit.jsp">Edit Tables</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-gamepad"></i> Game <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/Vortex/view/controlpanel/gameTables.jsp">Table Views</a></li>
                      <li><a href="/Vortex/view/controlpanel/gameEdit.jsp">Edit Tables</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-cart-shopping"></i> Purchase <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/Vortex/view/controlpanel/purchaseTables.jsp">Table Views</a></li>
                      <li><a href="/Vortex/view/controlpanel/purchaseEdit.jsp">Edit Tables</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="menu_section">
                <h3>Data Visualization</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-chart-column"></i> Charts <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/Vortex/view/controlpanel/userCharts.jsp">User Charts</a></li>
                      <li><a href="/Vortex/view/controlpanel/gameCharts.jsp">Game Charts</a></li>
                      <li><a href="/Vortex/view/controlpanel/purchaseCharts.jsp">Purchase Charts</a></li>
                    </ul>
                  </li>
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="/Vortex/AdminLogout" style="width: 100%">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="/Vortex/assets/build/images/user.jpg" alt="">
                    ${sessionScope.name}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right" style="width:auto">
                    <li><a href="/Vortex/AdminLogout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>


              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">

        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="/Vortex/assets/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/Vortex/assets/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/Vortex/assets/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/Vortex/assets/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="/Vortex/assets/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="/Vortex/assets/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="/Vortex/assets/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="/Vortex/assets/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="/Vortex/assets/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="/Vortex/assets/vendors/Flot/jquery.flot.js"></script>
    <script src="/Vortex/assets/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="/Vortex/assets/vendors/Flot/jquery.flot.time.js"></script>
    <script src="/Vortex/assets/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="/Vortex/assets/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="/Vortex/assets/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="/Vortex/assets/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="/Vortex/assets/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="/Vortex/assets/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="/Vortex/assets/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="/Vortex/assets/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="/Vortex/assets/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="/Vortex/assets/vendors/moment/min/moment.min.js"></script>
    <script src="/Vortex/assets/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="/Vortex/assets/build/js/custom.min.js"></script>
	
  </body>
</html>
