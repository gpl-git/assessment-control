package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class lastNameStepDefs {


    @When("I type {string} into {string} field T")
    public void iTypeIntoFieldT(String inputName, String fieldName) {

        getDriver().findElement(By.xpath("//input[@placeholder='" + fieldName + "']")).sendKeys(inputName);
    }

    @Then("message {string} should be displayed T")
    public void messageShouldBeDisplayedT(String message) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + message + "')]")).isDisplayed()).isTrue();
    }

    @When("I delete {string} user T")
    public void iDeleteUserT(String fullUserName) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + fullUserName + "')]")).click();
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']/..//*[contains(text(),'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button[@class='mat-menu-item']/..//mat-icon[contains(text(),'delete')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-dialog-container[@id='mat-dialog-0']/..//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);

    }

    @Given("I go to {string} page T")
    public void iGoToPageT(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }
    }

    @And("I wait for {int} sec T")
    public void iWaitForSecT(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @When("I click button {string} T")
    public void iClickButtonT(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I type {string} into email field T")
    public void iTypeIntoEmailFieldT(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }
    @And("I enter {string} as password T")
    public void iEnterAsPasswordT(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @When("I click on {string} menu item T")
    public void iClickOnMenuItemT(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @Then("message {string} should be displayed TE")
   public void messageShouldBeDisplayedTE(String errorMessage) {
       assertThat(getDriver().findElement(By.xpath("//*[@class='cdk-overlay-container']")).isDisplayed()).isTrue();
    }

    @Then("message {string} should be displayed TD")
    public void messageShouldBeDisplayedTD(String err) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='mat-error ng-star-inserted']")).isDisplayed()).isTrue();

    }
}



