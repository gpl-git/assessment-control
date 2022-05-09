package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class VasylQuizStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Incorrect Url " + url);
        }
    }

    @When("I type {string} into email field VB")
    public void iTypeIntoEmailFieldVB(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into password field VB")
    public void iTypeIntoPasswordFieldVB(String pwd) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pwd);
    }

    @And("I click button {string} VB")
    public void iClickButtonVB(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + button + "')]")).click();
    }

    @When("I click {string} menu item VB")
    public void iClickMenuItemVB(String item) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + item + "')]")).click();
    }

    @And("I wait for {int} sec VB")
    public void iWaitForSecVB(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }

    @Then("I type {string} into quiz title field")
    public void iTypeIntoQuizTitleField(String qTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(qTitle);
    }

    @And("I add a question VB")
    public void iAddAQuestionVB() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

   /* @When("I select {string} question type VB")
    public void iSelectQuestionTypeVB(String qType) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + qType + "')]")).click();
        Thread.sleep(1000);
    }*/

    @When("I type {string} into {string} VB")
    public void iTypeIntoVB(String qName, String qNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(qName);
        Thread.sleep(2000);
    }

    @And("I type {string} as {string} into {string} VB")
    public void iTypeAsIntoVB(String optionText, String optionNum, String qNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionText);
        Thread.sleep(1000);
    }

    @Then("I select {string} as a correct answer in {string} VB")
    public void iSelectAsACorrectAnswerInVB(String optionNum, String qNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../../mat-radio-button")).click();
        Thread.sleep(1000);
    }

    @Then("I select {string} as a Show-Stopper question")
    public void iSelectAsAShowStopperQuestion(String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//span[contains(text(),'Show-Stopper')]/../..")).click();
    }

    @And("I verify asterisk next to the {string} is displayed")
    public void iVerifyAsteriskNextToTheIsDisplayed(String qNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]")).isDisplayed()).isTrue();
    }


    @When("I select {string} question type into {string} VB")
    public void iSelectQuestionTypeIntoVB(String qType, String qNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//*[contains(text(),'"+qType+"')]")).click();
        Thread.sleep(1000);
    }

    @Then("I delete quiz {string} VB")
    public void iDeleteQuizVB(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @And("I verify quiz {string} in {string} and {string} is displayed a red label")
    public void iVerifyQuizInAndIsDisplayedARedLabel(String title, String button, String qNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/../../..//span[contains(text(),'" + button + "')]")).click();
        Thread.sleep(1000);
        assertThat(getDriver().findElement(By.xpath("//h5[contains(text(),'"+qNum+"')]/..//p[contains(text(),'Show-Stopper')]")).isDisplayed()).isTrue();
        Thread.sleep(1000);
    }

    @When("I click on quiz {string} VB")
    public void iClickOnQuizVB(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/..")).click();
        Thread.sleep(1000);
    }

    @When("I verify quiz {string} is displayed in List of Quizzes")
    public void iVerifyQuizIsDisplayedInListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();
    }

    @And("I verify quiz {string} in {string} and {string} is not displayed a red label")
    public void iVerifyQuizInAndIsNotDisplayedARedLabel(String title, String button, String qNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/../../..//span[contains(text(),'" + button + "')]")).click();
        Thread.sleep(1000);
        assertThat(getDriver().findElement(By.xpath("//h5[contains(text(),'"+qNum+"')]/..//p[contains(text(),'Show-Stopper')]")).isDisplayed()).isFalse();
        Thread.sleep(1000);
    }

    @Then("I select {string} as a correct answer in {string} VB for multiple question")
    public void iSelectAsACorrectAnswerInVBForMultipleQuestion(String optionNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../../mat-checkbox")).click();
    }
}
