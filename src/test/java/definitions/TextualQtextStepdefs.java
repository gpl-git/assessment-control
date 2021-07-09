package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextualQtextStepdefs {

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMess) {
        String actErrMess = getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]")).getText();
        assertThat(actErrMess.equals(errorMess)).isTrue();
    }
}
