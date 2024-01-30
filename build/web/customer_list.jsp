<%@page import="Assignment_java.dao.getCustomerDetail"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        .img1{
            width: 2em;
            height: 2.5em;
        }
        .img2{
            width: 1.2em;
            height: 1.5em;
        }
        a{
            cursor: pointer;
        }
    </style>
    <title>Customer List</title>
    <!--Enable Bootstrap-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h1 style="text-align: center">Customer List</h1>
<div class="btn-group">
    <button type="button" class="btn btn-primary"aria-expanded="false" onclick="addCustomer()">
    Add Customer
    </button>
    &nbsp;&nbsp;
  <button type="button" class="btn btn-primary dropdown-toggle btnsearch" data-bs-toggle="dropdown" aria-expanded="false">Search By</button>
  <ul class="dropdown-menu">
      <li class="li1"><a class="dropdown-item" href="#">First Name</a></li>
      <li class="li2"><a class="dropdown-item" href="#">City</a></li>
      <li class="li3"><a class="dropdown-item" href="#">Email</a></li>
      <li class="li4"><a class="dropdown-item" href="#">Phone</a></li>
  </ul>&nbsp;&nbsp;
<script>
</script>
  <form id="myForm" class="d-flex" role="search" action="getSelecteddata_Servlet">
      <!--searching the customer by their name,city,email or phone-->
        <input type="hidden" name="tagInnerValue" id="tagInnerValue"/>
        <input class="form-control me-2 searchbar"name="searchbar"type="search" placeholder="Search" aria-label="Search" required>
        <button class="btn btn-outline-success searchbarbutton"name="searchbarbutton"type="submit" onclick="setValue()">Search</button>
      </form>
</div><hr/>
 <%
            java.util.List<Assignment_java.pojo.Customer>customers=(java.util.List<Assignment_java.pojo.Customer>)request.getAttribute("list");
            if(customers!=null){
            out.println("<table class='table-bordered'>");
//            display the all customers according to search or display the all customers according
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Address</th><th>City</th><th>State</th><th>Email</th><th>Phone</th><th>Action</th></tr>");
            for (Assignment_java.pojo.Customer obj:customers) {
                    out.println("<form>");
                    out.println("<tr><td>"+obj.getFirstname()+"</td><td>"+obj.getLastname()+"</td><td>"+obj.getAddress()+"</td><td>"+obj.getCity()+"</td><td>"+obj.getState()+"</td><td>"+obj.getEmail()+"</td><td>"+obj.getPhone()+"</td><td><a onclick='deleteCustomer(\"" + obj.getFirstname() + "\")'><img class='img1'src='Assignment_java.images/delete.jpg' alt='not found'/></a>&nbsp<a onclick='editCustomer(\"" + obj+ "\")'><img class='img2' src='Assignment_java.images/icon.png' alt='not found'/></a></td></tr>");
                    out.println("</form>");
            }
            out.println("</table>");}
            else{
                out.println("No Customer data Found");
            }
        %>
<script>
  
function deleteCustomer(firstName) {
    var url = 'http://localhost:2022/Assignment_java/DeleteCustomer_Servlet'; //call to a servlet for delete customer
    var data = encodeURIComponent(firstName);
    var mess="";
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: data
    })
    .then(response => response.json())
    .then(data => {
        mess=data.message;
    })
    .catch(error => {
        console.error('Error:', error);
    });
    alert("Customer deleted successfully");//customer detete successfully
    window.location.href = '/Assignment_java/login.jsp';
}
function editCustomer(obj) {
    window.location.href = '/Assignment_java/addedit_customer.jsp';//this page will edit or add customer according to the first name.If first name is already found then update other things and not found then add the customer
}
    document.getElementById("myForm").addEventListener("submit", function() {
        var hiddenInput = document.createElement("input");
        hiddenInput.setAttribute("type", "hidden");//generate hidden field for passing data 
        hiddenInput.setAttribute("name", "data");
        hiddenInput.setAttribute("value", btn.textContent);
        document.getElementById("myForm").appendChild(hiddenInput);
    });
    let btn=document.querySelector(".btnsearch");
    var li1 = document.querySelector(".li1");
    var li2 = document.querySelector(".li2");
    var li3 = document.querySelector(".li3");
    var li4 = document.querySelector(".li4");
    if(btn.textContent=="Search By")
    {//search bar will be inactive until user don't select the filter to search
        var searchBar = document.querySelector(".searchbar");
        var searchButton = document.querySelector(".searchbarbutton");
        searchBar.style.display ="none";
        searchButton.style.display = "none";//hide search bar
    }
    function setSearchBar()
    {
        if(btn.textContent!="Search By")
        {
            searchBar.style.display ="";
             searchButton.style.display = "";//show search bar
        }
    }
    li1.addEventListener("click", function() {
        var anchor1 = li1.querySelector("a");
        btn.innerHTML=anchor1.textContent;
        setSearchBar();
    });
    li2.addEventListener("click", function() {
        var anchor2 = li2.querySelector("a");
        btn.innerHTML=anchor2.textContent;
                setSearchBar();

    });
    li3.addEventListener("click", function() {
        var anchor3 = li3.querySelector("a");
        btn.innerHTML=anchor3.textContent;
        setSearchBar();
    });
    li4.addEventListener("click", function() {
        var anchor4 = li4.querySelector("a");
        btn.innerHTML=anchor4.textContent;
        setSearchBar();
    });
    function addCustomer()
    {
        window.location.href = "addedit_customer.jsp";
    }
</script>
</body>
</html>