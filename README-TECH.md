# Sistema de Gerenciamento de Eventos 

# Visão Geral (Técnico):

Aplicação web desenvolvida em Java com Spring Boot para organizar e gerenciar eventos e convidados. Permite cadastro, edição, exclusão e listagem de eventos e convidados.

# Tecnologias Utilizadas:

	•	Linguagem de Programação: Java 21
	•	Framework Backend: Spring Boot
	•	Frontend: HTML, CSS, Thymeleaf, Materialize CSS, JS
	•	Banco de Dados: MySQL
	•	IDE: Visual Studio Code
	•	Gerenciamento de Dependências: Maven
	•	Ferramentas: PowerShell, MySQL CLI

# Estrutura do Projeto:

Utilizamos a arquitetura MVC (Model-View-Controller), organizando dessa forma:

**Model:**
	•	Evento: Identificado por codigo, com atributos como nome, data, e local.
	•	Convidado: Identificado pelo nome.

**Repository:**
	•	EventoRepository
	•	ConvidadoRepository

**Controller:**
	•	/eventos: Listagem e criação de eventos.
	•	/detalhesEvento/{codigo}: Detalhes de um evento e gerenciamento de convidados.
	•	/editarConvidado/{rg}: Edita as informações de um convidado.
	•	/deletarConvidado/{rg}: Remove um convidado de um evento.

**View:**
	•	Index: Página inicial com listagem de eventos.
	•	Detalhes do Evento: Página que exibe informações específicas de um evento e seus convidados.
	•	Formulários: Para cadastro e edição de eventos e convidados.

**Static Files:**
Os arquivos CSS e JavaScript estão organizados em:
	•	src/main/resources/static/materialize/css/materialize.min.css
	•	src/main/resources/static/materialize/js/materialize.min.js

# Suas Funcionalidades:

**Gerenciamento de Eventos:**
	•	Cadastro, edição, exclusão e listagem de eventos.

**Gerenciamento de Convidados:**
	•	Adicionar convidados a um evento.
	•	Editar informações dos convidados.
	•	Remover convidados de um evento.

**Validação e Redirecionamento:**
	•	Validação de campos obrigatórios com mensagens de erro.
	•	Redirecionamento após ações, como edição ou exclusão.

# Configurações:

**Banco de Dados:**
Configure o MySQL no arquivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/eventosapp
spring.datasource.username=root
spring.datasource.password=**senha** // insira a sua senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

**Dependências Maven:**
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

**Endpoints:**
Método	Endpoint					Descrição
GET		/eventos					Listar todos os eventos.
POST	/eventos					Criar um novo evento.
GET		/detalhesEvento/{codigo}	Exibir detalhes de um evento.
POST	/detalhesEvento/{codigo}	Adicionar um convidado a um evento.
GET		/editarConvidado/{rg}		Exibir formulário para editar um convidado.
POST	/editarConvidado/{rg}		Atualizar dados de um convidado.
DELETE	/deletarConvidado/{rg}		Remover um convidado de um evento.

# Executação:

	1. Configurar o banco de dados:
Comece criando o banco de dados nomeado como “eventosapp” no MySQL/powerShell utilizando o seguinte comando: “create database eventosapp;”

	2. Altere o login do seu banco de dados:
Localize o arquivo DataConfiguration (presente na pasta Model) e application.properties (em resources) e altere a senha para a respectiva de seu MySQL.

	3.	SpringBoot Dashboard:
Certifique-se de que a extensão “SpringBoot Dashboard” da Microsoft é VMware está instalada (caso esteja utilizando a IDE Vscode) e logo inicie o servidor.

	4.	Acessar a Aplicação:
Abra o navegador e acesse: http://localhost:8080/eventos.

**Events:**
    •   inicial: página inicial estilizada em CSS do style contendo informações sobre o site, contato e os eventos disponíveis e poder logar em uma conta.
    •   login: página para entrar em uma conta que esteja no banco de dados, no momento somente admin, para se ingressar no evento.
    •   menu: página principal do admin.
    

**Style:**
    •   index, login, style: estilização com base no tema Neon com tons de azul, rosa e ciano.

**Melhorias Futuras:**
	•	Implementação de autenticação e autorização.
	•	Filtros avançados para eventos e convidados.
	•	Design responsivo completo.
	•	Integração com APIs externas para notificações.
