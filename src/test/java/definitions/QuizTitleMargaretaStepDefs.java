package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTitleMargaretaStepDefs {
    @Given("I'm opening {string} page")
    public void iMOpeningPage(String url) {
        if (url.equals("Login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("Registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This url is not opening: " + url);
        }
    }

    @When("I type {string} as an email")
    public void iTypeAsAnEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

//    @And("I type {string} into password field")
//    public void iTypeIntoPasswordField(String password) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
//    }

    @And("I click on {string} button MB")
    public void iClickOnButtonMB(String buttonNameMB) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonNameMB+"')]")).click();
    }


//    @Then("{string} page should be displayed")
//    public void pageShouldBeDisplayed(String expectedUrl) {
//        String currentUrl = getDriver().getCurrentUrl();
//        assertThat(currentUrl.contains(expectedUrl)).isTrue();
//    }

    @When("I click on {string} from menu item")
    public void iClickOnFromMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I'm clicking on {string} button")
    public void iMClickingOnButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]/../..//button")).click();
    }

    @When("I'm typing {string} as a quiz title")
    public void iMTypingAsAQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add the question")
    public void iAddTheQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("I click outside from input field")
    public void iClickOutsideFromInputField() {
        getDriver().findElement(By.xpath("//form")).click();
    }

    @And("I select the {string} question")
    public void iSelectTheQuestion(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + questionType + "')]")).click();
    }

    @When("I type {string} in {string} question field")
    public void iTypeInQuestionField(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @Then("the quiz {string} is displaying on the list of quizzes")
    public void theQuizIsDisplayingOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'MargoB')]")).isDisplayed()).isTrue();
    }

    @Then("I delete quiz with name {string}")
    public void iDeleteQuizWithName(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'MargoB')]")).click();
        Thread.sleep(1000);
    }

    @Then("No error message is displayed under the {string} field")
    public void noErrorMessageIsDisplayedUnderTheField(String titleOfTheQuiz) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='header-form-group']")).isDisplayed()).isTrue();
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[(text()='This field is required')]")).isDisplayed()).isTrue();
    }

//    @Then("error message {string} should be displayed")
//    public void errorMessageShouldBeDisplayed(String expectedError) {
//        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
//        assertThat(actualError.equals(expectedError)).isTrue();
//    }


    @And("{string} field is marked with asterisk is displayed")
    public void fieldIsMarkedWithAsteriskIsDisplayed(String asterisk) {
        assertThat(getDriver().findElement(By.xpath("//input")).getAttribute("placeholder").contains("*")).isTrue();
    }

    @And("I type {string} as {string} in {string} MB")
    public void iTypeAsInMB(String optionTextMB, String optionNumMB, String questionNumMB) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumMB+"')]/../../..//textarea[@placeholder='"+optionNumMB+"']")).sendKeys(optionTextMB);
    }

    @Then("I select {string} as correct option in {string} MB")
    public void iSelectAsCorrectOptionInMB(String optionNumMB, String questionNumMB) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumMB+"')]/../../..//textarea[@placeholder='"+ optionNumMB+ "']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} is displayed on the list of quizzes MB")
    public void quizIsDisplayedOnTheListOfQuizzesMB(String titleMB) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+titleMB+"')]")).isDisplayed()).isTrue();
    }

    @Then("I verify that {string} quiz title has a leading white space MB")
    public void iVerifyThatQuizTitleHasALeadingWhiteSpaceMB(String spaceMB) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+spaceMB+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" +spaceMB+"')]/../../..//*[contains(text(),'Edit')]")).click();
        Thread.sleep(2000);
        String actualTitleMB = getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).getAttribute("value");
        System.out.println(actualTitleMB);
        System.out.println(actualTitleMB.length());
        char firstMB = actualTitleMB.charAt(0);
        System.out.println("The first character in the title:" + firstMB);

        assertThat(Character.isWhitespace(firstMB)).isTrue();
    }

    @Then("I verify that {string} quiz title has a trailing white space MB")
    public void iVerifyThatQuizTitleHasATrailingWhiteSpaceMB(String trailingSpaceMB) throws InterruptedException{
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+trailingSpaceMB+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+trailingSpaceMB+ "')]/../../..//*[contains(text(),'Edit')]")).click();
        Thread.sleep(2000);
        String actualTitleMB1 = getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).getAttribute("value");
        System.out.println(actualTitleMB1);
        System.out.println(actualTitleMB1.length());
        char trailingSpace = actualTitleMB1.charAt(actualTitleMB1.length()-1);
        System.out.println("The last character in the title is: " + trailingSpace);

        assertThat(Character.isWhitespace(trailingSpace)).isTrue();
    }
}






