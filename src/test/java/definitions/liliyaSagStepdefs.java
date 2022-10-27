package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class liliyaSagStepdefs {
    @Given("I open {string} page as a teacher")
    public void iOpenPageAsATeacher(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I click on {string} button")
    public void iClickOnButton(String RegisterNow) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterNow + "')]")).click();
    }


    @When("I type {string} as a name")
    public void iTypeAsAName(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @When("I type {string} as a last name")
    public void iTypeAsALastName(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} as email")
    public void iTypeAsEmail(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as a group code")
    public void iTypeAsAGroupCode(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);
    }

    @And("I type {string} as a password")
    public void iTypeAsAPassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);

    }

    @And("I type {string} as a password confirmation")
    public void iTypeAsAPasswordConfirmation(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);


    }

    @Then("I click on {string} button ls")
    public void iClickOnButtonLs(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterMe + "')]")).click();

    }

    @Then("{string} page should be displayed ls")
    public void pageShouldBeDisplayedLs(String reg) {
        if (reg.equals("registration-confirmation")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration-confirmation");
        } else {
            System.out.println("This url is not supported: " + reg);
        }
    }


    @Given("I open {string} page as the teacher")
    public void iOpenPageAsTheTeacher(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I click at {string} button")
    public void iClickAtButton(String RegisterNow) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterNow + "')]")).click();
    }

    @When("I type {string} as the name")
    public void iTypeAsTheName(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} as the last name")
    public void iTypeAsTheLastName(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} as the group code")
    public void iTypeAsTheGroupCode(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);

    }

    @And("I type {string} as the password")
    public void iTypeAsThePassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);

    }

    @And("I type {string} as the password confirmation")
    public void iTypeAsThePasswordConfirmation(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @When("I click on {string} button l")
    public void iClickOnButtonL(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterMe + "')]")).click();

    }

    @Then("{string} error should be displayed")
    public void errorShouldBeDisplayed(String field) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + field + "')]")).isDisplayed()).isTrue();

    }

    @Given("I open {string} page as a teacher ls")
    public void iOpenPageAsATeacherLs(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I click at {string} button l")
    public void iClickAtButtonL(String RegisterNow) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterNow + "')]")).click();
    }

    @When("I type {string} as the name l")
    public void iTypeAsTheNameL(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} as the last name l")
    public void iTypeAsTheLastNameL(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} as email l")
    public void iTypeAsEmailL(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as the group code l")
    public void iTypeAsTheGroupCodeL(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);

    }

    @And("I type {string} as a password l")
    public void iTypeAsAPasswordL(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);


    }

    @And("I type {string} as the password confirmation l")
    public void iTypeAsThePasswordConfirmationL(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);


    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterMe + "')]")).click();
    }

    @Then("{string} error should be displayed l")
    public void errorShouldBeDisplayedL(String validEmail) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + validEmail + "')]")).isDisplayed()).isTrue();

    }

    @Given("I open {string} page as a teacher lsl")
    public void iOpenPageAsATeacherLsl(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I click at {string} button ls")
    public void iClickAtButtonLs(String RegisterNow) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterNow + "')]")).click();
    }

    @When("I type {string} as the name ls")
    public void iTypeAsTheNameLs(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} as the last name ls")
    public void iTypeAsTheLastNameLs(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} as email ls")
    public void iTypeAsEmailLs(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as the group code ls")
    public void iTypeAsTheGroupCodeLs(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);
    }

    @And("I type {string} as a password ls")
    public void iTypeAsAPasswordLs(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type {string} as the password confirmation ls")
    public void iTypeAsThePasswordConfirmationLs(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);

    }

    @When("I click on the {string} button l")
    public void iClickOnTheButtonL(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterMe + "')]")).click();

    }

    @Then("{string} error should be displayed ls")
    public void errorShouldBeDisplayedLs(String alert) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + alert + "')]")).isDisplayed()).isTrue();

        }

    @Given("I open {string} page as a teacher ll")
    public void iOpenPageAsATeacherLl(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }

    }

    @When("I click at {string} button ll")
    public void iClickAtButtonLl(String RegisterNow) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterNow + "')]")).click();
    }

    @When("I type {string} as the name ll")
    public void iTypeAsTheNameLl(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} as the last name ll")
    public void iTypeAsTheLastNameLl(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
            }

    @And("I type {string} as email ll")
    public void iTypeAsEmailLl(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
        
    }

    @And("I type {string} as the group code ll")
    public void iTypeAsTheGroupCodeLl(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);
    }

    @And("I type {string} as a password ll")
    public void iTypeAsAPasswordLl(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type {string} as the password confirmation ll")
    public void iTypeAsThePasswordConfirmationLl(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
        
    }

    @When("I click on the {string} button ll")
    public void iClickOnTheButtonLl(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterMe + "')]")).click();
    }

    @Then("{string} error should be displayed ll")
    public void errorShouldBeDisplayedLl(String alert) {
       assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + alert + "')]")).isDisplayed()).isTrue();

        }

    @Given("I open {string} page as a teacher ss")
    public void iOpenPageAsATeacherSs(String url) {
             if (url.equals("registration")) {
                getDriver().get("http://ask-qa.portnov.com/#/registration");
            } else if (url.equals("login")) {
                getDriver().get("http://ask-qa.portnov.com/#/login");
            } else {
                System.out.println("This url is not supported: " + url);
            }
        }

    @When("I click at {string} button ss")
    public void iClickAtButtonSs(String RegisterNow) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterNow + "')]")).click();

    }

    @When("I type {string} as the name ss")
    public void iTypeAsTheNameSs(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} as the last name ss")
    public void iTypeAsTheLastNameSs(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} as email ss")
    public void iTypeAsEmailSs(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as the group code ss")
    public void iTypeAsTheGroupCodeSs(String group) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(group);
    }


    @And("I type {string} as a password ss")
    public void iTypeAsAPasswordSs(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
        
        
    }

    @And("I type {string} as the password confirmation ss")
    public void iTypeAsThePasswordConfirmationSs(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @When("I click on the {string} button ss")
    public void iClickOnTheButtonSs(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + RegisterMe + "')]")).click();


    }

    @Then("{string} error should be displayed ss")
    public void errorShouldBeDisplayedSs(String alert) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + alert + "')]")).isDisplayed()).isTrue();
    }
}













