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
public class StudentRecommendations {

    public static String classifyStudent(double score) {
        if (score >= 75) {
            return "ممتاز";
        } else if (score >= 50) {
            return "متوسط";
        } else {
            return "خطير";
        }
    }

    public static void printRecommendations(String name, String level) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("الطالب : " + name);
        System.out.println("المستوى : " + level);
        System.out.println("----------------------------------------");
        System.out.println("التوصيات :");
        System.out.println();

        switch (level) {
            case "ممتاز" -> {
                System.out.println("  - الاستمرار في نفس الوتيرة");
                System.out.println("  - المشاركة في المسابقات الاكاديمية");
                System.out.println("  - مساعدة الزملاء في المراجعة");
                System.out.println("  - التقدم لمشاريع اضافية");
            }
            case "متوسط" -> {
                System.out.println("  - حضور دروس تقوية");
                System.out.println("  - حل تمارين اضافية يومياً");
                System.out.println("  - مراجعة الدروس بشكل منتظم");
                System.out.println("  - التواصل مع الاستاذ عند الصعوبة");
            }
            case "خطير" -> {
                System.out.println("  ! تحذير : الطالب في خطر اكاديمي");
                System.out.println("  ! حضور دروس تقوية الزامية");
                System.out.println("  ! جلسة مع المرشد الاكاديمي");
                System.out.println("  ! خطة دراسية مكثفة");
                System.out.println("  ! متابعة اسبوعية الزامية");
            }
        }

        System.out.println("========================================");
    }

    public static void main(String[] args) {

       // try {
        //    System.setOut(new PrintStream(System.out, true, "UTF-8"));
        //} catch (UnsupportedEncodingException e) {
        //+++++++++++++++}

        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            System.out.println("========================================");
            System.out.println("    نظام توصيات الطلاب الاكاديمية");
            System.out.println("========================================");
            System.out.println();

            System.out.println("ادخل عدد الطلاب :");
            int numStudents = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numStudents; i++) {
                System.out.println();
                System.out.println("--- الطالب رقم " + i + " ---");
                System.out.println();

                System.out.println("اسم الطالب :");
                String name = scanner.nextLine();

                System.out.println("درجة الطالب من 100 :");
                double score = scanner.nextDouble();
                scanner.nextLine();

                while (score < 0 || score > 100) {
                    System.out.println("درجة غير صحيحة ! ادخل درجة بين 0 و 100 :");
                    score = scanner.nextDouble();
                    scanner.nextLine();
                }

                String level = classifyStudent(score);
                printRecommendations(name, level);
            }

            System.out.println();
            System.out.println("تم الانتهاء من معالجة جميع الطلاب !");
        }
    }
}
  

