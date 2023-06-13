package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class QuizTitleAndriiStepDefs {
    @Given("I open page {string}")
    public void iOpenPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I provide login {string} for user")
    public void iprovideLoginForUser(String email) {
        getDriver().findElement(By.xpath("//*[@placeholder='Email *']")).sendKeys(email);
    }

    @And("I wait {int} sec")
    public void iWaitSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @When("I provide password {string} for user")
    public void iProvidePasswordForUser(String password) {
        getDriver().findElement(By.xpath("//*[@placeholder='Password *']")).sendKeys(password);
    }

    @When("I klick on button {string}")
    public void iKlickOn(String butName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+butName+"')]")).click();
    }

    @When("I click on menu {string}")
    public void iClickOnMenu(String menuName) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuName+"')]")).click();
    }

    @When("I click on button {string} and put new name {string}")
    public void iClickOnButtonAndPutNewName(String buttonName, String newName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(newName);
        getDriver().findElement(By.xpath("//*[contains(text(),'Should no more than 100 characters')]"));
    }
}
