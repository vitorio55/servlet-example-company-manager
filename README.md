# Tools used
* IDE => Eclipse 4.22.0  
* Server => Apache Tomcat 10.0

Servlet example project based on Alura's Servlet course.

Steps to run project in Eclipse:
1 - Clone repo
2 - In Eclipse, on the top menu...
3 - File -> Open Projects from File System
4 - Find and select the project's dir in the file system -> select checkbox in list
5 - Click Finish

A new Tomcat server must be added in Eclipse to run the project's servlets
1 - To open the Servers view, on the top menu click Window
2 - Show View -> Other
3 - Search for Server and select
4 - On the Server view, click on the option to create a new server
5 - Search and select Tomcat v10 -> Next
6 - If the servlets project is already imported in Eclipse, now it can be added
7 - Click on the servlets project name -> 'Add >' -> Finish
8 - If the project was bound to the Tomcat server, we can now run the server to serve the application
9 - Click on the Tomcat server name -> (on the right top of the Servers view) Start the server
10 - Access http://localhost:8080/servlet-example-company-manager/listCompanies to visit the servlet that list companies