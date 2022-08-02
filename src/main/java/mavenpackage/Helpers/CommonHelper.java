package mavenpackage.Helpers;

import org.openqa.selenium.WebDriver;

public class CommonHelper {
    
    WebDriver driver;

    public CommonHelper(WebDriver driver) {
        this.driver = driver;
	}

	public void LaunchBroswer(String url){
        this.driver.get(url);
    }

    public void QuitBroswer(){
        this.driver.quit();
    }
}
