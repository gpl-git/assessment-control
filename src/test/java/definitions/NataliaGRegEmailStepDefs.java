package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class NataliaGRegEmailStepDefs {

    @Then("I verify that error message for Email field is not displayed")
    public void iVerifyThatErrorMessageForEmailFieldIsNotDisplayed() {
        assertThat(getDriver().findElements(By.xpath("//mat-form-field[contains(*,'Email')]//mat-error")).isEmpty()).isTrue();
    }

    @Then("I verify that error message {string} for Email field is displayed")
    public void iVerifyThatErrorMessageForEmailFieldIsDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//mat-form-field[contains(*,'Email')]")).getText()).contains(message);
    }

    @When("I fill all fields except the Email field")
    public void iFillAllFieldsExceptTheEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("a");
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("b");
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys("123");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("12345");
    }

    @And("I enter the maximum number of characters allowed in the Email field")
    public void iEnterTheMaximumNumberOfCharactersAllowedInTheEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(RandomStringUtils.randomAlphanumeric(64).toLowerCase() +
                "@" + RandomStringUtils.randomAlphabetic(63).toLowerCase() + "." + RandomStringUtils.randomAlphabetic(63).toLowerCase());
    }

    @When("I enter valid email into Email field")
    public void iEnterValidEmailIntoEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(RandomStringUtils.randomAlphanumeric(1).toLowerCase() +
                "@" + RandomStringUtils.randomAlphabetic(1).toLowerCase() + "." + RandomStringUtils.randomAlphabetic(2).toLowerCase());
    }

    @And("I enter an email address with a total length of {int} characters whose last domain part is {int} characters long.")
    public void iEnterAnEmailAddressWithATotalLengthOfCharactersWhoseLastDomainPartIsCharactersLong(int totallength, int lastdomainlength) {

        if (( totallength - lastdomainlength - 2) % 2 == 0 ) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(RandomStringUtils.randomAlphanumeric(
                    ( totallength - lastdomainlength - 2 ) / 2 ).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(( totallength - lastdomainlength - 2)
                    / 2).toLowerCase() + "." + RandomStringUtils.randomAlphabetic(lastdomainlength).toLowerCase());
        }
        else {
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(RandomStringUtils.randomAlphanumeric(
                    ( totallength - lastdomainlength - 2 ) / 2 +1).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(( totallength - lastdomainlength - 2)
                    / 2).toLowerCase() + "." + RandomStringUtils.randomAlphabetic(lastdomainlength).toLowerCase());
        }
    }
}

