package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import io.restassured.path.xml.element.Node;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserXMLTest {

    @Test
    public void devoTrabalharComXML01() {
        given()
        .when()
             .get("https://restapi.wcaquino.me/usersXML/3")
        .then()
             .statusCode(200)
             .rootPath("user")
        .and()
             .body("name", is("Ana Julia"))
             .body("@id", is("3"))
             .body("filhos.name.size()", is(2))
             .body("filhos.name[0]", is("Zezinho"))
             .body("filhos.name[1]", is("Luizinho"))
             .body("filhos.name", hasItem("Luizinho"))
             .body("filhos.name", hasItems("Luizinho", "Zezinho"))
        ;
    }

    @Test
    public void devoTrabalharComXML02() {
        given()
        .when()
             .get("https://restapi.wcaquino.me/usersXML/3")
        .then()
             .statusCode(200)
             .rootPath("user")
        .and()
             .body("name", is("Ana Julia"))
             .body("@id", is("3"))
        .and()
             .rootPath("user.filhos")
             .body("name.size()", is(2))
             .body("name[0]", is("Zezinho"))
             .body("name[1]", is("Luizinho"))
             .body("name", hasItem("Luizinho"))
             .body("name", hasItems("Luizinho", "Zezinho"))
        ;
    }

    @Test
    public void devoTrabalharComXML03() {
        given()
        .when()
             .get("https://restapi.wcaquino.me/usersXML/3")
        .then()
             .statusCode(200)
        .and()
             .rootPath("user")
             .body("name", is("Ana Julia"))
             .body("@id", is("3"))
        .and()
             .rootPath("user.filhos")
             .body("name.size()", is(2))
        .and()
             .detachRootPath("filhos")
             .body(".filhos.name[0]", is("Zezinho"))
             .body("filhos.name[1]", is("Luizinho"))
        .and()
             .appendRootPath("filhos")
             .body("name", hasItem("Luizinho"))
             .body("name", hasItems("Luizinho", "Zezinho"))
        ;
    }

    @Test
    public void devoFazerPesquisasAvancadasComXML() {
        given()
        .when()
             .get("https://restapi.wcaquino.me/usersXML/")
        .then()
             .statusCode(200)
        .and()
             .body("users.user.size()", is(3))
             .body("users.user.findAll{it.age.toInteger() <= 25}.size()", is(2))
             .body("users.user.@id", hasItems("1", "2", "3"))
             .body("users.user.find{it.age == 25}.name", is("Maria Joaquina"))
             .body("users.user.findAll{it.name.toString().contains('n')}.name", hasItems("Maria Joaquina", "Ana Julia"))
             .body("users.user.salary.find{it != null}", is("1234.5678"))
             .body("users.user.salary.find{it != null}.toDouble()", is(1234.5678D))
             .body("users.user.age.collect{it.toInteger() * 2}", hasItems(40, 50, 60))
             .body("users.user.name.findAll{it.toString().startsWith('Maria')}.collect{it.toString().toUpperCase()}", is("MARIA JOAQUINA"))
        ;
    }

    @Test
    public void deveFazerPesquisasAvancadasComXMLEJava() {
        ArrayList<Node> nomes = given()
                                  .when()
                                       .get("https://restapi.wcaquino.me/usersXML/")
                                  .then()
                                       .statusCode(200)
                                  .and()
                                       .extract().path("users.user.name.findAll{it.toString().contains('n')}")
        ;
        System.out.println(nomes);
        Assert.assertEquals(2, nomes.size());
        Assert.assertEquals("Maria Joaquina".toUpperCase(), nomes.get(0).toString().toUpperCase());
        Assert.assertTrue("ANA JULIA".equalsIgnoreCase(nomes.get(1).toString()));
    }
}