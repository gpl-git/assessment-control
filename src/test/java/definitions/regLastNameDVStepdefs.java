package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class regLastNameDVStepdefs {
    @Then("{string} error message should be present -DV")
    public void errorMessageShouldBePresentDZ(String errmessage) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).isDisplayed()).isTrue();


    }

    @Then("{string} message should be present -DV")
    public void messageShouldBePresentDV(String message) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(), 'You have been Registered.')]")).isDisplayed()).isTrue();

    }
}
