package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Quiz_ArtemStepDefs {
    @Then("I type {string} into the Password area in popup window")
    public void iTypeIntoThePasswordAreaInPopupWindow(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type {string} into the New Password area in popup window")
    public void iTypeIntoTheNewPasswordAreaInPopupWindow(String newPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(newPassword);
    }

    @Then("I type {string} into the Confirm New Password area in popup window")
    public void iTypeIntoTheConfirmNewPasswordAreaInPopupWindow(String confirmNewPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmNewPassword);
    }


    @Then("I check that the error message {string} is present")
    public void iCheckThatTheErrorMessageIsPresent(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'Authentication failed. User not found or password ')]")).isDisplayed()).isTrue();
    }

    @Then("the message {string} is present")
    public void theMessageIsPresent(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']/../../..//*[contains(text(), '" + errorMessage + "')]")).isDisplayed()).isTrue();
    }

    @Then("the password in password field is hidden")
    public void thePasswordInPasswordFieldIsHidden() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type").equals("password"));

    }


    @When("I type {string} into that email field")
    public void iTypeIntoThatEmailField(String myemail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(myemail);
    }

    @And("I type {string} into that password field")
    public void iTypeIntoThatPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click that {string} button")
    public void iClickThatButton(String btnName) {
        getDriver().findElement(By.xpath("//*[text()='"+btnName+"']")).click();
    }

    @And("I will wait for {int} sec")
    public void iWillWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @And("I click on that {string} link")
    public void iClickOnThatLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + link + "')]")).click();
    }


    @Then("I click at that {string} button")
    public void iClickAtThatButton(String buttonName) {
        getDriver().findElement(By.xpath("//*[text()='"+buttonName+"']")).click();
    }

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("The site " + url + " is not supported");
        }
    }
}

