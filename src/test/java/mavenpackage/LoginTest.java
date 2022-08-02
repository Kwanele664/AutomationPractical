package mavenpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;
import mavenpackage.Pages.*;
import mavenpackage.Helpers.*;
import mavenpackage.TestData.*;

/**
 * TC_4:Sign into the website using a username and password stored as a global
    variable.
 */
public class LoginTest {
    WebDriver driver;
    
    SearchPage searchPage;
    HomePage homePage;
    LoginPage loginPage;
    
    CommonHelper commonHelper;
    GlobalVariable globalVariable = new GlobalVariable();
    SearchTestData searchTestData = new SearchTestData();

    @Before
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        CommonHelper common = new CommonHelper(driver);
        common.LaunchBroswer(globalVariable.GetLaunchtUrl());

        Thread.sleep(2000);
    }

    @Test
    public void LoginWithCorrectCredentials() {
        homePage = new HomePage(driver);
        homePage.GoToLoginPage();

        loginPage = new LoginPage(driver);
        loginPage.LogIn(globalVariable.GetCredentialsDetails().email,globalVariable.GetCredentialsDetails().Password);

        Assert.assertFalse(loginPage.IsErrorMessageShowing());
        
    }

    @After
    public void QuitBrowser(){
     driver = new ChromeDriver();
     CommonHelper common = new CommonHelper(driver);
     common.QuitBroswer();
    } 
}
