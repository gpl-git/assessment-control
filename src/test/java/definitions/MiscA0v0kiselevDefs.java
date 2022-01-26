package definitions;

import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public final class MiscA0v0kiselevDefs {
    private static Stream<WebElement> _findAllElements(final WebDriver driver,
                                                       final By by, final Predicate<WebElement> filter) {
        Stream<WebElement> elts = driver.findElements(by).stream();
        if (filter != null)
            elts = elts.filter(filter);
        return elts;
    }

    private static Stream<WebElement> _findAllElements(final By by, final Predicate<WebElement> filter) {
        return _findAllElements(getDriver(), by, filter);
    }

    /**
     * Return the only mathing element.
     *
     * @param by     search criteria
     * @param filter what to return
     * @return an element only when unique
     * @throws NoSuchElementException on no elements
     * @throws AssertionError         on more than one element
     */
    private static WebElement findOneElement(final By by, final Predicate<WebElement> filter) {
        final Iterator<WebElement> it = _findAllElements(by, filter).iterator();
        if (!it.hasNext())
            throw new NoSuchElementException("No elements match");
        final WebElement r = it.next();
        if (it.hasNext())
            throw new AssertionError("More than one element matches");
        return r;
    }

    /**
     * Return all mathing elements.
     *
     * @param by     search criteria
     * @param filter what to return
     * @return an element list
     */
    private static List<WebElement> findAllElements(final By by, final Predicate<WebElement> filter) {
        return _findAllElements(by, filter).collect(Collectors.toUnmodifiableList());
    }

    private static WebElement findOneElement(final By by) {
        return findOneElement(by, null);
    }

    private static WebElement findOneVisibleElement(final By by) {
        return findOneElement(by, WebElement::isDisplayed);
    }

    private static List<WebElement> findAllVisibleElements(final By by) {
        return findAllElements(by, WebElement::isDisplayed);
    }

    private static String unescapeArgument(final String v) {
        return StringEscapeUtils.unescapeJava(v);
    }

    private static String processArgument(final String v) {
        switch (v) {
            case "[:ascii-nc:]":
                return "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
            case "[:Ax1000:]":
                return StringUtils.repeat('A', 1000);
            default:
                return unescapeArgument(v);
        }
    }

    /**
     * Escapes an XPath string.
     *
     * @param v string to escape
     * @return escaped string
     */
    private static String escapeXPathString(final String v) {
        if (v.indexOf('\'') < 0)
            return "'" + v + "'";
        if (v.indexOf('"') < 0)
            return "\"" + v + "\"";
        return "concat('" + v.replace("'", "',\"'\",'") + "')";
    }

    @Then("I wait {long} ms")
    public void iWaitMillis(final long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    @Then("I wait for page update")
    public void iWaitForPageUpdate() throws InterruptedException {
        Thread.sleep(500);
        final WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(driver -> _findAllElements(driver, By.xpath("//ac-spinner"), WebElement::isDisplayed).findAny().isEmpty());
        Thread.sleep(500);
    }

    private String xPathPrefix = "";

    @Then("in dialog")
    public void inDialog() {
        xPathPrefix = "//*[@role='dialog']";
    }

    @Then("in menu")
    public void inMenu() {
        xPathPrefix = "//*[@role='menu']";
    }

    @Then("on page")
    public void onPage() {
        xPathPrefix = "";
    }

    @Then("I click element titled {string}")
    public void iClickElementTitled(final String text) {
        final String _text = escapeXPathString(processArgument(text));
        findOneVisibleElement(By.xpath(xPathPrefix + "//*[(text()[normalize-space(.)=" + _text + "]) or (self::input and (@type='button' or @type='submit') and normalize-space(@value)=" + _text + ")]"))
                .click();
    }

    @Then("I click radio button titled {string}")
    public void iClickMatRadioButtonTitled(final String text) {
        findOneVisibleElement(By.xpath(xPathPrefix + "//mat-radio-button[.//text()[normalize-space(.)=" + escapeXPathString(processArgument(text)) + "]]"))
                .click();
    }

    @Then("one radio button titled {string} is visible")
    public void matRadioButtonTitledIsVisible(final String text) {
        final String _text = processArgument(text);
        findOneElement(By.xpath(xPathPrefix + "//mat-radio-button//div[@class='mat-radio-label-content']"),
                elt -> elt.isDisplayed() && elt.getText().equals(_text));
    }

    @Then("radio button #{int} titled {string} is visible")
    public void matRadioButtonNTitledIsVisible(final int p, final String text) {
        final String _text = processArgument(text);
        findOneElement(By.xpath(xPathPrefix + "//mat-radio-button[" + p + "]//div[@class='mat-radio-label-content']"),
                elt -> elt.isDisplayed() && elt.getText().equals(_text));
    }

    private static final String xpathTextInput = "((self::input and (@type='text' or @type='password')) or self::textarea)";

    @Then("I type {string} into {string} field")
    public void iTypeIntoField(final String v, final String n) {
        findOneVisibleElement(By.xpath(xPathPrefix + "//*[" + xpathTextInput + " and @formcontrolname='" + n + "']"))
                .sendKeys(processArgument(v));
    }

    @Then("I type {string} into #{int} {string} field")
    public void iTypeIntoNField(final String v, final int p, final String n) {
        findOneVisibleElement(By.xpath("(" + xPathPrefix + "//*[" + xpathTextInput + " and @formcontrolname='" + n + "'])[" + p + "]"))
                .sendKeys(processArgument(v));
    }

    @Then("I mark #{int} {string} field")
    public void iMarkNField(final int p, final String n) {
        findOneVisibleElement(By.xpath("(" + xPathPrefix + "//mat-radio-group[.//*[@formcontrolname='" + n + "']]//mat-radio-button)[" + p + "]"))
                .click();
    }

    @Then("I click #{int} {string} field {string} icon")
    public void iClickNFieldIcon(final int p, final String n, final String in) {
        findOneVisibleElement(By.xpath("(" + xPathPrefix + "//mat-radio-group[.//*[@formcontrolname='" + n + "']]//mat-icon[text()='" + in + "'])[" + p + "]"))
                .click();
    }

    @Then("check #{int} {string} field match {string}")
    public void nFieldMatch(final int p, final String n, final String v) {
        assertThat(findOneVisibleElement(By.xpath("(" + xPathPrefix + "//*[" + xpathTextInput + " and @formcontrolname='" + n + "'])[" + p + "]"))
                .getAttribute("value")).isEqualTo(processArgument(v));
    }

    @Then("I remove all quizzes named {string}")
    public void iRemoveAllQuizzesNamed(final String title) throws InterruptedException {
        final String _title = escapeXPathString(processArgument(title));
        final List<WebElement> elts = findAllVisibleElements(By.xpath("//mat-accordion//mat-panel-title[normalize-space(.)=" + _title + "]"));
        for (final WebElement elt : elts) {
            elt.click();
            iClickElementTitled("Delete");
            inDialog();
            iClickElementTitled("Delete");
            onPage();
            iWaitForPageUpdate();
        }
    }
}
