package org.nuos.dzhurynskyi.labs.lb3;

public class LinearSolver {

    public void solveGauss(double[][] a, double[] b) {
        System.out.println("Solution by Gaussian method:\n");
        int n = b.length;
        double[] x = new double[n];
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double coef = a[i][k] / a[k][k];
                b[i] -= coef * b[k];
                for (int j = k; j < n; j++) {
                    a[i][j] -= coef * a[k][j];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / a[i][i];
        }
        for (int i = 0; i < n; i++) System.out.println("x[" + i + "] = " + x[i]);
        System.out.println("Error: " + estimateError(a, b, x) + "\n");
    }

    public void solveLU(double[][] a, double[] b) {
        System.out.println("Solution by the LU-distribution method:\n");
        int n = b.length;
        double[][] l = new double[n][n];
        double[][] u = new double[n][n];
        for (int i = 0; i < n; i++) {
            l[i][i] = 1.0;
        }
        for (int k = 0; k < n; k++) {
            u[k][k] = a[k][k];
            for (int i = k + 1; i < n; i++) {
                l[i][k] = a[i][k] / u[k][k];
                u[k][i] = a[k][i];
            }
            for (int i = k + 1; i < n; i++) {
                for (int j = k + 1; j < n; j++) {
                    a[i][j] = a[i][j] - l[i][k] * u[k][j];
                }
            }
        }
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = b[i];
            for (int j = 0; j < i; j++) {
                y[i] = y[i] - l[i][j] * y[j];
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = y[i];
            for (int j = i + 1; j < n; j++) {
                x[i] = x[i] - u[i][j] * x[j];
            }
            x[i] = x[i] / u[i][i];
        }
        for (int i = 0; i < n; i++) System.out.println("x[" + i + "] = " + x[i]);
        System.out.println("Error: " + estimateError(a, b, x) + "\n");
    }

    public double estimateError(double[][] a, double[] b, double[] x) {
        int n = b.length;
        double[] residual = new double[n];
        double[] aX = new double[n];
        for (int i = 0; i < n; i++) {
            aX[i] = 0.0;
            for (int j = 0; j < n; j++) {
                aX[i] += a[i][j] * x[j];
            }
            residual[i] = b[i] - aX[i];
        }
        double norm = 0.0;
        for (int i = 0; i < n; i++) {
            norm += residual[i] * residual[i];
        }
        norm = Math.sqrt(norm);
        return norm;
    }

    public void solveSquareRoot(double[][] a, double[] b) {
        int n = a.length;
        double[][] augmentedMatrix = new double[n][n + 1];
        System.out.println("Solution by the square root method:\n");
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = b[i];
        }
        for (int k = 0; k < n; k++) {
            int pivotRow = k;
            double pivotValue = Math.abs(augmentedMatrix[k][k]);
            for (int i = k + 1; i < n; i++) {
                double absValue = Math.abs(augmentedMatrix[i][k]);
                if (absValue > pivotValue) {
                    pivotRow = i;
                    pivotValue = absValue;
                }
            }
            if (pivotRow != k) {
                double[] tempRow = augmentedMatrix[k];
                augmentedMatrix[k] = augmentedMatrix[pivotRow];
                augmentedMatrix[pivotRow] = tempRow;
            }
            for (int i = k + 1; i < n; i++) {
                double factor = augmentedMatrix[i][k] / augmentedMatrix[k][k];
                for (int j = k + 1; j <= n; j++) {
                    augmentedMatrix[i][j] -= factor * augmentedMatrix[k][j];
                }
            }
        }
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += augmentedMatrix[i][j] * solution[j];
            }
            solution[i] = (augmentedMatrix[i][n] - sum) / augmentedMatrix[i][i];
        }
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "]=" + solution[i]);
        }
        System.out.println("Error: " + estimateError(a, b, solution));
    }

    public void print(double[][] a) {
        for (double[] doubles : a) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
