
package e2e.helper;

import e2e.pages.BasePage;
import e2e.pages.ContactsPage;
import e2e.pages.Header;
import e2e.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends Header {
    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void loginTestHelper()  {
        LoginPage loginPage;
        ContactsPage contactsPage;
        loginPage  = new LoginPage(driver);
        loginPage.waitForLoading();
        loginPage.login("test@gmail.com", "test@gmail.com");
        contactsPage = new ContactsPage(driver);
        contactsPage.waitForLoading();
    }
}
