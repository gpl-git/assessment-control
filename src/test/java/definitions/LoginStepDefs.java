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
       if(url.equals("login")) {
           getDriver().get("http://ask-qa.portnov.com/#/login");
       }else if (url.equals("registration")){
           getDriver().get("http://ask-qa.portnov.com/#/registration");
       }else{
           System.out.println("This site " + url+ " is not supported.");
       }

    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'password']")).sendKeys(password);
    }


    @When("click on {string} button")
    public void clickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I verify that current url contains {string}")
    public void iVerifyThatCurrentUrlContains(String page) {
       String curUrl= getDriver().getCurrentUrl();
       assertThat(curUrl.contains(page)).isTrue();
    }

    @Then("I verify that user role is {string}")
    public void iVerifyThatUserRoleIs(String role) {
        String info = getDriver().findElement(By.xpath("//*[@class='info']")).getText();
        assertThat(info.contains(role.toUpperCase())).isTrue();
    }


}
