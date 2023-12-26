# Simple Checking Account Management System

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

## How to Run
Provide instructions on how to compile and run the program, including any necessary commands or steps.

## Error Handling
Detail how the program handles errors, specifically regarding insufficient funds.

## Contribution
Instructions for how others can contribute to this project, if applicable.

## License
Include a license here, if applicable.

## Contact
Provide contact information for users who have questions or want to get in touch.

---

**Note:** This README is a template and should be modified to fit the specifics of your project's implementation and requirements.
