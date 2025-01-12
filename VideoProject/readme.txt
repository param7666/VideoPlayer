
Video Upload and Watch Online Application
This project provides functionality to upload videos to an Oracle database via an HTML form and retrieve the uploaded videos for online viewing.

Features
Upload Video: Allows users to upload videos with a name and video file (BLOB) to an Oracle database.
Watch Video: Retrieve and watch the uploaded videos directly through the browser.
Download Video: Option to download the uploaded video.
Setup Instructions
1. Setting Up Tomcat Server in Eclipse
To run the project, you need to set up Apache Tomcat in Eclipse.

Steps:
Install Apache Tomcat:
Download Apache Tomcat from Tomcat Downloads.
Extract the downloaded files to a directory (e.g., C:\apache-tomcat-9.0.x).
Configure Tomcat in Eclipse:
Open Eclipse and navigate to Window > Preferences > Server > Runtime Environments.
Click Add External Server and select Apache Tomcat v9.0 (or the version you downloaded).
Browse to the folder where you extracted Tomcat and select it.
Start Tomcat:
Once configured, go to Servers tab in Eclipse, right-click and select Start to start the Tomcat server.

2. Creating a Dynamic Web Project in Eclipse
Steps:
Open Eclipse and go to File > New > Dynamic Web Project.
Name the project (e.g., VideoUploadApp).
Select the target runtime as the Tomcat server you configured.
Click Finish.

3. Adding Servlet API and JDBC 8 JARs to the Project
Steps:
Add Servlet API:

Right-click on your project in the Project Explorer panel and select Properties.
Go to Java Build Path > Libraries > Add Library > Server Runtime > Apache Tomcat (this will add the servlet-api.jar).
Add JDBC 8 JAR:

Download the ojdbc8.jar from Oracle JDBC Downloads.
Add the JAR to the project:
Right-click the project, then Build Path > Configure Build Path > Libraries > Add External JARs.
Browse and select the ojdbc8.jar file

4. Database Setup
Create the Video Table in Oracle Database
To store the video data, create the table in Oracle database as follows:


Copy code
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
ID                                         NOT NULL VARCHAR2(5)
NAME                                       NOT NULL VARCHAR2(20)
VIDEO                                      NOT NULL BLOB


7. Running the Project
Once everything is set up, you can:

Deploy the project on Tomcat in Eclipse.
Open your browser and go to http://localhost:8080/VideoUploadApp/ to access the video upload page.
Use the form to upload a video, and once uploaded, you will be able to watch the video via the Watch link on the video list page.
Project Flow
Upload Video:

A user uploads a video via the form on the index.html page.
The UploadServlet handles storing the video data into the Oracle database.

Watch Video:

Users can retrieve and watch the video online from the video list page (videoList.jsp).
The WatchVideoServlet fetches the video and streams it to the user.
Database:

The video ID, name, and BLOB data (video file) are stored in the videotable in the Oracle database.
Conclusion
This project provides an easy-to-implement solution for uploading and viewing videos online. By following the setup instructions, you can configure the project on your local machine and start uploading and watching videos seamlessly.







