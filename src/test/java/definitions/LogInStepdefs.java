package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class LogInStepdefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("forgot-password")) {
            getDriver().get("http://ask-qa.portnov.com/#/forgot-password");
        } else {
            System.out.println("This site " + url + "is not supported.");
        }
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);

    }

    @When("I enter {string} into email field")
    public void iEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);


    }

    @And("I type password {string}")
    public void iTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I hit button {string}")
    public void iHitButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();

    }

    @When("I click {string}")
    public void iClick(String logout) {
        getDriver().findElement(By.xpath("//div[.='Log Out']")).click();
    }

    @Then("confirmation window should appear")
    public void confirmationWindowShouldAppear() {
        getDriver().findElement(By.xpath("//*[@role='dialog']"));
    }

    @And("I click {string} button")
    public void iClickButton(String logout) {
        getDriver().findElement(By.xpath("//*[@class='mat-button mat-warn']")).click();

    }

    @Then("return to {string}page")
    public void returnToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This site " + url + "is not supported");
        }
    }

    @Then("{string}page should be appear")
    public void pageShouldBeAppear(String page) {
        getDriver().navigate().to("http://ask-qa.portnov.com/#/registration");
    }


   // @And("I type {string} into last name field")
    //public void iTypeIntoLastNameField(String lastname) {
        //getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastname);
    //}

    @And("I enter {string} in email field")
    public void iEnterInEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string}into group code field")
    public void iTypeIntoGroupCodeField(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @And("I enter {string} into password field")
    public void iEnterIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I enter {string} into confirm password field")
    public void iEnterIntoConfirmPasswordField(String confirm) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirm);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("confirmation page should appear")
    public void confirmationPageShouldAppear() {
        getDriver().navigate().to("http://ask-qa.portnov.com/#/registration-confirmation");
    }


    @When("I click Back to Login Page")
    public void iClickBackToLoginPage() {
        getDriver().findElement(By.xpath("//span[.='Back to Login Page']")).click();

    }

    @Then("I see {string} page")
    public void iSeePage(String page) {
        getDriver().navigate().back();
    }


    @Then("password field should contain error message")
    public void passwordFieldShouldContainErrorMessage() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));

    }

    @Then("email field should contain error message")
    public void emailFieldShouldContainErrorMessage() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));

    }

    @Then("pop up window with error message text should show up")
    public void popUpWindowWithErrorMessageTextShouldShowUp() {
    assertThat(getDriver().findElement(By.xpath("//simple-snack-bar")).isDisplayed()).isTrue();

    }

    @Then("password should be masked")
    public void passwordShouldBeMasked() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type").
                equals("password")).isTrue();


    }

    @Then("I do right click on password field to see a menu where cut is disable")
    public void iDoRightClickOnPasswordFieldToSeeAMenuWhereCutIsDisable() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type").
                equals("password")).isTrue();
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("type enter")
    public void typeEnter() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Keys.SPACE);
    }

    @Then("email field should contain error message should be present")
    public void emailFieldShouldContainErrorMessageShouldBePresent() {
        getDriver().findElement(By.xpath("//*[@id='mat-error-0']"));

    }

    @When("I type enter into email field")
    public void iTypeEnterIntoEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Keys.SPACE);

    }

    @Then("I do right click on password field to see a menu where copy is disable")
    public void iDoRightClickOnPasswordFieldToSeeAMenuWhereCopyIsDisable() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type").
                equals("password")).isTrue();

    }

    @Then("I click on tab {string}")
    public void iClickOnTab(String tab) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Quizzes')]"));

    }

    @Then("message {string} is displayed in password field")
    public void messageIsDisplayedInPasswordField(String errorMessage) {
        String actualError= getDriver().findElement(By.xpath("//mat-error")).getText();
        System.out.println(actualError);
    }

    @Then("message {string} is displayed in email field")
    public void messageIsDisplayedInEmailField(String errorMessage) {
        String actualError= getDriver().findElement(By.xpath("//mat-error")).getText();
        System.out.println(actualError);
    }

    @When("I type {string} email into email field")
    public void iTypeEmailIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);


    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String error) {
        assertThat(getDriver().findElement(By.xpath("//mat-error")).isDisplayed()).isTrue();
    }

    @When("I clear email field")
    public void iClearEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).clear();
    }


    @And("I click confirm {string}")
    public void iClickConfirm(String button) {
        getDriver().findElement(By.xpath("//span[text()='Log Out']")).click();
    }
}



















