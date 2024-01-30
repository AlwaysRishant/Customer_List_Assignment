package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Assignment_java.dao.getCustomerDetail;

public final class customer_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <style>\n");
      out.write("        .img1{\n");
      out.write("            width: 2em;\n");
      out.write("            height: 2.5em;\n");
      out.write("        }\n");
      out.write("        .img2{\n");
      out.write("            width: 1.2em;\n");
      out.write("            height: 1.5em;\n");
      out.write("        }\n");
      out.write("        a{\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <title>Customer List</title>\n");
      out.write("    <!--Enable Bootstrap-->\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1 style=\"text-align: center\">Customer List</h1>\n");
      out.write("<div class=\"btn-group\">\n");
      out.write("    <button type=\"button\" class=\"btn btn-primary\"aria-expanded=\"false\" onclick=\"addCustomer()\">\n");
      out.write("    Add Customer\n");
      out.write("    </button>\n");
      out.write("    &nbsp;&nbsp;\n");
      out.write("  <button type=\"button\" class=\"btn btn-primary dropdown-toggle btnsearch\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Search By</button>\n");
      out.write("  <ul class=\"dropdown-menu\">\n");
      out.write("      <li class=\"li1\"><a class=\"dropdown-item\" href=\"#\">First Name</a></li>\n");
      out.write("      <li class=\"li2\"><a class=\"dropdown-item\" href=\"#\">City</a></li>\n");
      out.write("      <li class=\"li3\"><a class=\"dropdown-item\" href=\"#\">Email</a></li>\n");
      out.write("      <li class=\"li4\"><a class=\"dropdown-item\" href=\"#\">Phone</a></li>\n");
      out.write("  </ul>&nbsp;&nbsp;\n");
      out.write("<script>\n");
      out.write("</script>\n");
      out.write("  <form id=\"myForm\" class=\"d-flex\" role=\"search\" action=\"getSelecteddata_Servlet\">\n");
      out.write("      <!--searching the customer by their name,city,email or phone-->\n");
      out.write("        <input type=\"hidden\" name=\"tagInnerValue\" id=\"tagInnerValue\"/>\n");
      out.write("        <input class=\"form-control me-2 searchbar\"name=\"searchbar\"type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("        <button class=\"btn btn-outline-success searchbarbutton\"name=\"searchbarbutton\"type=\"submit\" onclick=\"setValue()\">Search</button>\n");
      out.write("      </form>\n");
      out.write("</div><hr/>\n");
      out.write(" ");

            java.util.List<Assignment_java.pojo.Customer>customers=(java.util.List<Assignment_java.pojo.Customer>)request.getAttribute("list");
            if(customers!=null){
            out.println("<table class='table-bordered'>");
//            display the customers list according to the search basis
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Address</th><th>City</th><th>State</th><th>Email</th><th>Phone</th><th>Action</th></tr>");
            for (Assignment_java.pojo.Customer obj:customers) {
                    out.println("<form>");
                    out.println("<tr><td>"+obj.getFirstname()+"</td><td>"+obj.getLastname()+"</td><td>"+obj.getAddress()+"</td><td>"+obj.getCity()+"</td><td>"+obj.getState()+"</td><td>"+obj.getEmail()+"</td><td>"+obj.getPhone()+"</td><td><a onclick='deleteCustomer(\"" + obj.getFirstname() + "\")'><img class='img1'src='delete.jpg' alt='not found'/></a>&nbsp<a onclick='editCustomer(\"" + obj+ "\")'><img class='img2' src='icon.png' alt='not found'/></a></td></tr>");
                    out.println("</form>");
            }
            out.println("</table>");}
            else{
//                if(customers==null)
//                {
//                    customers=getCustomerDetail.getCustomerdetails();
//                    if(customers.size()==0)
//                    {
                        out.println("No Customer data Found");
//                    }
//                    else{
//                        out.println("<table class='table-bordered'>");
//                        out.println("<tr><th>First Name</th><th>Last Name</th><th>Address</th><th>City</th><th>State</th><th>Email</th><th>Phone</th><th>Action</th></tr>");
//                        for (Assignment_java.pojo.Customer obj:customers) {
//                                out.println("<tr><td>"+obj.getFirstname()+"</td><td>"+obj.getLastname()+"</td><td>"+obj.getAddress()+"</td><td>"+obj.getCity()+"</td><td>"+obj.getState()+"</td><td>"+obj.getEmail()+"</td><td>"+obj.getPhone()+"</td><td><a onclick='deleteCustomer(\"" + obj.getFirstname() + "\")'><img class='img1'src='Assignment_java.images/delete.jpg' alt='not found'/></a>&nbsp<a onclick='editCustomer(\"" + obj+ "\")'><img class='img2'src='Assignment_java.images/icon.png' alt='not found'/></a></td></tr>");
//                        }
//                        out.println("</table>");
//                    }
//                }
            }
        
      out.write("\n");
      out.write("<script>\n");
      out.write("  \n");
      out.write("function deleteCustomer(firstName) {\n");
      out.write("    var url = 'http://localhost:2022/Assignment_java/DeleteCustomer_Servlet';  // Replace with your servlet URL\n");
      out.write("    var data = encodeURIComponent(firstName);\n");
      out.write("    var mess=\"\";\n");
      out.write("    fetch(url, {\n");
      out.write("        method: 'POST',\n");
      out.write("        headers: {\n");
      out.write("            'Content-Type': 'application/x-www-form-urlencoded'\n");
      out.write("        },\n");
      out.write("        body: data\n");
      out.write("    })\n");
      out.write("    .then(response => response.json())  // Adjust based on your servlet's response format\n");
      out.write("    .then(data => {\n");
      out.write("        mess=data.message;\n");
      out.write("    })\n");
      out.write("    .catch(error => {\n");
      out.write("        console.error('Error:', error);\n");
      out.write("    });\n");
      out.write("    alert(\"data deleted sucessfully\");\n");
      out.write("    window.location.href = '/Assignment_java/login.jsp';\n");
      out.write("}\n");
      out.write("function editCustomer(obj) {\n");
      out.write("    window.location.href = '/Assignment_java/add_customer.jsp';\n");
      out.write("}\n");
      out.write("    document.getElementById(\"myForm\").addEventListener(\"submit\", function() {\n");
      out.write("        // Add additional data before submitting\n");
      out.write("        var hiddenInput = document.createElement(\"input\");\n");
      out.write("        hiddenInput.setAttribute(\"type\", \"hidden\");\n");
      out.write("        hiddenInput.setAttribute(\"name\", \"data\");\n");
      out.write("        hiddenInput.setAttribute(\"value\", btn.textContent);\n");
      out.write("        document.getElementById(\"myForm\").appendChild(hiddenInput);\n");
      out.write("    });\n");
      out.write("    let btn=document.querySelector(\".btnsearch\");\n");
      out.write("    var li1 = document.querySelector(\".li1\");\n");
      out.write("    var li2 = document.querySelector(\".li2\");\n");
      out.write("    var li3 = document.querySelector(\".li3\");\n");
      out.write("    var li4 = document.querySelector(\".li4\");\n");
      out.write("    if(btn.textContent==\"Search By\")\n");
      out.write("    {\n");
      out.write("        var searchBar = document.querySelector(\".searchbar\");\n");
      out.write("        var searchButton = document.querySelector(\".searchbarbutton\");\n");
      out.write("        searchBar.style.display =\"none\";\n");
      out.write("        searchButton.style.display = \"none\";\n");
      out.write("    }\n");
      out.write("    function setSearchBar()\n");
      out.write("    {\n");
      out.write("        if(btn.textContent!=\"Search By\")\n");
      out.write("        {\n");
      out.write("            searchBar.style.display =\"\";\n");
      out.write("             searchButton.style.display = \"\";\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    li1.addEventListener(\"click\", function() {\n");
      out.write("        var anchor1 = li1.querySelector(\"a\");\n");
      out.write("        btn.innerHTML=anchor1.textContent;\n");
      out.write("        setSearchBar();\n");
      out.write("    });\n");
      out.write("    li2.addEventListener(\"click\", function() {\n");
      out.write("        var anchor2 = li2.querySelector(\"a\");\n");
      out.write("        btn.innerHTML=anchor2.textContent;\n");
      out.write("                setSearchBar();\n");
      out.write("\n");
      out.write("    });\n");
      out.write("    li3.addEventListener(\"click\", function() {\n");
      out.write("        var anchor3 = li3.querySelector(\"a\");\n");
      out.write("        btn.innerHTML=anchor3.textContent;\n");
      out.write("        setSearchBar();\n");
      out.write("    });\n");
      out.write("    li4.addEventListener(\"click\", function() {\n");
      out.write("        var anchor4 = li4.querySelector(\"a\");\n");
      out.write("        btn.innerHTML=anchor4.textContent;\n");
      out.write("        setSearchBar();\n");
      out.write("    });\n");
      out.write("    function addCustomer()\n");
      out.write("    {\n");
      out.write("        window.location.href = \"add_customer.jsp\";\n");
      out.write("    }\n");
      out.write("</script>\n");
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
