package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ForgotPassword_Alex_Stepdefs {

    static String localName, domainName;

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        getDriver().get(url);
    }

    @Then("I copy randomly generated email string")
    public void iCopyRandomlyGeneratedEmailString() {
        localName = getDriver().findElement(By.id("userName")).getAttribute("value");
        domainName = getDriver().findElement(By.xpath("//div[@id='domnamserch']/input[2]")).getAttribute("value");
        String email = localName + "@" + domainName;
        System.out.println(email);
    }

    @And("I click button with text {string}")
    public void iClickButtonWithText(String text) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + text + "')]")).click();
    }


    @And("I enter {string} into the field with xpath {string}")
    public void iEnterIntoTheFieldWithXpath(String input, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(input);

    }

    @And("I enter randomly generated email into the field with xpath {string}")
    public void iEnterRandomlyGeneratedEmailIntoTheFieldWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(localName + "@" + domainName);
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
}