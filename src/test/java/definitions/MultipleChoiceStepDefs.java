package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MultipleChoiceStepDefs {
    @And("I type quiz title {string}")
    public void iTypeQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I select correct option in {string} as {string}")
    public void iSelectCorrectOptionInAs(String questionNmbr, String optionNmbr) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNmbr+"')]/../../..//textarea[@placeholder='"+optionNmbr+"']/../../../../../mat-checkbox")).click();

    }
}
