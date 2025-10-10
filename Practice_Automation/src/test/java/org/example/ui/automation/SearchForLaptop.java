package org.example.ui.automation;

import org.example.ui.automation.utility.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchForLaptop extends BaseTest{

    @Test(dataProvider = "data",dataProviderClass = TestData.class)
    public void checkForItemsUsingMenu(String testData){
        /*
         Validate the title of the HomePage of Flipkart
         */
        HomePage homePage = new HomePage(driver);
        String homePageTitle = homePage.validate_HomePage_Title();
        System.out.println("The home page title is " + homePageTitle);

        /*Search for the item in the HomePage*/
        homePage.searchForTheItem(testData);
        System.out.println("The title of the item page is " + driver.getTitle());
    }
}
