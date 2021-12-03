package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ChangeUserRoleStepDefs {
    @When("I choose {string}")
    public void iChoose(String student) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'"+student+"')]")).click();
    }

    @Then("I select Change User's Role option")
    public void iSelectLink() {
        getDriver().findElement(By.xpath("//button//mat-icon[text()='school']")).click();
    }

    @Then("I click on Options button")
    public void iClickOnTab() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'settings')][@class='mat-icon material-icons']")).click();
    }

    @And("message {string} should be displayed")
    public void messageShouldBeDisplayed(String messageUserBecomeTeacher) {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'"+messageUserBecomeTeacher+"')]")).isDisplayed()).isTrue();
    }

    @And("I click on {string}")
    public void iClickOn(String changeRole) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+changeRole+"')]")).click();
    }

    @Then("I validate that {string} is displayed")
    public void iValidateThatIsDisplayed(String teacherRole) {
        assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'"+teacherRole+"')]")).isDisplayed()).isTrue();
    }

    @When("I click on {string} tab")
    public void iClickOnTab(String teachersTab) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+teachersTab+"')]")).click();
    }
}
