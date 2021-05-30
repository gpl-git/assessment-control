package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ForgotPasswordIonStepdefs {
    @Given("I open page {string}")
    public void iOpenPage(String url) {
        if (url.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Site " + url + " is not supported");
        }
    }

    @And("I click on element forgot password")
    public void iClickOnElementForgotPassword() {
        getDriver().findElement(By.xpath("//a[contains(text(),'I forgot my password')]")).click();
    }

    @When("I type valid {string} in the element {string}")
    public void iTypeValidInTheElement(String email, String xpath) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("test123456789123456712@gmail.com");

    }


    @And("I click request password reset")
    public void iClickRequestPasswordReset() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Request Password Reset')]")).click();
    }


    @Then("message should be displayed {string}")
    public void messageShouldBeDisplayed(String text) {
        String s=getDriver().findElement(By.xpath("//h4[contains(text(),'"+text+"')]")).getText();
        assertThat(s.contains(text)).isTrue();
    }

    @Then("I navigate to my email")
    public void iNavigateToMyEmail() {
        getDriver().get("https://mail.google.com/mail/u/6/#inbox");
    }

    @And("I click on new email in inbox field")
    public void iClickOnNewEmailInInboxField() {
        getDriver().findElement(By.xpath("//tr[@tabindex='-1'][1]")).click();
    }



    @And("I click on {string} button")
    public void iClickOnButton(String reset) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Reset Password')]")).click();


//        getDriver().switchTo().window()
    }


    @Then("I should see page title as {string}")
    public void iShouldSeePageTitleAs(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }


    @And("I click reset button on page reset password")
    public void iClickResetButtonOnPageResetPassword() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }


    @Then("message is displayed {string}")
    public void messageIsDisplayed(String text) {
        String s=getDriver().findElement(By.xpath("//*[contains(text(),'Your Password was Changed')]")).getText();
        assertThat(s.contains(text)).isTrue();
    }


    @And("I type {string} into New Password field")
    public void iTypeIntoNewPasswordField(String newPass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(newPass);
    }

    @And("I type {string} into Confirm New Password field")
    public void iTypeIntoConfirmNewPasswordField(String newPass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(newPass);
    }


    @And("I click Back To Login Page button")
    public void iClickBackToLoginPageButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Back To Login Page')]")).click();
    }

    @Then("I type {string} into email field on page login")
    public void iTypeIntoEmailFieldOnPageLogin(String email) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(email);
    }


    @Then("I type {string} into password field on page login")
    public void iTypeIntoPasswordFieldOnPageLogin(String pass) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys(pass);


    }
    @Then("I type my {string} to sign in page")
    public void iTypeMyToSignInPage(String email) {
        getDriver().findElement(By.xpath("//input[@id='identifierId']")).sendKeys(email);

    }

    @And("I click on first next button")
    public void iClickOnFirstNextButton() {
        getDriver().findElement(By.xpath("//div[@class='FliLIb DL0QTb']")).click();
    }

    @Then("I type {string} into password field on sign in page")
    public void iTypeIntoPasswordFieldOnSignInPage(String pass) {
        getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
    }

    @And("I click on second next button")
    public void iClickOnSecondNextButton() {
        getDriver().findElement(By.xpath("//div[@id='passwordNext']")).click();
    }


    @Then("I click Sign In button on login page")
    public void iClickSignInButtonOnLoginPage() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }



    @When("I type invalid {string} in the element {string}")
    public void iTypeInvalidInTheElement(String arg0, String xpath) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("1234567890987654321@gmail.com");

    }

    @Then("pop-up message should be displayed {string}")
    public void popUpMessageShouldBeDisplayed(String text) {
        String s=getDriver().findElement(By.xpath("/*[contains(text(),'"+text+"')]")).getText();
        assertThat(s.contains(text)).isTrue();
    }
}
