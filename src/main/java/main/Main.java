package main;

public class Main {
    private double EPS = 1e-6;
    private final double a = -0.5;
    private final double b = 2.0;

    public double f(double x) {
        if (x < 0.7 + EPS) return 1;
        if (x > 1.4 + EPS) return Math.exp(a*x) * Math.cos(b*x);
        return a * x * x * Math.log(x);
    }

    public int steps(double start, double end, double step) {
        return (int) Math.round((end - start) / step + 1);
    }

    public double[] fillX(double start, double end, double step) {
        double[] x = new double[steps(start, end, step)];
        for (int i = 0; i < x.length; i++){
            x[i] = start + i * step;
        }
        return x;
    }

    public double[] fillY(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++){
            y[i] = f(x[i]);
        }
        return y;
    }
}
