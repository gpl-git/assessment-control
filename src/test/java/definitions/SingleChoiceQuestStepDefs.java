package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleChoiceQuestStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) { getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String tEmail) {
        WebElement teacher = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        teacher.sendKeys(tEmail);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} btn")
    public void iClickOn(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I verify that user role {string} is displayed")
    public void iVerifyThatUserRoleIsDisplayed(String userRole) {
        String info = getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]")).getText();
        assertThat(info.contains(userRole)).isTrue();
    }

    @When("I go to {string} section")
    public void iGoToSection(String quizzes) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @Then("I click button {string}")
    public void iClickButton(String createQuiz) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @And("I type {string} into title field")
    public void iTypeIntoTitleField(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I click on {string} btn")
    public void iClickOnBtn(String btn) {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I click radio-button {string}")
    public void iClickRadioButton(String singleChoice) {
        getDriver().findElement(By.xpath("//div[contains(text(),'Single-Choice')]")).click();
    }

    @Then("I check {string} checkbox")
    public void iCheckCheckbox(String checkbox) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+checkbox+"')]")).click();
    }

    @And("I verify that {string} present")
    public void iVerifyThatPresent(String expected) {
        String actual = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1*: new empty question')]")).getText();
        assertThat(actual.contains(expected)).isTrue();
    }

    @Then("I type {string} into text field")
    public void iTypeIntoTextField(String text) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(text);
    }

    @And("I type {string} into option field")
    public void iTypeIntoOptionField(String option) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(option);
    }

    @And("I type {string} into field")
    public void iTypeIntoField(String option2) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(option2);
    }

    @Then("I check {string} radio-button")
    public void iCheckRadioButton(String correctAnswer) {
        getDriver().findElement(By.xpath("//label[contains(text(),'" +correctAnswer+ "')]/../../../../../..//div[@class='mat-radio-container']")).click();
    }

    @And("I click on Preview button")
    public void iClickOnPreviewButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Preview')]")).click();
    }

    @When("I verify that {string} displayed")
    public void iVerifyThatDisplayed(String expectedRes) {
        String actualRes = getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]")).getText();
        assertThat(actualRes.contains(expectedRes)).isTrue();
    }

    @When("I go to {string} part")
    public void iGoToPart(String assignments) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
    }

    @And("I click on {string} mat-button")
    public void iClickOnMatButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @Then("I choose group {string}")
    public void iChooseGroup(String group) {
        getDriver().findElement(By.xpath("//mat-select[@formcontrolname='groupFilter']")).sendKeys(group);
    }

    @And("I choose quiz DONT DELETE")
    public void iChooseQuizDontDelete() {
        getDriver().findElement(By.xpath("//mat-select[@placeholder='Select Quiz To Assign']")).click();
    }


    @And("I check {string}")
    public void iCheck(String checkbox) {
        getDriver().findElement(By.xpath("//mat-pseudo-checkbox[@class='mat-pseudo-checkbox mat-pseudo-checkbox-checked']")).click();
    }

    @And("I click on the {string}")
    public void iClickOnThe(String giveAssignment) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
    }

    @When("I log out")
    public void iLogOut() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
    }

    @And("I confirm logging out")
    public void iConfirmLoggingOut() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
    }

    @When("I type student email {string} into email field")
    public void iTypeStudentEmailIntoEmailField(String sEmail) {
        WebElement student = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        student.sendKeys(sEmail);
    }

    @Then("I verify that student role {string} is displayed")
    public void iVerifyThatStudentRoleIsDisplayed(String sRole) {
        String info = getDriver().findElement(By.xpath("//p[contains(text(),'STUDENT')]")).getText();
        assertThat(info.contains(sRole)).isTrue();
    }

    @When("I click on Go To My Assignments")
    public void iClickOnGoToMyAssignments() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Go To My Assignments')]")).click();
    }

    @And("I click on Go To Assessment")
    public void iClickOnGoToAssessment() {
        getDriver().findElement(By.xpath("//td[contains(text(),'DONT DELETE')]/../td[contains(text(),'Assigned at: 02/25/21 14:47')]")).click();
    }

}
