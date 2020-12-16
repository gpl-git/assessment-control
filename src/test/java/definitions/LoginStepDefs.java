package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDefs {
    @Given("I open {string}")
    public void iOpen(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("Unsupported site");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I enter {string} as email")
    public void iEnterAsEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);

    }

    @And("I enter {string} as password")
    public void iEnterAsPassword(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pwd);

    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I verify that user role is equal to {string}")
    public void iVerifyThatUserRoleIsEqualTo(String userRole) {
        String actualRole = getDriver().findElement(By.xpath("//header")).getText();
        assertThat(actualRole.contains(userRole)).isTrue();
    }

    @And("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+link+"')]")).click();
    }
}
