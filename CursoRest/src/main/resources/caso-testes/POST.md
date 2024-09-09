
# Casos de Testes - API de Autenticação

## 1. Teste de autenticação bem-sucedida
- **Objetivo:** Verificar se o token é gerado corretamente quando as credenciais são válidas.
- **Pré-condição:** O username e password devem ser válidos.
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
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

## 2. Teste de autenticação com credenciais inválidas
- **Objetivo:** Verificar se a API retorna erro quando o username ou password estão incorretos.
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
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

## 3. Teste com dados ausentes no request
- **Objetivo:** Verificar a resposta da API quando campos obrigatórios estão ausentes.
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
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

## 4. Teste de expiração do token
- **Objetivo:** Verificar se o token expira após o tempo configurado.
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
- **Entrada:** Token gerado e aguardado o tempo de expiração.
- **Saída esperada (response):**
    - Código HTTP: 401 (Unauthorized)
    - Corpo:
  ```json
  {
    "message": "Token expired"
  }
  ```

## 5. Teste de integridade do token
- **Objetivo:** Verificar se o token gerado está no formato JWT (JSON Web Token).
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
- **Entrada:** Request de autenticação válido.
- **Saída esperada (response):**
    - O campo `token` deve ser um JWT válido, composto por três partes separadas por pontos (`header.payload.signature`).

## 6. Teste de autenticação com username inexistente
- **Objetivo:** Verificar o comportamento da API ao tentar autenticar com um username que não existe no sistema.
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
- **Entrada (request):**
  ```json
  {
    "username": "nonexistentuser",
    "password": "anyPassword"
  }
  ```
- **Saída esperada (response):**
    - Código HTTP: 404 (Not Found)
    - Corpo:
  ```json
  {
    "message": "User not found"
  }
  ```

## 7. Teste de refresh token
- **Objetivo:** Verificar se o `refreshToken` pode ser utilizado para gerar um novo token.
- **Request:**
  ```arduino
  curl --location 'https://dummyjson.com/auth/login'
  ```
- **Entrada:** Enviar o `refreshToken` recebido no login.
- **Saída esperada (response):**
    - Código HTTP: 200 (OK)
    - Novo token gerado corretamente.
