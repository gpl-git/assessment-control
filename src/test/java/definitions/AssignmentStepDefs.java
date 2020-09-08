package definitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class AssignmentStepDefs {
    @And("I click {string} button for new assignment")
    public void iClickButtonForNewAssignment(String newAssign) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).click();
    }

    @And("I select {string} from Group Filter menu")
    public void iSelectFromGroupFilterMenu(String groupFilter) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='groupFilter']")).sendKeys(groupFilter);
    }

    @And("I select {string} from Quiz to assign menu")
    public void iSelectAsQuizToAssign(String nameOfQuiz) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='quizId']")).sendKeys(nameOfQuiz);
    }


}
