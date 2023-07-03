package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class Quiz2Stepdefs {
    @Given("I go to {string} page m")
    public void iGoToPageM(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site " + url + " is not supported");
        }
    }

    @When("I type {string} into email field m")
    public void iTypeIntoEmailFieldM(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }


    @And("I type {string} into password field m")
    public void iTypeIntoPasswordFieldM(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button m")
    public void iClickButtonM(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @And("I click {string} menu item m")
    public void iClickMenuItemM(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("I type {string} as quiz title m")
    public void iTypeAsQuizTitleM(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question m")
    public void iAddAQuestionM() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question type m")
    public void iSelectQuestionTypeM(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+questionType+"')]")).click();
    }

    @And("I type {string} into question field of {string} m")
    public void iTypeIntoQuestionFieldOfM(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @When("I type {string} into {string} option field of {string} m")
    public void iTypeIntoOptionFieldOfM(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']")).sendKeys(optionText);
    }


    @When("I select {string} as a correct option in {string} m")
    public void iSelectAsACorrectOptionInM(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"*']/../../../../..//mat-radio-button")).click();
    }

    @Then("{string} is displayed on the list of quizzes m")
    public void isDisplayedOnTheListOfQuizzesM(String quizTitle) {
        List <WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title  :  titles) {
            if(title.getText().contains(quizTitle)){
                title.isDisplayed();
            }

        }
    }

    @And("I delete {string} from the list of quizzes m")
    public void iDeleteFromTheListOfQuizzesM(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='Delete']")).click();
        Thread.sleep(2000);

    }
}
