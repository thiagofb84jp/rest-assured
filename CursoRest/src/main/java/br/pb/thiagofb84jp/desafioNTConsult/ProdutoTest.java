package br.pb.thiagofb84jp.desafioNTConsult;

import br.pb.thiagofb84jp.core.APILinks;
import br.pb.thiagofb84jp.core.BaseTest;
import br.pb.thiagofb84jp.dto.ProdutoDTO;
import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ProdutoTest extends BaseTest {

    @Test
    public void criarProduto() {

    }

    @Test
    public void buscarProdutos() {
        given()
        .when()
             .get(APILinks.PRODUTOS)
        .then()
             .statusCode(200)
        ;
    }

    @Test
    public void buscarProdutoPorID() {
        given()
             .pathParam("id", 1)
        .when()
             .get(APILinks.PRODUTOS + "{id}")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("title", is("Essence Mascara Lash Princess"))
        ;
    }

    @Test
    public void buscarProdutoInexistente() {
        int PRODUCT_ID = 199;

        given()
             .pathParam("id", PRODUCT_ID)
        .when()
             .get(APILinks.PRODUTOS + "{id}")
        .then()
             .statusCode(400)
        .and()
             .body("message", is("Product with id '"+ PRODUCT_ID +"' not found"))
        ;
    }

    private ProdutoDTO getProdutoValido() {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setTitle("Perfume 212 VIP Carolina Herrera");
        produto.setDescription("Perfume 212 VIP Carolina Herrera fará com que você entre nas festas sem pedir.");

        return produto;
    }
}
