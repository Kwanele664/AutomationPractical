package mavenpackage.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void SetSearchText(String searchTex){
       WebElement searchTextbox = driver.findElement(By.name("search_query"));
        searchTextbox.sendKeys(searchTex);
    }

    public void ClickSearchButton(){
        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
    }

    public void SearchText(String searchTex){
        this.SetSearchText(searchTex);
        this.ClickSearchButton();
    }

    public String GetSearchResult(){
        WebElement searchResult = driver.findElement(By.xpath("//h5[@itemprop='name']/a[@class='product-name']"));
        return searchResult.getText();
    }


    public void ClickMoreToAddToCart(){
        WebElement viewMore = driver.findElement(By.xpath("//a[@itemprop='url']/a[@class='button lnk_view btn btn-default']"));
        viewMore.click();
    }

    public void ClickToAddToCartButton(){
        WebElement addToCart = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
        addToCart.click();
    }

    public Boolean AddToCartConfirmationResult(){
        WebElement addtocartresult = driver.findElement(By.className("icon-ok"));
        if(addtocartresult.isDisplayed()){
            return true;
        }
        else
         return false;
    }

    public void ViewCart(){
        WebElement viewcart = driver.findElement(By.className("btn btn-default button button-medium"));
        viewcart.click();
    }

    public String ViewCartConfirmationResult(){
        WebElement viewtocartresult = driver.findElement(By.id("cart_title"));
        return viewtocartresult.getText();
    }

    public void ClickButtonToIncreaseQty(){
        WebElement quantity = driver.findElement(By.id("cart_quantity_up_5_19_0_0"));
        quantity.click();
    }

    
    public double SelectedUnitPrice(){
        WebElement unitPrice = driver.findElement(By.id("total_product"));
        return Double.parseDouble(unitPrice.toString());
    }

    
    public int SelectedQuantity(){
        WebElement quantity = driver.findElement(By.className("cart_quantity text-center"));
        //Here I use a substring to remove the $ sign from the unit price.. 
        return Integer.parseInt(quantity.toString().substring(1)); 
    }
}
