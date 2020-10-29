package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTQLutkovStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if(url.equals("Sign In")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("Unsupported site " + url);
        }
    }

    @When("I {string} with email: {string} and password: {string}")
    public void iWithEmailAndPassword(String action, String email, String pswd) {
        WebElement emailElement = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
        WebElement pswdElement = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        WebElement btnElement = getDriver().findElement(By.xpath("//div[@class='controls']/descendant::span[contains(text(),'" + action + "')]"));

        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='email']")));
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='password']")));
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.elementToBeClickable(btnElement));

        if(action.equals("Sign In")){
            emailElement.sendKeys(email);
            pswdElement.sendKeys(pswd);
            btnElement.click();
        }
        else {
            System.out.println("In construction"); // todo later
        }
    }


    @Then("I check user role as {string}")
    public void iCheckUserRoleAs(String userRole) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='info']")));

        String userInfo = getDriver().findElement(By.xpath("//div[@class='info']")).getText();
        //assertThat(userInfo.contains(userRole)).isTrue();

        //String userInfo = getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]"));
        //System.out.println(userInfo);
        boolean userRoleBoolean = userInfo.toUpperCase().contains(userRole.toUpperCase());
        Assert.assertEquals(userRoleBoolean, true, "Only 'Teacher' user role is good for this test scenario.");

    }
}
