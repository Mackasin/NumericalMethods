package org.nuos.dzhurynskyi.labs.lb3;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run() {
        LinearSolver solver = new LinearSolver();
        double[][] a =
                {{1.2, -0.2, 0.3},
                {0.2, 1.6, -0.1},
                {-0.3, 0.1, -1.5}};
        double[] b = {-0.6, 0.3, 0.4};
        solver.print(a);
        double[][] aCopy = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) aCopy[i] = Arrays.copyOf(a[i], a[i].length);
       solver.solveGauss(aCopy, b);

        solver.solveLU(aCopy, b);
        solver.solveSquareRoot(aCopy, b);
    }
}
