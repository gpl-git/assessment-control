package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;
import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.Thread.sleep;
import static support.TestContext.getDriver;

public class QuizTotalQuestionsStepDefs {

    private String quizTitle;
    long startTime;
    long totalTime;

    @Given("I set title for quiz as {string}")
    public void iSetTitleForQuizAs(String qTitle) {
        this.quizTitle = qTitle;
    }

    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        switch (url) {
            case "login":
                getDriver().get("http://ask-qa.portnov.com/#/" + url);
                break;
//            case "":
//                getDriver().get("http://ask-qa.portnov.com/#/"+url);
            default:
                System.out.println("Unknown URL: " + url);
        }
    }

    @When("I type {string} into Email field and {string} into Password field")
    public void iTypeIntoEmailFieldAndIntoPasswordField(String email, String pass) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pass);

    }

    @And("I click on {string} button")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//button/*[contains(text(),'" + button + "')]")).click();
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @Then("menu with the item {string} should be appear")
    public void menuWithTheItemShouldBeAppear(String menuItem) {
        assertThat(getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).isDisplayed()).isTrue();
    }

    @When("I sure that I logged as a {string}")
    public void iSureThatILoggedAsA(String role) {
        assertThat(getDriver().findElement(By.xpath("//header/*/*[contains(text(),'" + role + "')]")).isDisplayed()).isTrue();
    }

    @When("I click on menu item {string}")
    public void iClickOnMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @And("I type {string} into field Title Of The Quiz")
    public void iTypeIntoFieldTitleOfTheQuiz(String qTitle) {
        if (qTitle.equals("titleGiven")) {
            qTitle = quizTitle;
        }
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(qTitle);
    }

    @And("I add new question")
    public void iAddNewQuestion() {
        getDriver().findElement(By.xpath("//button/*/*[text()='add_circle']")).click();
    }

    @And("I type {string} into question # {string}")
    public void iTypeIntoQuestionFieldFor(String text, String qNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + qNumber + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(text);
    }

    @And("I type {string} into field {string} in question # {string}")
    public void iTypeIntoFieldInQuestion(String text, String oPlaceHolder, String qNumber) {
        ////mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='Option 1*']
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + qNumber + "')]/../../..//textarea[@placeholder='" + oPlaceHolder + "']")).sendKeys(text);
    }

    @And("I select {string} as correct option in question # {string}")
    public void iSelectAsCorrectOptionInQuestion(String oPlaceHolder, String qNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + qNumber + "')]/../../..//textarea[@placeholder='" + oPlaceHolder + "']/../../../../..//mat-radio-button")).click();
    }

// This version of the function doesn't work for the 2nd and further questions
//    @When("I select radio button {string} question type")
//    public void iSelectRadioButtonQuestionType(String qType) {
//        getDriver().findElement(By.xpath("//mat-radio-button/*/*[contains(text(),'" + qType + "')]")).click();
//    }

    @And("I select radio button {string} question type in question # {string}")
    public void iSelectRadioButtonQuestionTypeInQuestion(String qType, String qNumber) {
        ////mat-panel-title[contains(text(),'Q2')]/../../..//*/*/*/*/*/*/*/mat-radio-button/*/*[contains(text(),'Singl')]
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q"+qNumber+"')]/../../..//*/*/*/*/*/*/*/mat-radio-button/*/*[contains(text(),'"+qType+"')]")).click();;
    }

    @And("I create {int} {string} questions with two options")
    public void iCreateQuestionsWithTwoOptions(int qCount, String qType) throws InterruptedException {
        String qNumber="";
        for(int i=0;i<qCount;i++){
            qNumber=valueOf(i+1);
            iAddNewQuestion();
            sleep(500);
            iSelectRadioButtonQuestionTypeInQuestion(qType, qNumber);
            sleep(250);
            iTypeIntoQuestionFieldFor("This is question # "+qNumber, qNumber);
            iTypeIntoFieldInQuestion("Option 1", "Option 1*", qNumber);
            iTypeIntoFieldInQuestion("Option 2", "Option 2*", qNumber);
            iSelectAsCorrectOptionInQuestion("Option 1*", qNumber);
            sleep(250);
        }
    }

    @And("I stop here to analyse")
    public void iStopHereToAnalyse() {
        System.out.println("Just set here breakpoint and get time to analyse");
    }

    @Given("I start measuring the execution time")
    public void iStartMeasuringTheExecutionTime() {
        this.startTime = System.currentTimeMillis();;
    }

    @Then("I get total execution time")
    public void iGetTotalExecutionTime() {
        this.totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total execution time " + valueOf(totalTime/1000) + " seconds");
    }

    @Then("List of Quizzes should not be appear")
    public void listOfQuizzesShouldNotBeAppear() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'List of Quizzes')]")).isDisplayed()).isFalse();
    }

    @Then("List of Quizzes should be appear")
    public void listOfQuizzesShouldBeAppear() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'List of Quizzes')]")).isDisplayed()).isTrue();
    }

    @And("quiz {string} should be in the list")
    public void quizShouldBeInTheList(String qTitle) {
        if (qTitle.equals("titleGiven")) {
            qTitle = quizTitle;
        }
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I expand row clicking by {string}")
    public void iExpandRowClickingBy(String qTitle) {
        if (qTitle.equals("titleGiven")) {
            qTitle = quizTitle;
        }
//        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).isDisplayed()).isTrue();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).click();
    }

    @Then("number of question in row is equal number in the expanded area for {string}")
    public void numberOfQuestionInRowIsEqualNumberInTheExpandedAreaFor(String qTitle) {
        if (qTitle.equals("titleGiven")) {
            qTitle = quizTitle;
        }
        String qNumberInRow = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]/..//mat-panel-description")).getText();
        String qNumberInExpanded = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]/../../..//div/*/*/*/*/*/td[2]")).getText();
        assertThat(qNumberInRow.contains(qNumberInExpanded)).isTrue();
    }

    @And("I click on {string} button for {string}")
    public void iClickOnButtonFor(String button, String qTitle) {
        if (qTitle.equals("titleGiven")) {
            qTitle = quizTitle;
        }
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]/../../../*/*/*/*/*/*[contains(text(),'"+button+"')]")).click();
    }

    @And("I click on {string} button in the confirmation pop-up window")
    public void iClickOnButtonInTheConfirmationPopUpWindowFor(String button) {
        getDriver().findElement(By.xpath("//p[contains(text(),'DELETE whole quiz')]/../../*/*/*[contains(text(),'"+button+"')]")).click();
    }

    @When("I delete all instances of {string}")
    public void iDeleteAllInstancesOf(String qTitle) throws InterruptedException {
        if (qTitle.equals("titleGiven")) {
            qTitle = quizTitle;
        }
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        sleep(1000);
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'List of Quizzes')]")).isDisplayed()).isTrue();
        sleep(1000);
        int qCount = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).size();
        for(int i=0; i<qCount; i++){
            sleep(1000);
            assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).isDisplayed()).isTrue();
            sleep(1000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qTitle+"')]/../../../*/*/*/*/*/*[contains(text(),'Delete')]")).click();
            getDriver().findElement(By.xpath("//p[contains(text(),'DELETE whole quiz')]/../../*/*/*[contains(text(),'Delete')]")).click();
        }
    }
}
