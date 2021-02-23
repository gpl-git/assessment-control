package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalNumberDoinaStepDefs {
    @And("I verify that {string} button is present")
    public void iVerifyThatButtonIsPresent(String expbutton) {
        String quizzes=getDriver().findElement(By.xpath("//*[text()='Quizzes']")).getText();
        assertThat(quizzes.contains(expbutton)).isTrue();


    }


    @Then("I click on {string} button")
    public void iClickOnButton(String quizzes) {
        getDriver().findElement(By.xpath("//*[text()='Quizzes']")).click();
    }

    @And("I verify that Quizzes {string} is displayed")
    public void iVerifyThatQuizzesIsDisplayed(String expmatcard) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='quizzes']")).isDisplayed()).isTrue();


    }

    @And("I click on {string} tab")
    public void iClickOnTab(String create) {
    }
}
