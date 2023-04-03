package org.nuos.dzhurynskyi.labs.lb4;
import java.util.Arrays;

public class IterativeMethods {

    // Розв'язок СЛАР за методом простої ітерації (Якобі)
    public double[] solveJacobi(double[][] A, double[] b, double tol) {
        int n = b.length;
        double[] x0 = new double[n]; // Початкове наближення
        double[] x = new double[n];  // Нове наближення
        double[] d = new double[n];  // Діагональна матриця A
        double[] r = new double[n];  // Матриця A без діагоналі

        // Розбиваємо матрицю A на діагональну та недіагональну частини
        for (int i = 0; i < n; i++) {
            d[i] = A[i][i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    r[i] += A[i][j];
                }
            }
        }

        int iter = 0;               // Лічильник ітерацій
        double error = Double.MAX_VALUE; // Похибка
        while (error > tol) {
            // Розраховуємо нове наближення x
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum -= A[i][j] * x0[j];
                    }
                }
                x[i] = 1.0 / d[i] * sum;
            }

            // Обчислюємо похибку
            error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(x[i] - x0[i]);
            }

            // Підготовка до наступної ітерації
            iter++;
            x0 = Arrays.copyOf(x, n);
        }

        System.out.println("Проста ітерація (Якобі): знайдено за " + iter + " ітерацій. Похибка= "+error);
        return x;
    }

    // Розв'язок СЛАР за методом Гауса-Зейделя
    public double[] solveGaussSeidel(double[][] A, double[] b, double tol) {
        int n = b.length;
        double[] x0 = new double[n]; // Початкове наближення
        double[] x = new double[n];  // Нове наближення

        int iter = 0;               // Лічильник ітерацій
        double error = Double.MAX_VALUE; // Похибка
        while (error > tol) {
            // Розраховуємо нове наближення x
            for (int i = 0; i < n; i++) {
                double sum1 = 0;
                double sum2 = 0;
                for (int j = 0; j < i; j++) {
                    sum1 += A[i][j] * x[j];
                }
                for (int j = i + 1; j < n; j++) {
                    sum2 += A[i][j] * x0[j];
                }
                x[i] = 1.0 / A[i][i] * (b[i] - sum1 - sum2);
            }

            // Обчислюємо похибку
            error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(x[i] - x0[i]);
            }

            iter++;
            x0 = Arrays.copyOf(x, n);
        }

        System.out.println("Метод Гауса-Зейделя: знайдено за " + iter + " ітерацій. Похибка= "+error);
        return x;
    }
}
