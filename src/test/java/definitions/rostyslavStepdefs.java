package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class rostyslavStepdefs {
    @And("I add an option")
    public void iAddAnOption() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
    }

    @And("I verify that textarea {string} is displayed")
    public void iVerifyThatIsDisplayed(String text) {
        assertThat(getDriver().findElement(By.xpath("//textarea[contains(@placeholder,'"+ text +"')]")));
    }

    @Then("error message with text {string} should be displayed under the {string} field")
    public void errorMessageWithTextShouldBeDisplayedUnderTheOptionField(String text, String optionText) {
        getDriver().findElement(By.xpath("//*[contains(text(), '"+ optionText +"')]/../../../..//mat-error[contains(text(),'"+ text +"')]"));
    }
}
