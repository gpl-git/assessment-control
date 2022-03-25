package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class changeUserNameNatalliaStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This site is not supported: " +url);
        }
    }

    @Then("I type {string} into email input field")
    public void iTypeIntoEmailInputField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password input field")
    public void iTypeIntoPasswordInputField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        getDriver().findElement(By.xpath("//button/span[contains(text(),'"+buttonName+"')]")).click();
    }

    @And("I pick {string} menu item")
    public void iPickMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @And("I click on {string} tab")
    public void iClickOnTab(String roleTab) {
        getDriver().findElement(By.xpath("//mat-tab-header/../..//*[contains(text(),'"+roleTab+"')]")).click();
    }

    @Then("I click on {string} name")
    public void iClickOnName(String name) {
        getDriver().findElement(By.xpath("//mat-tab-body/../..//*[contains(text(),'"+name+"')]")).click();

    }

    @And("I click on {string}")
    public void iClickOn(String buttonName) {
            getDriver().findElement(By.xpath("//button")).click();

    }

    @Then("I click on {string} from settings menu")
    public void iClickOnFromSettingsMenu(String settingName) {
        switch(settingName) {
            case "Change User's Name":
                getDriver().findElement(By.xpath("//*[@role='menu']/..//button[1]")).click();
                break;
            case "Change User's Role":
                getDriver().findElement(By.xpath("//*[@role='menu']/..//button[2]")).click();
                break;
            case "Change User's Group":
                getDriver().findElement(By.xpath("//*[@role='menu']/..//button[3]")).click();
                break;
            case "Delete User":
                getDriver().findElement(By.xpath("//*[@role='menu']/..//button[4]")).click();
                break;
            default:
                // code block
        }
    }

    @Then("I type {string} in full name field")
    public void iTypeInFullNameField(String newName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(newName);
    }


    @Then("I verify that a new name {string} displays")
    public void iVerifyThatANewNameDisplays(String newName) {
        assertThat(getDriver().findElement(By.xpath("//mat-card")).getText().contains(newName)).isTrue();
    }


    @Then("I type special string {int} characters before and {int} after space in full name field")
    public void iTypeSpecialStringCharactersBeforeAndAfterSpaceInFullNameField(int numBefore, int numAfter) {
        int lengthBefore = numBefore;
        int lengthAfter = numAfter;
        boolean useLetters = true;
        boolean useNumbers = true;
        boolean useCharacters = true;
        String generatedStringBefore = RandomStringUtils.random(lengthBefore, useLetters, useNumbers);
        String generateStringAfter = RandomStringUtils.random(lengthAfter, useLetters, useCharacters);
        //System.out.println(generatedString);
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(generatedStringBefore+" "+generateStringAfter);
    }


    @Then("I verify that the error message {string} is displayed")
    public void iVerifyThatTheErrorMessageIsDisplayed(String lengthError) {
        String actError = getDriver().findElement(By.xpath("//mat-error")).getText();
        System.out.println(actError);
        assertThat(actError.equals(lengthError));
    }

    @Then("I verify that the error message is displayed")
    public void iVerifyThatTheErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error")).isDisplayed()).isTrue();
    }

    @Then("I erase name field")
    public void iEraseNameField(){
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
    }

}
