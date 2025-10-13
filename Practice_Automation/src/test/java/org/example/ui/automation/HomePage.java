package org.example.ui.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//div[@class='_3sdu8W emupdz']/a")
    List<WebElement> allLinks;

    //WebElements of Electronics Menu
    @FindBy(css="a[aria-label='Electronics']")
    WebElement menuElectronics;

    @FindBy(xpath = "//div[@class='_16rZTH']/object/a[text()='Laptop and Desktop']")
    WebElement subMenuLaptopsDesktops;

    @FindBy(xpath="//div[@class='_31z7R_']/object/a[text()='Laptops']")
    WebElement itemLaptops;

    @FindBy(css="img[class='xTaogf _3iTqAS']")
    List<WebElement> saleImages;

    @FindBy(css="div.mt4CeI")
    List<WebElement> eleTopElements;
    /*//WebElements of Home&Furnitures Menu
    @FindBy(css="div[aria-label='Home & Furniture']")
    WebElement menuHomeNFurnitures;

    @FindBy(xpath = "//div[@class='_16rZTH']/object/a[text()='Tools & Utility']")
    WebElement subMenuToolsnUtility;

    @FindBy(xpath="//div[@class='_31z7R_']/object/a[text()='Hand tools']")
    WebElement itemHandTools;*/

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String validate_HomePage_Title(){
        String expected_Title = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        wait.until(ExpectedConditions.visibilityOfAllElements(allLinks));
        Assert.assertEquals(driver.getTitle(),expected_Title,"The home page title is not shown exactly");
        return driver.getTitle();
    }

    public void searchForTheItem(String menu){
        switch(menu){
            case "Electronics" :
                navigateToSearchItemPage(menuElectronics,subMenuLaptopsDesktops,itemLaptops);
                break;

            /*case "Home & Furniture":
                navigateToSearchItemPage(menuHomeNFurnitures,subMenuToolsnUtility,itemHandTools);
                break;*/
        }
    }

    public void navigateToSearchItemPage(WebElement mainMenu,WebElement subMenu,WebElement item){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(mainMenu));
        mainMenu.click();
        /*actions.moveToElement(mainMenu).perform();
        actions.moveToElement(subMenu).perform();
        item.click();*/
    }

    public void checkImageAndClick(){
        for(WebElement img : saleImages) {
            if (img.isDisplayed()) {
                img.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfAllElements(eleTopElements));
        for(WebElement ele : eleTopElements){
            System.out.println(ele.getText());
        }
    }
}
