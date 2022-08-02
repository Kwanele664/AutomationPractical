package mavenpackage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver; 
    

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void SetEmail(String emailText){
        WebElement emailTextbox = driver.findElement(By.id("email"));
        emailTextbox.sendKeys(emailText);  
    }

    public void SetPassoword(String passwordText){
        WebElement passwordTextbox = driver.findElement(By.id("passwd"));
        passwordTextbox.sendKeys(passwordText);
    }

    public void ClickLoginButton(){
        WebElement loginButton = driver.findElement(By.id("SubmitLogin"));
        loginButton.click(); 

    }

    public void LogIn(String emailText, String passwordTex){
        this.SetEmail(emailText);
        this.SetPassoword(passwordTex);
        this.ClickLoginButton();
    }

    public Boolean IsErrorMessageShowing(){
        WebElement errorMessage = driver.findElement(By.className("alert alert-danger"));
        if(errorMessage.isDisplayed()){
        return true;
        }
        else
       return false;

    } 
}
