package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LarisaHomeStepDefs {

    @Then("I go to the page {string}")
    public void iGoToThePage(String page) {
        getDriver().findElement(By.xpath("// h5[contains(text(),'"+page+"')]")).click();
    }

    @Then("I go to the page {string} and validate page details")
    public void iGoToThePageAndValidatePageDetails(String page) {
        getDriver().findElement(By.xpath("// h5[contains(text(),'"+page+"')]")).click();
        String curUrl = getDriver().getCurrentUrl();
        assertThat(curUrl.contains(page.toLowerCase())).isTrue();

    }
}
