package com.danila.applications.posttest;

import com.danila.applications.data.InputData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;


public class PostTestAssured {

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        config = config().objectMapperConfig(
                new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        new Jackson2ObjectMapperFactory() {
                            @Override
                            public ObjectMapper create(Type type, String s) {
                                return new ObjectMapper();
                            }
                        }
                )
        );

    }

    @Test
    void postTest() throws JsonProcessingException {
        given()
                .contentType("application/json")
                .body(InputData.createLoanApplication())
                .when()
                .post("/create")
                .then()
                .statusCode(200);
    }
}
