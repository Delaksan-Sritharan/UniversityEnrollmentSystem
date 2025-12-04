/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universityenrollmentsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class WestminsterEnrollmentManager implements EnrollmentManager{
    
    // ArrayList
    public ArrayList<Person> personList;
    public int person_limit;
    
    public WestminsterEnrollmentManager(int maxMemebersNumber){
        personList = new ArrayList<Person>();
        person_limit = maxMemebersNumber;
    }

    @Override
    public boolean runMenu() {
         boolean exit = false; 
        
        // Run console menu
        System.out.println("\n-- UNIVERSITY ENROLLMENT SYSTEM CONSOLE MENU--");
        
        System.out.println("To save and exit, press 0");
        System.out.println("To Add a new person, press 1");
        System.out.println("To Print the list of all people press 2");
        System.out.println("To Open GUI, press 3");
        System.out.println("To Edit Student Modules, press 4");
        System.out.println("To Edit Student Details, press 5");



        // Switch based on selected option
        Scanner s = new Scanner(System.in);
        int choice;
        
        // Basic error handling for choice input
        try {
             choice = s.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number from the menu.");
            s.nextLine(); // Clear the buffer
            return false; // Rerun the menu
        }
       
        switch(choice){
            
             // Exit
            case 0:
                exit = true;
                break;
            
            // Add person
            case 1:
                this.addPerson();
                break;
            // Print person list
            case 2:
                this.printPersonList();
                break;
            
            // GUI
            case 3:
                this.runGUI();
                break;

            //Edit Student Modules
            case 4:
                this.editStudentModules();
                break;

            // Edit Student Details
            case 5:
                this.editStudentDetails();
                break;

            
            default:
                System.out.println("Invalid option selected.");
        }
        
        return exit;
    }

    @Override
    public void addPerson() {
        Scanner s = new Scanner (System.in);
        
        if(personList.size() < person_limit){
            System.out.println("Press 1 if you want to add a Student");
            System.out.println("Press 2 if you want to add a Lecturer");
            
            
            int choicePerson;
            try {
                choicePerson = s.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1, 2 (or 3 for Task 01).");
                s.nextLine();
                return;
            }
            s.nextLine(); // Consume newline
            
            // common questions
            System.out.println("Enter the first name");
            String name = s.nextLine();
            
            System.out.println("Enter the last name");
            String surname = s.nextLine();
            
            System.out.println("Enter the ID");
            String ID = s.nextLine();
            
            
            System.out.println("Enter the date of birth (dd/MM/yyyy format only!)");
            LocalDate date = null;
            boolean parsingSucceds = false;
            while(!parsingSucceds){
                String dob = s.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                try{
                    date = LocalDate.parse(dob, formatter);
                    parsingSucceds = true;  
                }catch(DateTimeParseException e){
                    System.out.println("Enter the correct format. It should be dd/MM/yyyy!");
                    parsingSucceds = false;
                }
            }
            
            // check if the person is a student, lecturer, or administrator
            switch(choicePerson){
                case 1:
                    // it is a student
                    System.out.println("Enter the course title");
                    String courseTitle = s.nextLine();
                    
                    System.out.println("Enter the number of modules enrolled:");
                    int modulesEnrolled;
                    try {
                        modulesEnrolled = s.nextInt();
                    } catch (java.util.InputMismatchException e) {
                         System.out.println("Invalid input for modules. Setting to 0.");
                         modulesEnrolled = 0;
                         s.nextLine();
                    }
                    
                    // create a new Student and add to the list
                    Student student = new Student(name, surname);
                    student.setCourseTitle(courseTitle);
                    student.setModulesEnrolled(modulesEnrolled);
                    student.setDob(date);
                    student.setID(ID);
                    this.addPersonToList(student);
                    
                    break;
                    
                case 2:
                    //it is a lecturer
                    System.out.println("Enter the office number");
                    int officeNum;
                    try {
                        officeNum = s.nextInt();
                    } catch (java.util.InputMismatchException e) {
                         System.out.println("Invalid input for office number. Setting to 0.");
                         officeNum = 0;
                         s.nextLine();
                    }
                    s.nextLine(); // Consume newline
                    
                    System.out.println("Enter the specialisation/department");
                    String specialisation = s.nextLine();
                    
                    // create a new lecturer and add to the list
                    Lecturer lecturer = new Lecturer(name, surname);
                    lecturer.setOfficeNumber(officeNum);
                    lecturer.setSpecialisation(specialisation);
                    lecturer.setDob(date);
                    lecturer.setID(ID);
                    this.addPersonToList(lecturer);
                    
                    break;
                
                
                default:
                    System.out.println("Invalid person type selected. Person not added.");
            }
            
        }
        else {
            System.out.println("The system is at full capacity.");
        }
    }
    
    public void addPersonToList(Person person){
        
        //check if there are space available
        if(this.personList.size() < person_limit) {
            personList.add(person);
            System.out.println("Person added successfully.");
        }
        else{
            System.out.println("No more space in the list");
        }
    }

    @Override
    public void printPersonList() {
        
        
        if (!personList.isEmpty()){
            Collections.sort(personList);
            System.out.println("\n--- ENROLLED PEOPLE LIST ---");
            for(Person member : personList) {
                System.out.println(member.toString());
            }
            System.out.println("---------------------------\n");
        }
        else{
            System.out.println("There are no people in the system.");
        }
    }

    @Override
    public void runGUI() {
        UniversityTableGUI table = new UniversityTableGUI(personList);
        table.setVisible(true);
    }

    @Override
    public void editStudentModules() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the student ID: ");
        String ID = input.next();

        boolean found = false;
        for (Person person: personList){
            if ( person instanceof Student && person.getID().equalsIgnoreCase(ID)){
                found = true;
                Student student = (Student) person;

                System.out.println("Course Title: " + student.getCourseTitle() +
                        "\nNumber of modules: " + student.getModulesEnrolled()
                );

                int newModules = -1;
                boolean valid = false;

                while (!valid){
                    System.out.println("Enter new number of modules: ");
                    try{
                        newModules = input.nextInt();
                        input.nextLine(); //clear buffer

                        if (newModules < 0 ){
                            System.out.println("Modules cannot be negative. Try again");
                        }else {
                            valid = true;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid input. Please enter a positive number.");
                        input.nextLine(); //clear invalid input
                    }
                }
                student.setModulesEnrolled(newModules);
                System.out.println("Modules updated successfully!");
                break;
            }
        }

        if (!found){
            System.out.println("Student with ID " + ID + " not found.");
        }



    }

    @Override
    public void editStudentDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID of the person whose details you want to edit: ");
        String ID = input.next();

        boolean found = false;
        for (Person person: personList){
            if (person.getID().equalsIgnoreCase(ID)){
                found = true;

                //if NOT a Student
                if (!(person instanceof Student)){
                    System.out.println("This person is not a student. Only student details can be edited");
                    return;
                }

                Student student = (Student) person;

                System.out.println("Course Title: " + ((Student) person).getCourseTitle()
                        + "\nModules Enrolled: " + ((Student) person).getModulesEnrolled());

                System.out.println("\nEdit Student Details");
                System.out.println("Press 1 to change course title");
                System.out.println("Press 2 to change number of modules");
                System.out.println("Press 3 to change both");

                int choice = -1;
                try{
                    choice = input.nextInt();
                    input.nextLine(); //clear buffer
                }catch (InputMismatchException e){
                    System.out.println("Invalid choice");
                    return;
                }

                switch (choice){
                    case 1:
                        System.out.println("Enter new course title: ");
                        String newCourse = input.nextLine();
                        student.setCourseTitle(newCourse);
                        System.out.println("Course title updated successfully!");
                        break;

                    case 2:
                        System.out.println("Enter new number of modules (1–8):");
                        int newModules;
                        try {
                            newModules = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid number. Modules NOT updated.");
                            return;
                        }

                        if (newModules < 1 || newModules > 8) {
                            System.out.println("Error: Module count must be between 1 and 8. Value NOT changed.");
                        } else {
                            student.setModulesEnrolled(newModules);
                            System.out.println("Modules updated successfully!");
                        }
                        break;

                    case 3:
                        // Change BOTH
                        System.out.println("Enter new course title:");
                        String bothCourse = input.nextLine();

                        System.out.println("Enter new number of modules (1–8):");
                        int bothModules;
                        try {
                            bothModules = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid number. Only course title updated.");
                            student.setCourseTitle(bothCourse);
                            return;
                        }

                        if (bothModules < 1 || bothModules > 8) {
                            System.out.println("Error: Module count must be between 1 and 8. Only course title updated.");
                            student.setCourseTitle(bothCourse);
                        } else {
                            student.setCourseTitle(bothCourse);
                            student.setModulesEnrolled(bothModules);
                            System.out.println("Both course title and modules updated successfully!");
                        }

                        break;

                    default:
                        System.out.println("Invalid option chosen. No changes made.");
                }
                return;
            }
        }
        if (!found){
            System.out.println("No person found with ID " + ID + ".");
        }

    }

    public void displayOnlyStudentsSorted(){

        ArrayList <Person> studentList = new ArrayList<>();

        for (Person p: personList){
            if (p instanceof Student){
                studentList.add(p);
            }
        }

        Collections.sort(studentList);

        if (studentList.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("\n--- STUDENTS ONLY (SORTED) ---");
        for (Person student : studentList) {
            System.out.println(student.toString());
        }
        System.out.println("-------------------------------\n");
    }
}

