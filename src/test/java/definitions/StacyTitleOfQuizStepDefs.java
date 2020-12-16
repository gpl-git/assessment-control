package definitions;

        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.openqa.selenium.By;


        import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
        import static support.TestContext.getDriver;

public class StacyTitleOfQuizStepDefs {
    @When("I click on Title Of The Quiz field")
    public void iClickOnTitleOfTheQuizField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).click();
    }

    @And("I click anywhere else on the screen")
    public void iClickAnywhereElseOnTheScreen() {
        getDriver().findElement(By.xpath("//ac-quiz-builder-page[@class='ng-star-inserted']")).click();
    }

    @Then("error message {string} appears")
    public void errorMessageAppears(String error) {
        String errorMessage = getDriver().findElement(By.xpath("//mat-form-field")).getText();
        assertThat(errorMessage.contains(error)).isTrue();
    }


    @Then("error message {string} does not appear")
    public void errorMessageDoesNotAppear(String error) {
        String errorMessage = getDriver().findElement(By.xpath("//mat-form-field")).getText();
        assertThat(errorMessage.contains(error)).isFalse();
    }
}
