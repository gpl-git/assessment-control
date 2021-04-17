package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
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
        getDriver().findElement(By.xpath("//*[@id='email-table']/a[1]/div[2]")).click();
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

    @Then("user's credentials {string} are present at element with xpath {string}")
    public void userSCredentialsArePresentAtElementWithXpath(String expectedCredentials, String xpath) {
        String actualCredentials = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualCredentials.equals(expectedCredentials)).isTrue();
    }


    @Then("warning message with text {string} is present at element with xpath {string}")
    public void warningMessageWithTextIsPresentAtElementWithXpath(String expectedMessage, String xpath) {
        String actualMessage = getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println(actualMessage);
        assertThat(actualMessage.equals(expectedMessage)).isTrue();

    }

    @And("I click {string} link")
    public void iClickLink(String text) {
        getDriver().findElement(By.xpath("//a[contains(text(), '" + text + "')]")).click();

    }

    @And("I enter {string} into the Email field")
    public void iEnterIntoTheEmailField(String text) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(text);
    }

}