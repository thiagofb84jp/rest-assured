package br.pb.thiagofb84jp.test;

import br.pb.thiagofb84jp.core.APILinks;
import br.pb.thiagofb84jp.core.BaseTest;
import br.pb.thiagofb84jp.dto.ProdutoDTO;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

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
        .and()
             .body("id", is(notNullValue()))
             .body("title", is(produto.getTitle()))
             .body("price", is(produto.getPrice()))
             .body("discountPercentage", is(produto.getDiscountPercentage()))
             .body("stock", is(produto.getStock()))
             .body("rating", is(produto.getRating()))
             .body("thumbnail", is(produto.getThumbnail()))
             .body("description", is(produto.getDescription()))
             .body("brand", is(produto.getBrand()))
             .body("category", is(produto.getCategory()))
        ;
    }

    @Test
    public void buscarProdutos() {
        given()
        .when()
             .get(APILinks.CONSULTAR_PRODUTO)
        .then()
             .statusCode(200)
        .and()
             .body("products[0].id", is(notNullValue()))
        ;
    }

    @Test
    public void buscarProdutoPorID() {
        int PRODUCT_ID = 1;

        given()
             .pathParam("id", PRODUCT_ID)
        .when()
             .get(APILinks.CONSULTAR_PRODUTO + "{id}")
        .then()
             .statusCode(200)
        .and()
             .body("id", is(1))
             .body("title", is("Essence Mascara Lash Princess"))
             .body("description", is("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula."))
             .body("category", is("beauty"))
             .body("price", is(9.99F))
             .body("discountPercentage", is(7.17F))
             .body("rating", is(4.94F))
             .body("stock", is(5))
        ;
    }

    @Test
    public void buscarProdutoInexistente() {
        int PRODUCT_ID = 999;

        given()
             .pathParam("id", PRODUCT_ID)
        .when()
             .get(APILinks.CONSULTAR_PRODUTO + "{id}")
        .then()
             .statusCode(404)
        .and()
             .body("message", is("Product with id '"+ PRODUCT_ID +"' not found"))
        ;
    }

    @Test
    public void buscarProdutosComAutenticacao() {
        UsuarioTest usuario = new UsuarioTest();

        given()
             .header("Authorization", "Bearer " + usuario.getToken())
        .when()
             .get(APILinks.CONSULTAR_PRODUTO_AUTH)
        .then()
             .statusCode(200)
        .and()
             .body("products[0].id", is(1))
             .body("products[0].title", is("Essence Mascara Lash Princess"))
             .body("products[0].description", is("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula."))
             .body("products[0].category", is("beauty"))
             .body("products[0].price", is(9.99F))
             .body("products[0].discountPercentage", is(7.17F))
             .body("products[0].rating", is(4.94F))
             .body("products[0].stock", is(5))
        ;
    }

    @Test
    public void buscarProdutosSemInformarOToken() {
        given()
             .header("Authorization", "Bearer ")
        .when()
             .get(APILinks.CONSULTAR_PRODUTO_AUTH)
        .then()
             .statusCode(401)
        .and()
             .body("name", is("JsonWebTokenError"))
             .body("message", is("Invalid/Expired Token!"))
        ;
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
