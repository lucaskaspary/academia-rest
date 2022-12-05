# Projeto API REST de cadastro de alunos de uma academia de musculação

## Guia
Para executar os passos a seguir, pode-se utilizar o Postman (https://www.postman.com/)

### Logando como admin
Para criar usuarios, primeiramente você tem que obter um token como administrador,
para isso deve-se utilizar o usuário "admin" e senha "admin", conforme o JSON a seguir.

Enviar um POST para: http://localhost:8080/login

```json
{
    "username":"admin",
    "password":"admin"
}
```
A API irá retornar um JSON com o seu token (semelhante a este)
```json
{
    "login": "admin",
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzAyNzUxMjIsImV4cCI6MTY3MDI3ODcyMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdfQ.7QLkUvlaqQgvnyDjE2M9iiM3OTGkHSf4bOuwDtMAuEfjiRXCF6BXpw3D1avYxfYcr4T7FunkZFpPGzeTqYRs6A"
}
```
Para configurar a autenticação, basta entrar na aba Authorization, no tipo de autenticação, 
selecionar a opção Bearer Token e colar o token gerado.

### Criando novos usuarios de sistema
Para criar novos usuarios, basta estar logado com a role "ADMIN" e enviar um POST para http://localhost:8080/user com as
informações do usuário, como exemplo a seguir (todos campos devem ser preenchidos):
```json
{
  "name":"superuser",
  "username":"superuser",
  "password":"superpass",
  "gymAccessPassword":"1234",
  "roles":["ADMIN"],
  "email":"superuser@admin.com"
}
```
### Criando usuarios da academia
Para criar um usuário da academia, anteriormente deve-se criar um usuario de sistema. Para criar o usuario
da academia basta enviar um POST para http://localhost:8080/gymUser com as informações do cadastro. O "username"
precisa ser identico ao de um usuario do sistema criado previamente.
```json
{
  "username":"admin",
  "cpf":"222.222.222-22",
  "address":"wall street, 123",
  "phone":"99 99999999",
  "birthday":"01/01/1990"
}
```
A API retornará um JSON de confirmação
```json
{
  "id": 1,
  "username": "admin",
  "name": "admin",
  "cpf": "222.222.222-22",
  "address": "wall street, 123",
  "phone": "99 99999999",
  "birthday": "01/01/1990",
  "email": "admin@admin.com",
  "evaluations": null
}
```
### Consultando usuários da academia
Para consultar todos usuarios de academia cadastrados, basta enviar um GET para http://localhost:8080/gymUser que a API
irá retornar um JSON com a lista de todos os usuarios de academia cadastrados.

```json
[
  {
    "id": 1,
    "username": "admin",
    "name": "admin",
    "cpf": "222.222.222-22",
    "address": "wall street, 123",
    "phone": "99 99999999",
    "birthday": "01/01/1990",
    "email": "admin@admin.com",
    "evaluations": null
  },
  {
    "id": 2,
    "username": "superuser",
    "name": "superuser",
    "cpf": "333.333.333-33",
    "address": "Av Brasil, 123",
    "phone": "99 888888888",
    "birthday": "05/08/1993",
    "email": "superuser@admin.com",
    "evaluations": null
  }
]
```

Para consultar o usuário pelo Id, basta inserir o Id no final do link.
Ex http://localhost:8080/gymUser/2

```json
{
    "id": 2,
    "username": "superuser",
    "name": "superuser",
    "cpf": "333.333.333-33",
    "address": "Av Brasil, 123",
    "phone": "99 888888888",
    "birthday": "05/08/1993",
    "email": "superuser@admin.com",
    "evaluations": null
  }
```
### Registrar uma avaliação física
Para adicionar uma avaliação, basta enviar  um JSON com todas as informações
necessárias para a API, como o exemplo a seguir:

Enviar um POST para http://localhost:8080/user/evaluation com o JSON contendo todos
os campos abaixo:

```json
{
    "username":"superuser",
    "weight": 88,
    "height": 173,
    "bodyFat": 15.8
}
```

### Consultar todas as avaliações
Para consultar todas as avaliações, basta enviar um GET para http://localhost:8080/user/evaluation


```json
[
    {
        "id": 1,
        "gymUser": {
            "id": 1,
            "cpf": "222.222.222-22",
            "address": "wall street, 123",
            "phone": "99 99999999",
            "birthday": "01/01/1990"
        },
        "weight": 100.0,
        "height": 173.0,
        "bodyFat": 12.0
    }
    {
        "id": 2,
        "gymUser": {
            "id": 2,
            "cpf": "333.333.333-33",
            "address": "Av. Brasil, 123",
            "phone": "99 8888888888",
            "birthday": "08/08/1988"
        },
        "weight": 73.0,
        "height": 165.0,
        "bodyFat": 19.2
    },
    {
        "id": 3,
        "gymUser": {
            "id": 1,
            "cpf": "222.222.222-22",
            "address": "wall street, 123",
            "phone": "99 99999999",
            "birthday": "01/01/1990"
        },
        "weight": 98.0,
        "height": 173.0,
        "bodyFat": 10.3
    }
]
```

### Consultar as avaliações pelo ID
Para consultar uma avaliação pelo ID, basta enviar um GET 
informando ao final o ID da avaliação, como no exemplo:
http://localhost:8080/user/evaluation/3

```json
{
    "id": 3,
    "gymUser": {
        "id": 1,
        "cpf": "222.222.222-22",
        "address": "wall street, 123",
        "phone": "99 99999999",
        "birthday": "01/01/1990"
    },
    "weight": 98.0,
    "height": 173.0,
    "bodyFat": 10.3
}
```

## Sobre
API criada por Lucas Daniel Kaspary para a Digital Innovation One.