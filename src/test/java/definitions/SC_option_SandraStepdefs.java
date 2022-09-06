package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class SC_option_SandraStepdefs {
    @And("I add an option")
    public void iAddAnOption() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Add Option')]")).click();
    }

    @And("{string} button is disabled")
    public void buttonIsDisabled(String btnName) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), '"+btnName+"')]")).isEnabled()).isFalse();
    }

    @Then("error message appear")
    public void errorMessageAppear() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), 'Quiz is not completed.')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} from the question")
    public void iDeleteOptionFromTheQuiz(String optionNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@placeholder='"+optionNum+"']/following::*[contains(text(), 'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Option')]")).click();
    }


    @And("I check that {string} is present")
    public void iCheckThatIsPresent(String optionNum) {
        getDriver().findElement(By.xpath("//*[@placeholder='"+optionNum+"']")).isDisplayed();
    }

    @And("error message contains text {string}")
    public void errorMessageContainsText(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat((actualError).contains(expectedError)).isTrue();

    }

    @And("I type {int} alphanumeric characters as {string} into {string}")
    public void iTypeAlphanumericCharactersAsInto(int numberCharacters, String optNum, String qNum) {

        boolean useLetters = true;
        boolean useNumbers = true;

        String generatedString = RandomStringUtils.random(numberCharacters, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//*[@placeholder='"+optNum+"']")).sendKeys(generatedString);
    }


    @And("I add up to {int} options into {string}")
    public void iAddUpToOptionsInto(int num, String questionNum) {

        for (int i = 3; i <= num; i++){
        getDriver().findElement(By.xpath("//*[contains(text(), 'Add Option')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='Option "+i+"*']")).sendKeys("Option" + i);
    }
    }
}
