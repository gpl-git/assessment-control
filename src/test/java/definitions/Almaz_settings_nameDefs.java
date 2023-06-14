package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Almaz_settings_nameDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This site " + url + " is not supported.");
        }
    }

    @And("I will  wait for {int} sec")
    public void iWillWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @Then("I input {string} into email field")
    public void iInputIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I input {string} into password field")
    public void iInputIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I will click {string} button")
    public void iWillClickButton(String button) {
        getDriver().findElement(By.xpath("//span[(text()= '" + button + "')]")).click();
    }

    @And("I will click {string} menu item")
    public void iWillClickMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I type {string} into Full Name field")
    public void iTypeIntoFullNameField(String fullName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(fullName);
    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String xpath, String value) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
    }

    @When("I delete text into Full Name field")
    public void iDeleteTextIntoFullNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.ADD);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.BACK_SPACE);
    }

    @Then("element with xpath {string} should be displayed")
    public void elementWithXpathShouldBeDisplayed(String element) {
        assertThat(getDriver().findElement(By.xpath(element)).isEnabled()).isTrue();
    }

    @Then("user role {string} should be displayed")
    public void userRoleShouldBeDisplayed(String role) {
        String result = getDriver().findElement(By.xpath("//p")).getText();
        assertThat(result.equals(role)).isTrue();
    }

    @When("I type {int} alphanumeric characters for first name and {int} ones for last name into full name field")
    public void iTypeNameIntoFullNameField(int num1, int num2) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        boolean useLetters = true;
        boolean useNumbers = false;
        String firstName = RandomStringUtils.random(num1, useLetters, useNumbers);
        String lastName = RandomStringUtils.random(num2, useLetters, useNumbers);
        String fullname = firstName + " " + lastName;
        System.out.println(fullname);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(fullname);
    }

    @And("I verify that student name {string} should be displayed in the upper left corner of the page")
    public void iVerifyStudentNameShouldBeDisplayedInTheUpperLeftCornerOfThePage(String fullname) {
        String result = getDriver().findElement(By.xpath("//h3")).getText();
        System.out.println(result);
        assertThat(result.contains(fullname)).isTrue();
    }

    @Then("I verify that student name {string} should be displayed")
    public void iVerifyThatStudentNameShouldBeDisplayed(String fullname) {
        String result = getDriver().findElement(By.xpath("//mat-card")).getText();
        System.out.println(result);
        assertThat(result.contains(fullname)).isTrue();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errmessage) {
        String result = getDriver().findElement(By.xpath("//mat-error")).getText();
        System.out.println(result);
        assertThat(result.contains(errmessage)).isTrue();
    }
}