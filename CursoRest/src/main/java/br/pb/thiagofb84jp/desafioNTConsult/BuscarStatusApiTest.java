package br.pb.thiagofb84jp.desafioNTConsult;

import br.pb.thiagofb84jp.core.APILinks;
import br.pb.thiagofb84jp.core.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BuscarStatusApiTest extends BaseTest {
    @Test
    public void verificarStatusApi() {
        given()
        .when()
             .get(APILinks.STATUS_API)
        .then()
             .statusCode(200)
        .and()
             .body("status", is("ok"))
             .body("method", containsString("GET"))
        ;
    }
}
