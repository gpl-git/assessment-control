package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class RegLastNameStepDefs {
    @Then("I verify that error message contains {string} ns")
    public void iVerifyThatErrorMessageContainsNs(String errMassege) {
        String message=getDriver().findElement(By.xpath("(//div[@class='mat-input-subscript-wrapper mat-form-field-subscript-wrapper'])[2]")).getText();
        System.out.println(message);
        assertThat(message.equals(errMassege)).isTrue();
    }

    @And("I clear last name field ns")
    public void iClearLastNameFieldNs() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).clear();
    }

    @And("I verify that element {string} is present ns")
    public void iVerifyThatElementIsPresentNs(String message) {
        String errMessage=getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).getText();
        assertThat(message.equals(errMessage)).isTrue();
    }
}
