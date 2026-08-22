/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stat_project2;
import java.util.Scanner;
public class Stat_project2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("====================================");
        System.out.println("   WELCOME TO ACADEMIC STAT SYSTEM  ");
        System.out.println("====================================");
        System.out.println("Please select your role:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                // --- Teacher Interface Logic ---
                Teachers teacherObj = new Teachers(); // Create object
                
                System.out.println("\n--- Teacher Access Control ---");
                teacherObj.SetEmployeeID(); // Validates the ID
                teacherObj.Setdepartment();
                
                // Now, let the teacher input the data
                teacherObj.setStudentData(); // This fills the Names and 2D Array
                
                // Show the Teacher Menu
                System.out.println("\nWhat would you like to do?");
                System.out.println("A. Display Student Records");
                System.out.println("B. Run Detailed Academic Risk Analysis (Binomial)");
                System.out.println("C. View Normal Distribution");
                System.out.print("Choice: ");
                char tChoice = input.next().toUpperCase().charAt(0);
                
                if (tChoice == 'A') teacherObj.displayStudentInfo();
                else if (tChoice == 'B') teacherObj.earlyWarningOfAcademicFailure();
                else if (tChoice == 'C') teacherObj.NormalDistrbution();
                break;
                
            case 2:
                // --- Student Interface Logic ---
                // Here you would call your Student class methods
                System.out.println("\nWelcome Student!");
                System.out.println("This section is under construction or connect to Student class...");
                break;
                
            default:
                System.out.println("Invalid selection. Please restart the program.");
                break;
        }
        
        System.out.println("\nThank you for using the system.");
    }
}
      
 
    

