package main;

public class Main {
    private final double a = -0.5;
    private final double b = 2.0;

    public double f(double x) {
        if (x <= 0.7) return 1;
        if (x > 1.4) return Math.exp(a*x) * Math.cos(b*x);
        return a * x * x * Math.log(x);
    }
}
