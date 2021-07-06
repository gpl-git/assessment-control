import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestStepDefs {
    @Given("I learn git")
    public void iLearnGit() {
        System.out.println("Good Job");
        System.out.println();
    }

    @Then("Message")
    public void message() {
        System.out.println("good for you");
    }
}
