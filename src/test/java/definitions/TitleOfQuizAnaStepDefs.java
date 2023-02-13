package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TitleOfQuizAnaStepDefs {
    @And("I clear quiz title")
    public void iClearQuizTitle() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.BACK_SPACE);
    }

    @And("I click outside of the title field")
    public void iClickOutsideOfTheTitleField() {
        getDriver().findElement(By.xpath("//*[@class='ng-star-inserted']")).click();
    }

    @Then("error-message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();
        System.out.println(getDriver().getCurrentUrl());
        assertThat(actualMessage.equals(expectedMessage)).isTrue();

    }

    @When("I click Title Of The Quiz field")
    public void iClickTitleOfTheQuizField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).click();
    }

    @When("When I type {string} as quiz title")
    public void whenITypeAsQuizTitle(String QuizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(QuizTitle);
    }

    @When("I type {int} characters as {string}")
    public void iTypeCharactersAs(int num, String QuizTitle) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(generatedString);
    }
}


