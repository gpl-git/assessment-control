package definitions;

import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import support.TestContext;

import javax.xml.xpath.XPathExpression;

import static org.hamcrest.MatcherAssert.assertThat;
import static support.TestContext.getDriver;

public class RadhikaStepdefs {
    private Object getDriver;

    @Then("{string} confirmation message should be displayed RA")
    public void confirmationMessageShouldBeDisplayedRA(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//body")).getText();
        System.out.println(getDriver().getCurrentUrl());
        Assertions.assertThat(actualMessage.equals(expectedMessage)).isTrue();




    }
}