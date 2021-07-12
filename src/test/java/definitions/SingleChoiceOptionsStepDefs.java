package definitions;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class SingleChoiceOptionsStepDefs {

    @And("I add {int} Options in {string}")
    public void iAddOptionsIn(int optionNum, String questionNum) {
        if (optionNum>=1){
        for (int i=2; i < optionNum; ++i) {

            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='Option " + i + "*']")).sendKeys("Option " + i + "*");
            getDriver().findElement(By.xpath("//*[@class='mat-raised-button mat-accent']/span[contains(text(),'Add Option')]")).click();
        }

            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='Option " + optionNum + "*']")).sendKeys("Option " + optionNum + "*");
            getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        }


    }



    }




