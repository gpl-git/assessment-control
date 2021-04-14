package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if(url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
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
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I verify user role as {string}")
    public void iVerifyUserRoleAs(String userRole) {
        String actualRole = getDriver().findElement(By.xpath("//div[@class='info']")).getText();
        assertThat(actualRole.contains(userRole)).isTrue();
    }
}
