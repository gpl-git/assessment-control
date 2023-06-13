package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class ChangGrpStepdef {
    @Given("I go to {string} page -DA")
    public void iGoToPageDA(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site " + url + " is not supported.");
        }

    }


    @When("I type {string} into email field -DA")
    public void iTypeIntoEmailFieldDA(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field -DA")
    public void iTypeIntoPasswordFieldDA(String password) {

        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button -DA")
    public void iClickButtonDA(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @And("I wait for {int} sec -DA")
    public void iWaitForSecDA(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @And("I click {string} menu item -DA")
    public void iClickMenuItemDA(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I Select a student name {string} from the list of Students")
    public void iSelectAStudentNameFromTheListOfStudents(String studentName) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'" + studentName + "')]")).click();
    }

    @And("I Click on {string} button")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//span//..//mat-icon")).click();

    }

    @And("I select {string} from list")
    public void iSelectFromList(String optlist) {
        getDriver().findElement(By.xpath("//button[3]")).click();

    }

    @When("I clear User's Group filed")
    public void iClearUserSGroupFiled() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
    }

    @When("I type {string} into  User's Group filed")
    public void iTypeIntoUserSGroupFiled(String NewGrp) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(NewGrp);
    }


    @Then("I Click on {string} Button -DA")
    public void iClickOnButtonDA(String Change) {
        getDriver().findElement(By.xpath("//ac-modal-adjust-user//span[text()='Change']")).click();
    }

    @Then("{string} is displayed on the user-details page")
    public void isDisplayedOnTheUserDetailsPage(String NewUsrGrP) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//*[text()='Group']/../td[text()='"+NewUsrGrP+"']"));
        for (WebElement title : titles) {
            if (title.getText().contains(NewUsrGrP)) {
                title.isDisplayed();
                System.out.println(NewUsrGrP);
            }

        }
    }
}






   

