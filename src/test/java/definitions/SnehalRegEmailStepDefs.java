package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SnehalRegEmailStepDefs {
    @Then("I type {string} in the field with xpath {string}")
    public void iTypeInTheFieldWithXpath(String Fname, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(Fname);
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I clear the field with xpath {string}")
    public void iClearTheFieldWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).clear();
    }

    @And("I verify that {string} is displayed on the mat-form")
    public void iVerifyThatIsDisplayedOnTheMatForm(String emailError) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='email']/../../..//mat-error[contains(text(),'"+emailError+"')]")).isDisplayed()).isTrue();
    }

    @And("I verify that the user has been registered")
    public void iVerifyThatTheUserHasBeenRegistered() {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).isDisplayed()).isTrue();
    }
}
