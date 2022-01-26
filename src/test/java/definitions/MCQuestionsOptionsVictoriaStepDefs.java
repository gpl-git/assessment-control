package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

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
        getDriver().findElement(By.xpath("//label/../../textarea[contains(@placeholder, '"+optionNum+"')]"));
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
}
