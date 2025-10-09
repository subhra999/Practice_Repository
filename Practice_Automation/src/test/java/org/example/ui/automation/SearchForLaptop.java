package org.example.ui.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchForLaptop extends BaseTest{

    @Test
    public void checkForLaptops(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_3sdu8W emupdz']/a")));
        System.out.println("The title of the flipkart site is " + driver.getTitle());

        Actions actions = new Actions(driver);
        WebElement eleElectronics =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Electronics']")));

        actions.moveToElement(eleElectronics).perform();
        WebElement subMenuComputerLink = driver.findElement(By.xpath("//div[@class='_16rZTH']/object/a[text()='Laptop and Desktop']"));
        actions.moveToElement(subMenuComputerLink).perform();

        WebElement subMenuWiredHeadPhones = driver.findElement(By.xpath("//div[@class='_31z7R_']/object/a[text()='Laptops']"));
        subMenuWiredHeadPhones.click();

        System.out.println("The title of the Laptops page is " + driver.getTitle());
    }
}
