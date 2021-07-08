package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegLastNameStepDefs {
    @And("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmPwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPwd);
    }

    @And("I type {string} into Group Code field")
    public void iTypeIntoGroupCodeField(String grCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(grCode);
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String erorrM) {
        String erM = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-5']")).getText();
        System.out.println(erM);
        assertThat(erM.contains(erorrM)).isTrue();

    }


    @And("clear Last Name Field")
    public void clearLastNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).clear();
    }
}
