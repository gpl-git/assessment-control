package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizUpdatedStepDefs {
    @Given("I navigate to site {string}")
    public void iNavigateToSite(String site) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @And("I click {string} button NZ")
    public void iClickButtonNZ(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I update {string} quiz NZ")
    public void iUpdateQuizNZ(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));

        for (WebElement element : titles) {
            if (element.getText().contains(quizTitle)) {
                element.click();
            }

        }


        WebElement element = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//*[text()='Edit']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @When("I verify {string} was updated NZ")
    public void iVerifyWasUpdatedNZ(String quiz) throws InterruptedException {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));

        for (WebElement element : titles) {
            if (element.getText().contains(quiz)) {
                element.click();

            }

        }
        WebElement element = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quiz + "')]/../../..//span[text()='Delete']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

        String actualUpdatedAt = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quiz + "')]/../../..//td[text()='Updated At:']/..")).getText();
        System.out.println(actualUpdatedAt);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);

        String updatedAt = formattedDate.substring(0, 17);
        System.out.println("updatedAt: " + updatedAt);
        assertThat(actualUpdatedAt.contains(updatedAt)).isTrue();
    }

    @And("I delete {string} quiz NZ")
    public void iDeleteQuizNZ(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));

        for (WebElement element : titles) {
            if (element.getText().contains(quizTitle)) {
                element.click();

            }

        }
        WebElement element = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Delete']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
        getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//*[text()='Delete']")).click();
    }

}