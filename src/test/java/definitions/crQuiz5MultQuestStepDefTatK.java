package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class crQuiz5MultQuestStepDefTatK {
    String titleGenerator = RandomStringUtils.random(2, 1, 99, false, true);
    String quizTitle = "QuizTitle" + titleGenerator;

    @When("I select {string} as a correct option in {string}")
    public void iSelectAsACorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']/../../../../../mat-checkbox")).click();
    }

    @And("I create {string} title")
    public void iCreateTitle() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @When("I create quiz with {int} Multiple-Choice questions")
    public void iCreateQuizWithMultipleChoiceQuestions(int numQuestions) throws InterruptedException {

        if (numQuestions >= 1) {
            getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
            getDriver().findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
            Thread.sleep(2000);

            for (int i = 1; i < numQuestions; ++i) {
                Thread.sleep(1000);
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(), 'Multiple')]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[@placeholder='Question *']")).sendKeys("Question example " + i + "");
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys("Question " + i + "");
                getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys("Question " + i + "");
                Thread.sleep(2000);

                //failed getDriver().findElement(By.xpath("//*[contains(text(),'Option "+i+"*')]/../../../../../..//input[@type='checkbox']")).click();
                //failed getDriver().findElement(By.xpath("//div[@class='mat-checkbox-ripple mat-ripple']/../../../../..//*[contains(text(),'Option 1*')] ")).click();
                //failed tDriver().findElement(By.xpath("//*[contains(text(),'Q "+i+"')]/../../../..//*[contains(text(),'Option "+i+"*')]/../../../../../..//input[@type='checkbox']")).click();
                //failed getDriver().findElement(By.xpath("//*[contains(text(),'Option 1*')]/../../../../../..//*[@class='mat-checkbox-frame']")).click();
                //failed  getDriver().findElement(By.xpath("//*[contains(text(),'Option 1*')]/../../../../../..//*[@class='mat-checkbox-label']")).click();

                getDriver().findElement(By.xpath("//*[contains(text(),'Option 1*')]/../../../../../..//*[@type='checkbox']/..")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//mat-icon[contains(text(), 'add_circle')]")).click();
                Thread.sleep(2000);
            }

//            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + numQuestions + "')]/../../..//*[contains(text(),'Multiple-Choice')]")).click();
//            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + numQuestions + "')]/../../..//*[@placeholder='Question *']")).sendKeys("Question " + numQuestions + "");
//            getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        }
    }
}

//failed getDriver().findElement(By.xpath("//*[@placeholder='Option "+i+"*']/../../../../..//input[@type='checkbox']/../../../..//*[contains(text(),'Option "+i+"*')]")).click();
// failed getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + i + "')]/../../..//textarea[@placeholder='" + i + "']/../../../../../mat-checkbox")).click();
// failed getDriver().findElement(By.xpath("//*[@placeholder='Option "+i+"*']/../../../../..//textarea[@placeholder='" + i + "']/../../../../../mat-checkbox")).click();
// failed getDriver().findElement(By.xpath("//*[@placeholder='Option "+i+"*']/../../../../..//mat-checkbox")).click();
