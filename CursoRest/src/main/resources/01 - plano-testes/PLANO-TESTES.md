# Plano de Testes da API - Gerenciamento de Produtos Eletrônicos

## Objetivo

O objetivo deste plano de testes é validar o funcionamento das operações da API para gerenciamento de produtos eletrônicos, incluindo autenticação, criação, recuperação e listagem de produtos.

## URLs e Operações

### 1. Buscar Usuários para Autenticação

- **URL:** `https://dummyjson.com/users`
- **Método:** GET
- **Descrição:** Recupera a lista de usuários disponíveis para autenticação.

### 2. Criação de Token para Autenticação

- **URL:** `https://dummyjson.com/auth/login`
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
- URL: https://dummyjson.com/auth/products
- Método: GET
- Cabeçalhos:
  - Content-Type: application/json
  - Authorization: Bearer /* YOUR_TOKEN_HERE */
  - Descrição: Recupera a lista de produtos disponíveis com autenticação.

### 4. Criação de Produtos
- URL: https://dummyjson.com/products/add
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
- URL: https://dummyjson.com/products
- Método: GET
- Descrição: Recupera a lista completa de produtos disponíveis.

### 6. Buscar Produto por ID
- URL: https://dummyjson.com/products/1
- Método: GET
- Descrição: Recupera os detalhes de um produto específico pelo ID.

## Cenários de Teste
1. Teste de Autenticação
   - Verificar se é possível gerar um token com credenciais válidas.
   - Verificar se a resposta contém um token de autenticação.
2. Teste de Recuperação de Produtos com Autenticação
   - Verificar se a lista de produtos pode ser recuperada com um token válido.
   - Verificar se o código de resposta é 200 e se a lista de produtos está correta.
3. Teste de Criação de Produtos
   - Verificar se um novo produto pode ser criado com dados válidos.
   - Verificar se o código de resposta é 201 e se os dados do produto estão corretos.
4. Teste de Recuperação de Todos os Produtos
   - Verificar se a lista completa de produtos pode ser recuperada sem autenticação.
   - Verificar se o código de resposta é 200 e se a lista de produtos está correta.
5. Teste de Recuperação de Produto por ID
   - Verificar se um produto específico pode ser recuperado por ID.
   - Verificar se o código de resposta é 200 e se os dados do produto estão corretos.

## Critérios de Sucesso
- Todas as requisições devem retornar códigos de status apropriados (200, 201, etc.).
- As respostas devem conter os dados esperados conforme descrito nos cenários de teste.
- O comportamento da API deve ser consistente e conforme a especificação.

## Considerações Finais
- Todos os testes devem ser realizados em ambiente de teste para garantir que não afetem os dados de produção.
- O token de autenticação deve ser protegido e não deve ser exposto em logs ou relatórios.

--- 

Data: 09/09/2024

Responsável: Thiago Ferreira Barbosa
