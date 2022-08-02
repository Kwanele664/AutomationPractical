package mavenpackage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage {

    WebDriver driver;

    public NavigationPage(WebDriver driver){

        this.driver = driver;

    }

    public String VerifyingIfPageHasLoaded(){
        WebElement verifyPageLoad = driver.findElement(By.className("title_block"));
        return verifyPageLoad.getText();
    }
}
