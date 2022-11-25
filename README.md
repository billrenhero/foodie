Foodie
====
A demo project.

Functions:

1. Upload csv and save data to Database.
2. Query the data in the database.

How to Run:

1. Prepare a Mysql database. (If you already have one, just skip this step.)

    Use docker to create your DB (It is not recommended in Product Environment. It is not a good choice to use docker for data persistence.) :
    
    a. install docker.
    
    After step a, input these commands in the console : 
    
    b. docker search mysql
    
    c. docker pull centos/mysql-57-centos7
    
    d. docker run -itd --name myDB -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 centos/mysql-57-centos7
    
2. Use a DB connector or go to your mysql console to create a mysql database named "foodie"

3. Run the sql "doc\foodie.sql" to create the table.

Then, the database is ready.

4. Modify the configuration file "src\main\profiles\dev\application.yml". Modify the "spring datasource" part.
   Change the url, username and password as your actual situation.

5. Use maven repackage your project. Find the java file "foodie.jar" in "Foodie\modules\main\target\".

Deploy foodie.jar in Docker

6. Put "foodie.jar", "application.yml" and "doc\docker\Dockerfile" in the same path.(Just like the files in "doc\docker").

7. Build docker images. At the above path, use the command "docker build -t foodie:1.0.0 ."

8. Modify the property "spring.datasource.url" in the file "application.yml" like "jdbc:mysql://mysql:3306/foodie?useSSL=false".

9. Run the images. Use the command "docker run --name MyFoodie --link myDB:mysql -p 8080:8080 -d foodie:1.0.0"(The first mysql is your mysql container name).

10. Use the postman collection in "doc\Foodie.postman_collection.json" to post your request.