package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;


public class SinChoQuWiShowVladDefs {
    @Then("I check {string} checkbox in {int} question")
    public void iCheckCheckboxInQuestion(String checkBox, int qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//span[contains(text(),'"+checkBox+"')]/../..//input")).click();
    }
}
