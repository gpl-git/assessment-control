package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class AssignmentsStepDefs {
    @Then("I select quiz {string}")
    public void iSelectQuiz(String title) {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        WebElement titles = getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]/.."));
        executor.executeScript("arguments[0].click()", titles);

        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'" + title + "')]/.."));
        executor.executeScript("arguments[0].click()", item);
    }

    @And("I select {string} group")
    public void iSelectGroup(String group) throws InterruptedException {
//        WebElement groupFilter = getDriver().findElement(By.xpath("//*[contains(text(),'Group Filter')]/../.."));
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click()", groupFilter);
//
//        WebElement groupCode = getDriver().findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'"+group+"')]"));
//        executor.executeScript("arguments[0].click()", groupCode);

//        public void iSelectGroupFilter(String arg0) throws InterruptedException {
            getDriver().findElement(By.xpath("//*[contains(text(),'Group Filter')]/../..")).click();
            WebElement element = getDriver().findElement(By.xpath("//span[@class='mat-option-text' " +
                    "and contains(text(),'" + group + "')]"));
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(element);
//        actions.perform();
            element.click();
            Thread.sleep(1000);
        }


    @When("I select {int} students")
    public void iSelectFirstStudents(int num) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> checkboxes = getDriver().findElements(By.xpath("//mat-list-option"));
        List<WebElement> students = getDriver().findElements(By.cssSelector(".mat-card .mat-list-text"));
        int selectedStudents = 0;
        int sizeOfList = checkboxes.size();
        int i = 0;
        while (i < sizeOfList && selectedStudents < num) {
//            WebElement student = students.get(i);
                checkboxes.get(i).click();
                selectedStudents++;
            i++;
        }
        Thread.sleep(1000);
    }
}
