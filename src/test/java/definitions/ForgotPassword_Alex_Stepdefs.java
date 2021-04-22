package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;
import static support.TestContext.getDriver;

public class ForgotPassword_Alex_Stepdefs {

    static String randomEmail;

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        getDriver().get(url);
    }


    @And("I click button with text {string}")
    public void iClickButtonWithText(String text) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + text + "')]")).click();
    }

    @And("I enter randomly generated email into the field with xpath {string}")
    public void iEnterRandomlyGeneratedEmailIntoTheFieldWithXpath(String xpath) {
        Random randomGenerator = new Random();
        int randonInt = randomGenerator.nextInt(1000);
        String email ="a.kaladzinski-"+randonInt+"@gmail.com";
        getDriver().findElement(By.xpath(xpath)).sendKeys(email);
        System.out.println(email);
        randomEmail = email;

    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @And("I click to open Reset your password email")
    public void iClickToOpenResetYourPasswordEmail() {
        getDriver().findElement(By.xpath("//span[@title='Reset Your Password']")).click();
    }

    @Then("element with text {string} is present")
    public void elementWithTextIsPresent(String expectedText) {
        String actualText = getDriver().findElement(By.xpath("//*[@class='mat-card']/h4")).getText();
        assertThat(actualText.equals(expectedText)).isTrue();
    }

    @And("I click element with a linktext {string}")
    public void iClickElementWithALinktext(String linktext) {
        getDriver().findElement(By.linkText(linktext)).click();
    }

    @And("I switch to new opened window")
    public void iSwitchToNewOpenedWindow() {
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

    }

    @And("I click {string} link")
    public void iClickLink(String text) {
        getDriver().findElement(By.xpath("//a[contains(text(), '" + text + "')]")).click();

    }

    @And("I enter {string} into the Email field")
    public void iEnterIntoTheEmailField(String text) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(text);
    }

    @And("I enter {string} into the Usermane field")
    public void iEnterIntoTheUsermaneField(String email) {
        getDriver().findElement(By.id("login-username")).sendKeys(email);
    }

    @And("I click Next button")
    public void iClickNextButton() {
        getDriver().findElement(By.id("login-signin")).click();
    }

    @And("I enter {string} into Password Field")
    public void iEnterIntoPasswordField(String password) {
        getDriver().findElement(By.id("login-passwd")).sendKeys(password);
    }

    @And("I click Inbox link")
    public void iClickInboxLink() {
        getDriver().findElement(By.id("inboxNode")).click();
    }

    @And("I click to open {string} email")
    public void iClickToOpenEmail(String emailName) {
        getDriver().findElement(By.xpath("//span[@title='" + emailName + "']")).click();
    }


    @And("I enter {string} into New password field")
    public void iEnterIntoNewPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys(password);
    }

    @And("I enter {string} into Confirm New Password field")
    public void iEnterIntoConfirmNewPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm New Password']")).sendKeys(password);
    }

    @And("I enter {string} into Email field at ask page")
    public void iEnterIntoEmailFieldAtAskPage(String email) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
    }

    @And("I enter {string} into Password field at ask page")
    public void iEnterIntoPasswordFieldAtAskPage(String pswd) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(pswd);
    }

    @Then("user's credentials {string} are present at the top left corner of the page")
    public void userSCredentialsArePresentAtTheTopLeftCornerOfThePage(String expectedCredentials) {
        String actualCredentials = getDriver().findElement(By.xpath("//header/div[2]/h3")).getText();
        assertThat(actualCredentials.equals(expectedCredentials)).isTrue();

    }

    @Then("snack-bar with text {string} is present")
    public void snackBarWithTextIsPresent(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//body/div[1]")).getText();
        System.out.println(actualMessage);
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }

    @Then("warning message with text {string} is present")
    public void warningMessageWithTextIsPresent(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        System.out.println(actualMessage);
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }
}