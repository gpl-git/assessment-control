package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ShowStopperMyStepdefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site " + url + "is not supported");
        }
    }

    @When("I enter {string} into email field")
    public void iEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} into the password field")
    public void iEnterIntoThePasswordField(String pwd) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pwd);
    }

    @When("I push {string} button")
    public void iPushButton(String btn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btn+"')]")).click();
    }

    @When("I write {string} as quiz title")
    public void iWriteAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }


    @And("I select Show Stopper option")
    public void iSelectShowStopperOption() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Show-Stopper')]/../..//div")).click();
    }

    @And("I click on {string} quizz name")
    public void iClickOnQuizzName(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]")).click();

    }

    @Then("{string} label is displayed")
    public void labelIsDisplayed(String label) {
        assertThat(getDriver().findElement(By.xpath("//p[@class='show-stopper ng-star-inserted']")).isDisplayed()).isTrue();

    }

    @Then("I verify my role as {string}")
    public void iVerifyMyRoleAs(String role) {
        String actualRole = getDriver().findElement(By.xpath("//div[@class='info']/..//p")).getText();
        assertThat(actualRole.equals(role)).isTrue();
    }

    @Then("question {string} is marked with asterisk")
    public void questionIsMarkedWithAsterisk(String question) {
        String actualQuestion = getDriver().findElement(By.xpath("//*[@class='mat-expansion-panel-header-title']")).getText();
        System.out.println(actualQuestion + " from the application");
        assertThat(actualQuestion.contains(question)).isTrue();

    }

    @And("I expand {string} and click button {string}")
    public void iExpandAndClickButton(String quizTitle, String btnName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='"+btnName+"']")).click();
    }
}
