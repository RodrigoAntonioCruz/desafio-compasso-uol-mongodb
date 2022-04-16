<h3 align="center">
  <img align="center" alt="Logo UOL"  height="100" src="https://webjump.com.br/wp-content/uploads/2021/08/compassuol-logo-min.png" /><br>
  DESAFIO BACKEND COMPASSO UOL MONGODB
</h3>


### Contexto do Desafio

Desenvolver uma `API REST` de catálogo de produtos que utilize como meio de persistência de dados um `banco de dados não relacional(MongoDB)` e contemple as seguintes operações nos respectivos `Endpoints`:

<p align="center">
  <img align="center" src="https://raw.githubusercontent.com/RodrigoAntonioCruz/assets/main/endpoints.png" />
</p>


<h4>Tecnologias</h4>
<ul>
  <li> Java 11
  <li> Spring Boot 
  <li> Maven
  <li> Lombok
  <li> MongoDB
  <li> Swagger
  <li> Validation
  <li> JUnit
</ul>

### Requisitos

Para rodar estas aplicações, você deve ter instalado em seu computador:

<ul> 
   <li><a href="https://www.azul.com/downloads/?package=jdk" target="_blank">Java 11 (LTS)</a>
   <li><a href="https://gradle.org/next-steps/?version=7.0.2&format=bin" target="_blank">Gradle 7.0.2</a>  
   <li><a href="https://docs.docker.com/get-started/" target="_blank">Docker</a>
</ul> 

### Executando o projeto

1. Clone ou baixe o projeto do repositório para o seu `Computador`.

2. Navegue até a raíz do seu diretório onde salvou ou clonou o projeto, abra o `terminal e execute em sequencia os comandos:`
<ul> 
   <li> sudo gradle build
   <li> sudo docker-compose build
   <li> sudo docker-compose up
</ul>

3. Após a execução dos processos anteriores, estarão disponíveis para acesso em seu browser os seguintes `Endpoints` para teste:
<ul> 
  <li>
   <a href="http://localhost:9999" target="_blank">API-REST (http://localhost:9999)</a>

  <li>
   <a href="http://localhost:8081" target="_blank">Mongo Express (http://localhost:8081)</a>
</ul> 

### Executando os testes unitários

1. Navegue até a raíz do seu diretório onde salvou ou clonou o projeto, abra o `terminal e execute ` o comando `sudo gradle clean test`. Este comando executará todos os casos de teste.

<hr>
