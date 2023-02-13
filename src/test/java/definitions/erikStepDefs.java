package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class erikStepDefs {
    @Given("I open {string} page ER")
    public void iOpenPageER(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This website is not supported: " + url);
        }
    }


    @And("I wait for {int} seconds ER")
    public void iWaitForSecondsER(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }


    @When("I type {string} into email field ER")
    public void iTypeIntoEmailFieldER(String email) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(email);
        getDriver().findElement(By.xpath("//body")).click();
    }


    @When("I type {string} into password field ER")
    public void iTypeIntoPasswordFieldER(String password) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
        getDriver().findElement(By.xpath("//body")).click();
    }

    @And("I click {string} button ER")
    public void iClickButtonER(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @Then("Home page should be displayed ER")
    public void homePageShouldBeDisplayedER() {
        String url = getDriver().getCurrentUrl();
        //assertThat(getDriver().findElement(By.xpath("//h5[contains(text(), 'Home')]")).isDisplayed()).isTrue();
        assertThat(getDriver().getCurrentUrl().equals("http://ask-qa.portnov.com/#/home")).isTrue();
    }

    @Then("{string} error message will be displayed ER")
    public void errorMessageWillBeDisplayedER(String error) {
        getDriver().findElement(By.xpath("//body")).click();
        String actual = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(actual.contains(error)).isTrue();
    }

    @Then("Password field must be masked ER")
    public void passwordFieldMustBeMasked() {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1'][@type='password']")).isDisplayed();
//        getDriver().findElement("//body").

    }
}