package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Products {
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public RequestSpecification httpRequest;
    public JSONObject requestParams;


    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        baseURI = "https://fakestoreapi.com";
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("/products");
    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(int responseCode) {
        ResponseCode = response.getStatusCode();

        assertEquals(200, ResponseCode);
    }

    /*@Then("I verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is(String args) {
        body = response.getBody();

        //Convert response body to string
        String responseBody = body.asString();

        //JSON Representation from Response body
        JsonPath jsonPath = response.jsonPath();

        String s = jsonPath.getJsonObject("rating[0].rate").toString();

    }*/

    @Then("I verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is(String rate) {

        body = response.getBody();

        //Convert response body to string
        String responseBody = body.asString();

        //JSON Representation from Response body
        JsonPath jsonPath = response.jsonPath();

        String s = jsonPath.getJsonObject("rating[0].rate").toString();

        assertEquals(rate, s);
    }

    @Given("I hit the url of post products api endpoint")
    public void iHitTheUrlOfPostProductsApiEndpoint()
    {
        baseURI = "https://fakestoreapi.com";
        httpRequest = given();
        requestParams = new JSONObject();

    }

    @And("I pass the request body of product title {}")
    public void iPassTheRequestBodyOfProductTitle(String title)
    {
        requestParams.put("title", title);
        requestParams.put("price", 0.19);
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("category", "electronic");
        requestParams.put("image", "http://i.pravatar.cc");
        //requestParams.put("", "");

        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("/products");
        body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @Then("I receive the response body with id as {}")
    public void iReceiveTheResponseBodyWithIdAsId(String id)
    {
        JsonPath jsonPath = response.jsonPath();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
        String s = jsonPath.getJsonObject("id").toString();
        assertEquals(s, id);
    }

    @Given("I hit the url of put products api endpoint")
    public void iHitTheUrlOfPutProductsApiEndpoint() {

        baseURI = "https://fakestoreapi.com";
    }

    @When("I pass the url of products in the request with {}")
    public void iPassTheUrlOfProductsInTheRequestWith(String productNumber) {

        httpRequest = given();
        requestParams = new JSONObject();

        requestParams.put("title", "test product");
        requestParams.put("price", 0.19);
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("category", "electronic");
        requestParams.put("image", "http://i.pravatar.cc");

        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("/products/" + productNumber);
        body = response.getBody();
        JsonPath jsonPath = response.jsonPath();
        String s = jsonPath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @Given("I hit the url of delete products api endpoint")
    public void iHitTheUrlOfDeleteProductsApiEndpoint() {

        baseURI = "https://fakestoreapi.com";

        httpRequest = given();
        requestParams = new JSONObject();
    }

    @When("I pass the url of delete products in the request with {}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWith(String productNumber) {

        response = httpRequest.put("/products/" + productNumber);

    }
}