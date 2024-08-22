# Spring Boot Web-Based eCommerce Application

This project is a web-based CRUD application built using Java Spring Boot and the MVC architecture. It consists of two main modules: `e-admin` for administrative functionalities and `e-commerce` for the main e-commerce functionalities.

## Project Structure

- **e-admin:** Administrative panel for managing the application.
- **e-commerce:** Main e-commerce application for users.
- **ecommercedb:** MySQL database managed using XAMPP.

## Getting Started

### Prerequisites

Before running the application, ensure you have the following installed:

- **Java JDK 8 or higher**
- **Maven**
- **XAMPP** (for MySQL database)
- **Git**

### Installation and Setup

#### 1. Clone the Repository

```bash
git clone https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel.git
```

#### 2. Set Up the Database
- Start XAMPP and run Apache and MySQL.
- Open phpMyAdmin and create a database named ecommercedb.
- Import the database schema provided in the /db folder of the project.

#### 3. Configure Application Properties
Edit the `application.properties` file in both `e-admin` and `e-commerce` modules. Update the database connection settings:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/ecommercedb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

#### 4. Build the Project
Navigate to the root directory and run:

```bash
mvn clean install
```

#### 5. Run the Application
- To run the admin module:

```bash
cd e-admin
mvn spring-boot:run
```
- To run the e-commerce module:
  
```bash
cd e-commerce
mvn spring-boot:run
```

<br>



### Accessing the Application

#### e-Admin
- **URL:** [http://localhost:8080/admin/home](http://localhost:8080/admin/home)
<img src ="https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel/blob/master/New%20folder/admin%201.png"/>
<img src="https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel/blob/master/New%20folder/admin%202.png"/>
<img src="https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel/blob/master/New%20folder/admin%203.png"/>

####  e-Commerce
- **URL:** [http://localhost:8080/ecommerce/home](http://localhost:8080/ecommerce/home)

  
<img src="https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel/blob/master/New%20folder/h%200.png"/>
<img src="https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel/blob/master/New%20folder/h%202.png"/>
<img src="https://github.com/nipun-priyanjith/ecommerce_website_with_admin_panel/blob/master/New%20folder/h%203.png"/>

## Database

- **Database Management:** XAMPP
- **Database Name:** ecommercedb
- **Importing Schema:** Use phpMyAdmin to import the SQL schema provided in the `/db` folder.



## Technologies Used

### Backend
- **Java Spring Boot**
- **Spring MVC**
- **MySQL**
- **Servlets**
- **RESTful API**

### Frontend
- **JSP** (JavaServer Pages)
- **HTML**
- **CSS**


### Tools
- **Maven** (for dependency management)
- **XAMPP** (for MySQL database management)
- **Git** (for version control)


## Learning Outcomes

- **Enterprise Applications Architecture:** Familiarity with designing and implementing large-scale enterprise applications.
- **MVC Architecture:** Understanding of Model-View-Controller design patterns in building web applications.
- **Spring Boot:** Proficiency in using Spring Boot for developing Java-based applications.
- **RESTful API:** Knowledge of designing and consuming RESTful services.
- **Database Management:** Skills in managing MySQL databases, including schema design and data manipulation.




## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions, issues, or suggestions, feel free to reach out:

- **Email:** your.email@example.com
- **GitHub:** [yourusername](https://github.com/yourusername)
