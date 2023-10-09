package main;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "dataForTest")
    public static Object[][] createDataForTestF(){
        return new Object[][]{
                {0.1, 1.0},
                {2.0, -0.240462},
                {1.1, -0.057662}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForTestSteps(){
        return new Object[][]{
                {0.0, 1.0, 0.1, 11},
                {0.0, 3.0, 0.004, 751}
        };
    }

    @DataProvider(name = "dataForFillX")
    public static Object[][] createDataForFillX(){
        return new Object[][]{
                {0, 0.0},
                {175, 0.7},
                {350, 1.4},
                {750, 3.0}
        };
    }

    @DataProvider(name = "dataForFillY")
    public static Object[][] createDataForFillY(){
        return new Object[][]{
                {0, 1.0},
                {175, 1.0},
                {350, -0.329742},
                {750, 0.214243}
        };
    }
}
