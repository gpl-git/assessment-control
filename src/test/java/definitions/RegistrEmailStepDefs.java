package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
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
}
