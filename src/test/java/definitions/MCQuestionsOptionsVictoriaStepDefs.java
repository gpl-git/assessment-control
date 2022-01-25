package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MCQuestionsOptionsVictoriaStepDefs {
    @When("I click {string} button vk")
    public void iClickButtonVk(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+ btnName +"')]")).click();
    }

    @And("I type {string} as the quiz title vk")
    public void iTypeAsTheQuizTitleVk(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question vk")
    public void iAddAQuestionVk() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }
}
