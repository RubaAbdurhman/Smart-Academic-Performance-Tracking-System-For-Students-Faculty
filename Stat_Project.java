/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stat_project;

/**
 *
 * 
 * @author sweet
 */
import java.util.Scanner;
public class Stat_Project {

    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
       double mean=10;
       double standerD=2;   //initialization values//
       double x=12;
       double result=normalDistribution(x,mean,standerD);
      System.out.println("Enter your Name:");
        String Name=input.nextLine();
        System.out.println("Enter Credit hours:");
        int creditHours=input.nextInt();
        System.out.println(" Enter Submitted Assignments:");   // Ask the student about there information//
        int SubmittedAssignments=input.nextInt();
        System.out.println(" Enter Attendance Percentage:");
         double  AttendancePercentage= input.nextDouble();
         System.out.println(" Exam Score:");
        double examScore=input.nextDouble();
   double[]data={creditHours,SubmittedAssignments,AttendancePercentage,examScore};
   double average=Statistics.mean(data);
        System.out.println("Student Name:"+Name);
        System.out.println("Mean:"+average);
        //  double[] data = {Name, creditHours, SubmittedAssignments, AttendancePercentage}; // we put all student data in Array//
        double Average = mean(data);
        double standardDeviation = standardDeviation(data);
     
    
    }// end of main method 
    public static double normalDistribution(double x,double mean,double standerD){  //Normal distribution function//
        return(1/(standerD*Math.sqrt(2*Math.PI)))*Math.exp(-Math.pow(x-mean,2)/(2*Math.pow( standerD,2)));
    }
     public static double mean(double[]  studentData) {
        double sum = 0;
        for (double num :studentData) {
            sum += num;
        }
        return sum / studentData.length;
    }// end of method 
     public static double standardDeviation(double[] data) {
        double mean = mean(data);                             //  calculating the Average //
        double sum = 0;

        for (double num : data) {
            sum += Math.pow(num - mean, 2);
        }

        return Math.sqrt(sum / data.length);
    }// end of method //
}
    //end of normalDistribution methode//
   
