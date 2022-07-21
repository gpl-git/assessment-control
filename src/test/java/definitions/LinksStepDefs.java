package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LinksStepDefs {
    @Given("I go to {string} page T")
    public void iGoToPageT(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This sie " + url + " is not supported.");
        }
    }

    @When("I type {string} into email field T")
    public void iTypeIntoEmailFieldT(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} as password T")
    public void iEnterAsPasswordT(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click button {string} T")
    public void iClickButtonT(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }



    @When("I click {string} menu item TT")
    public void iClickMenuItemTT(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }



    @And("I verify role {string} on the side menu")
    public void iVerifyRoleOnTheSideMenu(String role) {
        String actualRole = getDriver().findElement(By.xpath("//header")).getText();
        assertThat(actualRole.contains(role));
    }

    @Then("I verify current url contains “home”")
    public void iVerifyCurrentUrlContainsHome() {

    }

    @Then("I verify current url contains {string}")
    public void iVerifyCurrentUrlContains(String menuItem) {
        String curUrl = getDriver().getCurrentUrl();
        assertThat(curUrl.contains(menuItem)).isTrue();
    }

    @Then("log out confirmation should be displayed")
    public void logOutConfirmationShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//h1[contains(text(), 'Confirmation')]")).click();


    }

    @When("I click button {string} TT")
    public void iClickButtonTT(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Log Out')]")).click();

    }

    @And("I verify role {string} on the side menu TT")
    public void iVerifyRoleOnTheSideMenuTT(String role) {
        String actualRole = getDriver().findElement(By.xpath("//header")).getText();
        assertThat(actualRole.contains(role));
    }

    @When("I click {string} menu item T")
    public void iClickMenuItemT(String myGrades) {
        getDriver().findElement(By.xpath("//h5[contains(text(), 'My Grades')]")).click();

    }

}