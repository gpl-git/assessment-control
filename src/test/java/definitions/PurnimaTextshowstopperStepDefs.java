package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class PurnimaTextshowstopperStepDefs {
    @Given("I go to {string} pages")
    public void iGoToPage(String url) {
        if(url.equalsIgnoreCase("login"))
            getDriver().get("http://ask-qa.portnov.com/#/login");
        else if (url.equalsIgnoreCase("registration"))
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        else
            System.out.println("This website is not supported");
    }

    @When("I type {string} into email fields")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        
    }

    @When("I type {string} into password fields")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
        
    }

    @When("I click {string} buttons")
    public void iClickButtons(String btnNames) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnNames+"')]")).click();



    }

    @Then("I wait for {int} secs")
    public void iWaitForSecs(int time) throws InterruptedException {
        Thread.sleep(1000*time);
    }

    @When("I click {string} menu items")
    public void iClickMenuItem(String Menuitem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+Menuitem+"')]")).click();
        
    }


    @Then("I type {string} as title")
    public void iTypeAsTitle(String quizname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizname);
        
    }

    @And("I add one question")
    public void iAddOneQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();

        
    }

    @When("I select {string} question types")
    public void iSelectQuestionTypes(String questiontype) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questiontype+"')]")).click();
        
    }

    @When("I enter {string} intextbox {string}")
    public void iEnterIntextbox(String questiontext, String questionnumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionnumber+"')]/../../..//*[@formcontrolname='question']")).sendKeys(questiontext);


    }

    @When("I select {string} option {string}")
    public void iSelectOption(String showstopper, String qnum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qnum+"')]/../../..//span[contains(text(),'Stopper')]")).click();

    }


    @Then("I verify {string} is displayed in the list")
    public void iVerifyIsDisplayedInTheList(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();


    }

    @And("I delete {string} from the list")
    public void iDeleteFromTheList(String qtitle)  throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qtitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qtitle+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }
    }




