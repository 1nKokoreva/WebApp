# Web Application for Java Elements Management
This project is a web application that allows users to view, search, and add elements in Java. It utilizes the servlet technology and a custom database called "Book" to store the elements.

# Features
View Java Elements: Users can search for Java elements based on their ID and publication date. The application retrieves the elements from the "Book" database and displays them to the user.

Add Java Elements: Users can add new Java elements to the "Book" database. They need to provide the ID, title, and genre of the element, and the application stores this information in the database.

Get Book Review: Users can search for a book review by providing the book ID. The application retrieves the review from the "Book" database and displays it to the user.

# Technologies Used
Servlet: The application is built using the servlet technology, which allows it to handle HTTP requests and responses.

Database: The application uses a custom database called "Book" to store and retrieve Java elements and their reviews. It utilizes JDBC (Java Database Connectivity) to interact with the database.

# Project Structure
The project consists of the following components:

HelloServlet: This servlet class handles the HTTP requests and responses for the application. It initializes the DBOService, which is responsible for interacting with the "Book" database. It also implements the doGet() and doPost() methods to handle the respective HTTP methods.

DBOService: This class provides methods to connect to the "Book" database, retrieve Java elements and reviews, add new Java elements, and retrieve the entire database. It uses JDBC to establish a connection with the database and execute SQL queries.

doGet.jsp: This JSP (JavaServer Pages) file is the view for the GET request. It contains a form where users can search for Java elements by ID and publication date. The retrieved elements are displayed to the user.

doPost.jsp: This JSP file is the view for the POST request. It contains a form where users can add new Java elements to the "Book" database. The result of the addition is displayed to the user.

# Usage
To use the web application, follow these steps:

Deploy the application to a Java servlet container (e.g., Apache Tomcat).

Access the application through a web browser.

Use the provided forms to search for Java elements, add new elements, or retrieve book reviews.

![image](https://github.com/1nKokoreva/WebApp/assets/127196631/a67dc2b0-471c-44e6-8ab1-2d199a125bd0)
![image](https://github.com/1nKokoreva/WebApp/assets/127196631/38dd57d0-8bfb-4976-b790-8ab6e007076a)
![image](https://github.com/1nKokoreva/WebApp/assets/127196631/01b4263c-e1d5-4ae3-949a-6a6dbc738265)
![image](https://github.com/1nKokoreva/WebApp/assets/127196631/288a77c2-9fef-43e9-b3e4-6a4f5b307537)
![image](https://github.com/1nKokoreva/WebApp/assets/127196631/30f9f93f-04d7-44fd-88ec-a9469df57b28)
![Uploading image.png…]()


