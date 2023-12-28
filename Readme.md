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
The Operation class is a utility class in Java that provides methods to calculate the area of a rectangle. It's designed to handle invalid inputs robustly by using exceptions and alternative error-handling strategies.

# Task 3 -  Java Operation Class for Rectangle Area Calculation:

### Methods
- **squareRectangle(int a, int b):** Calculates the area of a rectangle with sides 'a' and 'b'.
- **trySquareRectangle(int a, int b):** Attempts to calculate the area of a rectangle, providing alternative error handling.

### Error Handling
- **IllegalArgumentException:** Thrown by `squareRectangle` when either dimension is non-positive.
- **Alternative Approach:** `trySquareRectangle` uses a try-catch block to manage exceptions, returning a special value (-1) to indicate an error.

## Implementation

### squareRectangle Method
- **Signature:** `public static int squareRectangle(int a, int b)`
- **Behavior:** Calculates and returns the area if valid inputs are provided.
- **Error Handling:** Throws an IllegalArgumentException if `a` or `b` is less than or equal to 0, with a message indicating the requirement for positive dimensions.

### trySquareRectangle Method
- **Signature:** `public static int trySquareRectangle(int a, int b)`
- **Behavior:** Tries to calculate the area of a rectangle, handling any IllegalArgumentException internally.
- **Error Handling:** Catches IllegalArgumentException and returns -1, signaling an error without propagating the exception.

## Objectives
- **Robust Input Validation:** Utilize exception handling to manage and communicate errors effectively.
- **Static Utility Methods:** Provide operations without the need for class instantiation, suitable for utility-type tasks.
- **Alternative Error Handling:** Offer different strategies for dealing with errors to accommodate various use cases.

# Task 4 -  Gardening System - Plant Object Management

### Enumerations
- **Color:** Defines possible colors (`WHITE`, `RED`, `BLUE`) for plants.
- **Type:** Defines possible types (`RARE`, `ORDINARY`) for plants.

### Custom Exception Classes
- **ColorException:** Indicates issues with setting the plant's color.
- **TypeException:** Indicates issues with setting the plant's type.

### Plant Class
- **Attributes:**
  - `name (String)`: The name of the plant.
  - `color (Color)`: The color of the plant.
  - `type (Type)`: The type of the plant.
- **Constructor:**
  - `Plant(String type, String color, String name)`: Sets the plant's type and color; throws `TypeException` or `ColorException` for invalid inputs.
- **Methods:**
  - `getType()`, `getColor()`, `getName()`: Getters for the plant's attributes.
  - `toString()`: Provides a string representation of the plant.

### Error Handling and Creation Logic
- **tryCreatePlant(String type, String color, String name):**
  - Attempts to create a new `Plant` instance.
  - Handles `ColorException` and `TypeException` by setting default values and retrying.
  - Returns the created `Plant` object.

# Task 5 - Java Point Class for 2D Space Representation

## Overview
The Point class in Java is designed to represent a point in 2D space and provide functionalities to calculate distances between points. It offers methods to retrieve the point's coordinates and calculate the distance from this point to another point or the origin.

### Attributes
- **x (int):** Represents the x-coordinate of the point.
- **y (int):** Represents the y-coordinate of the point.

### Constructor
- **Point(int x, int y):** Initializes a new instance of the Point class with specified x and y coordinates.

### Methods
- **getXYPair():** Returns an array containing the x and y coordinates of the point.
- **distance(int x, int y):** Calculates the Euclidean distance between this point and another point with specified x and y coordinates.
- **distance(Point point):** Calculates the Euclidean distance between this point and another specified Point object.
- **distance():** Calculates the distance from this point to the origin (0,0).
# Task 6 -  Java Product Class for Store Inventory Management

## Overview
The Product class in Java represents items in a store's inventory. Each product has a name and price, and the class keeps track of the total number of product instances created. This class is designed to be used in applications that manage store inventories, product listings, or any system requiring an item representation with a count of total items.

## Features

### Attributes
- **name (private String):** The name of the product.
- **price (private double):** The price of the product.
- **counter (public static int):** A class-level counter tracking the total number of Product instances created.

### Constructors
- **Default Constructor:** Initializes a new instance of Product and increments the counter.
- **Parameterized Constructor (String name, double price):** Initializes a new instance with the specified name and price and increments the counter.

### Methods
- **Setters:**
  - `setName(String name)`: Sets the product's name.
  - `setPrice(double price)`: Sets the product's price.
- **Getters:**
  - `getName()`: Returns the product's name.
  - `getPrice()`: Returns the product's price.
- **Static Method:**
  - `count()`: Returns the total number of Product instances created.

## License
This project is licensed under the Apache License 2.0 - see the LICENSE file for details. The Apache License is a permissive free software license written by the Apache Software Foundation (ASF) that provides good protection against software patents and allows users to do almost anything with the project, including commercial use.
