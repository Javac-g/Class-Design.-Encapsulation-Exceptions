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

Attributes:
radius (private double): Represents the radius of the circle.
color (private String): Represents the color of the circle.
scale (private float): Represents the scale factor for the size of the circle.
Constructor:
Circle(double radius): Initializes the circle with the given radius and default values for color and scale.
Create Drawing Methods:

draw(): Draws the circle using its current properties (radius, color, and scale).
draw(String color): Draws the circle with the specified color, affecting the color attribute.
draw(float scale): Draws the circle with the specified scale, affecting the scale attribute.
draw(String color, float scale): Draws the circle with the specified color and scale, affecting both the color and scale attributes.
Functionality of Drawing Methods:

Each draw method should update the circle's properties accordingly.
The actual drawing functionality is not implemented (as indicated by the empty method bodies). You can assume these methods would integrate with a graphical library to render the circle on-screen.
Objectives:
Demonstrate the use of method overloading by providing multiple draw methods with different parameters.
Show understanding of basic OOP principles such as encapsulation by using private attributes and public methods.
Implement a constructor to initialize an object's state and methods to modify it.
Additional Considerations:
The methods are stubs (empty implementations), as the actual drawing depends on a graphical context not provided here.
Think about how you might expand this class to integrate with a real graphical library and what additional methods or properties might be necessary.
Consider adding getters and setters for the circle's properties to allow for more controlled access and modification.
Ensure your class structure is clear and provides a logical and intuitive interface for creating and manipulating circle objects with various visual properties.
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
