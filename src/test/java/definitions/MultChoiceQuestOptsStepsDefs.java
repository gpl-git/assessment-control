package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultChoiceQuestOptsStepsDefs {
    @When("I checked {string}")
    public void iCheckAnd(String option) {
        getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + option + "')]/../../../../../mat-checkbox")).click();
    }

    @And("Input test-data {int} chars into field {string}")
    public void inputTestDataIntoField(int stringLength, String optionField) {

        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        String testString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + optionField + "')]")).sendKeys(testString);
    }

    @When("I push button {string}")
    public void iPushButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @Then("{string} is not displayed on the list of quizzes")
    public void isNotDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).isDisplayed()).isFalse();
    }

    @And("I check and delete existed quizzes with name {string}")
    public void iCheckAndDeleteExistedQuizzesWithName(String quizTitle) throws InterruptedException {
        List<WebElement> quizzes = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]"));
        for (WebElement quiz : quizzes) {
            quiz.click();
            Thread.sleep(1500);
            getDriver().findElement(
                            By.xpath("//mat-expansion-panel[contains(@class, 'expanded')]//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[contains(text(),'Delete')]"))
                    .click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
            Thread.sleep(1000);
        }
    }

    @Then("Alert message below {string} field is displayed")
    public void alertMessageBelowFieldIsDisplayed(String optionPlaceholder) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[contains(@placeholder,'" + optionPlaceholder + "')]/../../..//mat-error")).isDisplayed();
    }

    @When("Clear the field {string}")
    public void clearTheField(String fieldPlaceholder) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[contains(@placeholder, '" + fieldPlaceholder + "')]")).clear();
    }

    @When("I add a question {int} times")
    public void iAddAQuestionTimes(int size){
        String xpath = "//span[@class='mat-button-wrapper' and contains(text(), 'Add Option')]/../..//button";
        for (int i = size; i > 2; i--) {
            WebElement element = getDriver().findElement(By.xpath(xpath));
            element.click();
        }
    }

    @And("I fill out all fields {string} with text {string}")
    public void iFillOutFieldsWithText(String fieldPlaceholder, String text){
        List<WebElement> options = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[contains(@placeholder, '" + fieldPlaceholder + "')]"));
        for (WebElement option : options) {
            option.sendKeys(text);
        }
    }
}
