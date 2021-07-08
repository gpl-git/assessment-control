package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextualQtextStepdefs {
    @And("I click on save button")
    public void iClickOnSaveButton() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
        String errMess = getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]")).getText();
        assertThat(errMess.equals(errorMessage)).isTrue();
    }
}
