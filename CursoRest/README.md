# Projeto de Testes Automatizados com REST-Assured
## Desafio técnico de QE para o Sicredi

Este projeto implementa testes automatizados para APIs RESTful utilizando a biblioteca **REST-Assured**. A estrutura do projeto foi desenvolvida em **Java 17** e utiliza **JUnit 4.12** como framework de testes. Além disso, são usadas as bibliotecas **GSON** para manipulação de JSON e **JSON Schema Validator** para validação de esquemas JSON.

<hr>

## Requisitos

Certifique-se de que seu ambiente de desenvolvimento atende aos seguintes requisitos:

- **Java 17** (ou superior)
- **IntelliJ IDEA 2023.2.2 (Community Edition)** (ou outra IDE de sua preferência)
- **Maven** (ou Gradle, dependendo do seu gerenciador de dependências)
- **Git** (opcional, para controle de versão)

<hr>

## Dependências Utilizadas

As principais dependências do projeto são:

- **REST-Assured 5.3.0**: Para realizar testes em APIs REST.
- **JUnit 4.12**: Framework para estruturação e execução dos testes.
- **Google Code GSON 2.10**: Para serialização e desserialização de objetos JSON.
- **JSON Schema Validator 5.1.1**: Para validação de respostas JSON utilizando schemas.

### Gerenciador de Dependências (Maven)

No arquivo `pom.xml`, as dependências podem ser adicionadas como:

```xml 
<dependencies>
    <!-- REST-Assured -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
        <scope>test</scope>
    </dependency>

    <!-- JUnit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>

    <!-- GSON -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10</version>
    </dependency>
    
    <!-- JAXB API -->
    <dependency>
        <groupId>org.glassfish.jaxb</groupId>
        <artifactId>jaxb-runtime</artifactId>
        <version>2.3.1</version>
        <scope>runtime</scope>
    </dependency>

    <!-- JAXB API -->
    <dependencies>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.1</version>
        </dependency>
    
    <!-- JSON Schema Validator -->
    <dependency>
        <groupId>com.github.java-json-tools</groupId>
        <artifactId>json-schema-validator</artifactId>
        <version>5.1.1</version>
    </dependency>
</dependencies>
```
<hr>

## Estrutura do Projeto
A estrutura do projeto segue o padrão Maven, com os diretórios separados para código fonte e testes:

```
/CursoRest/
|-- src/
|   |-- main/
|   |   |-- java/
|           |-- br
                |-- pb 
                    |-- thiagofb84jp
                        |-- core
                        |-- dto
                        |-- suite
                        |-- test
        |-- resources
            |-- plano-testes
            |-- caso-testes                   
|-- pom.xml
|-- README.md
```
<hr>

## Como executar os testes
1. Clone este repositório na sua máquina local:
``` bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```
2. Importe o projeto na sua IDE (exemplo: IntelliJ IDEA).
3. Compile e execute os testes utilizando o Maven:
``` bash
mvn clean test
```
4. Os resultados dos testes serão exibidos no console da IDE ou no terminal.

<hr>

## Exemplos de Testes
Aqui está um exemplo simples de teste de API utilizando REST-Assured e JUnit:

``` java
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void validarStatusCode() {
        RestAssured.baseURI = "https://api.exemplo.com";
        
        given().
        when().
            get("/endpoint").
        then().
            assertThat().
            statusCode(200);
    }
}
```
<hr>

## Planos e Casos de Testes
Este projeto possui:
- Plano de Teste;
- Casos de Testes:
  - Usuários;
  - Produtos.

Para maiores informações, verificar os arquivos contidos dentro da pasta \resources. 

<hr>

## Licença
Este projeto é licenciado sob a MIT License - consulte o arquivo LICENSE para mais detalhes.


### O que está incluído:
- **Introdução** sobre o propósito do projeto.
- **Requisitos** para preparar o ambiente de desenvolvimento.
- **Dependências utilizadas**, com exemplos de como incluí-las em um projeto Maven.
- **Estrutura do projeto**, ilustrando onde o código e testes ficam organizados.
- **Instruções de execução** para rodar os testes.
- **Exemplo de teste** usando REST-Assured com JUnit.
- **Licença** (opcional).