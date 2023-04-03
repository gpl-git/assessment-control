package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class FnameyStepDefs {
    @Given("I navigate  to {string} page")
    public void iNavigateToPage(String url) {
        if(url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
                    System.out.println(url + " is not supported");
                }
            }




    @And("I click register me button")
    public void iClickRegisterMeButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }


    @Then("fname error message should be displayed")
    public void fnameErrorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).isDisplayed()).isTrue();
    }

    @And("fname error message {string} should be displayed")
    public void fnameErrorMessageShouldBeDisplayed(String expmessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).getText();
        assertThat(actMessage.equals(expmessage)).isTrue();
    }

    @When("I type {string} into fname field")
    public void iTypeIntoFnameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);

    }


    @Then("fname  white space error message  {string}should be displayed")
    public void fnameWhiteSpaceErrorMessageShouldBeDisplayed(String expMessage) {
        String actMessage =getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();

    }

    @When("I type {string} into the fname field")
    public void iTypeIntoTheFnameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }

    @Then("fname error message should not be displayed")
    public void fnameErrorMessageShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).isDisplayed()).isFalse();
    }

    @And("I clear fname field")
    public void iClearFnameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
    }


    @When("I type maxium character {string}into fname field")
    public void iTypeMaxiumCharacterIntoFnameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);

    }

    @When("I type more than maxium cha {string} into fname field")
    public void iTypeMoreThanMaxiumChaIntoFnameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }

    @Then("NO more than maxium char error message{string} should be diplayed")
    public void noMoreThanMaxiumCharErrorMessageShouldBeDiplayed(String expMessage) {
        String actMessage =getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();
    }
}
