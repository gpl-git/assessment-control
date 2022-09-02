package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class loginStepdefs {
    @Then("I verify that homepage is opened")
    public void iVerifyThatHomepageIsOpened() {
        WebElement Page=getDriver().findElement(By.xpath("//body"));
        assertThat(Page.isDisplayed()).isTrue();
    }
}

