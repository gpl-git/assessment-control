package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizMultipleChoiceOptionOlgaStepdefs {
    @Then("I click on checkbox of {string} as correct option in {string}")
    public void iClickOnCheckboxOfAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]//../../..//textarea[@placeholder='"+optionNumber+"']/../../../../..//span[@class='mat-checkbox-label']//..")).click();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).isDisplayed()).isTrue();
    }

    @And("I verify that {string} is not present on the list of quizzes")
    public void iVerifyThatIsNotPresentOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]"))).hasSize(0);
    }

    @Then("I verify that element {string} is not present")
    public void iVerifyThatElementIsNotPresent(String deletedText) {
        assertThat(getDriver().findElements(By.xpath("//*[contains(text(),'"+deletedText+"')]"))).hasSize(0);
    }

    @Then("I click on settings on {string} of {string}, wait {int} sec, and delete this option")
    public void iClickOnSettingsOnOfWaitSecAndDeleteThisOption(String optionNumber, String questionNumber, int sec) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]//../../..//*[@placeholder='"+optionNumber+"']//../../../../..//*[contains(text(),'settings')]")).click();
        Thread.sleep(1000 * sec);
        getDriver().findElement(By.xpath("//*[contains(text(),'Delete Option')]")).click();
    }

    @Then("I click on settings on {string} of {string}, wait {int} sec, and move option down")
    public void iClickOnSettingsOnOfWaitSecAndMoveOptionDown(String optionNumber, String questionNumber, int sec) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]//../../..//*[@placeholder='"+optionNumber+"']//../../../../..//*[contains(text(),'settings')]")).click();
        Thread.sleep(1000 * sec);
        getDriver().findElement(By.xpath("//*[contains(text(),'Move option down')]")).click();
    }

    @Then("I click on settings on {string} of {string}, wait {int} sec, and move option up")
    public void iClickOnSettingsOnOfWaitSecAndMoveOptionUp(String optionNumber, String questionNumber, int sec) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]//../../..//*[@placeholder='"+optionNumber+"']//../../../../..//*[contains(text(),'settings')]")).click();
        Thread.sleep(1000 *sec);
        getDriver().findElement(By.xpath("//*[contains(text(),'Move option up')]")).click();
    }

    @Then("I verify that {string} is located in {string}")
    public void  iVerifyThatIsLocatedIn(String expectedText, String optionNumber) {
        String actualText = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]//../../..//*[@placeholder='"+optionNumber+"']")).getAttribute("value");
        assertThat(actualText.equalsIgnoreCase(expectedText)).isTrue();
    }

    @Then("error message in snack-bar {string} is displayed")
    public void errorMessageInSnackBarIsDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'"+message+"')]")).isDisplayed()).isTrue();
    }

    @And("I enter {int} alphanumeric characters into {string} in {string} ok")
    public void iEnterAlphanumericCharactersIntoInOk(int num, String optionNumber, String questionNumber) {

        boolean useLetters = true;
        boolean useNumbers = true;

        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='"+optionNumber+"']")).sendKeys(generatedString);

    }

    @And("I add up to {int} options to {string} ok")
    public void iAddUpToOptionsToOk(int num, String questionNumber) {

        for (int i = 5; i <= num; i ++ ) {
            getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='Option "+i+"*']")).sendKeys("Option "+ i);

        }
    }
}
