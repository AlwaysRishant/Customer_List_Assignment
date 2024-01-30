<!DOCTYPE html>
<html>
<head>
<title>Add Customer</title>
</head>
<body>
<h1>Customer Details</h1>
<!--Give a call to a servlet to add or edit customer in a database according to users action-->
<form action="add_edit_customer_servlet" method="post">
  <label for="firstname">First Name:</label>
  <input type="text" id="firstname" name="firstname" placeholder="firstname"required>
  <br><br>
  <label for="lastname">Last Name:</label>
  <input type="text" id="lastname" name="lastname" placeholder="lastname"required>
  <br><br>
  <label for="address">Address:</label>
  <input type="text" id="address" name="address"placeholder="address" required>
  <br><br>
  <label for="street">Street:</label>
  <input type="text" id="street" name="street" placeholder="street"required>
  <br><br>
  <label for="city">City:</label>
  <input type="text" id="city" name="city" placeholder="city"required>
  <br><br>
  <label for="state">State:</label>
  <input type="text" id="state" name="state" placeholder="state"required>
  <br><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" placeholder="email id"required>
  <br><br>
  <label for="phone">Phone:</label>
  <input type="text" id="phone" name="phone" placeholder="phone number"required>
  <br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>