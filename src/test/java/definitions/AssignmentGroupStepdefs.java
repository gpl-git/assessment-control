package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AssignmentGroupStepdefs {
    @Given("I go to this page ask")
    public void iGoToThisPage() {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @Then("I click on Assignments")
    public void iClickOnAssignments() {
        getDriver().findElement(By.xpath("//h5[@class='mat-line'][contains(text(),'Assignments')]")).click();
    }

    @And("I click Create New Assignment button")
    public void iClickCreateNewAssignmentButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @Then("I click to see the list of groups")
    public void iClickToSeeTheListOfGroups() {
        getDriver().findElement(By.xpath("//span[text()='All']")).click();
    }

    @And("I choose group {string}")
    public void iChooseGroup(String group) {
        getDriver().findElement(By.xpath("//span[@class='mat-option-text'][text()='"+group+"']")).click();
    }

    @And("I click to see the list of quizzes")
    public void iClickToSeeTheListOfQuizzes() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
    }

    @And("I choose {string} quiz")
    public void iChooseQuiz(String quiz) {
        getDriver().findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+quiz+"')]")).click();
    }

    @And("I click Select All button")
    public void iClickSelectAllButton() {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper'][contains(text(),'Select All')]")).click();
    }

    @And("I click Give Assignment button")
    public void iClickGiveAssignmentButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I should see this error message {string}")
    public void iShouldSeeThisErrorMessage(String errorMes) {
        String actualMes = getDriver().findElement(By.xpath("//*[contains(text(),'"+errorMes+"')]")).getText();
        assertThat(actualMes.contains(errorMes)).isTrue();
    }

    @Then("quiz {string} is displayed on the list of assignments")
    public void quizIsDisplayedOnTheListOfAssignments(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));
        for (WebElement element : titles) {
            if (element.getText().contains(quizTitle)) {
                element.isDisplayed();
            }
        }
    }

    @Then("I delete assignment with quiz {string}")
    public void iDeleteAssignmentWithQuiz(String quiz) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));
        for (WebElement element : titles) {
            if (element.getText().contains(quiz)) {
                element.isDisplayed();
                getDriver().findElement(By.xpath("//button[@class='mat-icon-button mat-primary']")).click();
                getDriver().findElement(By.xpath("//span[text()='Delete Assignment']")).click();
                wait(3000);
                getDriver().findElement(By.xpath("//button[@class='mat-button mat-warn']")).click();
                wait(3000);
                break;
            }
        }
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
