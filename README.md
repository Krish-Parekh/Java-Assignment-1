# Java Assignment 1

## Author
- **Name:** Krish Parekh
- **Student ID:** s4043281
- **GitHub:** [Krish-Parekh/Java-Assignment-1](https://github.com/Krish-Parekh/Java-Assignment-1)

## Overview

This application demonstrates the use of design patterns to build a maintainable and abstract Java application. The project focuses on the management and operation of a list of books, utilizing design patterns like Factory and Singleton to enhance code structure and reusability.

## Design Patterns Implemented

### 1. Factory Design Pattern
- **Purpose:** The Factory Design Pattern is employed to create objects for various operations that can be performed on the list of books.
- **Implementation:** All operation classes implement the `Operation` interface, which defines the `execute` method. This ensures that new operations can be added easily without modifying existing code, adhering to the Open-Closed Principle.

### 2. Singleton Design Pattern
- **Purpose:** The Singleton Design Pattern ensures that only a single instance of the `Cart` class is created during the application's lifecycle.
- **Implementation:** This design choice guarantees that only one cart instance is maintained for a single session, preventing conflicts or inconsistencies in the user's shopping cart.

## Design Choice: Preventing Multiple E-book Purchases
- **Reason:** Users are not allowed to purchase multiple copies of the same E-book. This decision is based on the fact that owning more than one digital copy of the same E-book is unnecessary and could lead to redundancy and waste of resources.

## Thought Process

1. **Abstraction & Maintainability:** The application is designed with a focus on abstraction and maintainability. By using design patterns, the codebase remains flexible and easy to extend.
2. **Operation Management:** The Factory Design Pattern allows for the seamless addition of new operations without altering existing code, making it easy to adapt to new requirements.
3. **Singleton Usage:** The Singleton Design Pattern is crucial for managing the cart instance, ensuring consistency and avoiding potential bugs related to multiple instances.

## Video Demo

A video demonstration of the application can be accessed through the following link:

[Watch the Demo](https://rmiteduau-my.sharepoint.com/:v:/g/personal/s4043281_student_rmit_edu_au/Ee5fz7ON3A5OsBK2Q2xs8kEBix5j4Rtz2BFQjlyztcbYAQ?e=vVyMb5&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)