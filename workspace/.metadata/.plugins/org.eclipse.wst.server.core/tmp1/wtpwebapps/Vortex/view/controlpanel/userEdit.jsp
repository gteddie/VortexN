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
    <!-- Datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.css" />
    <link href="/Vortex/assets/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/Vortex/assets/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/Vortex/assets/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/Vortex/assets/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/Vortex/assets/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">	
    <!-- Custom Theme Style -->
    <link href="/Vortex/assets/build/css/custom.min.css" rel="stylesheet">
    <style>
        .btn.btn-default.button.secondary,#addRowBtn,#editRowBtn,#deleteRowBtn {
			padding: 6px 12px;
    		border-radius: 3px;
		    border-top-left-radius: 3px;
		    border-top-right-radius: 3px;
		    border-bottom-right-radius: 3px;
		    border-bottom-left-radius: 3px;        
        }
    	#addRowBtn,#editRowBtn {
    		background-color: #337ab7;
    	}
    	#deleteRowBtn {
            background-color: #d9534f;
    	}
    	input:invalid {border-color :red}
    </style>
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
                      <li><a href="userTable.jsp">Table Views</a></li>
                      <li><a href="index2.html">Edit Tables</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-gamepad"></i> Game <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.html">Table Views</a></li>
                      <li><a href="index2.html">Edit Tables</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-cart-shopping"></i> Purchase <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.html">Table Views</a></li>
                      <li><a href="index2.html">Edit Tables</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="menu_section">
                <h3>Data Visualization</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-chart-column"></i> Charts <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="e_commerce.html">User Charts</a></li>
                      <li><a href="projects.html">Game Charts</a></li>
                      <li><a href="project_detail.html">Purchase Charts</a></li>
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
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Edit Table</h3>
              </div>
            </div>		
          </div>
        <div class="clearfix"></div>
        <div class="row"> 
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Users</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <!-- <p class="text-muted font-13 m-b-30">users of vortex</p> -->
    			 <table cellpadding="0" cellspacing="0" border="0" class="dataTable table table-striped" id="example"></table>
                  </div>
                </div>
              </div>
              </div>        
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
    <!-- iCheck -->
    <script src="/Vortex/assets/vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.js" ></script>
    <script src="/Vortex/assets/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.js" ></script>
    <script src="/Vortex/assets/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="/Vortex/assets/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="/Vortex/assets/vendors/jszip/dist/jszip.min.js"></script>
    <script src="/Vortex/assets/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="/Vortex/assets/vendors/pdfmake/build/vfs_fonts.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="/Vortex/assets/build/js/dataTables.altEditor.free.js" ></script>
	<script src="/Vortex/assets/build/js/example10.js" ></script>
    <script src="/Vortex/assets/build/js/custom.min.js"></script>
	<script type="text/javascript">

	</script>
  </body>
</html>
