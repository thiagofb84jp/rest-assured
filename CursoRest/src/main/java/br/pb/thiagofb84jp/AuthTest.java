package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import javax.swing.text.AbstractDocument;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

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
              .body("name", is("Luke Skywalker"))
        ;
    }

    @Test
    public void deveObterClima() {
        given()
             .log().all()
             .queryParam("q", "Paraiba")
             .queryParam("appid", "a941198d66f571ea632bc4d876fe97ea")
             .queryParam("units", "metric")
        .when()
             .get("https://api.openweathermap.org/data/2.5/weather")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("name", is("Paraíba"))
             .body("coord.lon", is(-36.5F))
             .body("main.temp", greaterThan(25F))
        ;
    }

    @Test
    public void naoDeveAcessarSemSenha() {
        given()
             .log().all()
        .when()
             .get("https://restapi.wcaquino.me/basicauth")
        .then()
             .log().all()
             .statusCode(401)
        ;
    }

    @Test
    public void deveFazerAutenticacaoBasica1() {
        given()
             .log().all()
        .when()
             .get("https://admin:senha@restapi.wcaquino.me/basicauth")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("status", is("logado"))
        ;
    }

    @Test
    public void deveFazerAutenticacaoBasica2() {
        given()
             .log().all()
             .auth().basic("admin", "senha")
        .when()
             .get("https://restapi.wcaquino.me/basicauth")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("status", is("logado"))
        ;
    }

   @Test
   public void deveFazerAutenticacaoBasica3() {
        given()
             .log().all()
             .auth().preemptive().basic("admin", "senha")
        .when()
             .get("https://restapi.wcaquino.me/basicauth2")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("status", is("logado"))
        ;
   }

   @Test
   public void deveFazerAutenticacaoComTokenJWT() {
       Map<String, String> login = new HashMap<String, String>();
       login.put("email", "yokifa3390@ipniel.com");
       login.put("senha", "abcd_123");

       // Login na API
       // Recebimento do Token
        String token = given()
                            .log().all()
                            .body(login)
                            .contentType(ContentType.JSON)
                       .when()
                            .post("http://barrigarest.wcaquino.me/signin")
                       .then()
                            .log().all()
                            .statusCode(200)
                            .extract().path("token")
        ;

       // Obter as contas
       given()
            .log().all()
            .header("Authorization", "JWT " + token)
       .when()
            .get("http://barrigarest.wcaquino.me/contas")
       .then()
            .log().all()
            .statusCode(200)
            .body("nome", hasItem("Conta 1020"))
       ;
   }
}