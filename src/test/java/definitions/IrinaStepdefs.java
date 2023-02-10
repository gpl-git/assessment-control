package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class IrinaStepdefs {
    @Then("error message {string}  should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @And("I click on group code field")
    public void iClickOnGroupCodeField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).click();
    }
}
