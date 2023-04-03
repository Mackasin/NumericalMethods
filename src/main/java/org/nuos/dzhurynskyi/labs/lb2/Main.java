package org.nuos.dzhurynskyi.labs.lb2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinearEquationProcessor processor = new LinearEquationProcessor();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start of the isolation interval: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the end of the isolation interval: ");
        double b = scanner.nextDouble();
        double e = 0.00001;
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        System.out.println("tan(0.5x+0.2)=x^2");
        double dis = processor.halfDivision(a, b, e);

        String y = "\ny = ";
        String x = "x = ";

        System.out.println("Method of half division: \n" + x + processor.errorChecker(dis) + y + processor.f(dis) + "\n");
        double iteration = processor.simpleIteration(a, b, e);
        System.out.println("Simple iteration method: \n" + x + processor.errorChecker(iteration) + y + processor.f(iteration) + "\n");
        double chord = processor.chordMethod(a, b, e);
        System.out.println("Chord method: \n" + x + processor.errorChecker(chord) + y + processor.f(chord) + "\n");
        double newton = processor.newtonsMethod(a, b, e);
        System.out.println("Newton's method: \n" + x + processor.errorChecker(newton) + y + processor.f(newton) + "\n");
    }
}
