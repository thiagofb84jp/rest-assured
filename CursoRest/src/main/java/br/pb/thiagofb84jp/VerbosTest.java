package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerbosTest {

    @Test
    public void deveSalvarUsuario() {
        given()
             .log().all()
             .contentType(ContentType.JSON)
             .body("{\"name\": \"José\", \"age\": 50}")
        .when()
             .post("http://restapi.wcaquino.me/users")
        .then()
             .log().all()
             .statusCode(201)
        .and()
             .body("id", is(notNullValue()))
             .body("name", is("José"))
             .body("age", is(50))
        ;
    }

    @Test
    public void naoDeveSalvarUsuarioSemNome() {
        given()
             .log().all()
             .contentType(ContentType.JSON)
             .body("{\"age\": 50}")
        .when()
             .post("http://restapi.wcaquino.me/users")
        .then()
             .log().all()
             .statusCode(400)
        .and()
            .body("error", is("Name é um atributo obrigatório"))
        ;
    }

    @Test
    public void deveSalvarUsuarioViaXML() {
        given()
             .log().all()
             .contentType(ContentType.XML)
             .body("<user><name>Jose da Silva</name><age>50</age></user>")
        .when()
             .post("http://restapi.wcaquino.me/usersXML")
        .then()
             .log().all()
             .statusCode(201)
        .and()
             .body("user.@id", is(notNullValue()))
             .body("user.name", is("Jose da Silva"))
             .body("user.age", is("50"))
        ;
    }

    @Test
    public void deveAlterarUsuario() {
        given()
             .log().all()
             .contentType(ContentType.JSON)
             .body("{\"name\": \"Usuário Alterado\", \"age\": 80, \"salary\": 8000.55}")
        .when()
             .put("http://restapi.wcaquino.me/users/1")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("name", is("Usuário Alterado"))
             .body("age", is(80))
             .body("salary", is(8000.55F))
        ;
    }

    @Test
    public void devoCustomizarURLParte1() {
        given()
             .log().all()
             .contentType(ContentType.JSON)
             .body("{\"name\": \"Usuário Alterado\", \"age\": 80, \"salary\": 8000.55}")
        .when()
             .put("http://restapi.wcaquino.me/{entidade}/{userId}", "users", "1")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("name", is("Usuário Alterado"))
             .body("age", is(80))
             .body("salary", is(8000.55F))
        ;
    }

    @Test
    public void devoCustomizarURLParte2() {
        given()
             .log().all()
             .contentType(ContentType.JSON)
             .body("{\"name\": \"Usuário Alterado\", \"age\": 80, \"salary\": 8000.55}")
             .pathParam("entidade", "users")
             .pathParam("userId", "1")
        .when()
             .put("http://restapi.wcaquino.me/{entidade}/{userId}")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("name", is("Usuário Alterado"))
             .body("age", is(80))
             .body("salary", is(8000.55F))
        ;
    }

    @Test
    public void deveRemoverUsuario() {
        given()
             .log().all()
        .when()
             .delete("http://restapi.wcaquino.me/users/1")
        .then()
             .statusCode(204)
        ;
    }

    @Test
    public void naoDeveRemoverUsuarioInexistente() {
        given()
             .log().all()
        .when()
             .delete("http://restapi.wcaquino.me/users/1000")
        .then()
             .log().all()
             .statusCode(400)
        .and()
             .body("error", is("Registro inexistente"))
        ;
    }
}