package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrGrpCodeRuslanS_StepDefs {
    @Given("navigate to {string}")
    public void navigateTo(String url)
    {
        getDriver().get(url);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String bText)
    {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+bText+"')]")).click();
    }

    @And("I wait {int} sec")
    public void iWaitSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @Then("I type {string} into {string} field")
    public void iTypeIntoField(String keyText, String fieldName)
    {
        getDriver().findElement(By.xpath("//input[@placeholder='"+fieldName+"']")).sendKeys(keyText);
    }

    @Then("I press {string} button")
    public void iPressButton(String bText)
    {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+bText+"')]")).click();
    }

    @Then("I press {string} menu item")
    public void iPressMenuItem(String miText)
    {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+miText+"')]")).click();
    }

    @Then("I press {string} in student list")
    public void iPressInStudentList(String usName)
    {
        getDriver().findElement(By.xpath("//a/..//h4[contains(text(),'"+usName+"')]")).click();
    }

    @Then("Group should contain {string} code")
    public void groupShouldContainCode(String grCode)
    {
        assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'"+grCode+"')]")).isDisplayed()).isTrue();

    }

    @Then("I press option button")
    public void iPressOptionButton()
    {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-accent']")).click();
    }

    @Then("I press delete user menu item")
    public void iPressDeleteUserMenuItem()
    {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'delete')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")).click();

    }

    @And("I fill Email field with random generated email")
    public void iFillEmailFieldWithRandomGeneratedEmail()
    {
        String newEmail = RandomString.make(8).toLowerCase();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail+"@email.com");
    }

    @Then("I verify that {string} message displayed")
    public void iVerifyThatMessageDisplayed(String expMessage)
    {
       String actMessage = getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).getText();
       assertThat(actMessage.equals(expMessage)).isTrue();
    }

}
