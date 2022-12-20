package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AP_StepDefs {

    @And("I click {string} button {int} time\\(s) - AP")
    public void iClickButtonTimeSAP(String btnName, int nClicks) {
        while(nClicks>0){
            getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
            nClicks--;
        }
    }

    @Then("question should have {int} options in total  - AP")
    public void questionShouldHaveOptionsInTotalAP(int numOptions){
        boolean displayed = true;
        try {
            assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='Option " + (numOptions+1) + "*']")).isDisplayed()).isTrue();
            System.out.println("Step is Failed: More than "+numOptions+" option(s) is displayed");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            displayed = false;
        }

        assertThat(!displayed).isTrue();
        while (numOptions > 0) {
                assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='Option " + numOptions + "*']")).isDisplayed()).isTrue();
                numOptions--;
            }

    }

    @Then("option {int} should not be present on the page  - AP")
    public void optionShouldNotBePresentOnThePageAP(int numOption) {

        boolean displayed = true;
        try {
            assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='Option "+numOption+"*']")).isDisplayed()).isTrue();
            System.out.println("Step is Failed: Option "+numOption+"* is displayed on the page");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            displayed = false;
        }

        assertThat(!displayed).isTrue();

    }


    @Then("{string} should be checked - AP")
    public void shouldBeCheckedAP(String numOption) {
        assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='"+numOption+"']/../../../../../mat-radio-button[contains(@class,'checked')]")).isDisplayed()).isTrue();

    }

    @And("{string} should be unchecked - AP")
    public void shouldBeUncheckedAP(String numOption) {
        assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='"+numOption+"']/../../../../../mat-radio-button[@class='mat-radio-button mat-accent']")).isDisplayed()).isTrue();
    }

    @Then("SnackBar element with the message {string} should appear - AP")
    public void snackbarElementWithTheMessageRedShouldAppearAP(String message) {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[text()='"+message+"']")).isDisplayed()).isTrue();
    }

    @And("error message {string} is displayed under {string} field in {string} - AP")
    public void errorMessageIsDisplayedUnderFieldInAP(String err, String optionNum, String questionNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../..//mat-error[contains(text(),'"+err+"')]")).isDisplayed()).isTrue();
    }

    @And("error message {string} is displayed underneath options - AP")
    public void errorMessageIsDisplayedUnderneathOptionsAP(String error) {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class,'choice-error')][contains(text(),'"+error+"')]")).isDisplayed()).isTrue();
    }

    @When("I press the settings \\(gear) button near Option {int} field - AP")
    public void iPressTheSettingsGearButtonNearOptionFieldAP(int optNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option "+optNum+"*']/../../../../..//mat-icon[text()='settings']")).click();
    }

    @Then("choice option settings menu should be displayed - AP")
    public void choiceOptionSettingsMenuShouldBeDisplayedAP() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class,'mat-menu-content')]")).isDisplayed()).isTrue();
    }

    @And("choice option settings {string} item should be disabled - AP")
    public void choiceOptionSettingsItemShouldBeDisabledAP(String setOpt) {
        assertThat(getDriver().findElement(By.xpath("//span[text()='"+setOpt+"']/..")).isEnabled()).isFalse();
    }

    @And("choice option settings {string} item should be enabled - AP")
    public void choiceOptionSettingsItemShouldBeEnabledAP(String setOpt) {
        assertThat(getDriver().findElement(By.xpath("//span[text()='"+setOpt+"']/..")).isEnabled()).isTrue();
    }

    @And("I click on the choice option settings item {string} - AP")
    public void iClickOnTheChoiceOptionSettingsItemAP(String setOpt) {
        getDriver().findElement(By.xpath("//span[text()='"+setOpt+"']/..")).click();
    }

    @Then("choice option settings menu should NOT be displayed - AP")
    public void choiceOptionSettingsMenuShouldNOTBeDisplayedAP() {
        boolean displayed = true;
            try {
                assertThat(getDriver().findElement(By.xpath("//div[contains(@class,'mat-menu-content')]")).isDisplayed()).isTrue();
                System.out.println("Step is Failed: The element is displayed on the page");
            } catch (org.openqa.selenium.NoSuchElementException e) {
                displayed = false;
            }

        assertThat(!displayed).isTrue();
    }

    @And("I type {int} alphanumeric characters into {string} field in {string} - AP")
    public void iTypeAlphanumericCharactersIntoFieldInAP(int numOfChars, String optionNum, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(numOfChars, useLetters, useNumbers);
//        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(generatedString);
    }

    @Then("Preview Mode dialog should be displayed - AP")
    public void previewModeDialogShouldBeDisplayedAP() {
        assertThat(getDriver().findElement(By.xpath("//ac-quiz-preview/..//h3[text()='PREVIEW MODE']")).isDisplayed()).isTrue();
    }




    @And("Option {int} in the question with the title {string} should contain text that has {int} characters - AP")
    public void optionInTheQuestionWithTheTitleShouldContainTextThatHasCharactersAP(int optNum, String questTitle, int numOfChars) {
        String text = getDriver().findElement(By.xpath("(//h3[text()='"+questTitle+"']/..//div[@class='mat-radio-label-content'])["+optNum+"]")).getText();
//        System.out.println(text);
        System.out.println("The field contains "+text.length()+" characters. Expected result: "+numOfChars+" characters");
        assertThat(text.length()==numOfChars).isTrue();


    }


    @Then("Option {int} in the question with the title {string} should contain text as {string} - AP")
    public void optionInTheQuestionWithTheTitleShouldContainTextAsAP(int optNum, String questTitle, String optText) {
        String ActualText = getDriver().findElement(By.xpath("(//h3[text()='"+questTitle+"']/..//div[@class='mat-radio-label-content'])["+optNum+"]")).getText();
        System.out.println("The field contains the following text: "+ActualText+". Expected result: "+optText);
        assertThat(optText.equals(ActualText)).isTrue();
    }

    @Then("Option {int} in Question {int} should not be displayed - AP")
    public void optionInQuestionShouldNotBeDisplayedAP(int optNum, int questNum) {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questNum+"')]/../../..//textarea[@placeholder='"+optNum+"']"));

        boolean displayed = true;
        try {
            assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q"+questNum+"')]/../../..//textarea[@placeholder='Option "+optNum+"*']")).isDisplayed()).isTrue();
            System.out.println("Step is Failed: The element is displayed on the page");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            displayed = false;
        }

        assertThat(!displayed).isTrue();
    }
}
