# Casos de Testes - API de Produtos - Método GET

---
### Caso de Teste 1: Consulta de Produtos - Verificação Geral

**Objetivo:** Verificar se o método GET /products/ retorna uma lista de produtos com os dados corretos.

**Requisição:** `GET /products/`.

**Requisitos:**
 - O método deve retornar um status code 200 (OK).
 - A resposta deve conter uma lista de produtos.
 - Cada produto deve ter os campos esperados com os tipos corretos.

**Dados Esperados:**
- Status code: 200
- Lista de produtos contendo:
    - **Produto 1**
        - `id`: 1
        - `title`: "Essence Mascara Lash Princess"
        - `description`: "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula."
        - `category`: "beauty"
        - `price`: 9.99
        - `discountPercentage`: 7.17
        - `rating`: 4.94
        - `stock`: 5
        - `tags`: ["beauty", "mascara"]
        - `brand`: "Essence"
        - `sku`: "RCH45Q1A"
        - `weight`: 2
        - `dimensions`:
            - `width`: 23.17
            - `height`: 14.43
            - `depth`: 28.01
        - `warrantyInformation`: "1 month warranty"
        - `shippingInformation`: "Ships in 1 month"
        - `availabilityStatus`: "Low Stock"
        - `reviews`:
            - Rating 2, Comment: "Very unhappy with my purchase!"
            - Rating 2, Comment: "Not as described!"
            - Rating 5, Comment: "Very satisfied!"
        - `returnPolicy`: "30 days return policy"
        - `minimumOrderQuantity`: 24
        - `meta`:
            - `createdAt`: "2024-05-23T08:56:21.618Z"
            - `updatedAt`: "2024-05-23T08:56:21.618Z"
            - `barcode`: "9164035109868"
            - `qrCode`: "https://assets.dummyjson.com/public/qr-code.png"
        - `images`:
            - "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/1.png"
        - `thumbnail`: "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png"
    - **Produto 2**
        - `id`: 2
        - `title`: "Eyeshadow Palette with Mirror"
        - `description`: "The Eyeshadow Palette with Mirror offers a versatile range of eyeshadow shades for creating stunning eye looks. With a built-in mirror, it's convenient for on-the-go makeup application."
        - `category`: "beauty"
        - `price`: 19.99
        - `discountPercentage`: 5.5
        - `rating`: 3.28
        - `stock`: 44
        - `tags`: ["beauty", "eyeshadow"]
        - `brand`: "Glamour Beauty"
        - `sku`: "MVCFH27F"
        - `weight`: 3
        - `dimensions`:
            - `width`: 12.42
            - `height`: 8.63
            - `depth`: 29.13
        - `warrantyInformation`: "1 year warranty"
        - `shippingInformation`: "Ships in 2 weeks"
        - `availabilityStatus`: "In Stock"
        - `reviews`:
            - Rating 4, Comment: "Very satisfied!"
            - Rating 1, Comment: "Very disappointed!"
            - Rating 5, Comment: "Highly impressed!"
        - `returnPolicy`: "30 days return policy"
        - `minimumOrderQuantity`: 32
        - `meta`:
            - `createdAt`: "2024-05-23T08:56:21.618Z"
            - `updatedAt`: "2024-05-23T08:56:21.618Z"
            - `barcode`: "2817839095220"
            - `qrCode`: "https://assets.dummyjson.com/public/qr-code.png"
        - `images`:
            - "https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/1.png"
        - `thumbnail`: "https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/thumbnail.png"

**Resultado Esperado:**
- Status code deve ser 200.
- A resposta deve conter todos os produtos com os detalhes correspondentes aos dados fornecidos.

---
## Cenário 2: Consulta de Produtos - Verificação de Estrutura dos Produtos
**Objetivo:** Verificar se cada produto na resposta possui todos os campos obrigatórios com os tipos corretos.

**Requisitos:**
- Cada produto deve conter os campos: `id`, `title`, `description`, `category`, `price`, `discountPercentage`, `rating`, `stock`, `tags`, `brand`, `sku`, `weight`, `dimensions`, `warrantyInformation`, `shippingInformation`, `availabilityStatus`, `reviews`, `returnPolicy`, `minimumOrderQuantity`, `meta`, `images`, `thumbnail`.

**Dados Esperados:**
- Status code: 200
- Cada produto deve conter:
    - `id`: Inteiro
    - `title`: String
    - `description`: String
    - `category`: String
    - `price`: Número (float)
    - `discountPercentage`: Número (float)
    - `rating`: Número (float)
    - `stock`: Inteiro
    - `tags`: Array de Strings
    - `brand`: String
    - `sku`: String
    - `weight`: Número (float)
    - `dimensions`: Objeto com:
        - `width`: Número (float)
        - `height`: Número (float)
        - `depth`: Número (float)
    - `warrantyInformation`: String
    - `shippingInformation`: String
    - `availabilityStatus`: String
    - `reviews`: Array de objetos com:
        - `rating`: Número (inteiro)
        - `comment`: String
        - `date`: Data (ISO 8601)
        - `reviewerName`: String
        - `reviewerEmail`: String
    - `returnPolicy`: String
    - `minimumOrderQuantity`: Inteiro
    - `meta`: Objeto com:
        - `createdAt`: Data (ISO 8601)
        - `updatedAt`: Data (ISO 8601)
        - `barcode`: String
        - `qrCode`: URL
    - `images`: Array de URLs
    - `thumbnail`: URL

---
## Cenário 3: Consulta de Produtos - Verificação de Dados de Produtos Específicos

**Objetivo:** Verificar se os dados de produtos específicos correspondem às informações fornecidas.

**Requisitos:**
- O método deve retornar produtos com os dados corretos para IDs específicos.

**Dados Esperados:**
- Status code: 200
- Para o produto com `id` 1:
    - `title`: "Essence Mascara Lash Princess"
    - `description`: "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula."
    - `category`: "beauty"
    - `price`: 9.99
    - `discountPercentage`: 7.17
    - `rating`: 4.94
    - `stock`: 5
    - `tags`: ["beauty", "mascara"]
    - `brand`: "Essence"
    - `sku`: "RCH45Q1A"
    - `weight`: 2
    - `dimensions`:
        - `width`: 23.17
        - `height`: 14.43
        - `depth`: 28.01
    - `warrantyInformation`: "1 month warranty"
    - `shippingInformation`: "Ships in 1 month"
    - `availabilityStatus`: "Low Stock"
    - `reviews`:
        - Rating 2, Comment: "Very unhappy with my purchase!"
        - Rating 2, Comment: "Not as described!"
        - Rating 5, Comment: "Very satisfied!"
    - `returnPolicy`: "30 days return policy"
    - `minimumOrderQuantity`: 24
    - `meta`:
        - `createdAt`: "2024-05-23T08:56:21.618Z"
        - `updatedAt`: "2024-05-23T08:56:21.618Z"
        - `barcode`: "9164035109868"
        - `qrCode`: "https://assets.dummyjson.com/public/qr-code.png"
    - `images`:
        - "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/1.png"
    - `thumbnail`: "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png"

- Para o produto com `id` 2:
    - `title`: "Eyeshadow Palette with Mirror"
    - `description`: "The Eyeshadow Palette with Mirror offers a versatile range of eyeshadow shades for creating stunning eye looks. With a built-in mirror, it's convenient for on-the-go makeup application."
    - `category`: "beauty"
    - `price`: 19.99
    - `discountPercentage`: 5.5
    - `rating`: 3.28
    - `stock`: 44
    - `tags`: ["beauty", "eyeshadow"]
    - `brand`: "Glamour Beauty"
    - `sku`: "MVCFH27F"
    - `weight`: 3
    - `dimensions`:
        - `width`: 12.42
        - `height`: 8.63
        - `depth`: 29.13
    - `warrantyInformation`: "1 year warranty"
    - `shippingInformation`: "Ships in 2 weeks"
    - `availabilityStatus`: "In Stock"
    - `reviews`:
        - Rating 4, Comment: "Very satisfied!"
        - Rating 1, Comment: "Very disappointed!"
        - Rating 5, Comment: "Highly impressed!"
    - `returnPolicy`: "30 days return policy"
    - `minimumOrderQuantity`: 32
    - `meta`:
        - `createdAt`: "2024-05-23T08:56:21.618Z"
        - `updatedAt`: "2024-05-23T08:56:21.618Z"
        - `barcode`: "2817839095220"
        - `qrCode`: "https://assets.dummyjson.com/public/qr-code.png"
    - `images`:
        - "https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/1.png"
    - `thumbnail`: "https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/thumbnail.png"

---
## Cenário 4: Consulta de Produtos - Verificação de Produtos em Estoque

**Objetivo:** Verificar se apenas produtos com status "In Stock" são retornados como disponíveis.

**Requisitos:**
- Produtos com o status `availabilityStatus` como "In Stock" devem estar disponíveis.

**Dados Esperados:**
- Status code: 200
- Produtos retornados devem incluir apenas aqueles com `availabilityStatus` como "In Stock".

**Produto Esperado com Status "In Stock":**
- **Produto 2**
    - `availabilityStatus`: "In Stock"

---
## Cenário 5: Consulta de Produtos - Verificação de Produtos com Avaliação Alta

**Objetivo:** Verificar se produtos com uma `rating` maior que 4.5 são retornados na resposta.

**Requisitos:**
- Produtos com `rating` maior que 4.5 devem estar presentes na resposta.

**Dados Esperados:**
- Status code: 200
- Produtos com `rating` maior que 4.5:
    - **Produto 1**
        - `rating`: 4.94

---
## Cenário 6: Consulta de Produtos - Verificação de Ordenação dos Produtos

**Objetivo:** Verificar se os produtos são retornados na ordem esperada (por exemplo, por `price`).

**Requisitos:**
- A resposta deve retornar produtos ordenados por `price` em ordem crescente.

**Dados Esperados:**
- Status code: 200
- Produtos ordenados por `price` em ordem crescente:
    - **Produto 1** (Preço: 9.99)
    - **Produto 2** (Preço: 19.99)