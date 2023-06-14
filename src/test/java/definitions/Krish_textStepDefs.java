package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;

public class Krish_textStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if(url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else{
            System.out.println("This url " + url + " is not supported.");
        }
    }

    @When("I enter {string} into email field")
    public void iEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);

    }

    @And("I enter {string} into password field")
    public void iEnterIntoPasswordField(String pass) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pass);

    }

    @When("I press {string} button")
    public void iPressButton(String buttonNa) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonNa+"')]")).click();

    }

    @And("I waited for {int} sec")
    public void iWaitedForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @And("I press {string} menu item")
    public void iPressMenuItem(String menuType) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuType+"')]")).click();
    }

    @When("I give {string} as quiz title")
    public void iGiveAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add question")
    public void iAddQuestion() throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
        Thread.sleep(1000);
    }

    @And("I enter {string} into field of {string}")
    public void iEnterIntoFieldOf(String Qn, String Qno) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+Qno+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(Qn);
    }


    @Then("{string} is displayed on the list")
    public void isDisplayedOnTheList(String qTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title   :  titles           ) {
            if(title.getText().contains(qTitle)){
                title.isDisplayed();
            }

        }
    }

    @When("I choose {string} question type for qn number {int}")
    public void iChooseQuestionTypeForQnNumber(String qType, int no) {
        getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content' and contains(text(),'"+qType+"')])["+no+"]")).click();
    }

    @Then("new panel for qn {int} is displayed")
    public void newPanelForQnIsDisplayed(int no) {
        assertThat(getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content' and contains(text(), 'Single-Choice')])["+no+"]")).isDisplayed()).isTrue();
    }

    @Then("I click {string} checkbox for qn {int}")
    public void iClickCheckboxForQn(String txt, int no) {
        getDriver().findElement(By.xpath("(//span[contains(text(),'"+txt+"')])["+no+"]")).click();
    }

    @Then("{string} label is displayed near the question")
    public void labelIsDisplayedNearTheQuestion(String txt) {
        WebElement label = getDriver().findElement(By.xpath("//p[contains(text(),'"+txt+"')]"));
        if(label.equals(txt)) {
            label.isDisplayed();
        }

    }

    @Then("I should check an asterisk displayed near both questions")
    public void iShouldCheckAnAsteriskDisplayedNearBothQuestions() {
        WebElement Q1 = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]"));
        WebElement Q2 = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]"));
        if(Q1.getText().contains("*")){
            System.out.println("Q1 is the showstopper");
        }else if (Q2.getText().contains("*")){
            System.out.println("Q2 is the showstopper");
        }else if(Q1.getText().contains("*") && Q2.getText().contains("*")){
            System.out.println("Its a bug");
        }
        else{
            System.out.println("no showstopper");
        }
    }
    @And("I remove {string} from the list of quizzes")
    public void iRemoveFromTheListOfQuizzes(String qTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @Then("I should check an asterisk displayed near only {string}")
    public void iShouldCheckAnAsteriskDisplayedNearOnly(String qNo) {
        WebElement Q2 = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNo+"')]"));
        assertTrue(Q2.getText().contains("*"));
    }
}
