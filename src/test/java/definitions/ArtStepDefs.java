package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ArtStepDefs {
    @Then("{string} error message should be displayed AK")
    public void stringErrorMessageShouldBeDisplayedAK(String error_message) {
        Boolean displayed = getDriver().findElement(By.xpath("//*[contains(text(),'" + error_message + "')]")).isDisplayed();
        assertThat(displayed).isTrue();
    }


    @And("I add {string} of {string} questions with {string} text AK")
    public void iAddOfQuestionsWith(String str_number_of_questions, String type_of_question, String question_text) throws InterruptedException {
        int number_of_questions = Integer.parseInt(str_number_of_questions);
        if (type_of_question.equals("Textual")) {
            for(int q = 1; q <= number_of_questions; q++) {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
                Thread.sleep(150);
                getDriver().findElement(By.xpath("(//*[contains(text(), '" + type_of_question + "')])[" + q + "]")).click();
                Thread.sleep(100);
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question_text);
                Thread.sleep(300);
            }
            }
        else if (type_of_question.equals("Single-Choice")){
            for(int q = 1; q <= number_of_questions; q++) {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
                Thread.sleep(150);
                getDriver().findElement(By.xpath("(//*[contains(text(), '" + type_of_question + "')])[" + q + "]")).click();
                Thread.sleep(100);
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question_text);
                Thread.sleep(100);
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys("test_answer1");
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys("test_answer2");
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 1*']/../../../../../mat-radio-button")).click();
                Thread.sleep(300);
            }

        }

        else if (type_of_question.equals("Multiple-Choice")){
            for(int q = 1; q <= number_of_questions; q++) {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
                Thread.sleep(150);
                // select question type
                getDriver().findElement(By.xpath("(//*[contains(text(), '" + type_of_question + "')])[" + q + "]")).click();
                Thread.sleep(100);
                // input question text
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question_text);
                Thread.sleep(100);
                // adding 3d question
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//span[contains(text(), 'Option')]")).click();
                // adding answers
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys("test_answer1");
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys("test_answer2");
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 3*']")).sendKeys("test_answer3");
                // selecting correct answer
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
                Thread.sleep(300);
            }

        }

        else if (type_of_question.equals("MultiType")){
            // adding text question
            getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
            Thread.sleep(150);
            getDriver().findElement(By.xpath("(//*[contains(text(), 'Textual')])[1]")).click();
            Thread.sleep(100);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question_text);
            Thread.sleep(300);

            // adding single choice question
            getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
            Thread.sleep(150);

            getDriver().findElement(By.xpath("(//*[contains(text(), 'Single-Choice')])[2]")).click();
            Thread.sleep(100);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question_text);
            Thread.sleep(100);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys("test_answer1");
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys("test_answer2");
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 1*']/../../../../../mat-radio-button")).click();
            Thread.sleep(300);

            for(int q = 3; q <= number_of_questions; q++) {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
                Thread.sleep(150);
                // select question type
                getDriver().findElement(By.xpath("(//*[contains(text(), 'Multiple-Choice')])[" + q + "]")).click();
                Thread.sleep(100);
                // input question text
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question_text);
                Thread.sleep(100);
                // adding 3d question
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//span[contains(text(), 'Option')]")).click();
                // adding answers
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys("test_answer1");
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys("test_answer2");
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 3*']")).sendKeys("test_answer3");
                // selecting correct answer
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + q + "')]/../../..//textarea[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
                Thread.sleep(300);
            }

        }



        }

    }