package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;

import java.util.Random;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class RegFirstNameBagyMyStepdefs {
    @Given("navigate to {string}")
    public void navigateTo(String url) {
        if (url.equalsIgnoreCase("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
            getDriver().findElement(By.xpath("//span[normalize-space()='Register Now']")).click();
        } else if (url.equalsIgnoreCase("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("this page doesn't exist");
        }
    }

    @Then("LN as {string}, Email as {string}, GroupCode as {string}, Password as {string}, Confirm Password as {string};")
    public void lnAsEmailAsGroupCodeAsPasswordAsConfirmPasswordAs(String ln, String email, String gc, String pw, String cpw) {
        getDriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(ln);
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(gc);
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pw);
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(cpw);


    }

    @And("I look at the page for {int} sec")
    public void iLookAtThePageForSec(int sec) throws InterruptedException{
        Thread.sleep(sec*1000);

    }

    @When("you click on Register me")
    public void youClickOnRegisterMe() {
        getDriver().findElement(By.xpath("//span[normalize-space()='Register Me']")).click();
    }

    @Then("error message should be displayed {string}")
    public void errorMessageShouldBeDisplayed(String rqmsg) {
        String actualMsg=getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();
        assertThat(actualMsg).isEqualToIgnoringCase(rqmsg);
    }


    @When("I type {string} on the First Name field")
    public void iTypeOnTheFirstNameField(String onechar) {
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(onechar);

    }

    @And("Registration page is confirmed")
    public void registrationPageIsConfirmed() {
        assertThat(getDriver().findElement(By.xpath("//body[contains(.,'Registered')]")).isDisplayed()).isTrue();

    }

    @Then("{string} error message is displayed")
    public void errorMessageIsDisplayed(String erwht) {
        String erwhtActual = getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();
        assertThat(erwhtActual).isEqualToIgnoringCase(erwht);
    }


    @When("I enter first name containing {int} Latin characters")
    public void iEnterFirstNameContainingLatinCharacters(int num) {
        boolean useLetters = true;
        boolean useNumbers = false;
        String genName = RandomStringUtils.random(num, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(genName);



    }
}
