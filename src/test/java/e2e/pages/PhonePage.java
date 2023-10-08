package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonePage extends Header {

    public PhonePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "(//*[@role=\"tab\"])[2]")
    private WebElement phoneButton;

    @FindBy(id = "btn-add-phone")
    private WebElement addPhoneNumberButton;

    @FindBy(className = "row-table-cc")
    private WebElement savedPhoneCode;

    @FindBy(className = "row-table-pn")
    private WebElement savedPhoneNumber;


    public void waitForLoading(){
        getWait().forVisibility(addPhoneNumberButton);
    }


    public void clickPhoneButton(){
        phoneButton.click();
    }

    public void clickAddPhoneButton(){
        addPhoneNumberButton.click();
    }

    public boolean isPhoneCodeCorrect(String expectedCode){
        return  savedPhoneCode.getText().contains(expectedCode);
    }
    public boolean isPhoneNumberCorrect(String expectedPhoneNumber){
        return  savedPhoneNumber.getText().contains(expectedPhoneNumber);
    }


}