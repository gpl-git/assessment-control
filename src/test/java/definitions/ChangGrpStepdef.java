package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import org.openqa.selenium.Keys;

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


    @Then("{string} is displayed on the user-details page")
    public void isDisplayedOnTheUserDetailsPage(String NewGrp) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//*[text()='Group']/../td[text()='" + NewGrp + "']"));
        WebElement errorMessage = getDriver().findElement(By.xpath("//mat-error[contains(text(),'Should contain only first and last name')]"));

        if (!titles.isEmpty() && titles.get(0).isDisplayed() && !errorMessage.isDisplayed()) {
            System.out.println(NewGrp);

        } else {
            assertThat(errorMessage.isDisplayed()).isFalse();
            System.out.println("This Group code " + NewGrp + " is not displayed");

        }
    }


    @Then("I should see modal window with {string} -DA")
    public void iShouldSeeModalWindowWithDA(String expectedText) {
        WebElement modalWindow = getDriver().findElement(By.xpath("//h1"));
        String actualText = modalWindow.getText();
        assertThat(actualText).contains(expectedText);
        System.out.println(actualText);
//        This is known issue JIRA MAY23-400
    }

    @Then("I should see input field placeholder as {string} -DA")
    public void iShouldSeeInputFieldPlaceholderAsDA(String expectedPlaceholder) {
        WebElement inputField = getDriver().findElement(By.xpath("//input[@placeholder='Full Name']"));
        String actualPlaceholder = inputField.getAttribute("placeholder");
        assertThat(actualPlaceholder).isEqualTo(expectedPlaceholder);
        System.out.println(actualPlaceholder);
    }

    @And("I click on {string} button -DA")
    public void iClickOnButtonDA(String ChangBtn) {
        getDriver().findElement(By.xpath("//ac-modal-adjust-user//span[text()='Change']")).click();
    }

    @And("I Click on {string} button at mat-card -DA")
    public void iClickOnButtonAtMatCardDA(String OptionsBtn) {
        getDriver().findElement(By.xpath("//span")).click();

    }


    @When("I click on the {string} tap")
    public void iClickOnTheTap(String Tap) {
        getDriver().findElement(By.xpath("//div[contains(text(),'Teachers')]")).click();

    }

    @And("I Select a Teacher name {string} from the list of Students")
    public void iSelectATeacherNameFromTheListOfStudents(String TeacherName) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'" + TeacherName + "')]")).click();

    }

    @Then("I should see {string} window -DA")
    public void iShouldSeeWindowDA(String expectedNotification) {
        WebElement notificationWindow = getDriver().findElement(By.xpath("//h1"));
        String actualNotification = notificationWindow.getText();
        assertThat(actualNotification).isEqualTo(expectedNotification);
    }


    @Then("{string} is not displayed on the user-details page -DA")
    public void isNotDisplayedOnTheUserDetailsPageDA(String NewGrpcod) {
            List<WebElement> titles = getDriver().findElements(By.xpath("//*[text()='Group']/../td[text()='" + NewGrpcod + "']"));
            if (titles.isEmpty()) {
                System.out.println("This Group code " + NewGrpcod + " is not displayed");
            } else {
                for (WebElement title : titles) {
                    if (title.isDisplayed()) {
                        System.out.println("The Group code " + NewGrpcod + " is unexpectedly displayed");
                    }
                }
            }
        }

    @And("error message {string} shold be displayed -DA")
    public void errorMessageSholdBeDisplayedDA(String error) {
        WebElement modalWindow = getDriver().findElement(By.xpath("//mat-error[@role='alert']"));
        String actualText = modalWindow.getText();
        assertThat(actualText).contains(error);
        System.out.println(actualText);

    }





    @And("I press {string} key")
    public void iPressKey(WebElement element) {
        element.sendKeys(Keys.RETURN);
    }



    @And("I clear and backspace User's Group filed  -DA")
    public void iClearAndBackspaceUserSGroupFiledDA() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
//        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("AAAA");
//        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.ENTER);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).click();


    }
}









   

