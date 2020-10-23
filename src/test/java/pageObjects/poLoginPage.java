package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class poLoginPage {
    public WebDriver ldriver;
    WaitHelper waitHelper;
    public poLoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper= new WaitHelper(ldriver);
    }
    @FindBy(how = How.ID, using = "userLogin")
    @CacheLookup
    WebElement txtUser;

    @FindBy(how = How.ID, using ="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(how = How.CSS, using =".btn-lg")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(how = How.CSS, using =".alert-danger")
    @CacheLookup
    WebElement lblErrorMessage;

    @FindBy(how = How.CSS, using =".mdi-logout")
    @CacheLookup
    WebElement lnkLogout;

    public void setTxtUser(String value){
        waitHelper.waitForElement(txtUser,20);
        txtUser.clear();
        txtUser.sendKeys(value);
    }

    public void setTxtPassword(String value){
        txtPassword.clear();
        txtPassword.sendKeys(value);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public void clickLnkLogout(){
        waitHelper.waitForElement(lnkLogout,20);
        lnkLogout.click();
    }
    public boolean lblErrorMessageDisplayed(){
        return lblErrorMessage.isDisplayed();
    }

    public boolean isBtnLoginEnabled(){
        return btnLogin.isEnabled();
    }
}
