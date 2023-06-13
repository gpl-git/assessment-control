package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

   /* @Then("I click {string} checkbox")
    public void iClickCheckbox(String txt) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+txt+"')]")).click();
    }*/

    @Then("{string} is displayed near the question")
    public void isDisplayedNearTheQuestion(String txt) {
        WebElement title = getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]"));
        if(title.equals(txt)){
            title.isDisplayed();
        }
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


    @Then("check * is displayed near both question as show stopper")
    public void checkIsDisplayedNearBothQuestionAsShowStopper() {
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
}
