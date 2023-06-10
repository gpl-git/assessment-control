package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyStepdefs {
    @Given("I open up this page")
    public void iOpenUpThisPage() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        driver.quit();
    }


}
