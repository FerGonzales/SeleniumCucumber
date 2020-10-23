package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepsOpenSkyHomePage {
    WebDriver driver;
    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","C://Drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Then("I verify that the logo present on page")
    public void i_verify_that_the_logo_present_on_page() {
        boolean status=driver.findElement(By.cssSelector(".account-logo-box")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    @When("I open OpenSky homepage")
    public void iOpenOpenSkyHomepage() {
        driver.get("https://opensky-bi.azurewebsites.net/login");

    }
}
