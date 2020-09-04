package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationStepdefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {
        if (page.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else if (page.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");

        }else{
            System.out.println("Undefined page");
        }
    }

    @When("I type {string} into firstName field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);

    }

    @When("I type {string} into lastName field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @When("I type {string} into group field")
    public void iTypeIntoGroupField(String groupCode) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @When("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);

    }

    @When("I type {string} into confirmPassword field")
    public void iTypeIntoConfirmPasswordField(String confPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confPassword);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) throws InterruptedException {

        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//span[text()='"+btnName+"']")).click();
        Thread.sleep(3000);


        WebElement button = getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", button);

    }

    @Then("confirmation message {string} is displayed")
    public void confirmationMessageIsDisplayed(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/h4")).getText();
        assertThat(actualMessage.equals(message)).isTrue();

    }


    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).getText();
        assertThat(actualMessage.equals(errorMessage)).isTrue();
    }

    @Then("error {string} is displayed")
    public void errorIsDisplayed(String whitespace) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).getText();
        assertThat(actualMessage.equals(whitespace)).isTrue();


    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);

    }

    @When("I Click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+link+"')]")).click();
    }

    @And("I click {string} button contains text")
    public void iClickButtonContainsText(String text) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]")).click();
    }

    @Then("I check {string} as correct answer in question {string}")
    public void iCheckAsCorrectAnswerInQuestion(String option, String question) {
        String xpath = "//*[contains(text(),'"+question+"')]/../../..//*[@placeholder='"+option+"']/../../../../..//*[input]";
        getDriver().findElement(By.xpath(xpath)).click();
//        String x="//*[contains(text(),'"+question+"')]/../../..//*[@placeholder='"+option+"']/../../../../..//*[input]";
//        getDriver().findElement(By.xpath(x)).click();
    }
}

