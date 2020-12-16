package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultiplechoiceStepdefs {
    @And("I click on {string} button")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + button + "')]")).click();
    }

    @And("I verify the {string} option is disabled")
    public void iVerifyTheOptionIsDisabled(String option) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'Delete Option')]")).isEnabled()).isTrue();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Close Menu')]")).click();
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String icon) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']/../../../../..//mat-icon[contains(text(),'settings')]")).click();
    }

    @When("I mark {string} as correct in question {string}")
    public void iMarkAsCorrectInQuestion(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + optionNum + "']/../../../../../mat-checkbox")).click();
    }

    @And("I click {string} in Menu")
    public void iClickInMenu(String menu) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menu + "')]")).click();
    }

    @And("I create {int} options as {string} in the field {string}")
    public void iCreateOptionsAsInTheField(int numOptions, String optionField, String optionText) throws InterruptedException {
        for (int i = 3; i <= numOptions; i++) {
            getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
            Thread.sleep(1 * 1000);
            getDriver().findElement(By.xpath("//textarea[@placeholder = 'Option " + i + "*']")).sendKeys(optionText + i);
            getDriver().findElement(By.xpath("//textarea[@placeholder= 'Option " + i + "*']/../../../../../mat-checkbox")).click();
        }

    }

    @Then("I verify quiz {string} with {int} options")
    public void iVerifyQuizWithOptions(String quizName, int optionsNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]")).click();
        Thread.sleep(1 * 1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]/../../..//*[contains(text(),'Preview')]")).click();
        Thread.sleep(1 * 1000);
        if (getDriver().findElement(By.xpath("//div[@class='ng-untouched ng-pristine ng-valid']//span[contains(text(),'Option " + optionsNum + "')]")).isDisplayed()) {
            System.out.println("Test failed. The quiz can contain up to 15 options but has " + optionsNum + " options");
        } else {
            System.out.println("Test was successfully created with " + optionsNum + " of options");
        }
    }

    @And("I click on settings")
    public void iClickOnSettings() {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']/../../../../..//mat-icon[contains(text(),'settings')]")).click();
    }
}

