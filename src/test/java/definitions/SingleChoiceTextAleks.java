package definitions;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class SingleChoiceTextAleks {
    @And("I click on {string} radiobutton for correct answer")
    public void iClickOnRadiobutton(String opt1RadioBttn) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Option 1')]/..//..//..//..//..//..//div[@class='mat-radio-container']")).click();
    }

    @And("I type {string} into {string} text field")
    public void iTypeIntoTextField(String txt, String txtField) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+txtField+"*']")).sendKeys(txt);

    }
}
