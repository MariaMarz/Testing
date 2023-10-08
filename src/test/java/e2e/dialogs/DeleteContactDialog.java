package e2e.dialogs;

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteContactDialog extends BasePage {
    public DeleteContactDialog(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;
    @FindBy(id = "check-box-remove-contact")
    private WebElement confirmCheckbox;
    @FindBy(id = "submit-remove")
    private WebElement removeContactButton;

    public void waitForLoading(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(confirmCheckbox);
        getWait().forVisibility(removeContactButton);
    }

    public void clickToCheckBox() {
        confirmCheckbox.click();
    }

    public void clickButtonDeleteElement() {
        removeContactButton.click();
    }
    public void waitForClosed(){

        getWait().forInvisibility(dialog);
    }
}
