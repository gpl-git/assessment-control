package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class NataliaShStepDefs {
    private Object assertThat;

    @Given("I navigate to url {string}")
    public void iNavigateToUrl(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This website is not supported: " + url);
        }
    }

    @When("I type {string} for teacher credentials")
    public void iTypeForTeacherCredentials(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I click button {string}")
    public void iClickButton(String buttonName) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+buttonName+"')]")).click();
    }


    @Then("I click on {string} item")
    public void iClickOnItem(String item) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @When("I click button {string} NS")
    public void iClickButtonNS(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @Then("I type {string} as a Quiz title")
    public void iTypeAsAQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @Then("I click {string}")
    public void iClick(String addQuestion) {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }


    @And("I click on {string} type of question")
    public void iClickOnTypeOfQuestion(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(), '"+questionType+"')]")).click();
    }

    @When("I enter {string} into {string} NS")
    public void iEnterIntoNS(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I type {string} as {string} in {string} NS")
    public void iTypeAsInNS(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']")).sendKeys(optionText);
    }


    @Then("I select {string} as correct option in {string} NS")
    public void iSelectAsCorrectOptionInNS(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../../mat-checkbox")).click();
    }

    @And("I wait for {int} sec NS")
    public void iWaitForSecNS(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @Then("{string} is displayed on the list of quizzes NS")
    public void isDisplayedOnTheListOfQuizzesNS(String title) {
      assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} quiz NS")
    public void iDeleteQuizNS(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @When("I enter {int} alphanumeric characters into {string} NS")
    public void iEnterAlphanumericCharactersIntoNS(int number, String questionNumber) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

//        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(generatedString);
    }

    @Then("error message {string} should be displayed NS")
    public void errorMessageShouldBeDisplayedNS(String errorMessage) {
        String actualError = getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]")).getText();
//        System.out.println(actualError);
        assertThat(actualError.equals(errorMessage)).isTrue();
    }
}





