package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceOptionsStepDefs {
    @When("I type {string} as question")
    public void iTypeAsQuestion(String question) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(question);

    }

    @And("I type {string} in field Option {int}")
    public void iTypeInFieldOption(String option, int number) {
        if (number == 1) {
            getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys(option);
        } else if (number == 2) {
            getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys(option);
        } else if (number == 3) {
            getDriver().findElement(By.xpath("//*[@placeholder='Option 3*']")).sendKeys(option);
        } else if (number == 4) {
            getDriver().findElement(By.xpath("//*[@placeholder='Option 4*']")).sendKeys(option);
        } else if (number == 5) {
            getDriver().findElement(By.xpath("//*[@placeholder='Option 5*']")).sendKeys(option);
        }
    }

    @When("I add {int} options to question")
    public void iAddOptionsToQuestion(int counter) {
        for (int i = 0; i <= counter - 1; i++) {
            getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
        }
        for (int x = 3; x <= counter+2; x++) {
            String xpach = "//*[@placeholder='Option " + x + "*']";
            getDriver().findElement(By.xpath(xpach)).sendKeys("Option " + x + "*");
        }
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String warningMessage) {
        String actualMessaage = getDriver().findElement(By.xpath("//*[contains(text(),'15 Options]")).getText();
        assertThat(actualMessaage.equals(warningMessage)).isTrue();

    }
}