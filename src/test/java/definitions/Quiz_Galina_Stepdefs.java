package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Quiz_Galina_Stepdefs {
    @When("I click on {string} link")
    public void iClickOnLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + link + "')]")).click();
    }

    @When("I type {string} into quiz title field")
    public void iTypeIntoQuizTitleField(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @Then("I select {string} question")
    public void iSelectQuestion(String questionType) {
        getDriver().findElement(By.xpath("//div[@class='mat-radio-label-content'][contains(text(),'" + questionType + "')]")).click();
    }

    @When("I type {string} into {string} input field {string}")
    public void iTypeIntoInputField(String questionText, String questionNumber, String questionField) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + questionField + "']")).sendKeys(questionText);
    }

    @And("I check {string} as correct in question {string}")
    public void iCheckAsCorrectInQuestion(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']/../../../../..//*[input]")).click();
    }

    public boolean isDisplayed(String quizTitle) {
        List<WebElement> elements = getDriver().findElements(By.xpath("//mat-panel-title"));

        return elements.stream().anyMatch(e->e.getText().trim().equals(quizTitle));


    }
    @Then("{string} is displayed on the list of quizzes")
    public void isDisplayedOnTheListOfQuizzes(String quizTitle) throws InterruptedException {

//        System.out.println(isDisplayed(quizTitle));
//        assertThat(isDisplayed(quizTitle)).isTrue();


//        for (WebElement title : titles) {
//            if (title.getText().equals(quizTitle)) {
//                System.out.println(quizTitle);
        Thread.sleep(2000);
//        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));
//        for (WebElement element : titles) {
//            assertThat(element.getText().contains(quizTitle)).isTrue();
//        }
//            }
//
//        }
        List<WebElement> elements = getDriver().findElements(By.xpath("//mat-panel-title"));
        assertThat(elements.stream().anyMatch(e -> e.getText().trim().equals(quizTitle))).isTrue();

//        WebElement expectedText= getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]"));
//        assertThat(expectedText.isDisplayed()).isTrue();

    }

    @And("I click {string} and {string} in the list of quizzes")
    public void iClickAndInTheListOfQuizzes(String quizTitle, String btnName) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]/../../..//*[contains(text(),'"+btnName+"')]")).click();

        Thread.sleep(3000);
    //   getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//button[contains(@class,'mat-warn')]")).click();
        WebElement confirmDelete =  getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//button[contains(@class,'mat-warn')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", confirmDelete);

    }
}





