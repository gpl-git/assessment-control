package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class PasswordCofirmPasswordHannaStepdefs {
    @Given("Navigate to {string} page h")
    public void navigateToPageH(String url) {
        if(url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("This site is not supported: " + url);
        }

    }

    @When("I click on FirstName field and type {string} h")
    public void iClickOnFieldAndType(String name) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(name);
    }

    @And("I click on LastName field and type {string} h")
    public void iClickOnLastNameFieldAndTypeH(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I click on email field and type {string} h")
    public void iClickOnEmailFieldAndTypeH(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I click on Group Code field and type {string} h")
    public void iClickOnGroupCodeFieldAndType(String code) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(code);
    }

    @And("I click on password field and type {string} h")
    public void iClickOnPasswordFieldAndType(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type on Confirm Password field {string} h")
    public void iTypeOnConfirmPasswordFieldH(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @Then("click on button 'Register Me' h")
    public void clickOnButtonRegisterMe() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("confirmation message should be displayed h")
    public void confirmationMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).isDisplayed()).isTrue();
    }

    @And("error message should be displayed and contain text {string} h")
    public void errorMessageShouldBeDisplayedAndContainText(String message) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).isDisplayed()).isTrue();
        Assert.assertEquals(message, getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).getAttribute("textContent"));
    }

    @And("errors messages should be displayed and contain text {string} h")
    public void errorsMessagesShouldBeDisplayedAndContainText(String message) {
        assertThat(getDriver().findElement(By.xpath("(//mat-error[@class='mat-error ng-star-inserted'])[1]")).isDisplayed()).isTrue();
        Assert.assertEquals(message, getDriver().findElement(By.xpath("(//mat-error[@class='mat-error ng-star-inserted'])[1]")).getAttribute("textContent"));

        assertThat(getDriver().findElement(By.xpath("(//mat-error[@class='mat-error ng-star-inserted'])[2]")).isDisplayed()).isTrue();
        Assert.assertEquals(message, getDriver().findElement(By.xpath("(//mat-error[@class='mat-error ng-star-inserted'])[2]")).getAttribute("textContent"));
}

    @And("I wait {int} sec")
    public void iWaitSec(int arg0) throws InterruptedException {
        Thread.sleep(1000);
    }
}

