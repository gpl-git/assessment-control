package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class VSForgotPassMyStepdefs {
    @Given("I navigate to the {string} page")
    public void iNavugateToThePage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("Site '" + url + "' is not supported.");
        }
    }

    @When("I enter {string} into email input")
    public void iEnterIntoEmailInput(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter{string} into password")
    public void iEnterIntoPassword(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @When("I click {string}")
    public void iClick(String SignIn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+SignIn+"')]")).click();
    }

    @And("I wait for {int} second")
    public void iWaitForSecond(int sec) throws InterruptedException {
        Thread.sleep(sec* 1000L);
    }
//==========================================================

    @Then("I click on {string}")
    public void iClickOn(String forgotMyPass) {
        getDriver().findElement(By.xpath("//a[contains(text(),'I forgot my password')]")).click();
    }

    @And("I should see the header as {string}")
    public void iShouldSeeTheHeaderAs(String Reset) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'Reset Password Request')]")).isDisplayed()).isTrue();
    }

    @When("I click on {string} email field")
    public void iClickOnEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys("mavunaku@gmail.com");
    }

    @Then("I submit my request by clicking {string}")
    public void iSubmitMyRequestByClicking(String send) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Request Password Reset')]")).click();
    }

    @And("I should see the page with {string}")
    public void iShouldSeeThePageWith(String Confirmed) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'Your request is confirmed')]")).isDisplayed()).isTrue();
    }

    @Then("I redirecting myself to the {string} link via my email")
    public void iRedirectingMyselfToTheLinkViaMyEmail(String reset_link) {
        getDriver().get("http://ask-qa.portnov.com//#/reset-password/8108/12fd2524f11b165b2f9f6af9ce2523b1a8a95a15");
    }

    @And("I enter new {string}")
    public void iEnterNew(String newPass) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(newPass);
    }

    @And("confirm my new {string} one more time")
    public void confirmMyNewOneMoreTime(String confirmPass) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(confirmPass);
    }

    @Then("I click {string} to change my password")
    public void iClickToChangeMyPassword(String Reset) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
    }

    @When("I should be redirected to the page with {string}")
    public void iShouldBeRedirectedToThePageWith(String Confirmation) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'Your Password was Changed')]")).isDisplayed()).isTrue();
    }
}
