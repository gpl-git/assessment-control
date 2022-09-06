package defenitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MyStepdefs {
    @Given("I navigate to the {string}")
    public void iNavigateToThe(String url) {
        getDriver().get(url);
    }

    @And("I login as a Student")
    public void iLoginAsAStudent() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("3nququyfk7@rifasuog.tech");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Mama19591105");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("I wait for {long} sec")
    public void iWaitForSec(long sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @Then("I go to My Assignments")
    public void iGoToMyAssignments() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Assignments')]/ancestor::a")).click();
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        getDriver().findElement(By.xpath("//td[contains(.,'"+buttonName+"')]//following-sibling::td//button")).click();

    }

    @Then("I choose the answer {string}")
    public void iChooseTheAnswer(String answerText) {
        getDriver().findElement(By.xpath("//div[contains(.,'"+answerText+"')]/ancestor::mat-radio-button/label/div")).click();
    }

    @And("I click on the Submit My Answers button")
    public void iClickOnTheSubmitMyAnswersButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }
}


