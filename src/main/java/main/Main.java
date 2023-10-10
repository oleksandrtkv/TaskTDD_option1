package main;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    private double EPS = 1e-6;
    private final double a = -0.5;
    private final double b = 2.0;

    public double f(double x) {
        if (x < 0.7 + EPS) return 1;
        if (x > 1.4 + EPS) return Math.exp(a * x) * Math.cos(b * x);
        return a * x * x * Math.log(x);
    }

    public int steps(double start, double end, double step) {
        return (int) Math.round((end - start) / step + 1);
    }

    public double[] fillX(double start, double end, double step) {
        return IntStream.range(0, steps(start, end, step)).mapToDouble(i -> start + i * step).toArray();
    }

    public double[] fillY(double[] x) {
        return DoubleStream.of(x).map(this::f).toArray();
    }

    public double sum(double[] arr) {
        return DoubleStream.of(arr).sum();
    }

    public double avg(double[] arr) {
        return DoubleStream.of(arr).average().orElse(0);
    }

    public int findIndexOfMin(double[] arr) {
        int indexOfMin = 0;
        double min = arr[indexOfMin];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                indexOfMin = i;
                min = arr[indexOfMin];
            }
        }
        return indexOfMin;
    }

    public int findIndexOfMax(double[] arr) {
        int indexOfMax = 0;
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                indexOfMax = i;
                max = arr[indexOfMax];
            }
        }
        return indexOfMax;
    }

    public void printMax(double[] x, double[] y){
        int indexOfMax = findIndexOfMax(y);
        double yMax = y[indexOfMax];
        double xMax = x[indexOfMax];

        System.out.printf("Ymax = %6.3f with x = %6.3f and index is %d\n", yMax, xMax, indexOfMax);
    }

    public void printMin(double[] x, double[] y){
        int indexOfMin = findIndexOfMin(y);
        double yMin = y[indexOfMin];
        double xMin = x[indexOfMin];

        System.out.printf("Ymin = %6.3f with x = %6.3f and index is %d\n", yMin, xMin, indexOfMin);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        double[] x = fillX(0.0, 3.0, 0.004);
        double[] y = fillY(x);
        double sum = sum(y);
        double avg = avg(y);
        printMax(x, y);
        printMin(x, y);
        System.out.printf("sum = %6.3f\navg = %6.3f\n", sum, avg);
    }
}