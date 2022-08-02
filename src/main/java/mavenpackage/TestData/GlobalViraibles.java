package mavenpackage.TestData;

import org.openqa.selenium.WebDriver;

import mavenpackage.Models.LoginModel;

public class GlobalViraibles {
    
    WebDriver driver;

    private String websiteUrl = "http://automationpractice.com";

    private String email = "AutomationDemo@gmail.com";

    private String password = "Test@123";

    LoginModel credentials = new LoginModel(email, password);

    public String GetLaunchtUrl(){
    return websiteUrl;  
    }

    public void LoginCredentialsDetails( String email, String password){
      this.email = email;
      this.password =password;
    }

    public LoginModel GetCredentialsDetails(){
        return credentials;
    }
}
