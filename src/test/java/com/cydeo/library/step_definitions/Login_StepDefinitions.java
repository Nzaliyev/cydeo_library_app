package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa3_url"));
    }
    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.email_input.sendKeys(username);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.password_input.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signIn_Btn.click();
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expectedUrl = "dashboard";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("Url verification process failed",actualUrl.contains(expectedUrl));
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa3_url"));
    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.email_input.sendKeys(ConfigurationReader.getProperty("librarian_username"));
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.password_input.sendKeys(ConfigurationReader.getProperty("librarian_password"));
        loginPage.signIn_Btn.click();
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.email_input.sendKeys(ConfigurationReader.getProperty("student_username"));
    }

    @And("user enters student password")
    public void user_enters_student_password() {
        loginPage.password_input.sendKeys(ConfigurationReader.getProperty("student_password"));
        loginPage.signIn_Btn.click();
    }

    @And("there should be {string} users")
    public void there_should_be_users(String users) {
        String usersCount = Driver.getDriver().findElement(By.id("user_count")).getText();
        System.out.println("usersCount = " + usersCount);
        Assert.assertEquals("Users number verification failed!",users,usersCount);
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String expectedUrl = "dashboard";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("Url verification process failed",actualUrl.contains(expectedUrl));
    }
}
