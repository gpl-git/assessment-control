package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class AS658 {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("This site "+url+ "is not supported");

        }
    }

    @When("I enter {string} into email field")
    public void iEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }


    @And("I enter {string} into password field")
    public void iEnterIntoPasswordField(String pwd) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pwd);

    }

    @When("I press {string} button")
    public void iPressButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @When("I press on {string} menu")
    public void iPressOnMenu(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("I press on {string} button")
    public void iPressOnButton(String menuItem) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+menuItem+"')]")).click();

    }

    @And("I enter {string} as old password")
    public void iEnterAsNewPassword(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pwd);
    }

    @And("I enter {string} as new password")
    public void iEnterAsOldPassword(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='newPassword']")).sendKeys(pwd);
    }

    @And("I confirm {string} as new password")
    public void iConfirmAsNewPassword(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(pwd);
    }

    @And("I hit {string} button")
    public void iHitButton(String btn) {
        getDriver().findElement(By.xpath("//*[@type='button']/span[1][contains(text(),'"+btn+"')]")).click();

    }
}


