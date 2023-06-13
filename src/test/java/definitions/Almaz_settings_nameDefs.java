package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import javax.security.auth.kerberos.KeyTab;
import java.security.Key;

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
        getDriver().findElement(By.xpath("//span[contains(text(), '" + button + "')]")).click();
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

    @And("I clicked {string} button")
    public void iClickedButton(String butChange) {
        getDriver().findElement(By.xpath("//span[text()='Change']")).click();
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

//    @And("I will click to element with xpath {string}")
//    public void iWillClickToElementWithXpath(String xpath1) {
//    getDriver().findElement(By.xpath("//h1[@class='mat-dialog-title']")).click();
//    }


//    @And("I will click to element with xpath {string}")
//    public void iWillClickToElementWithXpath(String xpath) {
//        WebElement element = getDriver().findElement(By.xpath("//h1[@class='mat-dialog-title']"));
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click();", element);


//    @Then("button with xpath {string} in disabled")
//    public void buttonWithXpathInDisabled(String xpath) {
//        getDriver().findElement(By.xpath("//button[@disabled='']"));
    }
