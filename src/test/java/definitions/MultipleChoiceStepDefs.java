package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MultipleChoiceStepDefs {
    @And("I type quiz title {string}")
    public void iTypeQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I select correct option in {string} as {string}")
    public void iSelectCorrectOptionInAs(String questionNmbr, String optionNmbr) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNmbr + "')]/../../..//textarea[@placeholder='" + optionNmbr + "']/../../../../../mat-checkbox")).click();

    }

    @When("I create a MC question with {int} choices")
    public void iCreateAMCQuestionWithChoices(int num) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../..//[@Placeholder='Question ']")).sendKeys("Question Text");
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../..//[@Placeholder='Option 1']")).sendKeys("Option1 Text");
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../..//[@Placeholder='Option 2']")).sendKeys("Option2 Text");
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../..//[@Placeholder='Option 2']/../../../../..//*[input]")).click();

        for (int i = 3; i<= num ; i ++){
            getDriver().findElement(By.xpath("//*[contains(text(),'Q1')]/../../..//*[contains(text(),'Add Option')]")).click();
            String xpath = "//*[contains(text(),'Q1')]/../../..//*[@placeholder='Option " + i + "*']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Option " + i);
        }
    }
}
