package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizNameStepDefs {
    @Given("I navigate to the page {string}")
    public void iNavigateToThePage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I enter {string} into the email field")
    public void iEnterIntoTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} into the password field")
    public void iEnterIntoThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I wait for  the {int} seconds")
    public void iWaitForTheSeconds(int second) throws InterruptedException{
        Thread.sleep(second*1000);
    }


    @And("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();
    }

    @Then("I go to the {string} page")
    public void iGoToThePage(String assignment) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignment')]")).click();
    }

    @Then("I push the {string} button")
    public void iPushTheButton(String newAssignment) {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Create New Assignment')]/../../button")).click();
    }

    @Then("I select {string} element")
    public void iSelectElement(String quizToAssign) {
        getDriver().findElement(By.xpath("//mat-select[@formcontrolname='quizId']")).click();
    }

    @Then("I choose {string} quiz")
    public void iChooseQuiz(String quizName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Quiz Name Test')]")).click();
    }

    @And("I choose {string}")
    public void iChoose(String student) {
        WebElement element = getDriver().findElement(By.xpath("//mat-list-option[26]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("I click the {string} button")
    public void iClickTheButton(String giveAssignment) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
    }


    @Then("I logout from teacher acoount")
    public void iLogoutFromTeacherAcoount() {
        getDriver().findElement(By.xpath("//h5[contains(text(), 'Log Out')]")).click();
    }

    @And("confirm logout")
    public void confirmLogout() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
    }

    @Then("I go to my assignments")
    public void iGoToMyAssignments() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To My Assignment')]")).click();
    }

    @And("verify that I have {string} assignment")
    public void verifyThatIHaveAssignment(String newAssignment) {
        String info = getDriver().findElement(By.xpath("//td[contains(text(),'Quiz Name Test')]")).getText();
        assertThat(info.contains(newAssignment)).isTrue();
    }

    @Then("I click on the button near Quiz Name Test assignment")
    public void iClickOnTheButtonNearQuizNameTestAssignment() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), 'Quiz Name Test')]/..//button")).click();
    }

    @And("I delete Quiz Name Test assignment")
    public void iDeleteQuizNameTestAssignment() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Delete Assignment')]/../../button")).click();
    }

    @And("I confirm that I want to delete assignment")
    public void iConfirmThatIWantToDeleteAssignment() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Delete')]")).click();
    }
}
