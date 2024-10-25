# HotelEase - Hotel Management System

[Run the application](https://github.com/azizbelkhouja/HotelEase/blob/main/hotel-management-system.jar)

## Overview

The **Hotel Management System** is a Java-based application designed to manage hotel operations efficiently. The system provides functionalities for managing hotel rooms, customer information, check-ins, and check-outs. It features a graphical user interface built with Swing and follows modern design principles to ensure a user-friendly experience.

## Features

- **User Interface**: Clean and intuitive GUI built with Java Swing.
- **Room Management**: Ability to view, add, and update room information.
- **Customer Management**: Add, update, and view customer information.
- **Check-in/Check-out**: Handle customer check-ins and check-outs with real-time updates to room availability.
- **Data Persistence**: Store customer and room information using a SQL database.

## Project Structure

- **`HotelManagementSystem.java`**: Main entry point of the application, providing the initial splash screen and navigation to the login screen.
- **`Login.java`**: User authentication screen.
- **`AddCustomer.java`**: Form to add new customers.
- **`CustomerInfo.java`**: View customer details in a table format.
- **`Checkout.java`**: Handle customer check-outs.
- **`Reception.java`**: Main dashboard for hotel reception operations.
- **`Conn.java`**: Database connection utility for SQL operations.

## Prerequisites

To run this application, you need:

- **Java Development Kit (JDK)**: Version 8 or higher.
- **SQL Database**: MySQL or any compatible SQL database.
- **Database Schema**: Ensure the required tables (`customer`, `room`, etc.) are created in your database

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/hotel-management-system.git
   cd hotel-management-system
   ```

2. **Compile the Java Files**:
   ```bash
   javac -d bin src/hotel/management/system/*.java
   ```

3. **Set Up the Database**:
   - Configure your SQL database and import the schema. Ensure that the database connection details in `Conn.java` match your database setup.

4. **Run the Application**:
   ```bash
   java -cp bin hotel.management.system.HotelManagementSystem
   ```

## Usage

1. **Launch the Application**: Run the `HotelManagementSystem` class to start the application.
2. **Navigate**: Use the "Next" button on the splash screen to proceed to the login page.
3. **Login**: Enter valid credentials to access the system.
4. **Manage Hotel Operations**:
   - **Add Customer**: Access the form to add new customers.
   - **View Customer Info**: View and manage existing customer information.
   - **Check-in/Check-out**: Perform check-ins and check-outs through the respective forms.

## Contributing

Contributions to the project are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push to your branch.
4. Open a pull request detailing your changes.
