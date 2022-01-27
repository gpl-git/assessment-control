package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SeleniumLogIN {
    @Given("I open login page Assessment Control Portnov Computer School")
    public void iOpenLoginPageAssessmentControlPortnovComputerSchool() {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @Then("I verify that page title is {string}")
    public void iVerifyThatPageTitleIs(String title) {
        assertThat(getDriver().getTitle()).contains(title);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click on button {string}")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + button + "')]")).click();
    }

    @Then("I will be redirected to my profile")
    public void iWillBeRedirectedToMyProfile() {
        assertThat(getDriver().findElement(By.xpath("//h5[contains(text(),'Home')]")).isDisplayed()).isTrue();
    }

    @Then("I should receive error Authentication failed. User not found or password does not match")
    public void iShouldReceiveErrorAuthenticationFailedUserNotFoundOrPasswordDoesNotMatch() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'Authentication failed. User not found or password does not match')]")).isDisplayed()).isTrue();
    }

    @Then("password should be masked")
    public void passwordShouldBeMasked() {
        WebElement input = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        boolean isEncrypted = input.getAttribute("type").equals("password");
    }

    @Then("user try copy password")
    public void userTryCopyPassword() {
        String mytext = getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getText();
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(mytext);
    }

    @Then("I should receive error Whitespaces are not allowed")
    public void iShouldReceiveErrorWhitespacesAreNotAllowed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespaces are not allowed')]")).isDisplayed()).isTrue();
    }

    @Then("I click on  log out")
    public void iClickOnButtonLogOut() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]]")).click();
    }

    @Then("I click on log out")
    public void iClickOnLogOut() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
    }

    @Then("I click on element log out")
    public void iClickOnElementLogOut() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
    }

    @Then("I try to cut password field")
    public void iTryToCutPasswordField() {
        // or any locator strategy that you find suitable
        WebElement locOfOrder = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        Actions act = new Actions(getDriver());
        act.moveToElement(locOfOrder).doubleClick().build().perform();
// catch here is double click on the text will by default select the text
// now apply copy command

        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(Keys.chord(Keys.CONTROL, "x"));
// now apply the command to paste
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    @Then("I should receive error on bottom email field This field is required")
    public void iShouldReceiveErrorOnBottomEmailFieldThisFieldIsRequired() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).isDisplayed()).isTrue();
    }

    @Then("I should receive error on bottom password field This field is required")
    public void iShouldReceiveErrorOnBottomPasswordFieldThisFieldIsRequired() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']/../../../div/div/mat-error")).isDisplayed()).isTrue();
    }

    @Then("I try to copy email field")
    public void iTryToCopyEmailField() {
        // or any locator strategy that you find suitable
        WebElement locOfOrder = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        Actions act = new Actions(getDriver());
        act.moveToElement(locOfOrder).doubleClick().build().perform();
// catch here is double click on the text will by default select the text
// now apply copy command

        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
// now apply the command to paste
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    @Then("I try to copy password field")
    public void iTryToCopyPasswordField() {
        // or any locator strategy that you find suitable
        WebElement locOfOrder = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        Actions act = new Actions(getDriver());
        act.moveToElement(locOfOrder).doubleClick().build().perform();
// catch here is double click on the text will by default select the text
// now apply copy command

        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
// now apply the command to paste
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    @Then("I click sign in {int} times")
    public void iClickSignInTimes(int num) {
        for (int i = 0; i < num; i++) {
            getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        }
    }

    @When("I clear email field")
    public void iClearEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).clear();
    }
}





