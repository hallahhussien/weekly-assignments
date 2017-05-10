# Form-Based Auth Exercises - Week 5

### Goal

Add form-based authentication to this web application using Tomcat's 
JDBC Realm and your MySQL Sample database.

### Requirements

1. Everyone should be able to access index.jsp of your site.
1. Restrict access to the admin.jsp to only users who have a role of 
"administrator".
1. Restrict access to the display.jsp to only users who have a role of 
"registeredUser" or "administrator".

### Suggested Steps

#### Create tables in your application's database to hold user and role information.
    
1. Create a user table

        create table users (
        user_name         varchar(15) not null primary key,
        user_pass         varchar(15) not null
        );
    
1. Create a user_roles table

        create table user_roles (
        user_name         varchar(15) not null,
        role_name         varchar(15) not null,
        primary key (user_name, role_name)
        );

1. Create a user so that Tomcat can access the database you just created.

		CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'tomcat';

1. Give the tomcat user privileges to read.

		GRANT SELECT ON sample.* TO 'tomcat'@'localhost';

1. Create some users:

        insert into users values ('admin', 'admin');
        // TODO: Based on the requirements, what other user/s do you need to 
        add?
       
1. Add some roles: 

        insert into user_roles values ('admin', 'administrator');
        // TODO: Based on the requirements, what other role/s do you need to add?

#### Set up Tomcat to use JDBCRealm and your newly created tables

1. Locate the Realm elements in your $CATALINA_BASE/conf/server.xml.

1. Here's an example for using a MySQL database called "sample", configured with the tables described above, and accessed with username "tomcat" and password "tomcat":

		    <Realm className="org.apache.catalina.realm.JDBCRealm"
		    driverName="com.mysql.jdbc.Driver"
		    connectionURL="jdbc:mysql://localhost:3306/sample?user=tomcat&amp;password=tomcat"
		    userTable="users" userNameCol="user_name" userCredCol="user_pass"
		    userRoleTable="user_roles" roleNameCol="role_name"/>
		    //TODO: Make sure this configuration information is consistent with your database/table details
1. Add the MySQL driver to the Tomcat lib directory.   	  	  	

#### Add login and login error handling capability to your web application
            
1. Add a login form to the login.jsp. An example form might be:
    
        <FORM ACTION="j_security_check" METHOD="POST">
        	<TABLE>
        		<TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username"> 
        		<TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password"> 
        		<TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
        	</TABLE>
        </FORM>

1. Take a look at the failedLogin.jsp which has already been created for you.
1. Specify the login and error pages in web.xml using the ```<login-config>```
element. 
1. Add ```<security-constraint>``` elements to the application's web.xml to 
control which resources are available to which roles. 
1. Restart Tomcat and deploy your application.
1. Log in with the users you created to verify the requirements are met.

   	  	  	
   	  	 

