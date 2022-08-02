package mavenpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonException;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenpackage.Pages.*;
import mavenpackage.Helpers.*;
import mavenpackage.TestData.*;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.io.*;

/**
 *TC1 - Navigate to http://automationpractice.com/ perform a search and verify the first
        result matches your search criteria.
 *TC2 – Repeat TC1 adding the following criteria:
        a. Store 3 search criteria in one variable separated by commas.
           Example: String searchCriteria = “search1,search2,search3”.
        b. Manipulate the string and store each search criteria in an array and use a
           loop to perform the search and verify.
 *TC3 – Repeat TC1 again this time using a data driven approach using an external
        datafile such as an excel spreadsheet or text file.
 */

public class SearchTest {
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
    public void SearchWithSingleText(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchText(searchTestData.GetSingleSearchText());

         Assert.assertTrue(searchPage.GetSearchResult().contains(searchTestData.GetSingleSearchText()), "Name not found");
    }

    @Test 
    public void SearchWithStringManupulation(){
       
        String textOne = searchTestData.GetMultipleSearchText();

        String[] searchArray = new String[3];
        searchArray[0] = textOne.substring(0, textOne.indexOf(",")).trim();
        searchArray[1] = textOne.substring(textOne.indexOf(",") + 1, textOne.lastIndexOf(",")).trim();
        searchArray[2] = textOne.substring(textOne.lastIndexOf(",") +1).trim();

        for (String strTemp : searchArray){
            SearchPage searchPage = new SearchPage(driver);
           searchPage.SearchText(strTemp);

         Assert.assertTrue(searchPage.GetSearchResult().contains(strTemp), "Name not found");
            System.out.println(strTemp);
        }

    }

    @Test
    public void SearchUsingJsonFile()  throws FileNotFoundException, IOException, ParseException{
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("./Search.json");
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject)object;

        String savedString = (String) jsonObject.get("SearchText");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchText(savedString);

        Assert.assertTrue(searchPage.GetSearchResult().contains(savedString), "Name not found");
        
    }


    @After
    public void QuitBrowser(){
     driver = new ChromeDriver();
     CommonHelper common = new CommonHelper(driver);
     common.QuitBroswer();
    }
    
}
