package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalNumberDoinaStepDefs {
    @And("I verify that {string} button is present")
    public void iVerifyThatButtonIsPresent(String expbutton) {
        String quizzes = getDriver().findElement(By.xpath("//*[text()='" + expbutton + "']")).getText();
        assertThat(quizzes.contains(expbutton)).isTrue();


    }


    @Then("I click on {string} button byDI")
    public void iClickOnButton(String forquiz) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + forquiz + "')]")).click();
    }


//    @And("I click on {string} tab")
//    public void iClickOnTab(String newquiz) {
//      getDriver().findElement(By.xpath("//*[@class='mat-button-wrapper']")).click();
//    }

    @Then("I type {string} into quiz title")
    public void iTypeIntoQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }


    @And("I click on the plus button")
    public void iClickOnThePlusButton() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            sleep(2000);
        }
    }


    @Then("I verify that {string} is displayed")
    public void iVerifyThatIsDisplayed(String lastquest) {
        List<WebElement> lastquest50 = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'Q50')]"));

        for (WebElement element : lastquest50) {
            if (element.getText().contains(lastquest)) {
                element.isDisplayed();
            }
        }
        {

        }

    }


    @And("I click on the plus button {int}")
    public void iClickOnThePlusButton(int a) throws InterruptedException {
        for (int i = 0; i < 49; i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            sleep(2000);
            getDriver().findElement(By.xpath("//div[contains(text(),'Textual')]")).click();
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//*[placeholder='Question*']")).sendKeys("Way QA?");
            Thread.sleep(2000);

        }
    }


    @Then("I select {string}")
    public void iSelect(String select) {
        WebElement element = getDriver().findElement(By.xpath("//label[contains(text(),'" + select + "')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

    }

    @And("I select group {string}")
    public void iSelectGroup(String group) {
        WebElement element = getDriver().findElement(By.xpath("//mat-list-option[24]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    @Then("I select quiz  {string}")
    public void iSelectQuiz(String quiz) {
        WebElement element = getDriver().findElement(By.xpath("//div[@dir='ltr']/../../../..//span[contains(text(),'Graded automatically')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

    }

//    @Then("I click on student name")
//    public void iClickOnStudentName() {
//        WebElement element = getDriver().findElement(By.xpath("//mat-pseudo-checkbox[@class='mat-pseudo-checkbox']/..//*[text()='N001']"));
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click();", element);
//
//    }

    @And("I click {string} byDI")
    public void iClick(String quiz) {
        WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
        // getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();

    }

    @Then("I click to {string}")
    public void iClickTo(String logout) {
        WebElement element = getDriver().findElement(By.xpath("//mat-dialog-container[@role='dialog']//span[contains(text(),'Log Out')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

    }


    @When("I choose {string}")
    public void iChoose(String myassignments) {
        WebElement element = getDriver().findElement(By.xpath("//tr[@class='ng-star-inserted']//td[contains(text(),'Graded automatically')]/..//span[contains(text(),'Go To Assessment')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);


    }


    @Then("I choose a Student")
    public void iChooseAStudent() {
        getDriver().findElement(By.xpath("//mat-list-option[29]")).click();
    }

    @And("I click the plus button")
    public void iClickThePlusButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();

    }

    @Then("I type the question")
    public void iTypeTheQuestion() {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys("Why Qa?");
    }

    @Then("I click button plus {int}")
    public void iClickButtonPlus(int q) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(2000);
            //   getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys("Why Qa?");
        }


    }


    @Then("I click on the plus button {int} times select {string} and type {string}")
    public void iClickOnThePlusButtonTimesSelectAndType(int quesnum, String questype, String questext) throws InterruptedException {

        for (int i = 1; i <= quesnum; i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//div[contains(text(),'" + questype + "')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + quesnum + "')]/../../..//*[@placeholder='Question*']")).sendKeys(questext);


        }
    }


    @When("I add {int} Textual questions")
    public void iAddTextualQuestions(int num) throws InterruptedException {
        String question = "Q";
        String[] quetiontext = {"", "Why QA?", "How did you calculate time needed for your work?", "What happened if you were not meeting your deadline?", "Tell me about your typical working day",
                "How did you calculate time needed for your work",
                "What happened if you were not meeting your deadline?",
                "What obstacles did you face while working on your project? ",
                " How do you know you have enough requirements?",
                "How do you know you have enough test coverage?",
                " What are the typical problems of software requirements?",
                "What is your ideal working environment?",
                " Tell us about the sprint cycle in your company",
                "What methodology was used in previous projects, explain?", "Tell me about your typical working day",
                "How did you calculate time needed for your work",
                "What happened if you were not meeting your deadline?",
                "What obstacles did you face while working on your project? ",
                " How do you know you have enough requirements?",
                "How do you know you have enough test coverage?",
                " What are the typical problems of software requirements?",
                "What is your ideal working environment?",
                " Tell us about the sprint cycle in your company",
                "What methodology was used in previous projects, explain?",
                "What is bug triage?",
                " What types of testing did you perform on your project?",
                "How do you report bugs in your project?",
                " Explain bug cycle.",
                "What are the main components of a bug report?",
                "What is functional testing? How do you perform it?",
                " If you don’t have requirements how will you test?",
                " If a bug is found by a customer, what will you do?",
                "What would you do when you have 100 open tickets? What are your actions?",
                "If you reported a bug and the developer rejects it (saying it’s not important), what would you do?",
                "If you reported a bug and a developer can’t reproduce it, what should you do?",
                " How are you going to test if there are no requirements?",
                "When do you start testing?",
                "When do you stop testing?",
                "How do you communicate with developers?",
                " Is there a bug you still remember?",
                "How to create a Test Plan? Explain your approach.",
                "How do you determine what needs testing?",
                "How do you prioritize testing if you’re short on time?",
                "Have you used Use cases? How were they used? Describe in detail",
                " Did you do regression testing after every Sprint? How was it done?",
                "What is the risk of releasing an application with possible regression issues?",
                "What was the most critical bug you have ever found?",
                "Give me common problems when working in Agile Software Development?",
                "What problems did you face in your previous company? How did you resolve them?",
                " Have you uncovered Test Documentation problems as a result of testing?",
                "How did you work in Jira, tell in details?",
                "How did you use SQL in your project?",
                "Tell me about yourself?",
                " Tell about your project? What does your workspace look like?",
                "Why did you choose QA carrier?",
                "Why do you want to move from your current company?",
                "Why do you want to work in our company?",
                "What are your skills or what value can you bring to the company?",
                " What is your biggest accomplishment in this company?",
                " Do you have any questions for us?",
                " How do you consider yourself in 5 years?",
                " Why should we hire you?",
                "What is you Strengths/Weaknesses?",
                "What is BDD?"};
        String queshold = "Question";
        WebElement toaddQuestion = getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]"));

        for (int i = 1; i <= num; i++) {
            toaddQuestion.click();
            Thread.sleep(1000);
            String selectType = "//*[contains(text(),'" + question + i + "')]/../../..//*[contains(text(),'Textual')]";
            getDriver().findElement(By.xpath(selectType)).click();
            String xpath = "//*[contains(text(),'" + question + i + "')]/../../..//*[@placeholder='" + queshold + " *']";
            getDriver().findElement(By.xpath(xpath)).sendKeys(quetiontext[i]);
        }
    }

    @Then("I should see my quiz {string} in the page")
    public void iShouldSeeMyQuizInThePage(String quizname) {
        List<WebElement> quiztotal = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'" + quizname + "')]"));

        for (WebElement element : quiztotal) {
            if (element.getText().contains(quizname)) {
                element.isDisplayed();
            }
        }
    }


    @Then("I will click on quiz name")
    public void iWillClickOnQuizName() {
        String quizname = "Total  Number of questions";
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizname + "')]")).click();


    }


    @Then("I confirm the deletion")
    public void iConfirmTheDeletion() {
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();


    }

    @Then("I should see the snak-bar")
    public void iShouldSeeTheSnakBar() {
        String snakbartext = "Quiz is not completed.";
        String snakbar = getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Quiz is not completed.')]")).getText();
        String quizzes = getDriver().findElement(By.xpath("//*[text()='" + snakbartext + "']")).getText();
        assertThat(snakbar.contains(snakbartext)).isTrue();

    }
}