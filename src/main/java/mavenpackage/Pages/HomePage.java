package mavenpackage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private void ClickSignInLink(){
        WebElement signIn = driver.findElement(By.className("login"));
        signIn.click();
    }

    public void GoToLoginPage(){
        this.ClickSignInLink();
    }

    private void ClickWomenCategory(){
        WebElement womenCategory = driver.findElement(By.className("sf-with-ul"));
        womenCategory.click();
    }

    public void GoToWomenCatergory(){
        this.ClickWomenCategory();
    }
}
