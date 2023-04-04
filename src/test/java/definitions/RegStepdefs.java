package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegStepdefs {
    @And("I type {string} into firstName field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(firstName);
    }

    @And("I type {string} into lastName field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(lastName);
    }

    @And("I type {string} into groupcode field")
    public void iTypeIntoGroupcodeField(String groupfield) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys(groupfield);
    }


    @And("I type {string} into confirmpassword field")
    public void iTypeIntoConfirmpasswordField(String confirmpassword) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys(confirmpassword);
    }


    @Then("page with text {string} is displayed")
    public void pageWithTextIsDisplayed(String text) {
    }


    @And("lastName error massage  should be displayed")
    public void lastnameErrorMassageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).isDisplayed()).isTrue();
    }


    @Then("error massage {string} should be displayed")
    public void errorMassageShouldBeDisplayed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();
    }

    @Then("LN error massage should be displayed")
    public void lnErrorMassageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespace')]")).isDisplayed()).isTrue();
    }

    @And("I type {int} characters into lastName field")
    public void iTypeCharactersIntoLastNameField(int num) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(num, useLetters,useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(generatedString);
    }

    @Then("data too long error massage {string} should be displayed")
    public void dataTooLongErrorMassageShouldBeDisplayed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//body/div[2]/div[1]/div[1]/snack-bar-container[1]/simple-snack-bar[1]")).getText();
        assertThat(actMessage.equals(expMessage)).isFalse();
    }

    @Then("lastName error massage {string} should be displayed")
    public void lastnameErrorMassageShouldBeDisplayed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespace')]")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();

    }

    @Then("LastNameerror massage should be displayed")
    public void lastnameerrorMassageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Data too long for column 'name' at row 1')]")).isDisplayed()).isTrue();
    }

}

