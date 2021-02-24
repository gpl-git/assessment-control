package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class QuizTitleStepDefs {
    @When("I click on {string} button")
    public void iClickOnButton(String btn) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }


    @And("I type {string} in the Title field")
    public void iTypeInTheTitleField(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);

    }


    @Then("I click {string}")
    public void iClick(String btn) {
        getDriver().findElement(By.xpath("//body/ac-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/main[1]/ac-quiz-builder-page[1]/form[1]/div[1]/button[1]/span[1]")).click();
    }


    @Then("quiz page should be displayed")
    public void quizPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//h3[contains(text(),'Passing Rate')]")).isDisplayed();
    }


    @When("I clear Title field")
    public void iClearTitleField() {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).clear();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String message) {
        String actual=getDriver().findElement(By.xpath("")).getText();
        assertThat(actual.contains(message)).isTrue();
    }
}


