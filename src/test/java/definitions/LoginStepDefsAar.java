package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDefsAar {
    @Then("I should see password is masked AaR")
    public void iShouldSeePasswordIsMaskedAaR( ) {
        WebElement password = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
        String typeofPasswordfield = password.getAttribute("type");
        System.out.println("Password field is of type : " + typeofPasswordfield);
        assertThat(typeofPasswordfield.equals("password")).isTrue();
    }



    @And("I type {string} into password field for case-sensitive check")
    public void iTypeIntoPasswordFieldForCaseSensitiveCheck(String passwd) {
        String changeCasePassword=passwd.toUpperCase();
        System.out.println("changed case password is :" + changeCasePassword);
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(changeCasePassword);

    }


    @Then("{string} should be displayed AaR")
    public void messageShouldBeDisplayedAaR(String message) {
        if (message.equals("Authentication failed.")) {
            WebElement element = getDriver().findElement(By.xpath("//simple-snack-bar[contains(@class, 'mat-simple-snackbar')]"));
            String actualText = element.getText();
            System.out.println("The actualText is " + actualText);
            assertThat(actualText.contains(message)).isTrue();
        } else {
            String actualtext = getDriver().findElement(By.xpath("//*[contains(text(),'" + message + "')]/../..")).getText();
            assertThat(actualtext.equals(message)).isTrue();
            System.out.println(actualtext);
        }

    }




    @Then("I should be on home page AaR")
    public void iShouldBeOnHomePageAaR() {
        WebElement onHomePage= getDriver().findElement(By.xpath("//h5[contains(text(),'Home')]/.."));
        String home = onHomePage.getText();
        System.out.println("Onto page: "+ home);
        int acceptedRoles=0;
        /*if (role.equalsIgnoreCase("student")||(role.equalsIgnoreCase("teacher"))){
            acceptedRoles=1;
        }
        System.out.println("role is "+ role + " and acceptedRoles = " + acceptedRoles);
       // assertThat(role.equalsIgnoreCase("student")).isTrue() */
    }
}


