package e2e.tests;

import e2e.helper.LoginHelper;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;



public class LoginTest extends BaseTest {

    LoginPage loginPage;
    LoginHelper loginHelper;
    @Test
    public void successLogin(){
        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();}
    @Test
    public void invalidEmail() {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login("tttt@gmail.com", "test@gmail.com");
        assertTrue(loginPage.errorMessageHasText(
                "Please check your activation or Login + Password combination"));
    }
    @Test
    public void invalidPass() throws InterruptedException {
        loginPage = new LoginPage(app.driver);
        loginPage.login("test@gmail.com", "tttt@gmail.com");
        assertTrue(loginPage.errorMessageHasText(
                "Please check your activation or Login + Password combination"));
    }

}

