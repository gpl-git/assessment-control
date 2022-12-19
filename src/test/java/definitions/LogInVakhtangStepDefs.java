package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.atomicIntegerFieldUpdater;
import static support.TestContext.getDriver;

public class LogInVakhtangStepDefs {
    @Given("I open {string} page VT")
    public void iOpenPageVT(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("reqistration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("Your site '"+url+"' is not supported.");
        }
    }

    @When("I type {string} into email text field VT")
    public void iTypeIntoEmailTextFieldVH(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password text field VT")
    public void iTypeIntoPasswordTextFieldVT(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click {string} button VT")
    public void iClickButtonVT(String btnName) {
        getDriver().findElement(By.xpath(" //span[contains(text(),'"+btnName+"')]")).click();
    }

    @And("I wait for {int} sec VT")
    public void iWaitForSecVT(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @Then("Menu with items is displayed VT")
    public void menuWithItemsIsDisplayedVt() {
        assertThat(getDriver().findElement(By.xpath("//mat-list[@class='mat-list']")).isDisplayed()).isTrue();
    }

    @And("I logout VT")
    public void iLogoutVT() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
        getDriver().findElement(By.xpath("//button[@type='button'][2]")).click();
    }

    @Then("email error message {string} is displayed VT")
    public void emailErrorMessageIsDisplayedVt(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//input[@formcontrolname='email']/../../../..//mat-error[@role='alert']")).getText();
        assertThat(expectedMessage.equals(actualMessage)).isTrue();
        System.out.println(getDriver().findElement(By.xpath("//input[@formcontrolname='email']/../../../..//mat-error[@role='alert']")).getText());

    }

    @When("I type email with a whitespace in from of it {string} into email text field VT")
    public void iTypeEmailWithAWhitespaceInFromOfItIntoEmailTextFieldVT(String whiteSpEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(whiteSpEmail);
    }

    @When("I type password with a whitespace in front of it {string} into password text field VT")
    public void iTypePasswordWithAWhitespaceInFrontOfItIntoPasswordTextFieldVT(String whiteSpPwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(whiteSpPwd);
    }

    @Then("password error message {string} should be displayed VT")
    public void passwordErrorMessageShouldBeDisplayedVt(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//input[@formcontrolname='password']/../../../..//mat-error[@role='alert']")).getText();
        assertThat(expectedMessage.equals(actualMessage)).isTrue();
        System.out.println(getDriver().findElement(By.xpath("//input[@formcontrolname='password']/../../../..//mat-error[@role='alert']")).getText());

    }


    @Then("password Authentication error message should be displayed VT")
    public void passwordAuthenticationErrorMessageShouldBeDisplayedVT() {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Authentication')]")).isDisplayed()).isTrue();
    }

    @Then("user role {string} is displayed VT")
    public void userRoleIsDisplayedVt(String expectedRole) {
        String actualRole = getDriver().findElement(By.xpath("//div[@class='info']//p")).getText();
//        System.out.println(getDriver().findElement(By.xpath("//div[@class='info']//p")).getText());
        assertThat(expectedRole.equals(actualRole)).isTrue();

    }

    @Then("I verify that password field has type {string} VT")
    public void iVerifyThatPasswordFieldHasTypeVt(String expectedType) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type")).isEqualTo(expectedType);
        System.out.println(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type"));

    }
}
