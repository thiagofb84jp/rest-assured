# Casos de Testes - API de Produtos - Método GET

---
### Cenário 1: Verificar retorno com uma lista de produtos com dados corretos.

**Objetivo:** Verificar se a requisição GET /products/ retorna uma lista de produtos com os dados corretos.

**Requisição:** `GET /products/`.

**Dados Esperados:**
- Status code: 200
- Lista de produtos contendo:
    - **Produto 1**
        - `id`: 1
        - `title`: "Essence Mascara Lash Princess"
        - `description`: "The Essence Mascara Lash Princess is a popular mascara known for its volumizing..."
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


**Resultado esperado:**
- O método deve retornar o status code 200 (OK).
- A resposta deve conter uma lista de produtos.
- Cada produto deve ter os campos esperados com os tipos corretos.
- A resposta deve conter todos os produtos com os detalhes correspondentes aos dados fornecidos.

---
## Cenário 2: Verificar a estrutura da lista de produtos.
**Objetivo:** Verificar se cada produto na resposta possui todos os campos obrigatórios com os tipos corretos.

**Requisição:** `GET /products/`.

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

**Resultado esperado:**
- Cada produto deve ter os campos esperados com os tipos corretos.

---
## Cenário 3: Verificar produtos específicos consultando pelo ID

**Objetivo:** Verificar se os dados de produtos específicos correspondem às informações fornecidas.

**Requisição:** `GET /products/{id}`.

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


**Resultado esperado:**
- O método deve retornar o status code 200 (OK).
- A resposta deve conter apenas a lista com o item informado no ID.
- Cada produto deve ter os campos esperados com os tipos corretos.
- A resposta deve conter todos os produtos com os detalhes correspondentes aos dados fornecidos.

---
## Cenário 4: Verificar o retorno informando um ID inexistente

**Objetivo:** Verificar se ao informar um ID inexistente a API retorna a mensagem de produto com ID não encontrado.

**Requisição:** `GET /products/{id}`.

**Dados Esperados:**
- Status code: 404.
- JSON apresentando o seguinte retorno:
```json
{
"message": "Product with id '{id}' not found"
}
```
**Resultado esperado:**
- O método deve retornar o status code 404 (Not Found).
- A resposta deve conter apenas a mensagem informada (produto com ID não encontrado).

---
## Cenário 5: Verificar o retorno informando um token inválido

**Objetivo:** Verificar se, após a geração de um token, ao alterar o valor do token, a API não permite a busca pelos produtos.

**Requisição:** `GET /products/`.

**Dados Esperados:**
- Status code: 403.
- JSON apresentando o seguinte retorno:
```json
{
  "message": "invalid signature"
}
```
**Resultado esperado:**
- O método deve retornar o status code 403 (Forbidden).
- A resposta deve conter apenas a mensagem informada.
---