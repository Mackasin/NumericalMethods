package org.nuos.dzhurynskyi.labs.lb1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Operations {
    Scanner scanner = new Scanner(System.in);

    public void productOfVectorAndScalar() {
        int size = enterData("Enter the size of vector:");
        if (size <= 0) {
            System.out.println("Size less than 0 or equals 0");

        } else {
            int[] vector = new int[size];
            int scalar = enterData("Enter the scalar:");
            fillVector(vector);
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= scalar;
            }
            System.out.println(Arrays.toString(vector));
        }
    }

    public void sumOfTwoVectors() {
        int sizes = enterData("Enter the size of vectors:");
        if (sizes <= 0) {
            System.out.println("Sizes less than 0 or equals 0");
        } else {
            int[] vector1 = new int[sizes];
            int[] vector2 = new int[sizes];
            System.out.println("Enter vector1:");
            fillVector(vector1);
            System.out.println("Enter vector2:");
            fillVector(vector2);
            for (int i = 0; i < vector2.length; i++) {
                vector1[i] += vector2[i];
            }
            System.out.println(Arrays.toString(vector1));
        }
    }

    public void scalarProductOfVectors() {
        int sizes = enterData("Enter the size of vectors:");
        if (sizes <= 0) {
            System.out.println("Sizes less than 0 or equals 0");
        } else {
            int sum = 0;
            int[] vector1 = new int[sizes];
            int[] vector2 = new int[sizes];
            System.out.println("Enter vector1:");
            fillVector(vector1);
            System.out.println("Enter vector2:");
            fillVector(vector2);
            for (int i = 0; i < vector2.length; i++) {
                vector1[i] *= vector2[i];
                sum += vector1[i];
            }
            System.out.println("Scalar product of vectors= " + sum);
        }
    }

    public void modulusOfVector() {
        int size = enterData("Enter the size of vector:");
        if (size <= 0) {
            System.out.println("Size less than 0 or equals 0");

        } else {
            double modul = 0;
            int[] vector = new int[size];
            fillVector(vector);
            for (int i = 0; i < vector.length; i++) {
                vector[i] = vector[i] * vector[i];
                modul = modul + vector[i];
            }
            modul = Math.sqrt(modul);
            System.out.println("Vector modulus= " + modul);
        }
    }

    public void transpontMatrix() {
        int size1 = enterData("Enter the length of rows:");
        int size2 = enterData("Enter the length of cols:");
        if (size1 <= 0 || size2 <= 0) {
            System.out.println("Size less than 0 or equals 0");
        } else {
            int[][] matrix = new int[size1][size2];
            int[][] transpMatrix = new int[size2][size1];
            System.out.println("Enter data:");
            fillMatrix(matrix);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    transpMatrix[j][i] = matrix[i][j];
                }
            }
            System.out.println("result");
            printMatrix(transpMatrix);
        }
    }

    public void productOfMatrixAndScalar() {
        int size1 = enterData("Enter the length of rows:");
        int size2 = enterData("Enter the length of cols:");
        if (size1 <= 0 || size2 <= 0) {
            System.out.println("Size less than 0 or equals 0");
        } else {
            int[][] matrix = new int[size1][size2];
            int scalar = enterData("Enter the scalar:");
            System.out.println("Enter data:");
            fillMatrix(matrix);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] *= scalar;
                }
            }
            System.out.println("result");
            printMatrix(matrix);
        }
    }

    public void productOfMatrixAndVector() {
        int size1 = enterData("Enter the length of rows:");
        int size2 = enterData("Enter the length of cols:");
        int size3 = enterData("Enter the length of vector:");
        if (size1 <= 0 || size2 <= 0 || size3 <= 0) {
            System.out.println("Size less than 0 or equals 0");
        } else if ((size2 != size3)) {
            System.out.println("We cant take product of matrix and vector, the number of rows in the vector is equal to the number of columns in the matrix.");
        } else {
            ifWeHaveMatrixAndVector(size1, size2, size3);
        }
    }

    private void ifWeHaveMatrixAndVector(int size1, int size2, int size3) {
        int[] res = new int[size1];
        int[][] matrix = new int[size1][size2];
        int[] vector = new int[size3];
        System.out.println("Enter numbers of matrix:");
        fillMatrix(matrix);
        System.out.println("Enter numbers of vector:");
        fillVector(vector);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[i] += matrix[i][j] * vector[j];
            }
        }
        System.out.println("result");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public void sumOfTwoMatrices() {
        int size1 = enterData("Enter the length of rows:");
        int size2 = enterData("Enter the length of cols:");
        if (size1 <= 0 || size2 <= 0) {
            System.out.println("Size less than 0 or equals 0");
        } else {
            int[][] matrix1 = new int[size1][size2];
            int[][] matrix2 = new int[size1][size2];
            System.out.println("Enter numbers of matrix1:");
            fillMatrix(matrix1);
            System.out.println("Enter numbers of matrix2:");
            fillMatrix(matrix2);
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    matrix1[i][j] += matrix2[i][j];
                }
            }
            System.out.println("Result");
            printMatrix(matrix1);
        }
    }

    public void productOfTwoMatrices() {
        int size1 = enterData("Enter the length of matrix1 rows:");
        int size2 = enterData("Enter the length of matrix1 cols:");

        int size3 = enterData("Enter the length of matrix2 rows:");
        int size4 = enterData("Enter the length of matrix2 cols:");

        if (size1 <= 0 || size2 <= 0 || size3 <= 0 || size4 <= 0) {
            System.out.println("Size less than 0 or equals 0");
        } else if(size1 == 1 || size2 == 1 || size3 == 1){
            System.out.println("Size cannot equals 1 in matrix1");
        }else if ((size2 != size3)) {
            System.out.println("We cant take product of matrix1 and matrix2.\nYou can only multiply a matrix by a matrix if they are the same size or if the number of columns in the matrix1 matches the number of rows in the matrix2.");
        } else {
            if (size4 > 1) {
                int[][] res = new int[size1][size4];
                int[][] matrix1 = new int[size1][size2];
                int[][] matrix2 = new int[size3][size4];
                System.out.println("Enter numbers of matrix1:");
                fillMatrix(matrix1);
                System.out.println("Enter numbers of matrix2:");
                fillMatrix(matrix2);
                for (int i = 0; i < size1; i++) {
                    for (int k = 0; k < size4; k++) {
                        for (int j = 0; j < size3; j++) {
                            res[i][k] += matrix1[i][j] * matrix2[j][k];
                        }
                    }
                }
                System.out.println("result");
                printMatrix(res);
            } else {
                ifWeHaveMatrixAndVector(size1, size2, size3);
            }
        }
    }


    private int[] fillVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = enterData("Enter element " + i + ":");
        }
        return vector;
    }

    private int[][] fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int enterData(String n1) {
        int data = 0;
        Callable<Integer> dataInput = () -> {

            System.out.println(n1);

            int data1;

            try {
                data1 = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException err) {

                System.out.println("Input value uncorrected");
                scanner.next();
                return -1;
            }

            return data1;
        };

        try {
            do {
                data = dataInput.call();

            } while (data == -1);

        } catch (Exception err) {

            err.printStackTrace();
        }
        return data;
    }
}
