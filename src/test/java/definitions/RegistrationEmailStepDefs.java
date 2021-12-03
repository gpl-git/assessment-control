package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static support.TestContext.getDriver;

public class RegistrationEmailStepDefs {
//    @Given("I navigate to {string} page")
//    public void iNavigateToPage(String url) {
//        if(url.equals("login")) {
//            getDriver().get("http://ask-qa.portnov.com/#/login");
//        }else if(url.equals("registration")){
//            getDriver().get("http://ask-qa.portnov.com/#/registration");
//        }else{
//            System.out.println("The site " + url+ " is not supported");
//        }
//
//    }

//    @When("I type {string} into First Name field")
//    public void iTypeIntoFirstNameField(String firstName) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
//    }

//    @Then("I type {string} into Last Name field")
//    public void iTypeIntoLastNameField(String lastName) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
//    }
//
//    @Then("I click on {string} button")
//    public void iClickOnButton(String button) {
//        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
//
//    }


    @Then("I validate Email field displays the error message {string}")
    public void iValidateEmailFieldDisplaysTheErrorMessage(String emailError) {
        {
            String actual = getDriver().findElement(By.xpath("//input[@formcontrolname='email']/../../..//mat-error")).getText();
            System.out.println(actual);
            assertThat(actual.equals(emailError));
        }
    }

//    @Then("I type {string} into Email field")
//    public void iTypeIntoEmailField(String email) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
//    }

    @Then("email error message is not displayed")
    public void emailErrorMessageIsNotDisplayed() {
        getDriver().findElement(By.xpath("//mat-error")).getText();
    }

    @Then("I type {string} into group field")
    public void iTypeIntoGroupField(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @Then("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confPass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confPass);
    }

    @Then("confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String confirmationMessage) {
        String actualMessage= getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actualMessage.equals(confirmationMessage));
    }

    @Then("I type {int} characters into Email field")
    public void iTypeCharactersIntoEmailField(int number) {{
            boolean useLetters = true;
            boolean useNumbers = true;
//            boolean useCharacters = true;
            String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
            System.out.println(generatedString);
            getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(generatedString);
        }
    }

    @Then("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }



    @When("I type new email with {int} characters before {string}")
    public void iTypeNewEmailWithCharactersBefore(int num, String domain) {
        boolean useLetters = true;
        boolean useNumbers = true;
        boolean useCharacters = true;
        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(generatedString+domain);

    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

//    @When("I type {int} characters before {string} and {int} characters after")
//    public void iTypeCharactersBeforeAndCharactersAfter(int num, String port, int num1) {
//        boolean useLetters = true;
//        boolean useNumbers = true;
//        boolean useCharacters = true;
//        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
//        String generatedString1 = RandomStringUtils.random(num1, useLetters, useNumbers);
//        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(generatedString+port+generatedString1);
//
//
//    }

}


