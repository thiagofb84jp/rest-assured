package br.pb.thiagofb84jp.test;

import br.pb.thiagofb84jp.core.APILinks;
import br.pb.thiagofb84jp.core.BaseTest;
import br.pb.thiagofb84jp.dto.UsuarioDTO;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
           .body("token", is(notNullValue()))
           .body("refreshToken", is(notNullValue()))
           .body("id", is(1))
           .body("username", is(usuario.getUsername()))
        ;
    }

    @Test
    public void buscarUsuarios() {
        given()
        .when()
             .get(APILinks.USUARIOS)
        .then()
             .statusCode(200)
        .and()
             .body("users[0].id", is(1))
             .body("users[0].firstName", is("Emily"))
             .body("users[0].lastName", is("Johnson"))
             .body("users[0].email", is("emily.johnson@x.dummyjson.com"))
             .body("users[0].username", is("emilys"))
             .body("users[0].password", is("emilyspass"))
             .body("users[0].image", is("https://dummyjson.com/icon/emilys/128"))
             .body("users[0].role", is("admin"))
        ;
    }

    @Test
    public void buscarUsuarioPorId() {
        int USER_ID = 2;

        given()
             .pathParam("id", USER_ID)
        .when()
             .get(APILinks.USUARIOS + "{id}")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(2))
             .body("firstName", is("Michael"))
             .body("lastName", is("Williams"))
             .body("email", is("michael.williams@x.dummyjson.com"))
             .body("username", is("michaelw"))
             .body("password", is("michaelwpass"))
             .body("image", is("https://dummyjson.com/icon/michaelw/128"))
             .body("role", is("admin"))
        ;
    }

    @Test
    public void buscarUsuarioInexistente() {
        int USER_ID = 999;

        given()
             .pathParam("id", USER_ID)
        .when()
             .get(APILinks.USUARIOS + "{id}")
        .then()
             .statusCode(404)
        .and()
             .body("message", is("User with id '"+ USER_ID +"' not found"))
        ;
    }

    @Test
    public void autenticarUsuarioComCredenciaisInvalidas() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsername("jonathan.smith");
        usuario.setPassword("11223344");

        given()
             .body(usuario)
        .when()
             .post(APILinks.CRIAR_TOKEN_AUTENTICACAO)
        .then()
             .statusCode(400)
        .and()
             .body("message", is("Invalid credentials"))
        ;
    }

    @Test
    public void autenticarSemUsuario() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setPassword("password");

        given()
             .body(usuario)
        .when()
             .post(APILinks.CRIAR_TOKEN_AUTENTICACAO)
        .then()
             .statusCode(400)
        .and()
             .body("message", is("Username and password required"))
        ;
    }

    @Test
    public void autenticarUsuarioSemSenha() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsername("emilys");

        given()
             .body(usuario)
        .when()
             .post(APILinks.CRIAR_TOKEN_AUTENTICACAO)
        .then()
             .statusCode(400)
        .and()
             .body("message", is("Username and password required"))
        ;
    }

    @Test
    public void autenticarSemUsuarioESenha() {
        given()
             .body("{}")
        .when()
             .post(APILinks.CRIAR_TOKEN_AUTENTICACAO)
        .then()
             .statusCode(400)
        .and()
             .body("message", is("Username and password required"))
        ;
    }

    private UsuarioDTO getUsuarioValido() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsername("emilys");
        usuario.setPassword("emilyspass");

        return usuario;
    }

    public String getToken() {
        UsuarioDTO usuario = getUsuarioValido();

        String token = given()
                            .body(usuario)
                       .when()
                            .post(APILinks.CRIAR_TOKEN_AUTENTICACAO)
                       .then()
                            .statusCode(200)
                            .extract().path("token")
                       ;

        return token;
    }
}