package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalNumberDoinaStepDefs {
    @And("I verify that {string} button is present")
    public void iVerifyThatButtonIsPresent(String expbutton) {
        String quizzes=getDriver().findElement(By.xpath("//*[text()='"+expbutton+"']")).getText();
        assertThat(quizzes.contains(expbutton)).isTrue();


    }


    @Then("I click on {string} button")
    public void iClickOnButton(String forquiz) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+forquiz+"')]")).click();
    }







//    @And("I click on {string} tab")
//    public void iClickOnTab(String newquiz) {
//      getDriver().findElement(By.xpath("//*[@class='mat-button-wrapper']")).click();
//    }

    @Then("I type {string} into quiz title")
    public void iTypeIntoQuizTitle(String title) {
       getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }


    @And("I click on the plus button")
    public void iClickOnThePlusButton() throws InterruptedException {
        for (int i=0 ;i< 50;i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(2000);
        }
    }


    @Then("I verify that {string} is displayed")
    public void iVerifyThatIsDisplayed(String lastquest) {
        List<WebElement> lastquest50 =getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'Q50')]"));

        for (WebElement element:lastquest50) {
            if (element.getText().contains(lastquest)) {
                element.isDisplayed();
            }
        }
             {

        }

    }



    @And("I click on the plus button {int}")
    public void iClickOnThePlusButton(int max1) throws InterruptedException {
        for (int i=0 ;i< max1;i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//div[contains(text(),'Textual')]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//*[placeholder='Question*']")).sendKeys("Way QA?");
            Thread.sleep(2000);

    }
}


    @Then("I select {string}")
    public void iSelect(String select) {
        WebElement element = getDriver().findElement(By.xpath("//label[contains(text(),'"+select+"')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

    }

    @And("I select group {string}")
    public void iSelectGroup(String group) {
        WebElement element = getDriver().findElement(By.xpath("//mat-list-option[24]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }



    @Then("I select quiz  {string}")
    public void iSelectQuiz(String quiz) {
        WebElement element = getDriver().findElement(By.xpath("//div[@dir='ltr']/../../../..//span[contains(text(),'Graded automatically')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

    }

//    @Then("I click on student name")
//    public void iClickOnStudentName() {
//        WebElement element = getDriver().findElement(By.xpath("//mat-pseudo-checkbox[@class='mat-pseudo-checkbox']/..//*[text()='N001']"));
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click();", element);
//
//    }

    @And("I click {string}")
    public void iClick (String quiz){
      WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]"));
      JavascriptExecutor executor = (JavascriptExecutor) getDriver();
      executor.executeScript("arguments[0].click();", element);
       // getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();

    }

    @Then("I click to {string}")
    public void iClickTo(String logout) {
        WebElement element = getDriver().findElement(By.xpath("//mat-dialog-container[@role='dialog']//span[contains(text(),'Log Out')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

    }



    @When("I choose {string}")
    public void iChoose(String myassignments) {
        WebElement element = getDriver().findElement(By.xpath("//tr[@class='ng-star-inserted']//td[contains(text(),'Graded automatically')]/..//span[contains(text(),'Go To Assessment')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);


    }


    @Then("I choose a Student")
    public void iChooseAStudent() {
        getDriver().findElement(By.xpath("//mat-list-option[29]")).click();
    }
}
