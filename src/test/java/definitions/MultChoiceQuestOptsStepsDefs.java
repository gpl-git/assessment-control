package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        List<WebElement> quiz = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'\" + quizTitle + \"')]"));
        if (!quiz.isEmpty()) {
            List<WebElement> webElements = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[contains(text(),'Delete')]"));
            if (!webElements.isEmpty()) {
                for (WebElement webElement : webElements) {
                    webElement.click();
                    Thread.sleep(1500);
                    getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
                    Thread.sleep(1500);
                }
            }
        }
    }
}
