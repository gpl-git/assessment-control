package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class MartinASKAuto {

//    @Given("I open {string} page")
//    public void iOpenPage(String url) {
//        if (url.equals("login")) {
//            getDriver().get("http://ask-qa.portnov.com/#/login");
//        } else if (url.equals("registration")) {
//            getDriver().get("http://ask-qa.portnov.com/#/registration");
//        } else {
//            System.out.println("This url is not supported: " + url);
//        }
//
//    }

//    @And("I wait for {int} sec")
//    public void iWaitForSec(int sec) throws InterruptedException {
//        Thread.sleep(sec * 1000);
//    }

//    @When("I type {string} for teacher user")
//    public void iTypeForTeacherUser(String email) {
//        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
//    }

//    @And("I type {string} as password")
//    public void iTypeAsPassword(String password) {
//        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
//    }

//    @When("I click {string} button")
//    public void iClickButton(String btnName) {
//        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
//    }

//    @Then("{string} page will be displayed")
//    public void pageWillBeDisplayed(String expectedUrl) {
//        String curUrl = getDriver().getCurrentUrl();
//        assertThat(curUrl.contains(expectedUrl)).isTrue();
//    }

//    @When("I click on {string} menu item")
//    public void iClickOnMenuItem(String menuItem) {
//        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
//    }


    @When("I click on {string}")
    public void iClickOn(String xpath) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }


//    @And("I type {string} as quiz title")
//    public void iTypeAsQuizTitle(String quizName) {
//        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizName);
//    }

    @And("I click  {string}")
    public void iClick(String xpath) {
        getDriver().findElement(By.xpath("//button[@type='button']//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select {string}")
    public void iSelect(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I type {string}")
    public void iType(String nameQuiz) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(nameQuiz);
    }


//    @Then("I type {string} into {string}")
//    public void iTypeInto(String questionContent, String questionNum) {
//        getDriver().findElement(By.xpath("//textarea[@placeholder='" + questionNum + "']")).sendKeys(questionContent);
//    }

    @And("I select {string} as the correct answer")
    public void iSelectAsTheCorrectAnswer(String optionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../../mat-checkbox")).click();
    }

    @And("I click on {string} button")
    public void iClickOnButton(String name) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + name + "')]")).click();
    }


    @And("I verify saved {string} in displayed in quizzes")
    public void iVerifySavedInDisplayedInQuizzes(String quizName) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]")).isDisplayed()).isTrue();
        Thread.sleep(2000);
    }

    @Then("I edit the quiz")
    public void iEditTheQuiz() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Edit')]")).click();

    }

    @Then("I clear text field of {string}")
    public void iClearTextFieldOf(String option2) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + option2 + "']")).clear();
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+option2+"']")).sendKeys("");
        getDriver().findElement(By.xpath("//form")).click();
    }


//    @Then("I click on Quiz Title title")
//    public void iClickOnQuizTitleTitle() {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]")).click();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Delete')]")).click();
//        getDriver().findElement(By.xpath("//ac-modal-confirmation[@class='ng-star-inserted']/..//span[contains(text(),'Delete')]")).click();
//
//    }


//    @Then("I Edit quiz")
//    public void iEditQuiz() {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Edit')]")).click();
//        getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']")).click();
//        getDriver().findElement(By.xpath(""))
//
//
//    }
//



    @Then("the button {string} is disabled")
    public void theButtonIsDisabled(String saveButton) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + saveButton + "')]")).isEnabled()).isFalse();
    }

    @Then("the button {string} is enabled")
    public void theButtonIsEnabled(String saveButton) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + saveButton + "')]")).isEnabled()).isTrue();
    }


    @And("I click on first question")
    public void iClickOnFirstQuestion() {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).click();
    }

    @And("I should see error message")
    public void iShouldSeeErrorMessage() throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1: Error')]/../../..//mat-error[contains(text(),'This field is required')]")).isDisplayed()).isTrue();
        Thread.sleep(1000);

    }

    @Then("I type text {string} into {string}")
    public void iTypeTextInto(String questionContent, String optionNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + optionNum + "']")).sendKeys(questionContent);
    }



    @Then("I enter {int} alphanumeric characters into {string}")
    public void iEnterAlphanumericCharactersInto(int number, String optionNum) {
        boolean useLetters =true;
        boolean useNumbers =true;
        String generatedString = RandomStringUtils.random( number, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+optionNum+"']")).sendKeys(generatedString);
    }

    @And("I click on {string} option button")
    public void iClickOnOptionButton(String word) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+word+"')]")).click();
    }





    @Then("I delete the quiz {string}")
    public void iDeleteTheQuiz(String quizName) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../..//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//ac-modal-confirmation[@class='ng-star-inserted']/..//span[contains(text(),'Delete')]")).click();



    }

    @And("I add up to {int} additional options")
    public void iAddUpToAdditionalOptions(int numOptions) {
        for(int i=3; i<=numOptions; i++){
            getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
            getDriver().findElement(By.xpath("//textarea[@placeholder='Option "+i+"*']")).sendKeys("Incorrect Option # "+ i);

        }
    }

    @And("I delete {string}")
    public void iDelete(String optionNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+optionNum+"']/../../../../..//mat-icon[contains(text(),'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']//span[contains(text(),'Delete Option')]")).click();
        Thread.sleep(1000);
    }

    @And("I click on settings icon for {string}")
    public void iClickOnSettingsIconFor(String optionNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+optionNum+"']/../../../../..//mat-icon[contains(text(),'settings')]")).click();
        Thread.sleep(1000);

    }

    @And("I move selected option by clicking on {string}")
    public void iMoveSelectedOptionByClickingOn(String menuOption) throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']//span[contains(text(),'"+menuOption+"')]")).click();
        Thread.sleep(1000);


    }

    @Then("I click on add option button")
    public void iClickOnAddOptionButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();

    }

    @Then("I should see the error message Choose at least one correct answer")
    public void iShouldSeeTheErrorMessageChooseAtLeastOneCorrectAnswer() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'*Choose at least one correct answer')]")).isDisplayed()).isTrue();
    }

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I type email {string} for teacher user")
    public void iTypeEmailForTeacherUser(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type password {string}")
    public void iTypePassword(String passw) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(passw);
    }

    @When("I click button {string}")
    public void iClickButton(String logBut) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+logBut+"')]")).click();
    }

    @And("I wait for {int} Sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec *1000);
    }

    @Then("I should see the {string} page is displayed")
    public void iShouldSeeThePageIsDisplayed(String expUrl) {
        String curURL = getDriver().getCurrentUrl();
        assertThat(curURL.contains(expUrl)).isTrue();
    }

    @When("I click on button {string} from left side menu items list")
    public void iClickOnButtonFromLeftSideMenuItemsList(String menuBut) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuBut+"')]")).click();
    }

    @And("I type string {string} as quiz title")
    public void iTypeStringAsQuizTitle(String quizName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizName);

    }
}





