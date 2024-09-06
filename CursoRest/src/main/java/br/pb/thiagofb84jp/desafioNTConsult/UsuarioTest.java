package br.pb.thiagofb84jp.desafioNTConsult;

import br.pb.thiagofb84jp.core.APILinks;
import br.pb.thiagofb84jp.core.BaseTest;
import br.pb.thiagofb84jp.dto.ProdutoDTO;
import br.pb.thiagofb84jp.dto.UsuarioDTO;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UsuarioTest extends BaseTest {
    @Test
    public void criarTokenAutenticacao() {
        UsuarioDTO usuario = getUsuarioValido();

        given()
             .body(usuario)
        .when()
             .post(APILinks.CRIAR_TOKEN_AUTENTICACAO)
        .then()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("token", is(notNullValue()))
             .body("refreshToken", is(notNullValue()))
        // TODO colocar a validação do corpo do JSON
        // Como pegar o token de forma automatizada: https://github.com/thiagofb84jp/studies-qa/blob/master/udemy-cursos/CursoRest/src/main/java/br/pb/udemycourse/rest/AuthTest.java
        ;
    }

    @Test
    public void buscarUsuarios() {
        given()
        .when()
             .get(APILinks.USUARIOS)
        .then()
             .statusCode(200)
        // TODO colocar a validação do corpo do JSON
        ;
    }

    private UsuarioDTO getUsuarioValido() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsername("emilys");
        usuario.setPassword("emilyspass");

        return usuario;
    }
}
