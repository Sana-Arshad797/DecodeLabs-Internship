# DecodeLabs Number Guessing Game (Java)

A console-based Java application where the player tries to guess a randomly generated secret number within a limited number of attempts. This project showcases structured programming, clean input sanitation, custom penalty tracking, and local file I/O operations for high-score persistence.

---

## 🎮 Game Rules & Design

1. **The Secret Number**: The computer picks a random integer between **0 and 1000** (inclusive) at the start of each game.
2. **Total Guesses**: You have a maximum of **10 valid attempts** to find the number.
3. **Smart Hints**: After every incorrect guess, the game guides the player by telling them if their guess was **too big** or **too smaller** compared to the secret number.
4. **History Tracker**: The game displays a live running log of all previous valid guesses before every turn to prevent user redundancy.

### ⚠️ Input Validation & Penalties
* **Out of Bounds**: If you enter a number less than 0 or greater than 1000, the game warns you, but it **will not** consume an active turn.
* **Invalid Input**: Entering text strings, symbols, or anything other than integers will trigger an invalid input warning. 
* **Consecutive Error Control**: If a player triggers a validation error or enters a duplicate (repeated) number **two times in a row**, they are penalized by **losing 1 guess** from their total attempts.

---

## 🏆 Persistent High Score System

The game automatically manages and saves your best record locally using Java File Handling:
* **Storage File**: The high score is stored in a plain text file named `highscore.txt` inside the root workspace directory.
* **How It Activates**: The file reading and writing mechanisms **only trigger when you win the game** (`guess == random`). No file is updated or created if you lose.
* **Efficiency Metric**: Scores are determined by efficiency—**fewer attempts indicate a higher, better record.** If you beat the previous best record, the file updates with your new lower turn count.

---

## 🚀 How to Run the Project

### Prerequisites
* **Java Development Kit (JDK)** installed on your machine (Version 8 or higher).
* A Command Prompt/Terminal or an IDE (like Eclipse, IntelliJ IDEA, NetBeans).

### Execution Steps
1. Clone or download the repository files.
2. Compile the program using terminal:
   ```bash
   javac DecodeLabs_Java_P1.java
   ```
3. Run the application:
   ```bash
   java DecodeLabs_Java_P1
   ```

### 🔍 Note on Finding `highscore.txt`
If you win the game and cannot see the `highscore.txt` file immediately in your IDE project panel, simply right-click on your main project folder and select **Refresh** (or press `F5`). The file is generated in the root project folder directory level.

---

## 🛠️ Tech Stack & Utilities

* **Language Platform**: Java 
* **Core APIs**:
  * `java.util.Scanner` — For parsing user keyboard input and reading the high score file.
  * `java.util.Random` — For generating the target secret number.
  * `java.io.File` & `java.io.FileWriter` — For checking, creating, and updating the storage file safely inside a `try-catch` block to handle `IOException`.
