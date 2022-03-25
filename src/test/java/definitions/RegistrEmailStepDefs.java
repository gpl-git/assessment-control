package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static support.TestContext.getDriver;

public class RegistrEmailStepDefs {
    @When("I type {string} into {string} field")
    public void iTypeIntoField(String inputField, String fieldName) {
        getDriver().findElement(By.xpath("//input[@placeholder='"+fieldName+"']")).sendKeys(inputField);
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} user")
    public void iDeleteUser(String fullName) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+fullName+"')]")).click();
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']/..//*[contains(text(),'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button[@class='mat-menu-item']/..//mat-icon[contains(text(),'delete')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-dialog-container[@id='mat-dialog-0']/..//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @And("I enter {int} alphanumeric characters on the left of @domain as email")
    public void iEnterAlphanumericCharactersOnTheLeftOfDomainAsEmail(int number) {
//        int length = number;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(generatedString + "@test.com");
        System.out.println(generatedString + "@test.com");
    }

    @And("I enter {int} alphanumeric characters on the right of @ before top-level domain as email")
    public void iEnterAlphanumericCharactersOnTheRightOfBeforeTopLevelDomainAsEmail(int number) {
//        int length = number;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters,useNumbers);
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@" + generatedString + ".com");
        System.out.println("test@" + generatedString + ".com");
    }

    @And("I enter {int} @ {int} alphanumeric characters .com as email")
    public void iEnterAlphanumericCharactersComAsEmail(int before, int after) {
//        int lengthBefore = before;
//        int lengthAfter = after;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString1 = RandomStringUtils.random(before, useLetters,useNumbers);
        String generatedString2 = RandomStringUtils.random(after, useLetters,useNumbers);
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(generatedString1 + "@" + generatedString2 + ".com");
        System.out.println(generatedString1 + "@" + generatedString2 + ".com");
    }
}
