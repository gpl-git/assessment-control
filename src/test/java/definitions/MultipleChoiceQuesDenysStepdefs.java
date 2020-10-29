package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MultipleChoiceQuesDenysStepdefs {
    @Then("I click on {string} button")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }
}
