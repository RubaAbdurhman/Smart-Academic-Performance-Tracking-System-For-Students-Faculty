/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stat_project;

/**
 *
 * @author sweet
 */
import java.util.Scanner;
public class Statistics {
    public static double mean(double[]  studentData) {
        double sum = 0;
        for (double num :studentData) {
            sum += num;
        }
        return sum / studentData.length;
    } //end of mean method //

   
    public static double standardDeviation(double[] data) {
        double mean = mean(data);                             //  calculating the Average //
        double sum = 0;

        for (double num : data) {
            sum += Math.pow(num - mean, 2);
        }

        return Math.sqrt(sum / data.length);
    }// end of standardDeviation method //

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your Name:");
        String name = input.nextLine();
        System.out.println("Enter Credit hours:");
        double hours = input.nextDouble();
        System.out.println("Enter Submitted Assignments:");
        double assignments = input.nextDouble();
        System.out.println("Enter Attendance Percentage:");
        double attendance = input.nextDouble();
        System.out.println("Enter Exam Score:");
        double examScore = input.nextDouble();
        double[] data = {hours, assignments, attendance, examScore}; // we put all student data in Array//
        double Average = mean(data);
        double standardDeviation = standardDeviation(data);

        System.out.println("Student: " + name);
        System.out.println("Mean = " + Average);
        System.out.println("Standard Deviation = " + standardDeviation);
    }
}


