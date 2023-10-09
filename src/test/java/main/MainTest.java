package main;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    private final double EPS = 1e-6;

    Main main;

    @BeforeMethod
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testF() {
        double expected = 1;
        double x = 0.1;
        double actual = main.f(x);
        assertEquals(actual, expected, EPS);
    }
}