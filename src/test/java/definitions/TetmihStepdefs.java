package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class TetmihStepdefs {
    @And("I select quiz title {string}")
    public void iSelectQuizTitle(String title) {

        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'" + title + "')]")).click();

    }


    @And("I click {string} field")
    public void iClickField(String title) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
    }

    @Then("I select {string} quiz")
    public void iSelectQuiz(String title) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Tetmih Quiz')]")).click();
    }

    @Then("I click on “Student One” in the student list")
    public void iClickOnStudentOneInTheStudentList() {
        List<WebElement> studentNames = getDriver().findElements(By.xpath("//mat-list-option"));
        for (WebElement item : studentNames) {
            if (item.getText().contains("Student One")) {
                item.click();
            }
        }

    }


    @Then("{string} should be present")
    public void shouldBePresent(String confirmation) {
        getDriver().findElement(By.xpath("//mat-dialog-container[@id='mat-dialog-19']")).isDisplayed();
    }

    @Then("I click {string} option")
    public void iClickOption(String LogOutButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
    }


}

