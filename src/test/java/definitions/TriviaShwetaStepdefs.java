package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class TriviaShwetaStepdefs {
    @Given("I {string}")
    public void i(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if(url.equals("")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else{
            System.out.println("The site " + url + " is not supported");
        }
    }

    @Then("I enter login {string}")
    public void iEnterLogin(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("rcnader111a@plussmail.com");
    }

    @Then("I enter password {string}")
    public void iEnterPassword(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345");
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @Given("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+link+"')]")).click();
    }

    @Then("I type in quiz tile as {string}")
    public void iTypeInQuizTileAs(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I click add question")
    public void iClickAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @Then("I select question type as {string}")
    public void iSelectQuestionTypeAs(String questionType) throws InterruptedException {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+questionType+"')]")).click();
        Thread.sleep(1);
    }


    @Then("I type into Question field {string}")
    public void iTypeIntoQuestionField(String quest) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(quest);
    }


    @And("I type {string} in first option")
    public void iTypeInFirstOption(String optionONE) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(optionONE);
    }

    @And("I type {string} in second option")
    public void iTypeInSecondOption(String optionTWO) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(optionTWO);

    }

    @And("I type {string} in third option")
    public void iTypeInThirdOption(String optionThree) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 3*']")).sendKeys(optionThree);

    }

    @Then("I select {string} and {string} correct choices")
    public void iSelectAndCorrectChoices(String optionTwo, String optionThree) {
        getDriver().findElement(By.xpath("(//mat-checkbox/label/div)[2]")).click();
        getDriver().findElement(By.xpath("(//mat-checkbox/label/div)[3]")).click();
    }
}
