<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
<h1>Login Page</h1>
<!--validate login details if passes then next page will open otherwise error message show -->
<form action="validateuserServlet" method="post">
  <label for="username">Login Id:</label>
  <input type="text" id="username" name="username" required placeholder="login id">
  <br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required placeholder="Password">
  <br><br>
  <input type="submit" value="Submit">
</form>
<script>
        var outputMessage = '<%= request.getAttribute("output") %>';
        if (outputMessage==='Wrong Id Password Try Again!!') {
//            if wrong login id password will filled
            alert(outputMessage);
        }
    </script>
</body>
</html>