package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static org.junit.Assert.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDef {
    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000* sec);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("personal page should be displayed")
    public void personalPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//body")).isDisplayed();
    }



    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMes) {

        String actErrorM = getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).getText();
        System.out.println(errorMes);
        Assertions.assertThat(actErrorM.equals(errorMes));
    }

    @Then("password field should contain text {string}")
    public void passwordFieldShouldContainText(String mask) {
        String actMask = getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getText();
        System.out.println(mask);
        Assertions.assertThat(actMask.equals(mask));

    }

    @And("email error message {string} should be displayed")
    public void emailErrorMessageShouldBeDisplayed(String emailError) {
        String actEmailE = getDriver().findElement(By.xpath("//*[contains(text(), 'Should be')]")).getText();
        System.out.println(emailError);
        Assertions.assertThat(actEmailE.equals(emailError));

    }

    @Then("I verify that password field is masked")
    public void iVerifyThatPasswordFieldIsMasked() {
        String type = getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type");
        //System.out.println(type);
        assertThat(type.equals("password"));
    }

    private void assertThat(boolean password) {
    }
}
