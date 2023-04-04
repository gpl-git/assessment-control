package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class quizTotalQuestionsIvanovaSDefs {

    @Then("I create {int} questions")
    public void iCreateQuestions(int num) throws InterruptedException {
        for (int i = 1; i <= num; i++) {
            getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//*[contains(text(),'Q" +i+ "')]/../../..//*[contains(text(),'Textual')]")).click();
            String xpath = "//*[contains(text(), 'Q" + i + "')]/../../..//*[@formcontrolname='question']";
            getDriver().findElement(By.xpath(xpath)).sendKeys(""+i);
        }
    }


    @Then("title {string} is displayed on the list of quizzes and have {int} total questions")
    public void titleIsDisplayedOnTheListOfQuizzesAndHaveTotalQuestions(String title, int expnum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'" +title+ "')]/../../..//table/tbody/tr[1]/*[text()='" +expnum+ "']")).isDisplayed();

    }

    @And("I delete {string}")
    public void iDelete(String title) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[contains(text(),'Delete')]")).click();
    }
}



