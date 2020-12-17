package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleChoiceShowStopperStepDefs {
    @When("I select the Show-stopper question checkbox")
    public void iSelectTheShowStopperQuestionCheckbox() {
        getDriver().findElement(By.xpath("//label[@for='mat-checkbox-2-input']/div")).click();
    }


    @Then("List of Quizzes should be displayed")
    public void listOfQuizzesShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='quizzes']")).isDisplayed()).isTrue();
    }

    @And("{string} question should be displayed in the list of quizzes")
    public void questionShouldBeDisplayedInTheListOfQuizzes(String question) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+question+"')]")).isDisplayed()).isTrue();
        System.out.println(question);
    }

    @And("I select a quiz from the dropdown")
    public void iSelectAQuizFromTheDropdown() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='mat-select-trigger']/div[1]//span[contains(text(),'Select Quiz To Assign')]")).click();
        Thread.sleep(1*1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Single Choice Show Stopper Test1')]")).click();
    }

    @Then("{string} should be displayed on the question")
    public void shouldBeDisplayedOnTheQuestion(String asteriskShowStopper) {
        //new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mat-content']/mat-panel-title[contains(text(),'*')]")));
        assertThat(getDriver().findElement(By.xpath("//span[@class='mat-content']/mat-panel-title[contains(text(),'"+asteriskShowStopper+"')]")).isDisplayed()).isTrue();
        //String actual = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1*: Select option1')]")).getText();
        //assertThat(actual.contains(asteriskShowStopper)).isTrue();
        //System.out.println(actual);
    }


    @And("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @And("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+link+"')]")).click();
    }

    @When("I select {string} from the list")
    public void iSelectFromTheList(String questionName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionName+"')]")).click();
    }

    @And("I click the Preview button")
    public void iClickThePreviewButton() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz_Shilpa')]/../../..//button[1]/span[contains(text(),'Preview')]")).click();
    }

    @Then("{string} text should be displayed")
    public void textShouldBeDisplayed(String text) {
        String actual = getDriver().findElement(By.xpath("//p[contains(text(),'"+text+"')]")).getText();
        assertThat(actual.contains(text)).isTrue();
        System.out.println(actual);
    }
}
