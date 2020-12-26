package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import utils.ReadProperties;

import static io.restassured.RestAssured.given;


public class getProjectsNFE extends BaseApiStep{
    private String endpoint;

    @Step
    @Given("api is set up")
    public void apiIsSetUp() {
        RestAssured.baseURI = new ReadProperties().getApiURL();
    }

    @Step
    @When("admin sends GET request to {string}")
    public void adminSendsGETRequestTo(String endpoint) {
        this.endpoint = endpoint;
    }

    @Step
    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
        given()
                .when().get(endpoint)
                .then().log().all().statusCode(statusCode);
    }

}
