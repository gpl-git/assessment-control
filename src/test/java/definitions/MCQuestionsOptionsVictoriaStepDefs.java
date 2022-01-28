package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MCQuestionsOptionsVictoriaStepDefs {
    @When("I click {string} button vk")
    public void iClickButtonVk(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @And("I type {string} as the quiz title vk")
    public void iTypeAsTheQuizTitleVk(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question vk")
    public void iAddAQuestionVk() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} question type vk")
    public void iSelectQuestionTypeVk(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @Then("I verify that {string} element is present vk")
    public void iVerifyThatElementIsPresentVk(String elementType) {
//        assertThat(getDriver().findElement(By.xpath("//input[contains(@id, '"+ elementType +"')]")).isDisplayed()).isTrue();
        boolean isElementDisplayed = getDriver().findElement(By.xpath("//input[contains(@id, '"+ elementType +"')]")).isDisplayed();
        assertThat(isElementDisplayed).isTrue();
    }

    @Then("I verify that option {int} is added vk")
    public void iVerifyThatOptionIsAddedVk(int optionNum) {
        assertThat(getDriver().findElement(By.xpath("//label/../../textarea[contains(@placeholder, '"+optionNum+"')]")).isDisplayed()).isTrue();
    }

    @When("I click on settings next to option {int}")
    public void iClickOnSettingsNextToOption(int optionNum) {
        getDriver().findElement(By.xpath("//div[@formarrayname = 'options']/div['"+optionNum +"']//mat-icon")).click();

    }

    @Then("I verify that {string} is disabled")
    public void iVerifyThatIsDisabled(String btnTxt) {
        boolean isButtonEnabled = getDriver().findElement(By.xpath("//span[contains(text(),'" + btnTxt + "')]/..")).isEnabled();
        // verify that the button is disabled
        assertThat(isButtonEnabled).isFalse();
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnTxt + "')]/..")).click();
    }

    @And("I verify that option {int} is removed vk")
    public void iVerifyThatOptionIsRemovedVk(int optionNum) {
        boolean isDisplayed = getDriver().findElement(By.xpath("//label/../../textarea[contains(@placeholder, '"+optionNum+"')]")).isDisplayed();
        assertThat(isDisplayed).isFalse();
    }

    @And("I verify that only {int} options left in a question")
    public void iVerifyThatOnlyOptionsLeftInAQuestion(int expectedOptionsNum) {
        int currentOptionsNum = getDriver().findElements(By.xpath("//textarea[contains(@placeholder, 'Option')]")).size();
//        System.out.println(currentOptionsNum);
        assertThat(currentOptionsNum).isEqualTo(expectedOptionsNum);
    }

    @When("I add {int} options by clicking {string} button vk")
    public void iAddOptionsByClickingButtonVk(int optionsNum, String btnName) throws InterruptedException {

        for (int i = 0; i < optionsNum; i++) {
            int sec = 0;
            getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
            Thread.sleep(sec * 1000);
        }
    }

    @And("I type {string} into Q{int} vk")
    public void iTypeIntoQVk(String questionText, int questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }


    @And("I type {string} as {string} into {string}")
    public void iTypeAsInto(String optionText, String optionNumber, String questionNumber) {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']")).sendKeys(optionText);

        getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '"+questionNumber+"')]")).sendKeys("book");
    }

    @And("I type {string} into {int} options")
    public void iTypeIntoOption(String text, int num) throws InterruptedException {

        for (int i = 1; i <= num; i++) {
            int sec = 0;
            getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + i + "')]")).sendKeys(text);
            Thread.sleep(sec * 1000);
        }
    }

    @And("I check the correct answer {int}")
    public void iCheckTheCorrectAnswer(int num) {
    getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + num + "')]/../../../../../mat-checkbox")).click();
    }

    @And("I delete {string} vk")
    public void iDeleteVk(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class ='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @Then("quiz {string} should be displayed on the list of quizzes vk")
    public void quizShouldBeDisplayedOnTheListOfQuizzesVk(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizTitle + "')]")).isDisplayed()).isTrue();
    }

    @When("I select quiz {string}")
    public void iSelectQuiz(String qTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).click();
    }

    @And("I click Preview button vk")
    public void iClickPreviewButtonVk() {
        getDriver().findElement(By.xpath("//span/mat-panel-title[contains(text(), 'vica')]/../../..//div/button[1]")).click();
    }

    @Then("I verify that {int} options are present vk")
    public void iVerifyThatOptionsArePresentVk(int expectedOptions) throws InterruptedException {
        int actualOptions = getDriver().findElements(By.xpath("//label[@class='mat-checkbox-layout']")).size();
        Thread.sleep(1000);
        assertThat(actualOptions).isEqualTo(expectedOptions);
    }
}







