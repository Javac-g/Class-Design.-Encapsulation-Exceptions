# Task 1 -  Simple Checking Account Management System

## Overview
This Java program simulates a simple checking account management system. It's designed to handle basic transactions such as deposits and withdrawals while managing situations like insufficient funds through custom exception handling.

## Features
- **Deposit Funds:** Add money to the account balance.
- **Withdraw Funds:** Deduct money from the account balance if sufficient funds are available.
- **Insufficient Funds Management:** Throws a custom exception when a withdrawal request exceeds the account balance.

## Classes and Methods

### CheckingAccount Class
- **Attributes:**
  - `private double balance`: Represents the current balance in the account.
  - `private int number`: Represents the account number.
- **Constructor:**
  - `CheckingAccount(int number)`: Initializes the account with the given account number and a balance of zero.
- **Methods:**
  - `deposit(double amount)`: Adds the specified amount to the current balance.
  - `withdraw(double amount)`: Deducts the specified amount from the current balance. Throws InsufficientAmountException if funds are insufficient.

### InsufficientAmountException Class
- **Attributes:**
  - `private double amount`: Represents the shortfall amount in the transaction.
- **Constructor:**
  - `InsufficientAmountException(double amount)`: Initializes the exception with the shortfall amount.
- **Methods:**
  - `getMessage()`: Returns a message indicating the shortfall amount.
  - `getAmount()`: Returns the shortfall amount.

###1) BankDemo Class
- **Methods:**
  - `doOperations()`: Simulates account operations, handles deposits, withdrawals, and captures exceptions.

## Objectives
- Demonstrate understanding of object-oriented programming principles such as encapsulation and exception handling.
- Implement custom exceptions to handle specific error scenarios.
- Use try-catch blocks to manage exceptions and provide informative feedback to the user.
Design a Java class named Circle to represent a circle with customizable properties and the ability to draw itself with various details. The class should allow setting the circle's radius, color, and scale and provide multiple drawing options.

# Task 2 -  Implement a Circle Class:

### Attributes
- **Radius (double):** Determines the size of the circle.
- **Color (String):** Defines the color of the circle.
- **Scale (float):** Adjusts the size of the circle relative to its original radius.

### Constructor
- **Circle(double radius):** Initializes a new instance of the Circle class with a specified radius and default values for color and scale.

### Drawing Methods
- **draw():** Renders the circle using its current properties.
- **draw(String color):** Draws the circle with a specified color, updating the color attribute.
- **draw(float scale):** Draws the circle with a specified scale, updating the scale attribute.
- **draw(String color, float scale):** Draws the circle with both specified color and scale, updating the respective attributes.

## Objectives
- **Method Overloading:** Demonstrates the use of method overloading by providing multiple drawing methods with different parameters.
- **Encapsulation:** Shows an understanding of basic OOP principles by using private attributes and public methods.
- **Initialization:** Implements a constructor to initialize the circle's state and methods to modify it.

## Additional Considerations
- **Stub Methods:** The draw methods are currently stubs, as the actual drawing implementation would require a graphical context. Consider how this class might integrate with a real graphical library like JavaFX or Swing.
- **Expansion:** Think about additional methods or properties that might be useful, such as getters and setters for the circle's properties, or methods to calculate area and circumference.
- **Error Handling:** Consider adding error handling for invalid parameters (e.g., negative radius or scale).

## How to Run
Provide instructions on how to compile and run the program, including any necessary commands or steps.

## Error Handling
Detail how the program handles errors, specifically regarding insufficient funds.

## Contribution
Instructions for how others can contribute to this project, if applicable.

## License
This project is licensed under the Apache License 2.0 - see the LICENSE file for details. The Apache License is a permissive free software license written by the Apache Software Foundation (ASF) that provides good protection against software patents and allows users to do almost anything with the project, including commercial use.

## Contact
Provide contact information for users who have questions or want to get in touch.

---

**Note:** This README is a template and should be modified to fit the specifics of your project's implementation and requirements.
