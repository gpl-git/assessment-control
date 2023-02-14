package definitions;

import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class Zakar_SC_TextStepDefs {
    @When("I type {int} characters into {string}")
    public void iTypeCharactersInto(int characterNum, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(characterNum, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(generatedString);
    }
}
