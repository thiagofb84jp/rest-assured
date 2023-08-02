package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserJsonTest {

    @Test
    public void deveVerificarPrimeiroNivel() {
        given()
        .when()
             .get("http://restapi.wcaquino.me/users/1")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("name", containsString("Silva"))
             .body("age", greaterThan(18))
        ;
    }

    @Test
    public void deveVerificarPrimeiroNivelOutrasFormas() {
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/users/1");

        //Path
        System.out.println(Optional.ofNullable(response.path("id")));
        Assert.assertEquals(new Integer(1), response.path("id"));
        Assert.assertEquals(new Integer(1), response.path("%s", "id"));

        //JsonPath
        JsonPath jsonPath = new JsonPath(response.asString());
        Assert.assertEquals(1, jsonPath.getInt("id"));

        //From
        int id = JsonPath.from(response.asString()).getInt("id");
        Assert.assertEquals(1, "id");
    }

    @Test
    public void deveVerificarSegundoNivel() {
        given()
        .when()
             .get("http://restapi.wcaquino.me/users/2")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(2))
             .body("name", containsString("Joaquina"))
             .body("endereco.rua", is("Rua dos bobos"))
        ;
    }

    @Test
    public void deveVerificarLista() {
        given()
        .when()
             .get("http://restapi.wcaquino.me/users/3")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(3))
             .body("name", containsString("Ana"))
             .body("filhos", hasSize(2))
             .body("filhos[0].name", is("Zezinho"))
             .body("filhos[1].name", is("Luizinho"))
             .body("filhos.name", hasItem("Zezinho"))
             .body("filhos.name", hasItems("Zezinho", "Luizinho"))
        ;
    }

    @Test
    public void deveRetornarErroUsuarioInexistente() {
        given()
        .when()
             .get("http://restapi.wcaquino.me/users/4")
        .then()
             .statusCode(404)
        .and()
             .body("error", is("Usuário inexistente"))
        ;
    }
}