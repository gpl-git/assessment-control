package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class liliyaSagStepdefs {
    @Given("I open {string} page as a teacher")
    public void iOpenPageAsATeacher(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I click on {string} button ls")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }


    @When("I type {string} as a first name")
    public void iTypeAsAName(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @When("I type {string} as a last name")
    public void iTypeAsALastName(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} as email")
    public void iTypeAsEmail(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as a group code")
    public void iTypeAsAGroupCode(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);
    }

    @And("I type {string} as a password")
    public void iTypeAsAPassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);

    }

    @And("I type {string} as a password confirmation")
    public void iTypeAsAPasswordConfirmation(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);


    }

    @Then("{string} message should be displayed ls")
    public void pageShouldBeDisplayedLs(String reg) {
        String confirmationMess=getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(confirmationMess.equals(reg)).isTrue();


    }

    @Then("{string} error should be displayed")
    public void errorShouldBeDisplayed(String field) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + field + "')]")).isDisplayed()).isTrue();

    }
}







