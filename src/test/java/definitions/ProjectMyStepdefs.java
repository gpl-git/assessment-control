package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class ProjectMyStepdefs {
    @Given("I navigate to sign in {string} page")
    public void iNavigateToSignInPage(String page) {
        switch (page){
            case "quiz":
                getDriver ().get ( "http://ask-qa.portnov.com/#/login" );
                break;
            case "quiz production":
                getDriver ().get ( "http://ask.portnov.com/#/login" );
                break;
            default:
                System.out.println ( "This site is not for you" );


        }
    }

    @Then("I should see page title contains {string}")
    public void iShouldSeePageTitleContains(String title) {
        getDriver ().getTitle ();
        System.out.println ( getDriver ().getTitle () );

    }

    @Then("I log in as a teacher with valid credentials where email is {string} and password is{string}")
    public void iLogInAsATeacherWithValidCredentialsWhereEmailIsAndPasswordIs(String email, String password) {
        getDriver ().findElement ( By.xpath ( "//*[@formcontrolname='email']" ) ).sendKeys ( email );
        getDriver ().findElement ( By.xpath ( "//*[@formcontrolname='password']" ) ).sendKeys ( password );
    }

    @And("I will click {string} button")
    public void iWillClickButtonOnAPage(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();
    }


    @And("I will wait for {int} sec")
    public void iWillWaitForSec(int sec) throws InterruptedException {
        Thread.sleep ( 2000+sec );

    }

    @When("I click on {string} menu in a left corner of the screen")
    public void iClickOnMenuInALeftCornerOfTheScreen(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
}

    @And("I type {string} in a quiz title field")
    public void iTypeInAQuizTitleField(String titleField) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(titleField);

}

    @And("I enter {string}")
    public void iEnter(String arg0) {
    }
}
