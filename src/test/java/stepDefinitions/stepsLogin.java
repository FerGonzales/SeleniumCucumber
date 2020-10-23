package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.poLoginPage;
import pageObjects.poShipmentsPage;

import java.util.Collections;

public class stepsLogin {
    public WebDriver driver;
    public poLoginPage lp;
    public poShipmentsPage sp;

    @Given("User Launch Chrome browser")
    public void userLaunchChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new poLoginPage(driver);
        sp = new poShipmentsPage(driver);

    }

    @Given("User Launch FireFox browser")
    public void userLaunchFireFoxBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        lp = new poLoginPage(driver);
    }

    @When("User opens URL {string}")
    public void userOpensURL(String urlValue) {
        driver.get(urlValue);
    }

    @And("User enters User as {string} and Password as {string}")
    public void userEntersUserAsAndPasswordAs(String userValue, String passwordValue) {
        lp.setTxtUser(userValue);
        lp.setTxtPassword(passwordValue);
    }

    @And("Click on Login")
    public void clickOnLogin() {
        lp.clickBtnLogin();
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String titleExpected) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.assertTrue(false);
        } else
            Assert.assertEquals(titleExpected, driver.getTitle());
    }

    @When("User click on Logout link")
    public void userClickOnLogoutLink() {
        lp.clickLnkLogout();
    }

    @And("Close Browser")
    public void closeBrowser() {
        driver.quit();
    }

    @Then("System should return an error message")
    public void systemShouldReturnAnErrorMessage() {
        Assert.assertTrue(lp.lblErrorMessageDisplayed());

    }

    @Then("Login button should be disabled")
    public void loginButtonShouldBeDisabled() {
        Assert.assertFalse(lp.isBtnLoginEnabled());
    }

    @When("User select {string} on dropdown Customer")
    public void userSelectOnDropdownCustomer(String option) {
        sp.selectCustomerOption(option);
    }

    @And("Click on Search button")
    public void clickOnSearchButton() {
        sp.clickBtnSearch();
    }


    @Then("The column Customer on the grip should contain {string} text")
    public void theColumnCustomerOnTheGripShouldContainText(String value) {
        Assert.assertTrue(sp.getTextColumnCustomer().containsAll(Collections.singleton(value)));
    }

    @When("CLick on Customer dropdown")
    public void clickOnCustomerDropdown() {
        sp.clickCmbCustomer();
    }
}
