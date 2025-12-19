package com.vimarsh.integration_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class authIntegrationTesting {

    private static final Logger log = LoggerFactory.getLogger(authIntegrationTesting.class);

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4005" ;
    }

    @Test
    public void ShouldReturnOkWithValidToken(){
        String requestPayload = """
                {
                    "userEmail": "jane.doe@company.com",
                      "password": "SecurePassword123!",
                      "role": "ADMIN"
                }
                """;
        Response response= given()
                .contentType("application/json")
                .body(requestPayload)
                .when()
                .get("/api/auth")
                .then()
                .statusCode(200)
                .body("loginToken", notNullValue())
                .extract()
                .response();

        log.info("Extracted token-> "+ response.jsonPath().getString("loginToken")) ;
    }
}
