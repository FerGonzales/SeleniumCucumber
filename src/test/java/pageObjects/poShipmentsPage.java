package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitHelper;

import java.util.List;

public class poShipmentsPage {
    public WebDriver ldriver;
    WaitHelper waitHelper;

    public poShipmentsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waitHelper = new WaitHelper(ldriver);
    }

    @FindBy(how = How.CSS, using = ".btn-success")
    @CacheLookup
    WebElement btnNew;

    @FindBy(how = How.CSS, using = ".btn-custom")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.CSS, using = ".btn-danger")
    @CacheLookup
    WebElement btnReset;

    @FindBy(how = How.ID, using = "idCustomer")
    @CacheLookup
    WebElement cmbCustomer;

    @FindBy(how = How.CSS, using = ".table-striped tr td.mat-column-customer")
    @CacheLookup
    List <WebElement> columnCustomer;

    public void clickBtnNew() {
        btnNew.click();
    }

    public void clickBtnSearch() {
        btnSearch.click();
    }

    public void clickBtnReset() {
        btnReset.click();
    }

    public void clickCmbCustomer() {
        cmbCustomer.click();
    }

    public void selectCustomerOption(String value) {
        waitHelper.waitForElement(cmbCustomer,20);
        Select drpCustomer=new Select(cmbCustomer);
        drpCustomer.selectByVisibleText(value);
    }

    public List<String> getTextColumnCustomer (){
        List<String> listElements = null;
        for(WebElement e : columnCustomer) {
            listElements.add(e.getText());
        }
        return listElements;
    }

}
