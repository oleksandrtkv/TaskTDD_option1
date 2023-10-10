package main;

import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class MainTest {

    private final double EPS = 1e-6;

    Main main;

    @BeforeMethod
    public void setUp() {
        main = new Main();
    }

    @Test(dataProvider = "dataForTest", dataProviderClass = StaticDataProvider.class)
    public void testF(double x, double expected) {
        double actual = main.f(x);
        assertThat(actual).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider.class)
    public void testSteps(double start, double end, double step, int expected) {
        int actual = main.steps(start, end, step);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillX")
    public void testFillX(int index, double expected) {
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;

        double[] actual = main.fillX(start, end, step);
        assertThat(actual[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillY")
    public void testFillY(int index, double expected) {
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] actual = main.fillY(main.fillX(start, end, step));
        assertEquals(actual[index], expected, EPS);
    }

    @Test
    public void testSum() {
        double[] arr = {1.1, 2.5, -7.0, 10.0, 0.5};
        double expected = 7.1;
        double actual = main.sum(arr);
        assertEquals(actual, expected, EPS);
    }

    @Test
    public void testAvg() {
        double[] arr = {1.1, 2.5, -7.0, 10.0, 0.5};
        double expected = 1.42;
        double actual = main.avg(arr);
        assertEquals(actual, expected, EPS);
    }

    @Test
    public void testFindIndexOfMin() {
        double[] arr = {1.1, 2.5, -7.0, 10.0, 0.5};
        int expected = 2;
        int actual = main.findIndexOfMin(arr);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindIndexOfMax() {
        double[] arr = {1.1, 2.5, -7.0, 10.0, 0.5};
        int expected = 3;
        int actual = main.findIndexOfMax(arr);
        assertEquals(actual, expected);
    }
}