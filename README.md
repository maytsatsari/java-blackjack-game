# Java Blackjack Game

A full-featured implementation of the classic Blackjack (21) game in Java, built using object-oriented principles.  
Developed as part of a university assignment to demonstrate advanced class design, interaction, and game logic.

---

##  Project Highlights

- Fully playable Blackjack game via console
- Object-Oriented Architecture with clear separation of responsibilities
- Support for:
  - Betting system
  - Doubling down
  - Splitting pairs
  - Dealer AI with proper rules
- Multiple decks supported via card river logic

---

##  Class Overview

The game is organized in modular Java classes, each responsible for a key part of the logic:

```
src/
├── Card.java              // Represents a single card
├── River.java             // Card deck manager (shuffling, dealing)
├── Hand.java              // Represents a player's hand
├── CasinoCustomer.java    // Player account (name, balance)
├── Player.java            // Game actions per player
├── Dealer.java            // Dealer logic and actions
├── Round.java             // Single round coordinator
└── BlackjackTable.java    // Main game loop controller
```

---

##  How to Compile & Run

```bash
javac src/*.java
java -cp src BlackjackTable
```

---

##  About the Project

This project was developed as part of the course **“Object-Oriented Programming Techniques”** in the Department of Computer Science, University of Ioannina.

It was designed to showcase:
- Java class design
- Inheritance & composition
- User input handling
- Game logic simulation

---

## Author

[maytsatsari](https://github.com/maytsatsari)
