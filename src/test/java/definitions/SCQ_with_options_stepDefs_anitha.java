package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class SCQ_with_options_stepDefs_anitha {
    public String questionText;
    public String quiztitle;
    public int optCount;
    public int currentOptionCount;
    public List<String> optionValues;
    public String optiontoDelete;


    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        switch (page) {
            case "login":
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            case "register":
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            case "forgot_password":
                getDriver().get("http://ask-qa.portnov.com/#/forgot-password");
                break;
        }
    }

    @When("I enter the teachers email {string} into email field")
    public void iEnterTheTeachersEmailIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter the password {string} into password field")
    public void iEnterThePasswordIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String btnName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + btnName + "')]")));
        element.click();
    }

    @And("I wait for {int} sec for the presence of all the elements on the page")
    public void iWaitForSecForThePresenceOfAllTheElementsOnThePage(long time) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    @Then("I should see the text {string} present in the home page")
    public void iShouldSeeTheTextPresentInTheHomePage(String txtPresence) {
        getDriver().findElement(By.xpath("//p[contains(text(),'" + txtPresence + "')]")).isDisplayed();
    }


    @And("I click the {string} menu item from the home page")
    public void iClickTheMenuItemFromTheHomePage(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @And("I click {string} button under the list of quizzes section")
    public void iClickButtonUnderTheListOfQuizzesSection(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I type {string} in the quiz title field")
    public void iTypeInTheQuizTitleField(String quizTitle) {
        this.quiztitle = quizTitle;
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question by clicking the button Add question")
    public void iAddAQuestionByClickingTheButtonAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select the question type as {string}")
    public void iSelectTheQuestionTypeAs(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I type the question as {string} into question field of {string}")
    public void iTypeTheQuestionAsIntoQuestionFieldOf(String questText, String questNum) {
        this.questionText = questText;
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@formcontrolname='question']")).sendKeys(questText);
    }

    @And("I type {string} into the {string} of {string}")
    public void iTypeIntoTheOf(String optText, String optNum, String questNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@placeholder='" + optNum + "*']")).sendKeys(optText);
    }


//    @And("I select the {string} from the list of options for question {string}")
    @And("I choose the answer as {string} for question {string}")
    public void iSelectTheFromTheListOfOptionsForQuestion(String optionNumber, String questNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@placeholder='" + optionNumber + "*']/preceding::mat-radio-button[1]")).click();
    }

    @Then("I should see the quiz name {string} in the list of quizzes section")
    public void iShouldSeeTheQuizNameInTheListOfQuizzesSection(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title : titles) {
            if (title.getText().contains(quizTitle)) {
                title.isDisplayed();
//                title.click();
            }
        }

    }

    @And("I should an error message on the {string} field")
    public void iShouldAnErrorMessageOnTheField(String option) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + option + "*']/following::mat-error[contains(text(),'This field is required')]")).isDisplayed();
    }

    @And("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMsg) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + errorMsg + "')]")).isDisplayed();
    }

    @And("I click the {string} from the list of quizzes section")
    public void iClickTheFromTheListOfQuizzesSection(String quizTitle) throws InterruptedException {
        WebElement title = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", title);
        Thread.sleep(500);
        title.click();
    }

    @And("I {string} the quiz name {string} from the list of quizzes")
    public void iTheQuizNameFromTheListOfQuizzes(String btnName, String quizTitle) throws InterruptedException {
//        WebElement element = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]"));
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].focus();", element);
//
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/following::span[text()='" + btnName + "']")).click();
//        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//        WebElement btnDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ac-modal-confirmation//span[text()='" + btnName + "']")));
//        btnDelete.click();

        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='"+btnName+"']")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='"+btnName+"']")).click();
        Thread.sleep(1000);

    }


    @And("I click {string} in the confirmation window")
    public void iClickInTheConfirmationWindow(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }

    @And("I {string} the quiz name {string} from the list of quizzes section")
    public void iTheQuizNameFromTheListOfQuizzesSection(String btnName, String quizTitle) {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/following::span[text()='" + btnName + "']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + btnName + "')]")));
        element.click();


    }

//    @Then("I verify the content displayed on the Preview mode is correct")
//    public void iVerifyTheContentDisplayedOnThePreviewModeIsCorrect() {
//        assertThat(getDriver().findElement(By.xpath("//h3[contains(text(),'" + this.questionText + "')]")).isDisplayed()).isTrue();
//        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'" + this.quiztitle + "')]")).isDisplayed()).isTrue();
//    }

    @Then("I verify the content displayed on the Preview mode is correct")
    public void iVerifyTheContentDisplayedOnThePreviewModeIsCorrect() {
        assertThat(getDriver().findElement(By.xpath("//mat-dialog-container//h3[contains(text(),'"+this.questionText+"')]")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//mat-dialog-container//h4[contains(text(),'" + this.quiztitle + "')]")).isDisplayed()).isTrue();
        List<WebElement> actualOptions=getDriver().findElements(By.xpath("//mat-dialog-container//div[@class='mat-radio-label-content']"));
        for(int i=0;i<this.optionValues.size();i++){
            assertThat(getDriver().findElement(By.xpath("//mat-dialog-container//div[contains(text(),'"+this.optionValues.get(i)+"')]")).isDisplayed()).isTrue();
        }
    }

    @And("I enter {int} character into the {string} of {string}")
    public void iEnterCharacterIntoTheOf(int charCount, String option, String questNum) {
        boolean useLetters = true;
        boolean useNumbers = false;
        String optionText = RandomStringUtils.random(charCount, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@placeholder='" + option + "*']")).sendKeys(optionText);
    }

    @Then("I should see an error message {string} on the snack-bar")
    public void iShouldSeeAnErrorMessageOnTheSnackBar(String errMsg) {
        getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'" + errMsg + "')]")).isDisplayed();

    }

    @And("I should an error message {string} on the {string} field")
    public void iShouldAnErrorMessageOnTheField(String errorMsg, String optNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + optNum + "*']/following::mat-error[contains(text(),'" + errorMsg + "')]")).isDisplayed();
    }


    @And("I enter {int} character into the option text fields of {string}")
    public void iEnterCharacterIntoTheOptionTextFieldsOf(int charCount, String questNum) {
        boolean useLetters = true;
        boolean useNumbers = false;

        List<String> optionValues = new ArrayList<>();
        for (int i = 1; i <= this.currentOptionCount + this.optCount; i++) {
            String optionText = RandomStringUtils.random(charCount, useLetters, useNumbers);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@placeholder='Option " + i + "*']")).sendKeys(optionText);
            optionValues.add(i - 1, optionText);
        }
        this.optionValues = optionValues;
    }

    @And("I add {int} new options to {string}")
    public void iAddNewOptionsTo(int optionCount, String qustNum) {
        this.optCount = optionCount;
        List<WebElement> currentCount = getDriver().findElements(By.xpath("//textarea[contains(@placeholder,'Option ')]"));
        this.currentOptionCount = currentCount.size();

        for (int i = 3; i <= currentCount.size() + optionCount; i++) {
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qustNum + "')]/following::span[contains(text(),'Add Option')]")).click();
        }
    }


    @And("I click the settings icon present next to {string} from {string}")
    public void iClickTheSettingsIconPresentNextToFrom(String optionNum, String qustNum) {
        getDriver().findElement(By.xpath("//textarea[contains(@placeholder,'" + optionNum + "*')]/following::mat-icon[contains(text(),'settings')]")).click();
        this.optiontoDelete = getDriver().findElement(By.xpath("//textarea[contains(@placeholder,'" + optionNum + "*')]")).getAttribute("value");
    }


    @And("I click the {string} from the menu panel")
    public void iClickTheFromTheMenuPanel(String btnName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + btnName + "')]")));
        element.click();
    }

    @Then("I verify the {string} gets deleted successfully")
    public void iVerifyTheGetsDeletedSuccessfully(String optionNum) {
        List<WebElement> actualOptions = getDriver().findElements(By.xpath("//textarea[contains(@placeholder,'Option ')]"));
        for (int i = 1; i <= actualOptions.size(); i++) {
            assertThat(getDriver().findElement(By.xpath("//textarea[contains(@placeholder,'" + optionNum + "*')]")).getAttribute("value")).doesNotContain(this.optiontoDelete);
        }
    }


    @And("I resize the browser window to the mobile Dimension {int} by {int}")
    public void iResizeTheBrowserWindowWithTheDimensionBy(int width, int height) {
        Dimension size = new Dimension(width,height);
        getDriver().manage().window().setSize(size);
    }


    @And("verify that the {string} is selected")
    public void verifyThatTheIsSelected(String optNum) {

    }
}
