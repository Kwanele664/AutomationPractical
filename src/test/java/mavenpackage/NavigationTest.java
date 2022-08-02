package mavenpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenpackage.Helpers.CommonHelper;
import mavenpackage.Pages.HomePage;
import mavenpackage.Pages.NavigationPage;
import mavenpackage.TestData.GlobalVariable;

/**
 * TC6 – Create a generic test case that uses the Navigation Menu to navigate to a
         certain page. This test case needs to match the following criteria:
            a. It should cater for either hovering over or clicking the categories “Women,
               Dresses, T-Shirts”.
            b. If a subcategory is to be selected it should hover over the main category and
               select the subcategory.
            c. Use generic page objects to select the appropriate category or subcategory
               item.
            d. Verify the correct page has loaded
 */

public class NavigationTest {
    WebDriver driver;

    HomePage homePage;
    CommonHelper common;
    GlobalVariable globalVariable = new GlobalVariable();

    @Before
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        common = new CommonHelper(driver);
        common.LaunchBroswer(globalVariable.GetLaunchtUrl());

        Thread.sleep(2000);
    }

    @Test

    public void WomenCatergory(){
        HomePage homePage = new HomePage(driver);
      NavigationPage navigationPage = new NavigationPage(driver);
      homePage.GoToWomenCatergory();

      String women = "women";

      Assert.assertEquals(women.toUpperCase(), navigationPage.VerifyingIfPageHasLoaded());
    }

    @After
    public void QuitBrowser(){
     driver = new ChromeDriver();
     CommonHelper common = new CommonHelper(driver);
     common.QuitBroswer();
    }
}
