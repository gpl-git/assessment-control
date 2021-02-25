package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class SingleChoiceTextAleks {
    @And("I click {string} radiobutton")
    public void iClickRadiobutton(String radioBttn) {
        getDriver().findElement(By.xpath("//label[@for='mat-radio-18-input']//div[@class='mat-radio-inner-circle']")).click();

    }
}
