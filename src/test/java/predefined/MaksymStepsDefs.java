package predefined;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MaksymStepsDefs {
  @Given("I navigate to {string} web site")
  public void iNavigateToWebSite(String page) {
    getDriver().navigate().to(page);
  }

  @Then("I type {string} into search field")
  public void iTypeIntoSearchField(String searchInfo) {
    getDriver().findElement(By.name("q")).sendKeys(searchInfo);
  }

  @Then("I click on find button")
  public void iClickOnFindButton() {
    getDriver().findElement(By.id("search_icon")).click();
  }

  @Then("I wait for {int} seconds")
  public void iWaitForSeconds(int seconds) throws InterruptedException {
    Thread.sleep(seconds * 1000L);
  }

  @Then("search result {string} should be present")
  public void searchResultShouldBePresent(String ExpectedSearchRes) {
    String actualSearchRes = getDriver().findElement(By.name("q")).getAttribute("value");
    assertThat(actualSearchRes.equals(ExpectedSearchRes)).isTrue();
  }

  @Then("I navigate to back")
  public void iNavigateToBack() {
    getDriver().navigate().back();
  }

  @Then("I refresh the current page")
  public void iRefreshTheCurrentPage() {
    getDriver().navigate().refresh();
  }

  @Then("I click on Images link")
  public void iClickOnImagesLink() {
    getDriver().findElement(By.id("images")).click();
  }

  @Then("logo should be present")
  public void logoShouldBePresent() {
    assertThat(
            getDriver()
                .findElement(By.xpath("//div[@id='logo']//img[@src='/images/logo.svg']"))
                .isDisplayed())
        .isTrue();
  }

  @Then("I click {string} from ALL CONVERTERS LIST")
  public void iClickFromALLCONVERTERSLIST(String converterType) {
    getDriver().findElement(By.xpath("//a[contains(text(),'" + converterType + "')]")).click();
  }

  @Then("I choose {string} from convertres sub-list")
  public void iChooseFromConvertresSubList(String converterKind) {
    getDriver().findElement(By.xpath("//a[contains(text(),'" + converterKind + "')]")).click();
  }

  @Then("the converter name must match with the header")
  public void theConverterNameMustMatchWithTheHeader() {}

  @Then("the converter header name contains {string}")
  public void theConverterNameMustMatchWithTheHeader(String expConvName) {
    String actualConvName =
        getDriver().findElement(By.xpath("//h1[contains(text(),'Power Converter')]")).getText();
    assertThat(actualConvName.contains(expConvName)).isTrue();
  }

  @Then("I choose {string} from FROM collumn list")
  public void iChooseFromFROMCollumnList(String optionFrom) {
    getDriver()
        .findElement(
            By.xpath("//select[@id='ucfromunit']/option[text()='"+optionFrom+"']"))
        .click();
  }

  @Then("I choose {string} from TO collumn list")
  public void iChooseFromTOCollumnList(String optionTo) {
    getDriver()
        .findElement(
            By.xpath("//select[@id='uctounit']/option[contains(@value,'"+optionTo+"')]"))
        .click();
  }

  @Then("I set {string} to From value")
  public void iSetToFromValue(String setValue) {
    getDriver().findElement(By.name("ucfrom")).sendKeys(setValue);
  }

  @Then("I verify expected calculation result is {string}")
  public void iVerifyExpectedCalculationResultIs(String expectedRes) {
    String actualRes = getDriver().findElement(By.id("ucto")).getAttribute("value");
    assertThat(actualRes.equals(expectedRes)).isTrue();
  }
}
