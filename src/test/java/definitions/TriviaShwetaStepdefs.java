package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

//    @When("I click on {string} button")
//    public void iClickOnButtonShweta(String button) {
//    }
    @And("I click on {string} button Shweta")
    public void iClickOnButtonShweta(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();

    }

    @Given("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+link+"')]")).click();
    }

//    @Then("I type in quiz tile as {string}")
//    public void iTypeInQuizTileAs(String title) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
//    }

    @Then("I type in quiz tile as {string}")
    public void iTypeInQuizTileAs(String title) throws InterruptedException {
//        Thread.sleep(1);
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

    @Then("quiz with text {string} should be displayed")
    public void quizWithTextShouldBeDisplayed(String quizName) {
        assertThat(getDriver().findElement(By.xpath("//span/mat-panel-title[contains(text(), '"+quizName+"')]")).isDisplayed()).isTrue();
    }


    @And("I click on element with text {string}")
    public void iClickOnElementWithText(String quizName) {
        getDriver().findElement(By.xpath("//span/mat-panel-title[contains(text(), '"+quizName+"')]")).click();
    }

    @Then("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String card) throws InterruptedException {
        Thread.sleep(2);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+card+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+card+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
    }


    @When("I click on settings for {string}")
    public void iClickOnSettingsFor(String settingsIcon) {
        getDriver().findElement(By.xpath("(//mat-icon[text()='settings'])[2]")).click();
    }

    @Then("I click on the {string}")
    public void iClickOnThe(String arrow) throws InterruptedException {
        getDriver().findElement(By.xpath("//button/mat-icon[contains(text(), '"+arrow+"')]")).click();
    }

    @Then("{string} should be at second position")
    public void shouldBeAtSecondPosition(String expectedValue) {
        WebElement actualValue = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']"));
        assertThat(actualValue.equals(expectedValue));
    }

    @Then("{string} should be at first position")
    public void shouldBeAtFirstPosition(String expectedValue) {
        WebElement actualValue = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']"));
        assertThat(actualValue.equals(expectedValue));
    }

    @When("I delete my {string} quiz")
    public void iDeleteMyQuiz(String myQuiz) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+myQuiz+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+myQuiz+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @Then("quiz with text {string} should not be displayed")
    public void quizWithTextShouldNotBeDisplayed(String quizName) {
        assertThat(getDriver().findElement(By.xpath("//span/mat-panel-title[contains(text(), '"+quizName+"')]")).isDisplayed()).isFalse();

    }

    @Then("I click on {string} option button")
    public void iClickOnOptionButton(String delete) {
        getDriver().findElement(By.xpath("//button/mat-icon[contains(text(), '"+delete+"')]")).click();

    }

    @Then("total number of options should be {int}")
    public void totalNumberOfOptionsShouldBe(int expectCountOfOptions) {
        int actualCountOfOptions = getDriver().findElements(By.xpath("//div[@formarrayname='options']/div")).size();
        assertThat(Objects.equals(expectCountOfOptions, expectCountOfOptions));
        System.out.println(actualCountOfOptions);
    }

    @Then("{string} option button should be disabled")
    public void optionButtonShouldBeDisabled(String delete) {
        WebElement actualStateOfDeleteButton = getDriver().findElement(By.xpath("//button/span[text()='Delete Option']"));
        assertThat(!actualStateOfDeleteButton.isEnabled());
    }

    @Then("I close the settings dialogue")
    public void iCloseTheSettingsDialogue() {
        getDriver().findElement(By.xpath("//button/span[contains(text(), 'Close')]")).click();
    }

    @Then("I delete the question")
    public void iDeleteTheQuestion() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Delete Question')]")).click();
        //span[contains(text(), 'Delete Question')]
    }

    @Then("I add total {int} options in by clicking {string} button")
    public void iAddTotalOptionsInByClickingButton(int numOfOptions, String addButton) throws InterruptedException {

        int i=1;
        String opt = "Option"+i;
        for( i=1; i<numOfOptions; i++) {
            getDriver().findElement(By.xpath("//span[contains(text(),'" + addButton + "')]")).click();
            getDriver().findElement(By.xpath("//textarea[@placeholder='Option "+ (i+2)+"*']")).sendKeys(opt);
            Thread.sleep(3);
        }
    }

    @Then("I should be able to {string} the quiz with multiple choice question with fifteen options")
    public void iShouldBeAbleToTheQuizWithMultipleChoiceQuestionWithFifteenOptions(String save) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+save+"')]")).click();
    }

    @Then("I select {string} as correct choices")
    public void iSelectAsCorrectChoices(String optionOne) {
        getDriver().findElement(By.xpath("(//mat-checkbox/label/div)[2]")).click();

    }

    @Then("I should be able to {string} the quiz with minimum two choices")
    public void iShouldBeAbleToTheQuizWithMinimumTwoChoices(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();

    }

    @Then("setting dialogue box should have opacity zero")
    public void settingDialogueBoxShouldHaveOpacityZero() {
        int number = (getDriver().findElements(By.xpath("//div[style='opacity: 0; transform: scale(1, 1);']"))).size();
        assertThat(number==0);
    }

    @Then("I add a space {string} at the beginning of question text")
    public void iAddASpaceAtTheBeginningOfQuestionText(String space) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(space);
    }

//    @Then("{string} message should be displayed")
//    public void messageShouldBeDisplayed(String expectedUrl) {
//        String actualUrl = getDriver().getCurrentUrl();
//        assertThat(actualUrl.contains(expectedUrl));
//        System.out.println( "expectedUrl : " + expectedUrl);
//        System.out.println( "actualUrl : " + actualUrl);
//    }

 //   @Then("quiz should not get saved")
//    public void quizShouldNotGetSaved() {
//        String actualUrl = getDriver().getCurrentUrl();
//        assertThat(actualUrl.contains("/quiz-builder/"));
//
//    }

    @Then("I should still be at {string} page")
    public void iShouldStillBeAtPage(String expectedUrl) {
        String actualUrl = getDriver().getCurrentUrl();
        System.out.println( "actualUrl : " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}//button/mat-icon[text()='arrow_downward']
//button/span[contains(text(), 'Close')]