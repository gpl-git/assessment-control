package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleOptionStepDefs {
    @When("I type {int} characters into {string} as {string}")
    public void iEnterAlphanumericCharacters(int number, String questionNum, String optionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).sendKeys(generatedString);
    }

    @And("I add up to {int} options in {string}")
    public void iAddUpToOptionsIn(int num, String questionNum) {
        for (int i = 3; i <= num; i++) {
            getDriver().findElement(By.xpath("//*[contains(text(),'Q1')]/../../..//*[contains(text(),'Add Option')]")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@placeholder='Option " + i + "*']")).sendKeys("Option " + i);

        }
    }


    @Then("I add Other text area")
    public void iAddOtherTextArea() {
        getDriver().findElement(By.xpath("//*[@id='mat-checkbox-6']")).click();
    }

    @Then("{string} error message should be displayed on webpage")
    public void errorMessageShouldBeDisplayedOnWebpage(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//div[@class='choice-error ng-star-inserted']")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }
}
