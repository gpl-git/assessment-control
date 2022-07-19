package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class NataliaKorsStepDefs {
    @Given("I NK go to {string} page")
    public void iNKGoToPage(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("this site " + url +" is not supported");
        }
    }

    @When("I NK type {string} in the Password field")
    public void iNKTypeInThePasswordField(String password) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I NK click on the Confirm Password field")
    public void iNKClickOnTheConfirmPasswordField() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='confirmPassword']")).click();
    }

    @Then("NK error message {string} is displayed")
    public void nkErrorMessageIsDisplayed(String errorMessage) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'Should be at least 5 characters')]")).getText();
    }

    @And("I NK clear Password field")
    public void iNKClearPasswordField() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='password']")).clear();
    }


    @Then("NLK error message {string} is displayed")
    public void nlkErrorMessageIsDisplayed(String message) {
        String Result = (getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).getText());
        System.out.println(Result);
    }


    @And("I NK refresh the {string} page")
    public void iNKRefreshThePage(String url) {
        getDriver().navigate().refresh();
    }

    @When("I NK type {string} into password field")
    public void iNKTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I NK enter {string} into confirm password field")
    public void iNKEnterIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I Nk submit the form")
    public void iNkSubmitTheForm() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("NK Error message will be {string}")
    public void nkErrorMessageWillBe(String error) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'Entered passwords should match')]")).getText();
    }


    @And("I NK type {string} in the Confirm Password field")
    public void iNKTypeInTheConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("NK error message {string} is not displayed")
    public void nkErrorMessageIsNotDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).isDisplayed()).isFalse();
    }

    @When("I NK enter {string} into First Name field")
    public void iNKEnterIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I NK enter {string} into Last Name field")
    public void iNKEnterIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I NK enter {string} into Email field")
    public void iNKEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I NK enter {string} into Group Code")
    public void iNKEnterIntoGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }


    @And("I NK see verification message")
    public void iNKSeeVerificationMessage() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']"));
    }

    @Then("NK verification message not displayed")
    public void nkVerificationMessageNotDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).isDisplayed()).isFalse();
    }


    @When("I Nk type {string} in the Password Field")
    public void iNkTypeInThePasswordField(String password) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I Nk type {string} in the Confirm Password Field")
    public void iNkTypeInTheConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }


    @Then("Nk error message {string} will display")
    public void nkErrorMessageWillDisplay(String error) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespaces are not allowed')]")).getText();
    }
}
