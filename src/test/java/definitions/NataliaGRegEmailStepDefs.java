package definitions;

import cucumber.api.java.en.Then;
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
}

