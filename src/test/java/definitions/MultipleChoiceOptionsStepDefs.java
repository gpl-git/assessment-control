package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceOptionsStepDefs {
    @Then("{string} should appear")
    public void shouldAppear(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).getText();
        assertThat(actualMessage).isEqualTo(message);
}

    @Then("quiz {string} shouldn't be displayed on the list of quizzes")
    public void quizShouldnTBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isFalse();
    }

    @When("I click on add option")
    public void iClickOnAddOption() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Add Option')]")).click();
    }
}
