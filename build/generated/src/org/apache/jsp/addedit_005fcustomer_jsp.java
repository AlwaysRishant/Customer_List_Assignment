package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addedit_005fcustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Add Customer</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>Customer Details</h1>\n");
      out.write("<!--Give a call to a servlet to add or edit customer in a database according to users action-->\n");
      out.write("<form action=\"add_edit_customer_servlet\" method=\"post\">\n");
      out.write("  <label for=\"firstname\">First Name:</label>\n");
      out.write("  <input type=\"text\" id=\"firstname\" name=\"firstname\" placeholder=\"firstname\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"lastname\">Last Name:</label>\n");
      out.write("  <input type=\"text\" id=\"lastname\" name=\"lastname\" placeholder=\"lastname\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"address\">Address:</label>\n");
      out.write("  <input type=\"text\" id=\"address\" name=\"address\"placeholder=\"address\" required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"street\">Street:</label>\n");
      out.write("  <input type=\"text\" id=\"street\" name=\"street\" placeholder=\"street\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"city\">City:</label>\n");
      out.write("  <input type=\"text\" id=\"city\" name=\"city\" placeholder=\"city\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"state\">State:</label>\n");
      out.write("  <input type=\"text\" id=\"state\" name=\"state\" placeholder=\"state\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"email\">Email:</label>\n");
      out.write("  <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"email id\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <label for=\"phone\">Phone:</label>\n");
      out.write("  <input type=\"text\" id=\"phone\" name=\"phone\" placeholder=\"phone number\"required>\n");
      out.write("  <br><br>\n");
      out.write("  <input type=\"submit\" value=\"Submit\">\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
