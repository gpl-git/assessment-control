package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

import static support.TestContext.getDriver;

public class SingleChoiceQTStepdefs {
    @And("I push {string} button")
    public void iPushButton(String signIn) throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + signIn + "')]")).click();
        Thread.sleep(2000);
    }


    @And("I click {string} button to create new quiz")
    public void iClickButtonToCreateNewQuiz(String createNewQuiz) throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + createNewQuiz + "')]")).click();
        Thread.sleep(2000);
    }

    @When("I click {string} link to open quizzes")
    public void iClickLinkToOpenQuizzes(String newPage) throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + newPage + "')]")).click();
        Thread.sleep(2000);
    }

    @When("I type {string} into title field")
    public void iTypeIntoTitleField(String title) {
        getDriver().findElement(By.xpath("//*[contains(@id,'mat-input')]")).sendKeys(title);
    }


    @And("^I wait for (\\d+) sec$")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }
}