package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void iEnter(String title) {
        getDriver ().findElement ( By.xpath ("//*[@formcontrolname='name']"  ) ).sendKeys ( title );
    }

    @And("I Delete {string} title of the quiz in input field")
    public void iDeleteTitleOfTheQuizInInputField(String arg0) {
        getDriver ().findElement ( By.xpath ( "//*[@formcontrolname='name']"  ) ).clear ();
    }

    @And("I click on plus sign {string} on a page")
    public void iClickOnPlusSignOnAPage(String sign) {
        getDriver ().findElement ( By.xpath ( "//*[contains(text(), 'add_circle')]" ) ).click ();
    }

    @And("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = getDriver ().findElement ( By.xpath ( "//*[contains(text(), 'This field is required')]" ) ).getText ();
        System.out.println ( actualMessage );
        assertThat ( actualMessage.equals ( expectedMessage ) ).isTrue ();
    }

    @When("I enter {int} alphanumeric characters")
    public void iEnterAlphanumericCharacters(int number) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random ( number, useLetters, useNumbers );

        getDriver ().findElement ( By.xpath ( "//*[@formcontrolname='name']" ) ).sendKeys ( generatedString );

    }

    @When("I type {int} alphanumeric characters")
    public void iTypeAlphanumericCharacters(int alphanumericCharacters) {
        {
            boolean useLetters = true;
            boolean useNumbers = true;
            String generatedString = RandomStringUtils.random ( alphanumericCharacters, useLetters, useNumbers );
            getDriver ().findElement ( By.xpath ( "//*[@formcontrolname='name']" ) ).sendKeys ( generatedString );
        }

}

    @And("error message {string} should be displayed on a screen")
    public void errorMessageShouldBeDisplayedOnAScreen(String message) {
        String actualMessage = getDriver ().findElement ( By.xpath ( "//*[contains(text(), 'Max length is 1000 characters')]" ) ).getText ();
        System.out.println ( actualMessage );
        assertThat ( actualMessage.equals ( message ) ).isTrue ();
    }

    @When("I leave {string} in title field")
    public void iLeaveInTitleField(String space) {
        getDriver ().findElement ( By.xpath ("//*[@formcontrolname='name']" ) ).sendKeys (space);
    }

    @And("error message {string} should be displayed on a screen under input field")
    public void errorMessageShouldBeDisplayedOnAScreenUnderInputField(String errorMessage) {
        String actualMessage = getDriver ().findElement (By.name ("Max length 1000 characters") ).getText ();
        System.out.println ( actualMessage );
        assertThat ( actualMessage.equals ( errorMessage ) ).isTrue ();


}

    @When("I type {string} into title quiz field")
    public void iTypeIntoTitleQuizField(String letter) {
        getDriver ().findElement ( By.xpath ("//*[@formcontrolname='name']"  ) ).sendKeys ( letter );

}
}

