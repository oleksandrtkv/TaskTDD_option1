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
}
