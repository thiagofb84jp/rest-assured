package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class AuthTest {

    @Test
    public void deveAcessarSWAPI() {
        given()
             .log().all()
        .when()
              .get("https://swapi.dev/api/people/1")
        .then()
              .log().all()
              .statusCode(200)
              .body("name", Matchers.is("Luke Skywalker"))
        ;
//        My Key: a941198d66f571ea632bc4d876fe97ea
//        URL API: https://api.openweathermap.org/data/2.5/weather?q=Paraiba,BR&appid=a941198d66f571ea632bc4d876fe97ea
    }
}