package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class HomePageLinksStepDefs {


    @When("I click on the {string} button")
    public void iClickOnTheButton(String Submissions) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Submissions')]")).click();
    }

    @Then("current url should contain {string}")
    public void currentUrlShouldContain(String text) {
        String actualText = getDriver().getCurrentUrl();
        assertThat(actualText.contains(text.toLowerCase())).isTrue();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String Assignments) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
    }

    @When("I click button {string}")
    public void iClickButton(String Quizzes) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @When("I click {string}")
    public void iClick(String Users) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Users Management')]")).click();
    }

    @When("I click on {string}")
    public void iClickOn(String Settings) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
    }

    @When("I click on the {string}")
    public void iClickOnThe(String Home) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Home')]")).click();
    }

    @When("I {string}")
    public void i(String LogOut) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log')]")).click();
    }

    @When("I click {string} button OR")
    public void iClickButtonOR(String MyAssignments) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
    }

    @When("I click {string} button O")
    public void iClickButtonO(String MyGrades) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Grades')]")).click();
    }

    @When("I click {string} button R")
    public void iClickButtonR(String Settings) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
    }

    @When("I click on {string} button OR")
    public void iClickOnButtonOR(String Home) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Home')]")).click();
    }

    @When("I click {string} button LO")
    public void iClickButtonLO(String LogOut) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log')]")).click();
    }

    @When("I click {string} button L")
    public void iClickButtonL(String LogO) {
        getDriver().findElement(By.xpath("//button[@type='button'][2]")).click();
    }
}

