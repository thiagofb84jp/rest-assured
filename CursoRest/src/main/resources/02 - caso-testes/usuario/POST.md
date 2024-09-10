# Casos de Testes - API de Usuários - Método POST

---
## Cenário 1: Verificar a geração de token com credenciais válidas .
- **Objetivo:** Verificar se o token é gerado corretamente quando as credenciais são válidas.
- **Pré-condição:** O username e password devem ser válidos.
- **Requisição:** `POST auth/users`
- **Entrada (request):**
  ```json
  {
    "username": "alexanderj",
    "password": "alexanderjpass"
  }
  ```
- **Saída esperada (response):**
    - Código HTTP: 200 (OK)
    - Corpo:
  ```json
  {
    "token": "<valid_token>",
    "refreshToken": "<valid_refresh_token>",
    "id": 7,
    "username": "alexanderj",
    "email": "alexander.jones@x.dummyjson.com",
    "firstName": "Alexander",
    "lastName": "Jones",
    "gender": "male",
    "image": "https://dummyjson.com/icon/alexanderj/128"
  }
  ```
---
## Cenário 2: Verificar geração de token com credenciais inválidas.
- **Objetivo:** Verificar se a API retorna erro quando o username ou password estão incorretos.
- **Requisição:** `POST auth/users`
- **Entrada (request):**
  ```json
  {
    "username": "alexanderj",
    "password": "wrongpassword"
  }
  ```
- **Saída esperada (response):**
    - Código HTTP: 401 (Unauthorized)
    - Corpo:
  ```json
  {
    "message": "Invalid credentials"
  }
  ```
---
## Cenário 3: Verificar a geração do token sem o envio do campo "password".
- **Objetivo:** Verificar a resposta da API quando campos obrigatórios estão ausentes.
- **Requisição:** `POST auth/users`
- **Entrada (request):**
  ```json
  {
    "username": "alexanderj"
  }
  ```
- **Saída esperada (response):**
    - Código HTTP: 400 (Bad Request)
    - Corpo:
  ```json
  {
    "message": "Password is required"
  }
  ```
---
## Cenário 4: Verificar a expiração do token após certo tempo de configuração.
- **Objetivo:** Verificar se o token expira após o tempo configurado.
- **Requisição:** `POST auth/users`
- **Entrada:** Token gerado e aguardado o tempo de expiração.
- **Saída esperada (response):**
    - Código HTTP: 401 (Unauthorized)
    - Corpo:
  ```json
  {
    "message": "Token expired"
  }
  ```
---
## Cenário 5. Verificar se o sistema permite gerar o token com usuário inexistente.
- **Objetivo:** Verificar o comportamento da API ao tentar autenticar com um username que não existe no sistema.
- **Requisição:** `POST auth/users`
- **Entrada (request):**
  ```json
  {
    "username": "nonexistentuser",
    "password": "anyPassword"
  }
  ```
- **Saída esperada (response):**
    - Código HTTP: 400 (Bad Request)
    - Corpo:
  ```json
  {
    "message": "User not found"
  }
  ```
---
## Cenário 6. Verificar se o "refreshToken" permite gerar um novo token.
- **Objetivo:** Verificar se o `refreshToken` pode ser utilizado para gerar um novo token.
- **Requisição:** `POST auth/users`
- **Entrada:** Enviar o `refreshToken` recebido no login.
- **Saída esperada (response):**
    - Código HTTP: 200 (OK)
    - Novo token gerado corretamente.
---