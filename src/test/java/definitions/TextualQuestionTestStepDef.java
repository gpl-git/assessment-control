package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class TextualQuestionTestStepDef {
    @When("I login as Teacher with credentials {string} and {string}")
    public void iLoginAsTeacherWithCredentialsAnd(String email, String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"email\"]")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @And("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[(text()='" + link + "')]")).click();
    }

    @And("I type {string} in the Title of the quiz")
    public void iTypeInTheTitleOfTheQuiz(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"name\"]")).sendKeys(title);
    }

    @And("I click to add Option")
    public void iClickToAddOption() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select {string} type")
    public void iSelectType(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + type + "')]")).click();
    }

    @And("I get error message {string}")
    public void iGetErrorMessage(String error) {
        getDriver().findElement(By.xpath("//*[contains(text(),'This field is required')]")).isDisplayed();
    }

    @When("I click {string} button to save quiz")
    public void iClickButtonToSaveQuiz(String arg0) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @When("I type {string} in the Question field")
    public void iTypeInTheQuestionField(String text) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"question\"]")).sendKeys(text);
    }

    @Then("{string} is displayed")
    public void isDisplayed(String arg0) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'List of Quizzes')]")).isDisplayed();

    }


}


