package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Carts {
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public RequestSpecification httpRequest;

    @Given("I hit the url of get carts api endpoint")
    public void i_hit_the_url_of_get_carts_api_endpoint() {
        baseURI = "https://fakestoreapi.com";
    }
    @When("I pass the url of carts in the request")
    public void i_pass_the_url_of_carts_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("/carts");
    }

    @Then("I receive the response code for carts api as {int}")
    public void i_receive_the_response_code_for_carts_api_as(int responseCode) {
        ResponseCode = response.getStatusCode();
        assertEquals(200, ResponseCode);
    }
}