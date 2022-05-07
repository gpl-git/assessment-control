package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
//    //mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='Option 3*']/../../../../..//*[@class='mat-icon material-icons']

//   //mat-panel-title[contains(text(),'Q2')]/../../..//*[@class='mat-checkbox-inner-container']
public class dmytro_SingleChoiceQuestionStepdefs {
    @Then("I mark {string} as a show-stopper")
    public void iMarkAsAShowStopper(String questionNum) {
        var show_stopper = getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@class='mat-checkbox-inner-container'])[2]"));
        show_stopper.click();
    }

    @When("I select single question type on {string}")
    public void iSelectSingleQuestionTypeOn(String questionNumber) {
        //  (//mat-panel-title[contains(text(),'Q1')]/../../..//*[@class='mat-radio-container'])[2]
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[@class='mat-radio-container'])[2]")).click();
    }

    @Then("I mark {string} as a other_text")
    public void iMarkAsAOther_text(String questionNum) {
        var other_text = getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@class='mat-checkbox-inner-container'])[1]"));
        other_text.click();
    }

    @And("I add a new option for {string}")
    public void iAddANewOptionFor(String questionNumber) {
        //      //mat-panel-title[contains(text(),'Q2')]/../../..//*[contains(text(), 'Add Option')]/..
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[contains(text(), 'Add Option')]/..")).click();
    }


    @And("I delete the option {string} on question {string}")
    public void iDeleteTheOptionOnQuestion(String optionNum, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../..//*[@class='mat-icon material-icons']")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'Delete Option')]/..")).click();
    }

    @And("I verify {string} has {int} choices")
    public void iVerifyHasChoices(String title, int num) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/..")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Dmytro Single')]/../../..//*[contains(text(),'Preview')]/..")).click();
//        System.out.println(getDriver().findElements(By.xpath("//*[@class='mat-radio-container']")).size());
        assertThat(getDriver().findElements(By.xpath("//*[@class='mat-radio-container']")).size()==num).isTrue();
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]/..")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/..")).click();

//        assertThat(getDriver().findElement(By.xpath("//*[@class='mat-radio-container']")))
    }

    @And("I create {int} options with input {string} in {string}")
    public void iCreateOptionsWithInputIn(int numOptions, String text, String questionNum) {
        for(int i=0;i<numOptions;i++) {
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[contains(text(), 'Add Option')]/..")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Option "+(i+3)+"*']")).sendKeys(text);
//            System.out.println(i);

        }
    }

    @And("I verify that I can't delete option {string} in {string}")
    public void iVerifyThatICanTDeleteOptionIn(String optionNum, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../..//*[@class='mat-icon material-icons']")).click();
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'Delete Option')]/..")).isEnabled()).isFalse();
    }
}
