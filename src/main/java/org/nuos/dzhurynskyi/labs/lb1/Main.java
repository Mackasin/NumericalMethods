package org.nuos.dzhurynskyi.labs.lb1;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        StringBuilder stringBuilder = new StringBuilder();

        boolean bool = true;

        stringBuilder
                .append("1) product of a vector and a scalar;\n")
                .append("2) sum of two vectors;\n")
                .append("3) scalar product of vectors;\n")
                .append("4) vector module;\n")
                .append("5) matrix transposition;\n")
                .append("6) the product of a matrix and a scalar;\n")
                .append("7) the product of a matrix and a vector;\n")
                .append("8) sum of two matrices;\n")
                .append("9) product of two matrices;\n")
                .append("0) exit.\n");

        while (bool == true) {

            System.out.println(stringBuilder);

            int key = operations.enterData("Enter a key:");

            switch (key) {
                case 1 -> operations.productOfVectorAndScalar();
                case 2 -> operations.sumOfTwoVectors();
                case 3 -> operations.scalarProductOfVectors();
                case 4 -> operations.modulusOfVector();
                case 5 -> operations.transpontMatrix();
                case 6 -> operations.productOfMatrixAndScalar();
                case 7 -> operations.productOfMatrixAndVector();
                case 8 -> operations.sumOfTwoMatrices();
                case 9 -> operations.productOfTwoMatrices();
                case 0 -> bool = false;
            }
        }
    }
}
