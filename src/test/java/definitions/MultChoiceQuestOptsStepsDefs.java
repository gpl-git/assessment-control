package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultChoiceQuestOptsStepsDefs {
    @When("I checked {string}")
    public void iCheckAnd(String option) {
        getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + option + "')]/../../../../../mat-checkbox")).click();
    }

    @And("Input test-data {int} chars into field {string}")
    public void inputTestDataIntoField(int stringLength, String optionField) {

        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        String testString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        getDriver().findElement(By.xpath("//textarea[contains(@placeholder, '" + optionField + "')]")).sendKeys(testString);
    }

    @When("I push button {string}")
    public void iPushButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }
}
