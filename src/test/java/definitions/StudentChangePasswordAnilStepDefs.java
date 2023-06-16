package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class StudentChangePasswordAnilStepDefs {
    @Given("I go to the {string} page - Anil")
    public void iGoToThePageAnil(String end) {
        if (end.equalsIgnoreCase("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (end.equalsIgnoreCase("home")){
            getDriver().get("http://ask-qa.portnov.com/#/home");
        }else if (end.equalsIgnoreCase("assignments")){
            getDriver().get("http://ask-qa.portnov.com/#/my-assignments");
        }else if (end.equalsIgnoreCase("grades")){
            getDriver().get("http://ask-qa.portnov.com/#/my-grades");
        }else if (end.equalsIgnoreCase("settings")){
            getDriver().get("http://ask-qa.portnov.com/#/settings");
        }else if (end.equalsIgnoreCase("quizzes")){
            getDriver().get("http://ask-qa.portnov.com/#/quizzes");
        }else {
            System.out.println("Website does not have a page named as "+end);
        }
    }

    @Then("I type {string} into the email field - Anil")
    public void iTypeIntoTheEmailFieldAnil(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into the password field - Anil")
    public void iTypeIntoThePasswordFieldAnil(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click on the {string} button - Anil")
    public void iClickOnTheButtonAnil(String btn) {
        if (btn.equalsIgnoreCase("sign in")){
            getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        }else if (btn.equalsIgnoreCase("register now")){
            getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
        }else if (btn.equalsIgnoreCase("change password")){
            getDriver().findElement(By.xpath("//span[contains(text(),'Change Your Password')]")).click();
        }else if (btn.equalsIgnoreCase("change")) {
            getDriver().findElement(By.xpath("//div[2]/button[2]/span[1]")).click();
        }else {
            System.out.println("Button name: "+btn+" can not found. Check the button name!");
        }
    }

    @Then("I will see my name {string} on the header")
    public void iWillSeeMyNameOnTheHeader(String name) {
        assertThat(name.contains(getDriver().findElement(By.xpath("//header/div[2]")).getText()));
    }

    @And("I type {string} into the new password field - Anil")
    public void iTypeIntoTheNewPasswordFieldAnil(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(password);
    }

    @And("I type {string} into the confirm password field - Anil")
    public void iTypeIntoTheConfirmPasswordFieldAnil(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I will wait {int} sec - Anil")
    public void iWillWaitSecAnil(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @Given("I leave the {string} field empty - Anil")
    public void iLeaveTheFieldEmptyAnil(String field) {
        if (field.equalsIgnoreCase("password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("a");
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(Keys.BACK_SPACE);
        }else if (field.equalsIgnoreCase("new password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys("a");
            getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(Keys.BACK_SPACE);
        }else if (field.equalsIgnoreCase("confirm password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("a");
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(Keys.BACK_SPACE);
        }else {
            System.out.println(field+" field could not be found.");
        }
    }

    @Then("I should see {string} message under the {string} field - Anil")
    public void iShouldSeeMessageUnderTheFieldAnil(String error, String field) {
        if (error.equalsIgnoreCase("this field is required")){
            assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field')]")).isDisplayed()).isTrue();
            assertThat(error.equalsIgnoreCase(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field')]")).getText()));
        }else if (error.equalsIgnoreCase("Should be at least 5 characters")){
            assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'Should')]")).isDisplayed()).isTrue();
            assertThat(error.equalsIgnoreCase(getDriver().findElement(By.xpath("//mat-error[contains(text(),'Should')]")).getText()));
        }else if (error.equalsIgnoreCase("Whitespaces are not allowed")){
            assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespaces')]")).isDisplayed()).isTrue();
            assertThat(error.equalsIgnoreCase(getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespaces')]")).getText()));
        }else {
            System.out.println("This error message can not be displayed!");
        }
    }

    @Then("I will see my name {string} on the header - Anil")
    public void iWillSeeMyNameOnTheHeaderAnil(String name) {
        assertThat(name.contains(getDriver().findElement(By.xpath("//header/div[2]")).getText()));
    }

    @Given("I enter a short password into the {string} field - Anil")
    public void iEnterAShortPasswordIntoTheFieldAnil(String field) {
        Boolean useLetters = true;
        Boolean useNumbers = true;
        String generatedPassword = RandomStringUtils.random(4,useLetters,useNumbers);
        System.out.println(generatedPassword);
        if (field.equalsIgnoreCase("password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(generatedPassword);
        }else if (field.equalsIgnoreCase("new password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(generatedPassword);
        }else if (field.equalsIgnoreCase("confirm password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(generatedPassword);
        }
    }

    @Given("I enter a white space into the {string} field - Anil")
    public void iEnterAWhiteSpaceIntoTheFieldAnil(String field) {
        if (field.equalsIgnoreCase("password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(" ");
        }else if (field.equalsIgnoreCase("new password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(" ");
        }else if (field.equalsIgnoreCase("confirm password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(" ");
        }else {
            System.out.println(field+" field could not be found.");
        }
    }

    @Given("I enter a long password into the {string} field - Anil")
    public void iEnterALongPasswordIntoTheFieldAnil(String field) {
        Boolean useLetters = true;
        Boolean useNumbers = true;
        String generatedPassword = RandomStringUtils.random(33,useLetters,useNumbers);
        System.out.println(generatedPassword);
        if (field.equalsIgnoreCase("password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(generatedPassword);
        }else if (field.equalsIgnoreCase("new password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(generatedPassword);
        }else if (field.equalsIgnoreCase("confirm password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(generatedPassword);
        }
    }
}
