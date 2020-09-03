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
        getDriver().findElement(By.xpath("//a[4]//div[1]//div[2]//h5[1]")).click();
    }

    @And("I type {string} in the Title of the quiz")
    public void iTypeInTheTitleOfTheQuiz(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname=\"name\"]")).sendKeys(title);
    }

    @And("I click to add Option")
    public void iClickToAddOption() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Add Option')]")).click();
    }

    @Then("I select {string} type")
    public void iSelectType(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Textual')]")).click();
    }
}