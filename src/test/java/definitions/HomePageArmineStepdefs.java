package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageArmineStepdefs {
    @Given("I navigate to {string} page AH")
    public void iNavigateToPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
            System.out.println("login");
        }

    }

    @When("I type {string} into email input field AH")
    public void iTypeIntoEmailInputFieldAH(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);


    }

    @And("I type {string} into password field AH")
    public void iTypeIntoPasswordFieldAH(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button AH")
    public void iClickButtonAH(String signinbtn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+signinbtn+"')]")).click();

    }

    @And("I wait for {int} sec AH")
    public void iWaitForSecAH(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I click {string} current url contains {string}")
    public void iClickCurrentUrlContains(String menuItems, String curUrl) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItems+"')]")).click();
        assertThat(getDriver().getCurrentUrl().contains(curUrl)).isTrue();

    }

    @Then("element {string} page is displayed")
    public void elementPageIsDisplayed(String Confirmation) {
        assertThat(getDriver().findElement(By.xpath("//h1[@id='mat-dialog-title-1']")).isDisplayed()).isTrue();

    }

    @When("I click {string} current url in Student account contains {string}")
    public void iClickCurrentUrlInStudentAccountContains(String menuItems  , String curUrl) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItems+"')]")).click();
        assertThat(getDriver().getCurrentUrl().contains(curUrl)).isTrue();
    }

    @And("I click {string} button in Confirmation")
    public void iClickButtonInConfirmation(String btnName) {
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[contains(text(),'"+btnName+"')]")).click();
    }
}
