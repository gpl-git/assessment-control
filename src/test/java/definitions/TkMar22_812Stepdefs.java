package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TkMar22_812Stepdefs {
    @When("I type {string} into firstName field")
    public void iTypeIntoFirstNameField(String name) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(name);

    }

    @And("I type {string} into lastName field")
    public void iTypeIntoLastNameField(String last) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(last);
    }

    @And("I type {string} into groupCode field")
    public void iTypeIntoGroupCodeField(String code) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(code);
    }

    @And("I type {string} into confirmPassword field")
    public void iTypeIntoConfirmPasswordField(String confirm) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirm);
    }

    @Then("I confirm {string}")
    public void iConfirm(String registered) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'"+registered+"')]")).isDisplayed()).isTrue();
    }

    @Then("I confirm {string} for email")
    public void iConfirmForEmail(String msg) {
        assertThat(getDriver().findElement(By.xpath("//*[@formcontrolname='email']/../../..//*[contains(text(),'"+msg+"')]")).isDisplayed()).isTrue();

    }

    @When("I use {string} into email field")
    public void iUseIntoEmailField(String email) {
        Random random = new Random();
        int y = random.nextInt(1000);
       String email1 = y + "@abc.com";
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email1);


    }
}
