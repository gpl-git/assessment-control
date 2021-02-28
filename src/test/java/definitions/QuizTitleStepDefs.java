//package definitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.openqa.selenium.By;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.openqa.selenium.By.*;
//import static support.TestContext.getDriver;
//
//public class QuizTitleStepDefs {
//    @When("I click on {string} button")
//    public void iClickOnButton(String btn) {
//        getDriver().findElement(xpath("//h5[contains(text(),'Quizzes')]")).click();
//    }
//
//
//    @And("I type {string} in the Title field")
//    public void iTypeInTheTitleField(String title) {
//        getDriver().findElement(xpath("//input[@formcontrolname='name']")).sendKeys(title);
//
//    }
//
//
//    @Then("I click {string}")
//    public void iClick(String btn) {
//        getDriver().findElement(xpath("//mat-icon[text()='add_circle']")).click();
//    }
//
//
//    @Then("quiz page should be displayed")
//    public void quizPageShouldBeDisplayed() {
//        getDriver().findElement(xpath("//h3[contains(text(),'Passing Rate')]")).isDisplayed();
//    }
//
//
//    @When("I clear Title field")
//    public void iClearTitleField() {
//        getDriver().findElement(xpath("//input[@placeholder='Title Of The Quiz *']")).clear();
//    }
//
//    @Then("error message {string} is displayed")
//    public void errorMessageIsDisplayed(String message) {
//        String actual=getDriver().findElement(xpath("//mat-error[contains(text(),'"+message+"')]")).getText();
//        assertThat(actual.contains(message)).isTrue();
//    }
//
//    @When("I click on {string} field")
//    public void iClickOnField(String title) {
//        getDriver().findElement(xpath("//input[@placeholder='Title Of The Quiz *']")).click();
//    }
//
//
//    @And("you confirm delete action")
//    public void youConfirmDeleteAction() {
//        getDriver().findElement(xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
//    }
//}
//
//
