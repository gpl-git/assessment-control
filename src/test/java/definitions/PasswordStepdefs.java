package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class PasswordStepdefs {
    @Given("I open {string} page site")
    public void iOpenPageSite(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @When("I type {string} into pass word field")
    public void iTypeIntoPassWordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @Then("error message {string} should be display SJ")
    public void errorMessageShouldBeDisplaySJ(String error1) {
        getDriver().findElement(By.xpath("//*[contains(text(),\"mat-error\")]")).isDisplayed();
    }

    @Then("I clear {string} field SJ")
    public void iClearFieldSJ(String error2) {
        getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).isDisplayed();
    }

    @When("I clear {string} field")
    public void iClearField(String error2) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).clear();
    }

    @When("I type {string} into password field SJ")
    public void iTypeIntoPasswordFieldSJ(String error3) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(error3);
    }

    @Then("error message {string} should be display I")
    public void errorMessageShouldBeDisplayI(String error4) {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Whitespaces')]")).isDisplayed();
    }

    @Then("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmE1) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"confirmPassword\"]")).sendKeys(confirmE1);
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String CE1) {
        getDriver().findElement(By.xpath("//div//*[@class=\"mat-error ng-star-inserted\"]")).isDisplayed();
    }

    @When("I clear {string} field I")
    public void iClearFieldI(String CE2) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"confirmPassword\"]")).clear();
    }



    @When("I type {string} into password field I")
    public void iTypeIntoPasswordFieldI(String CE4) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"confirmPassword\"]")).sendKeys(CE4);
    }



    @Then("error message {string} should be display III")
    public void errorMessageShouldBeDisplayIII(String CE4) {
        getDriver().findElement(By.xpath("//div//*[@class=\"mat-error ng-star-inserted\"]")).isDisplayed();
    }



    @Then("error message {string} should be display.")
    public void errorMessageShouldBeDisplay(String arg0) {
        getDriver().findElement(By.xpath("//mat-error[@id='mat-error-1']")).isDisplayed();
    }

    @When("I type {string} into confirm password field Ir")
    public void iTypeIntoConfirmPasswordFieldIr(String match) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"confirmPassword\"]")).sendKeys(match);
    }

    @Then("error message {string} should be displayed for miss match")
    public void errorMessageShouldBeDisplayedForMissMatch(String missMatch) {
        getDriver().findElement(By.xpath("//*[contains(text(), 'match')]")).isDisplayed();
    }

    @When("I type {string} into confirm password field Iri")
    public void iTypeIntoConfirmPasswordFieldIri(String NoE) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"confirmPassword\"]")).sendKeys(NoE);

    }



    @Then("I click {string} button for register")
    public void iClickButtonForRegister(String arg0) {
        getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
}
