package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ChangeUserNameStepDefs {
    @Then("I select {string} on the {string} tab")
    public void iSelectOnTheTab(String userName, String tabName) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + tabName + "')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + userName + "')]")).click();
        Thread.sleep(1000);
    }

    @Then("I type {string} in Full Name field")
    public void iTypeInFullNameField(String name) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(name);
    }

    @When("I click the Options button and select Change User's Name")
    public void iClickTheOptionsButtonAndSelectChangeUserSName() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='right']/button[@class='mat-raised-button mat-accent']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button//mat-icon[text()='edit']")).click();
        Thread.sleep(1000);
    }

    @Then("I remove the data in Full Name field")
    public void iRemoveTheDataInFullNameField() throws InterruptedException{
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        Thread.sleep(1000);
    }

    @Then("Name {string} should be displayed in the header of user details mat-card")
    public void nameShouldBeDisplayedInTheHeaderOfUserDetailsMatCard(String name) {
        String actualText = getDriver().findElement(By.xpath("//h2")).getText();
        assertThat(actualText).contains(name);
    }

    @And("Name {string} should be displayed in the list of users on the {string} tab")
    public void nameShouldBeDisplayedInTheListOfUsersOnTheTab(String name, String tabName) throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Management')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + tabName + "')]")).click();
        Thread.sleep(1000);
        String actualText = getDriver().findElement(By.xpath("//*[@class='mat-tab-body-wrapper']")).getText();
        assertThat(actualText).contains(name);
        Thread.sleep(1000);
//        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'"+name+"')]")).isDisplayed()).isTrue();
//        Thread.sleep(2000);
    }

    @And("I change user name {string} on the tab {string} to the name {string}")
    public void iChangeUserNameOnTheTabToTheName(String userName, String tabName, String newName) throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Management')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + tabName + "')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + userName + "')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='right']/button[@class='mat-raised-button mat-accent']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button//mat-icon[text()='edit']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(newName);
        getDriver().findElement(By.xpath("//span[contains(text(),'Change')]")).click();
    }

    @Then("Error message {string} should be displayed below the Full Name field")
    public void errorMessageShouldBeDisplayedBelowTheFullNameField(String errorMessage) throws InterruptedException {
//        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+errorMessage+"')]")).isDisplayed()).isTrue();
//        Thread.sleep(2000);
        String actualText = getDriver().findElement(By.xpath("//mat-form-field")).getText();
        assertThat(actualText).contains(errorMessage);
        Thread.sleep(2000);
    }

    @And("I click on dialog modal window")
    public void iClickOnDialogModalWindow() throws InterruptedException {
        getDriver().findElement(By.xpath("//h1")).click();
        Thread.sleep(2000);
    }

    @Then("Button {string} is disabled")
    public void buttonIsDisabled(String buttonName) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]/..")).isEnabled()).isFalse();
    }

    @Then("Button {string} is enabled")
    public void buttonIsEnabled(String buttonName) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]/..")).isEnabled()).isTrue();

    }

    @And("I type First Name of {int} characters and Last Name of {int} characters with {string} between them in Full Name field")
    public void iTypeFirstNameOfCharactersAndLastNameOfCharactersWithBetweenThemInFullNameField(int charNumFirst, int charNumLast, String between) {
        boolean useLetters = true;
        boolean useNumbers = true;
        boolean useCharacters = true;
        String generatedFirstName = RandomStringUtils.random(charNumFirst, useLetters, useNumbers);
        String generatedLastName = RandomStringUtils.random(charNumLast, useLetters, useNumbers);
        String newName = generatedFirstName + between + generatedLastName;
        System.out.println(newName);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(newName);
    }
}
