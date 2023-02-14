package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class annaTestStepDefs {
    @And("I type {string} into question field")
    public void iTypeIntoQuestionField(String text1) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(text1);
    }

    @And("And I type {int} characters into question field")
    public void andITypeCharactersIntoQuestionField(int num) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//textarea[@id='mat-input-3']")).sendKeys(generatedString);
    }

    @Then("{string} snackbar error message should be displayed")
    public void snackbarErrorMessageShouldBeDisplayed(String errorSnackbar) {
        String actualErrorSnack = getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']")).getText();
        assertThat(actualErrorSnack.equals(errorSnackbar)).isTrue();
    }

    @And("I select {string}Show-Stopper{string} checkbox")
    public void iSelectShowStopperCheckbox(String show, String stopper) {
        getDriver().findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();
    }

    @Then("the Show-stopper checkbox is selected")
    public void theShowStopperCheckboxIsSelected() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).isDisplayed());
    }
}






