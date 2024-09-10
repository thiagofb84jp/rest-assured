# Casos de Testes - API de Usuários - Método GET

---
## Cenário 1: Verificar o status code da API de usuários.
- **Objetivo:** Confirmar que a API retorna um código de status HTTP 200 para uma requisição bem-sucedida.
- **Requisição:** `GET /users`
- **Saída esperada (response):** Código de status HTTP 200.
---

## Cenário 2: Verificar a Estrutura do Response.
- **Objetivo:** Validar que o corpo da resposta está estruturado corretamente.
- **Requisição:** `GET /users`
- **Saída esperada (response):**
    - O corpo da resposta deve ser um objeto JSON.
    - O objeto JSON deve conter uma chave `"users"`, que é uma lista.
    - Cada item da lista `"users"` deve ser um objeto com as seguintes chaves:
        - `"id"`
        - `"firstName"`
        - `"lastName"`
        - `"maidenName"`
        - `"age"`
        - `"gender"`
        - `"email"`
        - `"phone"`
        - `"username"`
        - `"password"`
        - `"birthDate"`
        - `"image"`
        - `"bloodGroup"`
        - `"height"`
        - `"weight"`
        - `"eyeColor"`
        - `"hair"` (objeto com chaves `"color"` e `"type"`)
        - `"domain"`
        - `"ip"`
        - `"address"` (objeto com chaves `"address"`, `"city"`, `"coordinates"` (objeto com chaves `"lat"` e `"lng"`), `"postalCode"`, `"state"`)
        - `"macAddress"`
        - `"university"`
        - `"bank"` (objeto com chaves `"cardExpire"`, `"cardNumber"`, `"cardType"`, `"currency"`, `"iban"`)
        - `"company"` (objeto com chaves `"address"` (objeto com chaves `"address"`, `"city"`, `"coordinates"` (objeto com chaves `"lat"` e `"lng"`), `"postalCode"`, `"state"`), `"department"`, `"name"`, `"title"`)
        - `"ein"`
        - `"ssn"`
        - `"userAgent"`

---

## Cenário 3: Verificar o Conteúdo do Response.
- **Objetivo:** Garantir que o conteúdo dos dados do usuário é consistente com o Saída esperada (response).
- **Requisição:** `GET /users`
- **Saída esperada (response):**
    - A resposta deve conter pelo menos dois usuários.
    - Cada usuário deve ter valores válidos para todas as chaves especificadas (por exemplo, `"id"` deve ser um número, `"email"` deve seguir o formato de um endereço de e-mail, etc.).

---
## Cenário 4: Verificar a Presença de Campos Obrigatórios.
- **Objetivo:** Verificar se todos os campos obrigatórios estão presentes na resposta.
- **Requisição:** `GET /users`
- **Saída esperada (response):** Cada usuário na lista deve ter todos os campos obrigatórios presentes e não nulos.

---
## Cenário 5: Verificar o Tipo de Dados dos Campos.
- **Objetivo:** Garantir que os tipos de dados dos campos estão corretos.
- **Requisição:** `GET /users`
- **Saída esperada (response):**
    - `"id"`: número
    - `"firstName"`: string
    - `"lastName"`: string
    - `"maidenName"`: string
    - `"age"`: número
    - `"gender"`: string
    - `"email"`: string
    - `"phone"`: string
    - `"username"`: string
    - `"password"`: string
    - `"birthDate"`: string (formato data)
    - `"image"`: string (URL)
    - `"bloodGroup"`: string
    - `"height"`: número
    - `"weight"`: número
    - `"eyeColor"`: string
    - `"hair"`: objeto com `"color"` (string) e `"type"` (string)
    - `"domain"`: string
    - `"ip"`: string (formato IP)
    - `"address"`: objeto com os campos especificados (endereço, cidade, etc.)
    - `"macAddress"`: string (formato MAC address)
    - `"university"`: string
    - `"bank"`: objeto com os campos especificados (número do cartão, tipo, etc.)
    - `"company"`: objeto com os campos especificados (endereço, departamento, etc.)
    - `"ein"`: string
    - `"ssn"`: string
    - `"userAgent"`: string

---
## Cenário 6: Verificar a Resposta para Requisições Inválidas.
- **Objetivo:** Garantir que a API lida corretamente com requisições inválidas ou malformadas.
- **Requisição:** (faça uma requisição inválida, como um método HTTP incorreto ou URL errada)
- **Saída esperada (response):** A API deve retornar um código de status de erro apropriado (por exemplo, 404 ou 400).
---