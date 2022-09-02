package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class SC_option_SandraStepdefs {
    @And("I add an option")
    public void iAddAnOption() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Add Option')]")).click();
    }

    @And("{string} button is disabled")
    public void buttonIsDisabled(String btnName) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), '"+btnName+"')]")).isEnabled()).isFalse();
    }

    @Then("error message appear")
    public void errorMessageAppear() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), 'Quiz is not completed.')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} from the quiz")
    public void iDeleteOptionFromTheQuiz(String optionNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@placeholder='"+optionNum+"']/following::*[contains(text(), 'settings')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Option')]")).click();
    }


    @And("I check that {string} is present")
    public void iCheckThatIsPresent(String optionNum) {
        getDriver().findElement(By.xpath("//*[@placeholder='"+optionNum+"']")).isDisplayed();
    }
}
