package mavenpackage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import mavenpackage.Pages.*;
import mavenpackage.Helpers.*;
import mavenpackage.TestData.*;

/**
 * TC5:This test case needs to have the following steps:
    a. Add an item to shopping your cart.
    b. View shopping cart.
    c. Increase quantity to a desired amount.
    d. Calculate total (unit price x quantity): You will need to create a custom
        method/keyword that does the following:
            i. Accepts 2 variables "unit price, quantity".
            ii. Calculates and returns the result.
    e. Verify displayed total matches calculated total.
 */

public class AddToCartTest {
   
    WebDriver driver;

    SearchPage searchPage;
    CommonHelper common;
    GlobalVariable globalVariable = new GlobalVariable();
    SearchTestData searchTestData = new SearchTestData();

    @Before
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        common = new CommonHelper(driver);
        common.LaunchBroswer(globalVariable.GetLaunchtUrl());

        Thread.sleep(3000);
    }

    @Test
    public void AddItemToCart() throws InterruptedException {
        searchPage = new SearchPage(driver);
        searchPage.SearchText(searchTestData.GetSingleSearchText());

        Thread.sleep(2000);
        searchPage.ClickToAddToCartButton();

        Assert.assertTrue("Product successfully added to your shopping cart", searchPage.AddToCartConfirmationResult());
    }

    @Test
    public void ViewItemInCart() throws InterruptedException {
       
        AddToCartTest addToCartTest = new AddToCartTest();
        addToCartTest.AddItemToCart();

        Thread.sleep(1000);

        searchPage.ViewCart();

        Assert.assertEquals("SHOPPING-CART SUMMARY",searchPage.ViewCartConfirmationResult().toUpperCase());
        ;
        
    }
    @Test
    public void IncreaseQtyAmount() throws InterruptedException {
        AddToCartTest addToCartTest = new AddToCartTest();
        addToCartTest.ViewItemInCart();

        Thread.sleep(1000);

        searchPage.ClickButtonToIncreaseQty();

    }

    @Test
    public double  CalculateTotalAmount(){
        SearchPage searchPage = new SearchPage(driver);

        int quantity = searchPage.SelectedQuantity();

        double unitPrice = searchPage.SelectedUnitPrice();

        return quantity*unitPrice;  
    }

    @After
    public void QuitBrowser(){
     driver = new ChromeDriver();
     CommonHelper common = new CommonHelper(driver);
     common.QuitBroswer();
    }
}
