package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HTML {

    @Test
    public void deveFazerBuscasComHTML() {
        given()
             .log().all()
        .when()
             .get("https://restapi.wcaquino.me/v2/users")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .contentType(ContentType.HTML)
             .body("html.body.div.table.tbody.tr.size()", is(3))
             .body("html.body.div.table.tbody.tr[1].td[2]", is("25"))
        .and()
             .appendRootPath("html.body.div.table.tbody")
             .body("tr.find{it.toString().startsWith('2')}.td[1]", is("Maria Joaquina"))
        ;
    }

    @Test
    public void deveFazerBuscasComXpathEmHTML() {
        // No link, observar que existem casos em que a tag <link> não vai estar bem formatada
        // Com isso, não esquecer de colocar, ao final, o 'format=clean'
        given()
             .log().all()
        .when()
             .get("https://restapi.wcaquino.me/v2/users?format=clean")
        .then()
             .log().all()
             .statusCode(200)
        .and()
             .contentType(ContentType.HTML)
             .body(hasXPath("count(//table/tr)", is("4")))
             .body(hasXPath("//td[text() = '2']/../td[2]", is("4")))
        ;
    }
}