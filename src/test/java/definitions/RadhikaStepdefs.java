package definitions;

import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import support.TestContext;

import javax.xml.xpath.XPathExpression;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RadhikaStepdefs {
    private Object getDriver;

    @Then("{string} confirmation message should be displayed RA")
    public void confirmationMessageShouldBeDisplayedRA(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();




    }
}