# Casos de Testes - API de Produtos - Método POST

---
### Cenário 1: Criar um produto com dados válidos
- **Objetivo:** Enviar uma requisição POST com todos os dados obrigatórios corretos.
- **Pré-condição:** Todos os campos devem ser válidos.
- **Requisição:** `POST /products/add`.
- **Entrada:**
```json
{
  "title": "Perfume 212 VIP Femme Fatalle",
  "obsolete": "Gio",
  "description": "Mega Discount, Impression of Art",
  "price": 13,
  "discountPercentage": 8.4,
  "rating": 5,
  "stock": 65,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
}
```
- **Resultado Esperado:** O produto é criado com sucesso e a API retorna um código 201.

---

### Cenário 2: Criar um produto com valor inválido para o campo "rating"
- **Objetivo:** Enviar uma requisição POST com um valor inválido no campo "rating".
- **Requisição:** `POST /products/add`.
- **Entrada:**
```json
{
  "title": "Perfume 212 VIP Femme Fatalle",
  "obsolete": "Gio",
  "description": "Mega Discount, Impression of Art",
  "price": 13,
  "discountPercentage": 8.4,
  "rating": "one",
  "stock": 65,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
}
```
- **Resultado Esperado:** A API retorna um código de erro 400 com uma mensagem informando que o campo "rating" deve ser numérico.

---
### Cenário 3: Criar um produto com campo "price" vazio
- **Objetivo:** Enviar uma requisição POST sem o campo "price".
- **Requisição:** `POST /products/add`.
- **Entrada:**
```json
{
  "title": "Perfume 212 VIP Femme Fatalle",
  "obsolete": "Gio",
  "description": "Mega Discount, Impression of Art",
  "discountPercentage": 8.4,
  "rating": 5,
  "stock": 65,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
}
```
- **Resultado Esperado:** A API retorna um código de erro 400, indicando que o campo "price" é obrigatório.

---
### Cenário 4: Criar um produto com valor negativo para "stock"
- **Objetivo:** Enviar uma requisição POST com valor negativo para o campo "stock".
- **Requisição:** `POST /products/add`.
- **Entrada:**
```json
{
  "title": "Perfume 212 VIP Femme Fatalle",
  "obsolete": "Gio",
  "description": "Mega Discount, Impression of Art",
  "price": 13,
  "discountPercentage": 8.4,
  "rating": 5,
  "stock": -10,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
}
```
- **Resultado Esperado:** A API retorna um código de erro 400, informando que o campo "stock" não pode ter valores negativos.

---

### Cenário 5: Criar um produto com URL de imagem inválida para o campo "thumbnail"
- **Objetivo:** Enviar uma requisição POST com uma URL inválida no campo "thumbnail".
- **Requisição:** `POST /products/add`.
- **Entrada:**
```json
{
  "title": "Perfume 212 VIP Femme Fatalle",
  "obsolete": "Gio",
  "description": "Mega Discount, Impression of Art",
  "price": 13,
  "discountPercentage": 8.4,
  "rating": 5,
  "stock": 65,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "invalid-url"
}
```
- **Resultado Esperado:** A API retorna um código de erro 400, informando que o campo "thumbnail" deve conter uma URL válida.

---

### Cenário 6: Criar um produto com valor zero para o campo "price"
**Descrição:** Enviar uma requisição POST com o valor zero para o campo "price".
- **Entrada:**
```json
{
  "title": "Perfume 212 VIP Femme Fatalle",
  "obsolete": "Gio",
  "description": "Mega Discount, Impression of Art",
  "price": 0,
  "discountPercentage": 8.4,
  "rating": 5,
  "stock": 65,
  "brand": "Impression of Acqua Di Gio",
  "category": "fragrances",
  "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
}
```
- **Resultado Esperado:** A API retorna um código de erro 400, informando que o campo "price" deve ser maior que zero.
