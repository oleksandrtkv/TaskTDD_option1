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
}