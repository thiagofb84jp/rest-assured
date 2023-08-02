package br.pb.thiagofb84jp;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class OlaMundoTest {
    @Test
    public void testOlaMundo() {
        Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertTrue(response.statusCode() == 200);
        Assert.assertTrue("O status code deveria ser 200", response.statusCode() == 200);

        Assert.assertEquals(200, response.statusCode());

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

    @Test
    public void devoConhecerOutrasFormasRestAssured() {
        Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

        given() // Pré-Condições
        .when() // Ação de fato na qual vai ser testada
             .get("http://restapi.wcaquino.me/ola")
        .then() // Assertivas
             .statusCode(200)
        ;
    }

    @Test
    public void devoConhecerMatchersHamcrest() {
        Assert.assertThat("Maria", Matchers.is("Maria"));
        Assert.assertThat(128, Matchers.is(128));
    }
}
