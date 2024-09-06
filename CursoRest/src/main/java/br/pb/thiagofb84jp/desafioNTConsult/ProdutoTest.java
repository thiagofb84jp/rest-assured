package br.pb.thiagofb84jp.desafioNTConsult;

import br.pb.thiagofb84jp.core.APILinks;
import br.pb.thiagofb84jp.core.BaseTest;
import br.pb.thiagofb84jp.dto.ProdutoDTO;
import com.github.javafaker.Faker;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ProdutoTest extends BaseTest {

    @Test
    public void criarProduto() {
        ProdutoDTO produto = getProdutoValido();

        given()
             .body(produto)
        .when()
             .post(APILinks.CADASTRAR_PRODUTO)
        .then()
             .statusCode(201)
        // TODO colocar a validação do corpo do JSON
        ;
    }

    @Test
    public void buscarProdutos() {
        given()
        .when()
             .get(APILinks.CONSULTAR_PRODUTO)
        .then()
             .statusCode(200)
        // TODO colocar a validação do corpo do JSON
        ;
    }

    @Test
    public void buscarProdutoPorID() {
        given()
             .pathParam("id", 1)
        .when()
             .get(APILinks.CONSULTAR_PRODUTO + "{id}")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("title", is("Essence Mascara Lash Princess"))
        // TODO colocar a validação do corpo do JSON
        ;
    }

    @Test
    public void buscarProdutoInexistente() {
        int PRODUCT_ID = 199;

        given()
             .pathParam("id", PRODUCT_ID)
        .when()
             .get(APILinks.CONSULTAR_PRODUTO + "{id}")
        .then()
             .statusCode(404)
        .and()
             .body("message", is("Product with id '"+ PRODUCT_ID +"' not found"))
        // TODO colocar a validação do corpo do JSON
        ;
    }

    @Test
    @Ignore
    public void buscarProdutosComAutenticacao() {

    }

    private ProdutoDTO getProdutoValido() {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setTitle("Perfume 212 VIP Carolina Herrera");
        produto.setDescription("Mega discount of perfume 212 VIP Carolina Herrera fará com que você entre nas festas sem pedir.");
        produto.setPrice(13);
        produto.setDiscountPercentage(8.4F);
        produto.setRating(6.33F);
        produto.setStock(65);
        produto.setBrand("212 VIP CH");
        produto.setCategory("Perfumes Importados");
        produto.setThumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg");

        return produto;
    }
}
