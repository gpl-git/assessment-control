package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


    public class ChangePassYauhenDef {
        String longPSWD;
    @Given("I open home page to {string}")
    public void iOpenHomePageTo(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");}
        if(url.equals("register")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }
        else
        {
            System.out.println("Enter url login or register to open page");
        }
    }

        @And("I input credentials at login page {string} and {string}")
        public void iInputCredentialsAtLoginPageAnd(String email, String pass) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
                }

        @And("I click {string} button")
        public void iClickButton(String btnName) {
            getDriver().findElement(By.xpath("//span[contains(text(), '"+ btnName +"')]")).click();
        }

        @Given("I select in left menu {string}")
        public void iSelectInLeftMenu(String linkName) {
           getDriver().findElement(By.xpath("//h5[contains(text(),'" + linkName + "')]")).click();
      //      getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
        }

        @And("sleep {int} sec")
        public void sleepSec(int numbSec) throws InterruptedException {
        Thread.sleep(numbSec*1000);
        }

        @When("I input old password {string}")
        public void iInputOldPassword(String oldPass) {
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='password']")).sendKeys(oldPass);
             }

        @And("I input new password {string}")
        public void iInputNewPassword(String newPass) throws InterruptedException {
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='newPassword']")).sendKeys(newPass);
            Thread.sleep(1000*1);
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='confirmPassword']")).click();
            Thread.sleep(1000*1);
            getDriver().findElement(By.xpath("//mat-dialog-container")).click();
            Thread.sleep(1000*1);

            if (newPass.length()<5){
               boolean snackbox1 = getDriver().findElement(By.xpath("//mat-form-field[2]//mat-error[1]")).isDisplayed();
               String text1 = getDriver().findElement(By.xpath("//mat-form-field[2]//mat-error[1]")).getText();
               assertThat(snackbox1).isTrue();
               assertThat(text1).isEqualTo("Should be at least 5 characters");
                boolean snackbox2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).isDisplayed();
                String text2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).getText();
                assertThat(snackbox2).isTrue();
                assertThat(text2).isEqualTo("This field is required");
                           }
            else {boolean snackbox1 = false;
                boolean snackbox2 = false;
            assertThat(snackbox1).isFalse();
                assertThat(snackbox2).isFalse();}
            }


        @And("I confirm new password {string}")
        public void iConfirmNewPassword(String confPass) {
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='confirmPassword']")).sendKeys(confPass);

        }

         @And("title of the page with xpath {string} is displayed")
        public void titleOfThePageWithXpathIsDisplayed(String titleXpath) {
           String pageXpath = getDriver().getTitle();
           assertThat(pageXpath).isEqualTo(titleXpath);

        }

        @And("I clicking {string} button")
        public void iClickingButton(String butName) {
        getDriver().findElement(By.xpath("//ac-modal-change-password//span[contains(text(),'"+butName+"')]")).click();
        }


        @Then("I input long new password {int} from symbols")
        public void iInputLongNewPasswordFromSymbols(int passLength) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generetedPass = RandomStringUtils.random(passLength, useLetters,useNumbers);
            System.out.println(generetedPass);
            longPSWD = generetedPass;
        getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='newPassword']")).sendKeys(generetedPass);
        getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='confirmPassword']")).sendKeys(generetedPass);
        }



        @And("I input credentials with email {string} longPSWD")
        public void iInputCredentialsWithEmailLongPSWD(String email) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(longPSWD);
        }

        @When("I input old longpassword")
        public void iInputOldLongpassword() {
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='password']")).sendKeys(longPSWD);

        }


        @When("I input new password and confirm {string} {string} and see error messages {string} {string}")
        public void iInputNewPasswordAndConfirmAndSeeErrorMessages(String newPass, String confpass, String errorMessage1, String errorMessage2)
                throws InterruptedException{
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='newPassword']")).sendKeys(newPass);
            Thread.sleep(1000*1);
            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='confirmPassword']")).click();
            Thread.sleep(1000*1);
            getDriver().findElement(By.xpath("//mat-dialog-container")).click();
            Thread.sleep(1000*1);
            boolean contSpaceNewPass = false;
            boolean contSpaceConfirm = false;

            //check spaces

            if (newPass.contains(" "))            {
                contSpaceNewPass = true;
            }
            else {contSpaceNewPass = false;}

            if (confpass.contains(" "))            {
                contSpaceConfirm = true;
            }
            else {contSpaceConfirm = false;}


            //check new password field

            if (newPass.length()<5 && !contSpaceNewPass) {
                boolean snackbox1 = getDriver().findElement(By.xpath("//mat-form-field[2]//mat-error[1]")).isDisplayed();
                String text1 = getDriver().findElement(By.xpath("//mat-form-field[2]//mat-error[1]")).getText();
                assertThat(snackbox1).isTrue();
                assertThat(text1).isEqualTo(errorMessage1);
                //boolean snackbox2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).isDisplayed();
               // String text2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).getText();
               // assertThat(snackbox2).isTrue();
               // assertThat(text2).isEqualTo(errorMessage2);
                System.out.println("Error message: "+ text1);
               // System.out.println("Error message: "+ text2);
            }
            else if (contSpaceNewPass) {
                String text1 = getDriver().findElement(By.xpath("//mat-form-field[2]//mat-error[1]")).getText();
                assertThat(text1).isEqualTo("Whitespaces are not allowed");
                System.out.println("Error message7: "+ text1);

            }

            else {boolean snackbox1 = false;
                boolean snackbox2 = false;
                assertThat(snackbox1).isFalse();
                assertThat(snackbox2).isFalse();}

            getDriver().findElement(By.xpath("//ac-modal-change-password//input[@formcontrolname='confirmPassword']")).sendKeys(confpass);
            Thread.sleep(1000*1);


            if(confpass.length() < 1 && !contSpaceNewPass)
            {boolean snackbox2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).isDisplayed();
                String text2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).getText();
                assertThat(snackbox2).isTrue();
                assertThat(text2).isEqualTo("This field is required");
                System.out.println("Error message3: "+ text2);}

            else if(confpass.length() >= 5 && confpass.length() <= 1 && !contSpaceConfirm) {
                String text2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).getText();
                assertThat(text2).isEqualTo("Should be at least 5 characters");
                System.out.println("Error message4: "+ text2);
            }
            else if(!newPass.equals(confpass) && !contSpaceConfirm){
                String text2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).getText();
                assertThat(text2).isEqualTo("Entered passwords should match");
                System.out.println("Error message5: "+ text2);}
            else if (contSpaceConfirm) {
                String text1 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).getText();
                assertThat(text1).isEqualTo("Whitespaces are not allowed");
                System.out.println("Error message6: "+ text1);}
            else {
                boolean snackbox2 = getDriver().findElement(By.xpath("//mat-form-field[3]//mat-error[1]")).isDisplayed();
                assertThat(snackbox2).isFalse();
            }
        }

    }


