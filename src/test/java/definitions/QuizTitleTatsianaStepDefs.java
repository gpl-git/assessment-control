package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.nio.charset.Charset;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTitleTatsianaStepDefs {
    @When("I click on {string} button")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();

    }

    @And("quiz title {string} should be displayed at the top")
    public void quizTitleShouldBeDisplayedAtTheTop(String title) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='header-form-group']")).isDisplayed()).isTrue();
    }

    @And("I click on the field")
    public void iClickOnTheField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname ='name']")).click();
    }

    @And("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        String actual =
        getDriver().findElement(By.xpath("//div[@class='mat-input-wrapper mat-form-field-wrapper']")).getText();
        System.out.println(actual);
        assertThat(actual.equals(message));
    }

    @And("I click outside the title field")
    public void iClickOutsideTheTitleField() {
        getDriver().findElement(By.xpath("//ac-quiz-builder-page[@class='ng-star-inserted']")).click();
    }

    @And("no error message should be displayed")
    public void noErrorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='header-form-group']")).isDisplayed()).isTrue();

    }

    @And("I type {string} symbols as quiz title")
    public void iTypeSymbolsAsQuizTitle(String symbol) {
        byte[] array = new byte[1001];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
    }

    @And("quiz title should be displayed")
    public void quizTitleShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='header-form-group']")).isDisplayed()).isTrue();
    }

}
