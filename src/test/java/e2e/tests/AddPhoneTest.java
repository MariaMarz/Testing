package e2e.tests;

import e2e.dialogs.AddContactDialog;
import e2e.dialogs.AddNewPhoneDialog;
import e2e.dialogs.DeleteContactDialog;
import e2e.helper.LoginHelper;
import e2e.pages.ContactInfoPage;
import e2e.pages.ContactsPage;
import e2e.pages.PhonePage;
import org.testng.annotations.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class AddPhoneTest extends BaseTest {
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhonePage phonePage;
    AddNewPhoneDialog addNewPhoneDialog;

    @Test
    public void successAddPhone() throws InterruptedException {
        String newContactName = "Lola";
        String newContactLastName = "Müller";
        String phoneNumber = "999232139";
        String expectedCode = "+49";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("Lola");
        contactsInfo.add("Müller");
        contactsInfo.add("manager");

        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();
        contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickOnAddNewContactLink();

        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, "manager");
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        phonePage = new PhonePage(app.driver);
        phonePage.clickPhoneButton();
        phonePage.waitForLoading();
        phonePage.clickAddPhoneButton();

        addNewPhoneDialog = new AddNewPhoneDialog(app.driver);
        addNewPhoneDialog.waitForLoading();
        addNewPhoneDialog.chooseCountryCode();
        addNewPhoneDialog.enterPhoneNumber(phoneNumber);
        addNewPhoneDialog.savePhoneNumber();
        addNewPhoneDialog.waitForClose();

        phonePage.waitForLoading();
        assertTrue(phonePage.isPhoneCodeCorrect(expectedCode));
        assertTrue(phonePage.isPhoneNumberCorrect(phoneNumber));
    }




    }


