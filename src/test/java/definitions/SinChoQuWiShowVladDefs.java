package definitions;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class SinChoQuWiShowVladDefs {
    @And("I check {string} checkbox in {int} question")
    public void iCheckCheckboxInQuestion(String checkBox, String qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//span[contains(text(),'"+checkBox+"')]/../..//input/..")).click();
    }
}
