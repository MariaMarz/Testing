
package e2e.tests;

import e2e.dialogs.AddContactDialog;
import e2e.dialogs.DeleteContactDialog;
import e2e.helper.LoginHelper;
import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddNewContactTest extends BaseTest {
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    DeleteContactDialog removeContactDialog;

    @Test
    public void successAddNewContact() throws InterruptedException {
        String newContactName = "Maria";
        String newContactLastName = "Marz";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("Maria");
        contactsInfo.add("Marz");
        contactsInfo.add("123");

        String changedName = "MariaMaria9";
        String changedLastName = "MarzMarz9";

        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickOnAddNewContactLink();


        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, "123");
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(BaseTest.app.driver);
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo, contactInfoPage.getContactInfo(), contactsInfo);
        contactInfoPage.goToContactsPage();

        contactsPage.searchContact(newContactName);
        sleep(2000);
        String newContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(newContactName, newContactNameFromContactsLIst);
        contactsPage.clickOnNewContactNameLinkFromContactsList();


        assertTrue(contactInfoPage.isEditButtonDisplayed());
        contactInfoPage.clickOnEditButton();


        contactInfoPage.editName(changedName);
        contactInfoPage.editLastName(changedLastName);
        contactInfoPage.clickOnSaveButton();
        assertTrue(contactInfoPage.isEditButtonDisplayed());
        contactInfoPage.goToContactsPage();


        contactsPage.waitForLoading();
        contactsPage.searchContact(changedName + changedLastName);
        String changedContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(changedName, changedContactNameFromContactsLIst);
        contactsPage.deleteContact();


        removeContactDialog = new DeleteContactDialog(BaseTest.app.driver);
        removeContactDialog.waitForLoading();
        removeContactDialog.clickToCheckBox();
        removeContactDialog.clickButtonDeleteElement();
        removeContactDialog.waitForClosed();

        assertTrue(contactsPage.isNoResultsDisplayed());
    }
}
