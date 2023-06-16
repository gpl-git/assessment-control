package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class HomePageLinksAnastasiaStepDefs {
    @Given("I go to {string} page AP")
    public void iGoToPageAP(String url) {
        if(url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This site " + url + " is not supported.");
        }

    }

    @When("I type {string} into email field AP")
    public void iTypeIntoEmailFieldAP(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field AP")
    public void iTypeIntoPasswordFieldAP(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }


    @When("I click {string} button AP")
    public void iClickButtonAP(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();
    }

    @When("I click {string} menu item AP")
    public void iClickMenuItemAP(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("I click {string} home page button AP")
    public void iClickHomePageButtonAP(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();

    }

    @Then("I verify current url {string}")
    public void iVerifyCurrentUrl(String curUrl) {
        String url= getDriver().getCurrentUrl();
        assertThat(url.contains(curUrl)).isTrue();
    }

}
