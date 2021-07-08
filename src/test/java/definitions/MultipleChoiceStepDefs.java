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
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNmbr+"')]/../../..//textarea[@placeholder='"+optionNmbr+"']/../../../../../mat-checkbox")).click();

    }


    @And("I create quiz with {int} choices")
    public void iCreateQuizWithChoices(int questionsNum) throws InterruptedException {
        if (questionsNum >= 1) {
            for (int i = 1; i < questionsNum; ++i)
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionsNum+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys("Text is here");
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionsNum+"')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys("Text is here");
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionsNum+"')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys("Text is here");
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionsNum+"')]/../../..//textarea[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
        Thread.sleep(200);
        }
    }
}
