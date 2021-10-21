package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class IlonaAS649Stepdefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("This page "+url+ "is not supported");
        }
    }

    @Then("I see {string} form")
    public void iSeeForm(String form) {
       getDriver().findElement(By.xpath("//h4[contains(text(),'Registration')]")).isDisplayed();
    }

    @Then("I enter passworrd {string}")
    public void iEnterPassworrd(String pas) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).click();
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pas);
    }

    @Then("error message {string}")
    public void errorMessage(String error) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).click();
    String acterror=getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+error+"')]")).getText();
        System.out.println(acterror);
        assertThat(acterror.equals(error)).isTrue();
    }


    @Then("I enter Confirm password {string}")
    public void iEnterConfirmPassword(String confpass) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).click();
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confpass);
    }

    @Then("the error message {string} is displayed")
    public void theErrorMessageIsDisplayed(String error) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).submit();
        String acterror=getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+error+"')]")).getText();
        System.out.println(acterror);
        assertThat(acterror.equals(error)).isTrue();
    }

    @Then("password input field should have attribute {string} as {string}")
    public void passwordInputFieldShouldHaveAttributeAs(String type, String value) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute(type)).isEqualTo(value);
    }

    @Then("I enter first name {string}")
    public void iEnterFirstName(String firstName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(firstName);
    }

    @Then("I enter last name {string}")
    public void iEnterLastName(String lastName) {
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(lastName);
    }

    @Then("I enter email {string}")
    public void iEnterEmail(String email) {
        getDriver().findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(email);
    }

    @Then("I enter group {string}")
    public void iEnterGroup(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);
    }

    @Then("I click Register Me")
    public void iClickRegisterMe() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("page with message {string} opened")
    public void pageWithMessageOpened(String registered) {
        String actreg=getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actreg.equals(registered)).isTrue();
       // assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'You have been Registered')]")).isDisplayed()).isTrue();

    }

    @Then("I enter new email")
    public void iEnterNewEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        String newEmail = "username"+ randomInt +"@gmail.com";
        System.out.println(newEmail);
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);


    }
}

