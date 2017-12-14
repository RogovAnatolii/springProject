package ru.rogov.rest;


import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import ru.rogov.utils.GenerateURI;

import static io.restassured.RestAssured.given;

@Component
public class RestRequest {

    private static final Logger log = LoggerFactory.getLogger(RestRequest.class);

    @Autowired
    private GenerateURI util = new GenerateURI();

    public RestRequest() {
        RestAssured.filters(new AllureRestAssured());
    }

    @Step("GET Request")
    public Response getRequest(String path) {
        Response response = given().contentType("*/*").get(util.generateURI(path));
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Request to: " + util.generateURI(path).toString());
        log.info("Response: " + response.asString());
        return response;
    }


}
