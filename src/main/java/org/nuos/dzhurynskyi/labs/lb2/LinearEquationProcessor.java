package org.nuos.dzhurynskyi.labs.lb2;

public class LinearEquationProcessor {

    public double halfDivision(double a, double b, double e) {
        if (numberOfRoots(a, b) && (b > a)) {
            double c = (a + b) / 2;
            int count = 1;
            while (Math.abs(f(c)) > e) {
                if ((f(c) * f(b)) < 0) {
                    a = c;
                } else b = c;
                c = (a + b) / 2;
                count++;
            }
            System.out.println("The number of iterations of the half division method: " + count);
            return c;
        } else {
            return 2E10;
        }
    }

    public double simpleIteration(double a, double b, double e) {
        if (numberOfRoots(a, b) && (b > a)) {
            double x0 = (a + b) / 2;
            int count = 0;
            double lambda = 1 / fDerivative(b);
            while (Math.abs(f(x0)) > e) {
                x0 = x0 - lambda * f(x0);
                if (x0 < a || x0 > b) {
                    return 2E33;
                }
                count++;
            }
            System.out.println("The number of iterations of the simple iteration method: " + count);
            return x0;
        }
        return 2E10;
    }

    public double newtonsMethod(double a, double b, double e) {
        if (numberOfRoots(a, b) && (b > a)) {
            double x = 0;
            int count = 0;
            if (Math.abs(fDerivative(x)) < 1E-10) {
                return 2E20;
            }
            if (f(a) * fSecondDerivative(a) > 0) {
                x = a;
            }
            if (f(b) * fSecondDerivative(b) >= 0) {
                x = b;
            }
            do {
                double amendment = f(x) / fDerivative(x);
                x = x - amendment;
                count++;
            } while (Math.abs(f(x)) > e);
            System.out.println("Number of iterations of Newton's method: " + count);
            return x;
        } else return 2E10;
    }

    public double chordMethod(double a, double b, double e) {
        int count = 1;
        if (numberOfRoots(a, b) && (b > a)) {
            double c = b - (f(b) * (b - a)) / (f(b) - f(a));
            while (Math.abs(f(c)) > e) {
                c = b - (f(b) * (b - a)) / (f(b) - f(a));
                if ((f(a) * f(c)) > 0) a = c;
                else b = c;
                count++;
            }
            System.out.println("The number of iterations of the chord method: " + count);
            return c;
        }
        return 2E10;
    }

    public String errorChecker(double res) {
        if (res == 2E10) return "You have entered an incorrect isolation interval. Maybe it has more than 1 root.";
        if (res == 2E20) return "Division by zero is impossible";
        return String.valueOf(res);
    }

    private boolean numberOfRoots(double a, double b) {
        if (f(a) * f(b) >= 0) return false;
        return (fDerivative(a) > 0 && fDerivative(b) > 0) ||
                (fDerivative(a) < 0 && fDerivative(b) < 0);
    }

    public double f(double x) {
        return Math.tan(0.5 * x + 0.2) - x * x;
    }

    private double fDerivative(double x) {
        return -2 * x + ((0.5) / (Math.pow(Math.cos(0.5 * x + 0.2), 2)));
    }

    private double fSecondDerivative(double x) {
        return 0.5 * (Math.sin(0.5 * x + 0.2) / Math.pow(Math.cos(0.5 * x + 0.2), 3)) - 2;
    }
}
