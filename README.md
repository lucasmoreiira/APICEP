# API CEP 💻

<p align="center">
 <a href="#technologies">Technologies</a> • 
 <a href="#getting-started">Getting Started</a> • 
 <a href="#routes">API Endpoints</a>
</p>

<p align="center">
    <b>Uma API simples para consultar informações de CEP utilizando o serviço ViaCEP.</b>
</p>

## 💻 Technologies

- Java
- Spring Boot
- RESTful API
- PostgreSQL
- JUnit (Testes Unitários)

## 🚀 Getting Started

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Git](https://git-scm.com/)

### Clonando o projeto

Para obter o código-fonte em sua máquina local, execute:

```bash
git clone https://github.com/lucasmoreiira/APICEP/
```


. Acesse a aplicação em `http://localhost:8080`.

## 📌 API Endpoints

Abaixo estão listadas as principais rotas da API:

| Método | Rota          | Descrição                                                                 |
|--------|---------------|---------------------------------------------------------------------------|
| GET    | /cep/{cep}    | Consulta informações de um CEP específico, utilizando o serviço ViaCEP.  |

### GET /cep/{cep}

**REQUEST**  
Essa rota permite consultar informações detalhadas sobre um CEP específico.  
**Exemplo de requisição:**  
```bash
GET http://localhost:8080/cep/01001000
```

**RESPONSE**  
Em caso de sucesso, retorna os dados do CEP consultado:  
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```

**Erros Comuns**  
- **400 Bad Request:**  
  Quando o CEP fornecido está em um formato inválido ou contém caracteres não permitidos.  
  **Exemplo de resposta:**  
  ```json
  {
    "error": "O CEP fornecido é inválido. Use o formato 00000-000."
  }
  ```

- **404 Not Found:**  
  Quando o CEP não é encontrado na base de dados do ViaCEP.  
  **Exemplo de resposta:**  
  ```json
  {
    "error": "CEP não encontrado."
  }
  ```

## 🧬 Testes

Para executar os testes unitários, utilize o comando:
```bash
mvn test
