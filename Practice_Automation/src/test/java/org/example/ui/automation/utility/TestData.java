package org.example.ui.automation.utility;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "data")
    public String[][] menuData(){
        String[][] inputDetails = {{"Electronics"},{"Home & Furniture"}};
        return inputDetails;
    }
}
