package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Law_ShowstopperDefs {
    @Given("I go to {string}")
    public void iGoTo(String url) {
        if (url.equals("ASK Login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This webiste" + url + "is not working.");
        }
    }


    @When("I type {string} into e-input")
    public void iTypeIntoEInput(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into p-input")
    public void iTypeIntoPInput(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I click {string} btn")
    public void iClickBtn(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I click {string} on the sidebar")
    public void iClickOnTheSidebar(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(), '"+menuItem+"')]")).click();
    }

    @When("I type {string} as title for Quiz")
    public void iTypeAsTitleForQuiz(String quizTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @Then("I add the first question")
    public void iAddTheFirstQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }


    @Then("I click {string} radio button")
    public void iClickRadioButton(String chkbox) {
        getDriver().findElement(By.xpath(
                "//div[@class='mat-checkbox-inner-container']")).click();
    }

    @And("I type {string} into qfield of {string}")
    public void iTypeIntoQfieldOf(String qText, String qNum) {
        getDriver().findElement(
                By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]" +
                        "/../../..//textarea[@formcontrolname='question']")).sendKeys(qText);
    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String xpath, String resultText) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).containsIgnoringCase(resultText);

    }

    @When("I select {string} as a correct answer in {string}")
    public void iSelectAsACorrectAnswerIn(String aNum, String qNum) {
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+aNum+"*']" +
                        "/../../../../..//mat-radio-button")).click();
    }

    @Then("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("I verify {string} is displayed")
    public void iVerifyIsDisplayed(String xpath) {


    }

    @Then("I preview {string} to verify Showstopper is displayed")
    public void iPreviewToVerifyShowstopperIsDisplayed(String quizTitle) {
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Preview']")).click();


    }
}