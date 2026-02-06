# project-core-java
Semester 2 core java Project


# Connect 4 Game (Java – Console Based)

## 1. Introduction

Connect 4 is a classic two-player strategy board game in which players alternately drop discs into a vertical grid. The objective is to be the first player to form a continuous line of four discs horizontally, vertically, or diagonally.

This project implements a **console-based version of Connect 4 using Java**, focusing on correct game logic, structured programming, and effective user interaction. It demonstrates how core Java concepts can be applied to build an interactive game application without the use of graphical interfaces.

---

## 2. Problem Statement

Physical board games require manual setup and rule enforcement and are limited by physical availability. The problem addressed by this project is to digitally simulate the Connect 4 game in a console environment while ensuring accurate rule implementation, proper input validation, and smooth turn-based gameplay, without using graphical interfaces or external storage systems.

---

## 3. Objectives

The objectives of this project are:

- To design and implement a functional Connect 4 game using Java  
- To enable two-player, turn-based gameplay  
- To validate user input and prevent invalid moves  
- To correctly detect win and draw conditions  
- To provide options for quitting and replaying the game  
- To strengthen understanding of fundamental Java programming concepts  

---

## 4. Scope of the Project

- The application is console-based  
- It supports two human players  
- No graphical user interface (GUI) is used  
- No database or file handling is involved  
- The game state exists only during runtime  
- The project is intended for educational and academic purposes  

---

## 5. Software Requirements

The following software is required to develop and execute the project:

- **Programming Language:** Java  
- **Java Development Kit:** JDK 8 or higher  
- **Integrated Development Environment (IDE):**
  - IntelliJ IDEA  
  - Eclipse  
  - Visual Studio Code (with Java extensions)  
- **Operating System:** Any Java-supported OS (Windows, Linux, macOS)  

---

## 6. System Design

### Overall System Flow

1. Players enter their names at the start of the program  
2. The game board is initialized as a 6×7 grid  
3. Players take turns placing their discs  
4. Each player enters a column number or chooses to quit  
5. The disc is dropped into the lowest available position in the selected column  
6. The board is displayed after each move  
7. The system checks for win or draw conditions  
8. Players may choose to replay or exit the game  

### Class Design

**Connect4 (Single Class Design)**  
- Contains the `main()` method  
- Stores the game board and constants  
- Manages input handling, game flow, and core game logic  

### Key Methods

- `init()` – Initializes the board with empty cells  
- `print()` – Displays the current board state  
- `drop(int column, char player)` – Handles disc placement logic  
- `win(char player)` – Checks all possible winning combinations  
- `full()` – Detects draw condition  
- `name(char player)` – Returns the name of the current player  

---

## 7. Implementation Details

- The game board is represented using a two-dimensional character array (`char[][]`)  
- Constants are declared using `static final` to define board size and player symbols  
- User input is handled using the `Scanner` class  
- Input validation includes:
  - Ensuring column numbers are within valid range  
  - Handling invalid or non-numeric input using exception handling  
- The `drop()` method simulates gravity by placing discs from the bottom upwards  
- The `win()` method checks horizontal, vertical, and diagonal alignments  
- Quit confirmation and replay options ensure smooth user interaction  

---

## 8. Java Concepts Used

- Classes and static members  
- Constants (`static final`)  
- Arrays (two-dimensional arrays)  
- Loops (nested `for` loops)  
- Conditional statements (`if-else`)  
- Methods and modular programming  
- Object-oriented principles (encapsulation)  
- Exception handling (`try-catch`)  
- String manipulation (`trim()`, `equalsIgnoreCase()`)  

---

## 9. Limitations

- No graphical user interface; output is text-based  
- No AI or computer-controlled opponent  
- Entire logic is implemented in a single class  
- Game state is not stored after program termination  
- Limited extensibility without refactoring  

---

## 10. Future Enhancements

- Develop a GUI version using Java Swing or JavaFX  
- Implement single-player mode with AI logic  
- Add score tracking and player statistics  
- Refactor the program into multiple classes  
- Improve visuals using colors or animations  
- Enable online or network-based multiplayer gameplay  

---

## 11. Conclusion

This project successfully demonstrates the development of a Connect 4 game using Java in a console environment. It applies fundamental programming concepts such as arrays, loops, methods, and exception handling in a structured manner. The project strengthens Java fundamentals, enhances logical thinking, and provides a solid foundation for developing more advanced Java-based applications.
