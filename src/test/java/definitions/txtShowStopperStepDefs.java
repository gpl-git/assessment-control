package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class txtShowStopperStepDefs {
    @And("I check the checkbox Show-Stopper")
    public void iCheckTheCheckboxShowStopper() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Show-Stopper')]")).click();

    }

    @Then("the question number {string} should contain the symbol *")
    public void theQuestionNumberShouldContainTheSymbol(String questionNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]")).getText().contains("*"));


    }

    @When("I uncheck Show-Stopper")
    public void iUncheckShowStopper() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Show-Stopper')]")).click();

    }

    @Then("the question number {string} should not contain the symbol *")
    public void theQuestionNumberShouldNotContainTheSymbol(String questionNum) {
        boolean compare;
        String actualText=getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]")).getText();
        assertThat(actualText).doesNotContain("*");
      }

    @Then("I should see a new window Preview Mode")
    public void iShouldSeeANewWindowPreviewMode() {
        //getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
        assertThat(getDriver().findElement(By.xpath("//h3[contains(text(),'PREVIEW MODE')]")).isDisplayed()).isTrue();
    }

    @And("I should see the label Show-Stopper Question")
    public void iShouldSeeTheLabelShowStopperQuestion() {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]")).isDisplayed()).isTrue();
    }
}
