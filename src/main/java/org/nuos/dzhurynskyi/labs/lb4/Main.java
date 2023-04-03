package org.nuos.dzhurynskyi.labs.lb4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IterativeMethods iterativeMethods=new IterativeMethods();

        double[][] a = {{76, 5.8, 4.7}, {3.8, 41, 2.7}, {2.9, 2.1, 38}};
        double[] b = {101, 97, 78};
        double tol = 1e-5;

        double[] xJacobi = iterativeMethods.solveJacobi(a, b, tol);
        double[] xGaussSeidel = iterativeMethods.solveGaussSeidel(a, b, tol);

        System.out.println("Розв'язок за методом простої ітерації (Якобі): " + Arrays.toString(xJacobi));
        System.out.println("Розв'язок за методом Гауса-Зейделя: " + Arrays.toString(xGaussSeidel));
    }
}
