# 💳 Spring JDBC Transactions

Este projeto demonstra como utilizar **transações com JDBC puro** utilizando **Spring Framework** e **Spring Boot**, com foco em boas práticas e gestão correta de transações em operações críticas de banco de dados.

## ⚙️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring JDBC**
- **H2 Database (memória)**
- **Gradle**

## 📦 Objetivo do Projeto

Mostrar como:
- Configurar a infraestrutura de transações com `JdbcTemplate`
- Utilizar `@Transactional` para controle declarativo
- Gerenciar rollback automático em exceções
- Separar responsabilidades entre `Service` e `Repository`

## 🧪 Exemplos Implementados

- 💰 *Transferência de saldo entre contas*
- 🔄 *Rollback automático em erro*
- 🛡️ *Validação antes de persistência*

## 📂 Estrutura de pastas

```
spring-jdbc-transactions/
 ├── src/main/java/com/example/springjdbctransactions/
 │   ├── SpringJdbcTransactionsApplication.java
 │   ├── model/
 │   │   └── Product.java
 │   ├── repository/
 │   │   └── ProductRepository.java
 │   ├── service/
 │   │   └── ProductService.java
 │   └── config/
 │       └── DataSourceConfig.java
 ├── src/main/resources/
 │   ├── application.yml
 │   └── schema.sql
 └── src/test/java/com/example/springjdbctransactions/
     └── ProductServiceTest.java
```
