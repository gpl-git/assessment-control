package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefsMukund {
    @Given("I move to {string} page")
    public void iMoveToPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This site " + url +" is not supported.");
        }

    }

    @When("I input {string} into email field")
    public void iInputIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I input {string} into password field")
    public void iInputIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I press {string} button")
    public void iPressButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("{string} is displayed on the screen")
    public void isDisplayedOnTheScreen(String loggedUser) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//h3[contains(text(),'MUKUND')]"));
        for (WebElement title   :  titles) {
            if(title.getText().contains(loggedUser)){
                title.isDisplayed();
            }
        }
    }

    @And("I click {string} on side menu")
    public void iClickOnSideMenu(String sideMenuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+ sideMenuItem +"')]")).click();
    }

    @And("I click {string} mat list item")
    public void iClickMatListItem(String matListItem) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'"+ matListItem +"')]")).click();
    }

    @Then("user role is {string}")
    public void userRoleIs(String userRole) {
        getDriver().findElement(By.xpath("//td[contains(text(),'"+ userRole +"')]")).click();
    }

    @When("I tap Options button")
    public void iTapOptionsButton() {
        getDriver().findElement(By.xpath("//h2/../..//span")).click();
    }

    @And("I change users role")
    public void iChangeUsersRole() {
        getDriver().findElement(By.xpath("//button[2]")).click();
    }

    @And("I confirm {string}")
    public void iConfirm(String confirmButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+ confirmButton +"')]")).click();
    }

    @Then("I verify that user role {string} is displayed")
    public void iVerifyThatUserRoleIsDisplayed(String role) {
        String result = getDriver().findElement(By.xpath("//mat-card")).getText();
        System.out.println(result);
        assertThat(result.contains(role)).isTrue();
    }
}
