
---

# 📘 **University Enrollment Management System**

A Java-based desktop application for managing university students and lecturers.
The system supports adding people, editing student details, viewing data in a GUI table, and displaying basic statistics.
Built using **Java**, **Swing**, and **Object-Oriented Programming principles**.

---

## 🚀 **Features**

### 🧑‍🎓 **1. Person Management**

The system allows managing two types of people:

* **Students**
* **Lecturers**

You can:

* Add new students and lecturers
* Store details such as name, surname, date of birth, ID, and role-specific information
* View all added people in both console and GUI

---

### 🛠️ **2. Edit Student Module Enrollment**

A built-in editor allows updating the number of modules a student is enrolled in:

* Search for a student by ID
* Display their current course and module count
* Validate user input to prevent negative values
* Update the student’s data safely

---

### 🖥️ **3. Interactive GUI Table**

A Swing-based graphical interface displays all people in a table format.

The table includes:

* Name
* Surname
* Date of Birth
* Role (Student / Lecturer)
* **Details** (Course title for students, Specialisation for lecturers)

Additional GUI features:

* Column sorting
* Scrollable table view
* "Statistics" button for quick insights

---

### 📊 **4. Real-Time Statistics**

A **Statistics** button in the GUI provides:

* Total number of people
* Total number of students
* Total number of lecturers

Displayed in a user-friendly popup using `JOptionPane`.

---

### 🧪 **5. Unit Testing**

Includes JUnit tests covering the enrollment manager:

* Ensures that people are added correctly when within system limits
* Ensures the system does not exceed its capacity
* Improves reliability and stability of the application

---

## 🧱 **Project Structure**

```
src/
 └── universityenrollmentsystem/
       ├── Person.java
       ├── Student.java
       ├── Lecturer.java
       ├── EnrollmentManager.java
       ├── WestminsterEnrollmentManager.java
       ├── UniversityTableModel.java
       ├── UniversityTableGUI.java
       └── UniversityEnrollmentSystem.java

test/
 └── universityenrollmentsystem/
       └── WestminsterEnrollmentManagerTest.java
```

---

## 🧩 **Core Concepts Used**

The system demonstrates strong Object-Oriented Programming design:

* **Encapsulation** — private fields with getters/setters
* **Inheritance** — `Student` and `Lecturer` extend `Person`
* **Polymorphism** — shared behavior via `EnrollmentManager` interface
* **Abstraction** — interface-driven architecture
* **MVC elements** — clean separation between data, model, and GUI

---

## ▶️ **How to Run**

1. Open the project in **NetBeans** or any Java-supported IDE.

2. Run the main class:

   ```
   UniversityEnrollmentSystem.java
   ```

3. Use the console menu to:

    * Add people
    * Edit student modules
    * Print person list
    * Launch the GUI

4. In the GUI:

    * Browse table data
    * Click **Statistics** to view insights

---

## 🧪 **Running Unit Tests**

1. Navigate to the `test` folder in NetBeans.
2. Right-click → **Run Tests**.
3. Tests validate person-list capacity and addition behavior.

---

## 📌 **Future Enhancements**

* Export data to CSV / JSON
* Import existing university records
* GUI-based editing and deletion

---

