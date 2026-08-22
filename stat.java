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
import java.util.Scanner;

public class stat{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("**Student Early Warning System**");
        
        
        System.out.print("** Enter the Average grades of the subject:");
        double classMean = input.nextDouble();
        
        System.out.print("**Enter the stander deviation:");
        double classStdDev = input.nextDouble();

        
        System.out.print("** Enter the current degree:**");
        double studentGrade = input.nextDouble();

        double zScore = (studentGrade - classMean) / classStdDev;

        System.out.println("Analysis result :");
        
        if (zScore <= -2.0) {
            System.out.println("⚠️ you are in the high danger zon !!");
            System.out.println("You are exposed to academic failure by a large percentage!!`");
        } 
        else if (zScore <= -1.0) {
            System.out.println("⚠️ You are in the worry zone !!");
            System.out.println("You need to intensify level is significantly lower than average!!");
        } 
        else if (zScore >= 0) {
            System.out.println("✅ You are higher than average safe condition ");
            if (zScore >= 2.0) {
                System.out.println("You are better than creative !!");
            }
        } 
        else {
            System.out.println("you condition is cioser than average , you condition is stable!");
        }

        
        double probability = normalDistribution(studentGrade, classMean, classStdDev);
        System.out.printf("the distribution intensity of your current level is : %.4f\n", probability);
    }

 
    public static double normalDistribution(double x, double mean, double standerD) {
        return (1 / (standerD * Math.sqrt(2 * Math.PI))) * Math.exp(-Math.pow(x - mean, 2) / (2 * Math.pow(standerD, 2)));
    }
}

