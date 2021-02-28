package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class loginSCQMyStepdefs {
    @Given("I go  to {string}")
    public void iGoTo(String url) {

        getDriver().get(url);
    }

    @And("I login with {string} email and {string} password byAK")
    public void iLoginWithEmailAndPasswordByAK(String email, String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I wait for {int} sec to see what's on the page")
    public void iWaitForSecToSeeWhatSOnThePage(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @And("I click {string} byAK")
    public void iClickByAK(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @And("I navigate to {string} page from main menu byAK")
    public void iNavigateToPageFromMainMenuByAK(String sidemenu) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + sidemenu + "')]")).click();
    }

    @And("I type {string} in the form byAK")
    public void iTypeInTheFormByAK(String Title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname ='name']")).sendKeys(Title);
    }

    @And("I click {string} plus sign byAK")
    public void iClickPlusSignByAk(String add) {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'"+add+"')]")).click();
    }

    @And("I select {string} option byAK")
    public void iSelectOptionByAK(String typeoftest) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + typeoftest + "')]")).click();
    }


    @And("I put {int} characters in question field byAK")
    public void iPutCharactersInQuestionFieldByAK(int charcount) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(RandomStringUtils.randomAlphabetic(charcount));

    }


    @And("I select {string} byAK")
    public void iSelectByAK(String SelectOption) {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + SelectOption + "')]/../../../../../..//div[@class='mat-radio-container']")).click();
    }


    @And("I type {string} to the question {string} byAK")
    public void iTypeToTheQuestionByAK(String answer, String SelectOption) {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + SelectOption + "')]/../../../../../..//textarea[@formcontrolname='option']")).sendKeys(answer);
    }

    @Then("I should see page displaying {string} byAK")
    public void iShouldSeePageDisplayingByAK(String myquiz) {
        String info = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + myquiz + "')]")).getText();
        assertThat(myquiz.contains(info)).isTrue();
        System.out.println(info);

    }

    @Then("I should not see page displaying {string} byAK")
    public void iShouldNotSeePageDisplayingByAK(String myquiz) {
        String info = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + myquiz + "')]")).getText();
        assertThat(myquiz.contains(info)).isFalse();
        System.out.println(info);

    }

    @And("I click {string} {int} times byAK")
    public void iClickTimesByAK(String Add, int n) {
        WebElement addButton = getDriver().findElement(By.xpath("//span[contains(text(),'" + Add + "')]"));
        int i;
        for (i = 0; i <= n; i++) {
            addButton.click();

        }
    }

    @And("I type {string} to the question {string} {int} {string}times byAK")
    public void iTypeToTheQuestionTimesByAK(String answer, String option, int m, String star)
    {
       int n;
       for (n=1;n<=m;n++)
       getDriver().findElement(By.xpath("//label[contains(text(),'" + option + " " +n + star+"')]/../../../../../..//textarea[@formcontrolname='option']")).sendKeys(answer);

        }

    @Then("Verify that error message {string} displayed byAK")
    public void verifyThatErrorMessageDisplayedByAK(String error) {

        String errormssg=getDriver().findElement(By.xpath("//div[contains(text(),'"+error+"')]")).getText();
        assertThat(errormssg.contains(error)).isTrue();


    }

    @Then("I should see page input field  {string} byAK")
    public void iShouldSeePageInputFieldByAK(String text) {
        String textonthescreen=getDriver().findElement(By.xpath("//label[contains(text(),'"+text+"')]")).getText();
        assertThat(textonthescreen.contains(text)).isTrue();
    }

    @And("I select {string} for assigned quiz byAK")
    public void iSelectForAssignedQuizByAK(String answer) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+answer+"')]/..//div[@class='mat-radio-container']")).click();
    }


    @Then("I should see that test was graded at {string}")
    public void iShouldSeeThatTestWasGradedAt(String gradedhow) {
        String gradedonthescreen = getDriver().findElement(By.xpath("//td[contains(text(),'"+gradedhow+"')]")).getText();
        assertThat(gradedonthescreen.contains(gradedhow)).isTrue();
    }





}
