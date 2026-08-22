/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.stat_project2;
import java.util.Scanner;
public class Teachers {
    private int EmployeeID;
    private String department;
    private String []studentName;
    private  double [][] studentGrad;
    
    public Teachers(){
        
    }//end of constructor
    
    public Teachers(int EmployeeID,String department,String []studentName,double [][] studentGrad){
        this.EmployeeID=EmployeeID;
        this.department=department;
        this.studentGrad=studentGrad;
        this.studentName=studentName;
        
    }//end of constructor
    
     public void SetEmployeeID(){
         Scanner input=new Scanner(System.in);
         System.out.println("Ente the EmployeeID: ");
         this.EmployeeID=input.nextInt();
         System.out.println( EmployeeID);
     }// end of method
                                                     // يستقبل المعلومات اللي الاساتذة يحطونها 
      public void Setdepartment(){
         Scanner input=new Scanner(System.in);
         System.out.println("Ente the Department Name: ");
         this.department=input.nextLine();
         System.out.println( department);
     }// end of method
      public void setStudentData(){
         Scanner input=new Scanner(System.in);
         System.out.println("Ente the number of Student  : ");
         int size=input.nextInt();
         input.nextLine();
        this.studentName=new String[size];
        this.studentGrad=new double [size][3];
        for(int i=0;i<studentName.length;i++){
            System.out.println("Enter StudentName number"+(i+1+":"));
            studentName[i]=input.nextLine();
            System.out.println("Now Enter the Grade "+ studentName[i]+":");
            for(int j=0;j<studentGrad[i].length;j++){
                if(j==0){
                    System.out.println("Quize score:");
                }else if(j==1){
                            System.out.println("Mid score:");
                }else if (j==2){
                    System.out.println("Home Works:");
                }//end of if 
                studentGrad[i][j]=input.nextDouble();
                input.nextLine();
                System.out.println("############################################");
            }//end of for loop 2 method 
        }// end of for loop 1 method 
     }// end of method
      public void NormalDistrbution(){
          if(studentGrad==null){
              System.out.println("There are currently no grades observed.");
              return;
          }// end if 
          int n=studentName.length;
          double[]totals=new double[n];
          double sum=0;
          for(int i=0;i<n;i++){
              totals[i]=studentGrad[i][0]+studentGrad[i][1]+studentGrad[i][2];
              sum+=totals[i];
          }
          double mean=sum/n;
          int aboveAverage = 0;
           int belowAverage = 0;
            int atAverage = 0;                     //NormalDistrbution
            for(double score:totals){
                if(score>mean+5)aboveAverage++;
                else if (score<mean-5)belowAverage++;
                else atAverage++;
            }
            System.out.println("\\n---Analysis of the normal distribution the class ");
            System.out.println("Average current semester scores:"+mean);
            System.out.println("The number of student above average:"+aboveAverage );
            System.out.println("Number of student in the medium range:"+atAverage);
            System.out.println("Number of struggling student :"+belowAverage);
            if(aboveAverage>belowAverage&&aboveAverage>atAverage ){
                System.out.println("The class is very good(Skewed Left).");
            }else if (belowAverage>aboveAverage&&belowAverage>atAverage){
                System.out.println("The tests may be difficult or the level is low (Skewed Right).");
            }else{
                System.out.println("Normal natural distribution (Bell Curve)");
            }// end of if method 
      }//end of NormalDistrbution method 
     public void displayStudentInfo() {
    // Check if data exists to avoid NullPointerException
    if (this.studentName == null || this.studentGrad == null) {
        System.out.println(">>> Warning: No student data found. Please record grades first.");
        return;
    }

    System.out.println("\n==================================================================");
      System.out.println("Teacher ID: " + this.EmployeeID + " | Department: " + this.department);
     System.out.println("==================================================================");
    System.out.println("No.\tStudent Name\tQuiz\tMid\tAssign\tTotal(/60)");
    System.out.println("------------------------------------------------------------------");
    for (int i = 0; i < studentName.length; i++) {
        double currentSum = 0;
        System.out.print((i + 1) + "\t" + studentName[i] + "\t\t");
        for (int j = 0; j < studentGrad[i].length; j++) {
            System.out.print(studentGrad[i][j] + "\t");
            currentSum +=studentGrad[i][j]; // Calculate sum for this row
        }
        System.out.println(currentSum);
    }
    System.out.println("==================================================================");
}// end of Displayinformation student //
     public void earlyWarningOfAcademicFailure() {
    if (this.studentName == null || this.studentGrad == null) {
        System.out.println(">>> Warning: No data available for analysis.");
        return;
    }

    double weight = 0.20; // 20% weight for each category
    double passingThreshold = 10.0; // 50% of the 20 marks available in each category
    int totalAtRisk = 0;

    System.out.println("\n==================================================");
    System.out.println("       DETAILED ACADEMIC RISK ANALYSIS           ");
    System.out.println("==================================================");

    for (int i = 0; i < studentName.length; i++) {
        boolean studentFlagged = false;
        double q = studentGrad[i][0]; // Quiz
        double m = studentGrad[i][1]; // Midterm
        double a = studentGrad[i][2]; // Assignment

        System.out.println("Student: " + studentName[i]);

        // Check each category individually against 50% of its weight
        if (q < 10) {
            System.out.println("  [!] Risk in Quiz: " + q + "/20 (Below 50%)");
            studentFlagged = true;
        }// end of if 
        if (m < 10) {
            System.out.println("  [!] Risk in Midterm: " + m + "/20 (Below 50%)");
            studentFlagged = true;
        }// end of if 
        if (a < 10) {
            System.out.println("  [!] Risk in Assignments: " + a + "/20 (Below 50%)");
            studentFlagged = true;
        }// end of end 

        if (studentFlagged) {
            totalAtRisk++;
            double weightedTotal = (q * weight) + (m * weight) + (a * weight);
            System.out.println("  >> Current Weighted Contribution: " + weightedTotal + " / 12.0");
        } else {
            System.out.println("  >> Performance: Stable");
        }// end of else 
        System.out.println("--------------------------------------------------");
    }// end 
    double pFailure = (double) totalAtRisk / studentName.length;
    System.out.println("Class Failure Probability (p): " + String.format("%.2f", pFailure));
    
    if (pFailure > 0.4) {
        System.out.println("CRITICAL: More than 40% of the class is underperforming!");
    }// end of if 
}// end method 
      }// end 
      
     

