package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "inputEmail")
    public WebElement email_input;

    @FindBy(id = "inputPassword")
    public WebElement password_input;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signIn_Btn;

    public void login(String username,String password){
        email_input.sendKeys(ConfigurationReader.getProperty("librarian_username"));
        password_input.sendKeys(ConfigurationReader.getProperty("librarian_password"));
    }

}
