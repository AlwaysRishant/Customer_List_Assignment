This is a simple Customer Management CRUD (Create, Read, Update, Delete) application designed to manage customer information. The project is built with MySQL for the database, Java Servlets for the backend, and HTML/CSS/JS for the frontend.

Features
=======================

Backend (Java Servlets)
==================================

-Create a Customer:

        -API endpoint: /api/customers (POST)
        -Description: Creates a new customer in the database.

-Update a Customer:

        -API endpoint: /api/customers/{id} (PUT)
        -Description: Updates the information of an existing customer based on their ID.

-Get a List of Customers with Pagination and Searching:

        -API endpoint: /api/customers (GET)
        -Description: Retrieves a paginated list of customers from the database.It Supports searching.

-Get a Single Customer based on ID:

        -API endpoint: /api/customers/{id} (GET)
        -Description: Retrieves detailed information about a specific customer based on their ID.

-Delete a Customer:

        -API endpoint: /api/customers/{id} (DELETE)
        -Description: Deletes a customer from the database based on their ID.

Frontend (HTML/CSS/JS)
==============================
The frontend is built using simple HTML, CSS, and JavaScript. It provides a user-friendly interface for interacting with the Customer Management System.

-Database Configuration:

         -Set up a MySQL database and update the connection details in the backend.

-Backend Configuration:

        -For Java Servlets: Deploy the WAR file on a Servlet container (e.g., Apache Tomcat).
        -For Spring Boot: Run the Spring Boot application.

-Frontend Configuration:

        -Host the HTML/CSS/JS files on a web server or directly open the index.html file in a web browser.

-Access the Application:

        -Open the application in a web browser and start managing customer information.

Contributing
===============
Feel free to contribute to the project by submitting issues or pull requests. Your feedback and contributions are highly appreciated.
