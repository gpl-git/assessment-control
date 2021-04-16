package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println(url + " this site is not supported");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @When("I type {string} into email filed")
    public void iTypeIntoEmailFiled(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname ='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname ='password']")).sendKeys(pwd);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @Then("I verify user role as {string}")
    public void iVerifyUserRoleAs(String userRole) {
        String actualRole = getDriver().findElement(By.xpath("//div[@class='info']")).getText();
        assertThat(actualRole.contains(userRole)).isTrue();
    }

    @Then("password is masked and copy and cut disabled")
    public void passwordIsMaskedAndCopyCutDisabled() {
        String attribute = "type";

        WebElement element = getDriver().findElement(By.xpath("//input[@formcontrolname ='password']"));
        String attributeValue = element.getAttribute("type");
        assertThat(attributeValue).isEqualTo("password");
        System.out.println(attributeValue);
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String message) {
        String actMessage = getDriver().findElement(By.xpath("//simple-snack-bar")).getText();
        System.out.println(actMessage);
        assertThat(actMessage.contains(message)).isTrue();
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualMessage).isEqualTo(message);
    }

    @When("I type new email")
    public void iTypeNewEmail() {
        Random randomGenerator = new Random();
        int randonInt = randomGenerator.nextInt(1000);
        String newEmail ="test"+randonInt+"@abc.com";
        getDriver().findElement(By.xpath("//input[@formcontrolname ='email']")).sendKeys(newEmail);
        System.out.println(newEmail);

    }

    @And("I type new email into email field")
    public void iTypeNewEmailIntoEmailField() {
        Random randomGenerator = new Random();
        int randonInt = randomGenerator.nextInt(1000);
        String newEmail ="stud"+randonInt+"@test.com";
        getDriver().findElement(By.xpath("//input[@formcontrolname ='email']")).sendKeys(newEmail);
        System.out.println(newEmail);
    }
}