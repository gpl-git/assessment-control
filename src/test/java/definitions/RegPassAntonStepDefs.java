package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import support.TestContext;

import static support.TestContext.getDriver;

public class RegPassAntonStepDefs {
    @When("I click register now link")
    public void iClickRegisterNowLink() {

        getDriver().findElement(By.xpath("//button[@class='mat-button mat-primary']")).click();
    }


    @When("I enter {string} into first name field")
    public void iEnterIntoFirstNameField(String firstName) {

        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);

    }


    @When("I enter {string} into last name field")
    public void iEnterIntoLastNameField(String lastName) {

        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);

    }

    @And("I enter {string} into group field")
    public void iEnterIntoGroupField(String number) {

        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(number);

    }

    @And("I enter {string} into confirm password password field")
    public void iEnterIntoConfirmPasswordPasswordField(String confirmPassword) {

        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @And("click register me button")
    public void clickRegisterMeButton() {

        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();

    }


    @Then("I verify that {string} message is displayed")
    public void iVerifyThatMessageIsDisplayed(String message) {

        getDriver().findElement(By.xpath("//*[@class='mat-card']")).isDisplayed();
    }

    @Then("I verify that {string} alert message is displayed")
    public void iVerifyThatAlertMessagesIsDisplayed(String alertMessage) {

        getDriver().findElement(By.xpath("//*[@role='alert']")).getText();

    }
}
