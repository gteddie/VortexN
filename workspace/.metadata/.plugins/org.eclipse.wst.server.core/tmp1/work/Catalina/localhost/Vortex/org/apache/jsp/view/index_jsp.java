/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2022-12-26 09:50:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <!-- Meta, title, CSS, favicons, etc. -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    <title>Vortex Backend</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/fontawesome/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- NProgress -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/nprogress/nprogress.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- iCheck -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/iCheck/skins/flat/green.css\" rel=\"stylesheet\">\r\n");
      out.write("	\r\n");
      out.write("    <!-- bootstrap-progressbar -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- JQVMap -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/jqvmap/dist/jqvmap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <!-- bootstrap-daterangepicker -->\r\n");
      out.write("    <link href=\"/Vortex/assets/vendors/bootstrap-daterangepicker/daterangepicker.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Theme Style -->\r\n");
      out.write("    <link href=\"/Vortex/assets/build/css/custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body class=\"nav-md\">\r\n");
      out.write("    <div class=\"container body\">\r\n");
      out.write("      <div class=\"main_container\">\r\n");
      out.write("        <div class=\"col-md-3 left_col\">\r\n");
      out.write("          <div class=\"left_col scroll-view\">\r\n");
      out.write("            <div class=\"navbar nav_title\" style=\"border: 0;\">\r\n");
      out.write("              <a href=\"index.jsp\" class=\"site_title\"><i class=\"fa fa-tornado\"></i> <span>Vortex</span></a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("\r\n");
      out.write("            <!-- menu profile quick info -->\r\n");
      out.write("            <div class=\"profile clearfix\">\r\n");
      out.write("              <div class=\"profile_info\">\r\n");
      out.write("                <span>Welcome,</span>\r\n");
      out.write("                <h2 style=\"display: inline;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /menu profile quick info -->\r\n");
      out.write("\r\n");
      out.write("            <br />\r\n");
      out.write("\r\n");
      out.write("            <!-- sidebar menu -->\r\n");
      out.write("            <div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\">\r\n");
      out.write("              <div class=\"menu_section\">\r\n");
      out.write("                <h3>Database Management</h3>\r\n");
      out.write("                <ul class=\"nav side-menu\">\r\n");
      out.write("                  <li><a><i class=\"fa fa-user\"></i> User <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                    <ul class=\"nav child_menu\">\r\n");
      out.write("                      <li><a href=\"userTable.jsp\">Table Views</a></li>\r\n");
      out.write("                      <li><a href=\"index2.html\">Edit Tables</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li><a><i class=\"fa fa-gamepad\"></i> Game <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                    <ul class=\"nav child_menu\">\r\n");
      out.write("                      <li><a href=\"index.html\">Table Views</a></li>\r\n");
      out.write("                      <li><a href=\"index2.html\">Edit Tables</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li><a><i class=\"fa fa-cart-shopping\"></i> Purchase <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                    <ul class=\"nav child_menu\">\r\n");
      out.write("                      <li><a href=\"index.html\">Table Views</a></li>\r\n");
      out.write("                      <li><a href=\"index2.html\">Edit Tables</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"menu_section\">\r\n");
      out.write("                <h3>Data Visualization</h3>\r\n");
      out.write("                <ul class=\"nav side-menu\">\r\n");
      out.write("                  <li><a><i class=\"fa fa-chart-column\"></i> Charts <span class=\"fa fa-chevron-down\"></span></a>\r\n");
      out.write("                    <ul class=\"nav child_menu\">\r\n");
      out.write("                      <li><a href=\"e_commerce.html\">User Charts</a></li>\r\n");
      out.write("                      <li><a href=\"projects.html\">Game Charts</a></li>\r\n");
      out.write("                      <li><a href=\"project_detail.html\">Purchase Charts</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /sidebar menu -->\r\n");
      out.write("\r\n");
      out.write("            <!-- /menu footer buttons -->\r\n");
      out.write("            <div class=\"sidebar-footer hidden-small\">\r\n");
      out.write("              <a data-toggle=\"tooltip\" data-placement=\"top\" title=\"Logout\" href=\"/Vortex/AdminLogout\" style=\"width: 100%\">\r\n");
      out.write("                <span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span>\r\n");
      out.write("              </a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /menu footer buttons -->\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- top navigation -->\r\n");
      out.write("        <div class=\"top_nav\">\r\n");
      out.write("          <div class=\"nav_menu\">\r\n");
      out.write("            <nav>\r\n");
      out.write("              <div class=\"nav toggle\">\r\n");
      out.write("                <a id=\"menu_toggle\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("              <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                <li class=\"\">\r\n");
      out.write("                  <a href=\"javascript:;\" class=\"user-profile dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("                    <img src=\"/Vortex/assets/build/images/user.jpg\" alt=\"\">\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                    <span class=\" fa fa-angle-down\"></span>\r\n");
      out.write("                  </a>\r\n");
      out.write("                  <ul class=\"dropdown-menu dropdown-usermenu pull-right\" style=\"width:auto\">\r\n");
      out.write("                    <li><a href=\"/Vortex/AdminLogout\"><i class=\"fa fa-sign-out pull-right\"></i> Log Out</a></li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("              </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /top navigation -->\r\n");
      out.write("\r\n");
      out.write("        <!-- page content -->\r\n");
      out.write("        <div class=\"right_col\" role=\"main\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /page content -->\r\n");
      out.write("\r\n");
      out.write("        <!-- footer content -->\r\n");
      out.write("        <footer>\r\n");
      out.write("          <div class=\"pull-right\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"clearfix\"></div>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <!-- /footer content -->\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/jquery/dist/jquery.min.js\"></script>\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/bootstrap/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- FastClick -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/fastclick/lib/fastclick.js\"></script>\r\n");
      out.write("    <!-- NProgress -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/nprogress/nprogress.js\"></script>\r\n");
      out.write("    <!-- Chart.js -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/Chart.js/dist/Chart.min.js\"></script>\r\n");
      out.write("    <!-- gauge.js -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/gauge.js/dist/gauge.min.js\"></script>\r\n");
      out.write("    <!-- bootstrap-progressbar -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js\"></script>\r\n");
      out.write("    <!-- iCheck -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/iCheck/icheck.min.js\"></script>\r\n");
      out.write("    <!-- Skycons -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/skycons/skycons.js\"></script>\r\n");
      out.write("    <!-- Flot -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/Flot/jquery.flot.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/Flot/jquery.flot.pie.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/Flot/jquery.flot.time.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/Flot/jquery.flot.stack.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/Flot/jquery.flot.resize.js\"></script>\r\n");
      out.write("    <!-- Flot plugins -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/flot.orderbars/js/jquery.flot.orderBars.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/flot-spline/js/jquery.flot.spline.min.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/flot.curvedlines/curvedLines.js\"></script>\r\n");
      out.write("    <!-- DateJS -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/DateJS/build/date.js\"></script>\r\n");
      out.write("    <!-- JQVMap -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/jqvmap/dist/jquery.vmap.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/jqvmap/dist/maps/jquery.vmap.world.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js\"></script>\r\n");
      out.write("    <!-- bootstrap-daterangepicker -->\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/moment/min/moment.min.js\"></script>\r\n");
      out.write("    <script src=\"/Vortex/assets/vendors/bootstrap-daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Theme Scripts -->\r\n");
      out.write("    <script src=\"/Vortex/assets/build/js/custom.min.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
