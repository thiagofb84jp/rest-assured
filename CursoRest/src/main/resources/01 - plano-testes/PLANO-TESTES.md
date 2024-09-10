# Plano de Testes da API - Gerenciamento de Produtos Eletrônicos
## Objetivo

O objetivo deste plano de testes é validar o funcionamento das operações da API para gerenciamento de produtos 
eletrônicos, incluindo autenticação, criação, recuperação e listagem de produtos.

## URLs e Operações
### 1. Buscar Usuários para Autenticação
- **URL:** `{BASE_PATH}/users`
- **Método:** GET
- **Descrição:** Recupera a lista de usuários disponíveis para autenticação.

### 2. Criação de Token para Autenticação
- **URL:** `{BASE_PATH}/auth/login`
- **Método:** POST
- **Cabeçalhos:**
    - `Content-Type: application/json`
- **Dados:**
  ```json
  {
    "username": "emilys",
    "password": "emilyspass"
  }

- Descrição: Gera um token de autenticação para permitir o acesso às operações protegidas.

### 3. Buscar Produtos com Autenticação
- URL: `{BASE_PATH}/auth/products`
- Método: GET
- Cabeçalhos:
  - Content-Type: application/json
  - Authorization: Bearer /* YOUR_TOKEN_HERE */
  - Descrição: Recupera a lista de produtos disponíveis com autenticação.

### 4. Criação de Produtos
- URL: `{BASE_PATH}/products/add`
- Método: POST
- Cabeçalhos:
   `Content-Type: application/json`
- **Dados**:
```json
  {
  "title": "Perfume Oil",
  "description": "Mega Discount, Impression of A...",
  "price": 13,
  "discountPercentage": 8.4,
  "rating": 4.26,
  "stock": 65,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
  }
```
- **Descrição**: Adiciona um novo produto à lista de produtos.

### 5. Buscar Todos os Produtos
- URL: `{BASE_PATH}/products`
- Método: GET
- Descrição: Recupera a lista completa de produtos disponíveis.

### 6. Buscar Produto por ID
- URL: `{BASE_PATH}/products/{id}`
- Método: GET
- Descrição: Recupera os detalhes de um produto específico pelo ID.

## Cenários de Teste
**PRODUTOS**:

**POST**:
- Verificar a criação de um produto com dados válidos.
- Verificar a criação de um produto com valor inválido para o campo "rating".
- Verificar a criação de um produto com campo "price" vazio.
- Verificar a criação de um produto com valor negativo para "stock".
- Verificar a criação de um produto com URL de imagem inválida para o campo "thumbnail".
- Verificar a criação de um produto com valor zero para o campo "price".
- Verificar a criação de um produto sem informar nenhum valor no corpo do JSON.

**GET**:
- Verificar retorno com uma lista de produtos com dados corretos.
- Verificar a estrutura da lista de produtos.
- Verificar produtos específicos consultando pelo ID.
- Verificar o retorno informando um ID inexistente.
- Verificar o retorno informando um token inválido.

**USUÁRIOS**:

**POST**:
- Verificar a geração de token com credenciais válidas.
- Verificar geração de token com credenciais inválidas.
- Verificar a geração do token sem o envio do campo "password".
- Verificar a expiração do token após certo tempo de configuração.
- Verificar se o sistema permite gerar o token com usuário inexistente.
- Verificar se o "refreshToken" permite gerar um novo token.

**GET**:
- Verificar o status code da API de usuários.
- Verificar a Estrutura do Response
- Verificar o Conteúdo do Response.
- Verificar a Presença de Campos Obrigatórios.
- Verificar o Tipo de Dados dos Campos
- Verificar a Resposta para Requisições Inválidas.

## Critérios de Sucesso
- Todas as requisições devem retornar códigos de status apropriados (200, 201, etc.).
- As respostas devem conter os dados esperados conforme descrito nos cenários de teste.
- O comportamento da API deve ser consistente e conforme a especificação.

## Considerações Finais
- Todos os testes devem ser realizados em ambiente de teste para garantir que não afetem os dados de produção.
- O token de autenticação deve ser protegido e não deve ser exposto em logs ou relatórios.

--- 

**Data**: 09/09/2024

**Responsável**: Thiago Ferreira Barbosa.
