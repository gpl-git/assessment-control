package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleChoiceQuestionOptionsStepDefs {
    @And("I refresh the page")
    public void iRefreshThePage() {
        getDriver().navigate().refresh();
    }

    @Then("alert for empty field is displayed")
    public void alertForEmptyFieldIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]")).isDisplayed()).isTrue();
    }

    @Then("alert for maximum choices is displayed")
    public void alertForMaximumChoicesIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(), 'Max 15 choices')]")).isDisplayed()).isTrue();
    }

    @When("I open {string} for preview")
    public void iOpenForPreview(String quiz) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quiz + "')]")).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quiz + "')]/../../..//span[contains(text(),'Preview')]")).click();
    }

    @Then("I validate that Other text area is displayed")
    public void iValidateThatOtherTextAreaIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//*[@placeholder='Other']")).isDisplayed()).isTrue();
    }

    @Then("alert for maximum characters in Option field is displayed")
    public void alertForMaximumCharactersInOptionFieldIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(), 'Max 1000 characters')]")).isDisplayed()).isTrue();
    }

    @When("I click on {string} quiz")
    public void iClickOnQuiz(String quiz) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quiz + "')]")).click();
    }

    @And("I confirm action")
    public void iConfirmAction() {
        getDriver().findElement(By.xpath("//mat-dialog-container//span[contains(text(),'Delete')]")).click();
    }


    @And("I click {string} button for the {string} quiz")
    public void iClickButtonForTheQuiz(String button, String quiz) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+quiz+"')]/../../..//*[contains(text(),'"+button+"')]")).click();
    }
}
