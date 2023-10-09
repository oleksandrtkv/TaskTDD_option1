package main;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        assertEquals(actual, expected, EPS);
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider.class)
    public void testSteps(double start, double end, double step, int expected) {
        int actual = main.steps(start, end, step);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillX")
    public void testFillX(int index, double expected) {
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;

        double[] actual = main.fillX(start, end, step);
        assertEquals(actual[index], expected, EPS);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataForFillY")
    public void testFillY(int index, double expected) {
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] actual = main.fillY(main.fillX(start, end, step));
        assertEquals(actual[index], expected, EPS);
    }
}