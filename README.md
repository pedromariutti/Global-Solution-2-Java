# **🧠 Knowledge Hub API**

Uma plataforma inovadora para centralizar, organizar e gamificar o compartilhamento de conhecimento no contexto do futuro do trabalho.

## **📖 Sobre o Projeto**

O **Knowledge Hub** nasce da necessidade de preparar profissionais para o futuro do trabalho, onde a tecnologia e as relações humanas convergem.

**O Problema:** Links úteis, tutoriais e documentos importantes frequentemente se perdem em chats ou anotações pessoais, dificultando o acesso ao conhecimento coletivo.

**A Solução:** Uma API RESTful robusta que serve como backend para uma aplicação web onde colaboradores podem:

* **Cadastrar** links de vídeos, artigos e cursos.  
* **Organizar** conteúdos por categorias (Java, IA, Soft Skills).  
* **Gamificar** o aprendizado: Usuários ganham pontos ao contribuir, subindo de nível (ex: "Especialista em Java").

## **🚀 Tecnologias Utilizadas**

* **Linguagem:** Java 21 (LTS)  
* **Framework:** Quarkus (Supersonic Subatomic Java)  
* **Banco de Dados:** Oracle Database  
* **Gerenciamento de Dependências:** Maven  
* **Conteinerização:** Docker  
* **Deploy:** Render (Cloud)

## **🏗 Arquitetura e Design Patterns**

O projeto segue uma arquitetura em camadas baseada no padrão **MVC** (adaptado para API REST), garantindo separação de responsabilidades e facilidade de manutenção:

* **Resource (Controller):** Gerencia as requisições HTTP e respostas.  
* **BO (Business Object):** Contém as regras de negócio e validações.  
* **DAO (Data Access Object):** Responsável pela persistência e comunicação com o banco de dados (JDBC).  
* **TO (Transfer Object):** Objetos simples para tráfego de dados entre camadas.  
* **Singleton/Factory:** Utilizados na gestão da conexão com o banco (ConnectionFactory).

## 

## **👥 Autores e Créditos**

| Nome | RM |
| :---- | :---- |
| **Pedro Mariutti** | RM 75999 |
| **Henrique Orellana** | RM 565608 |
| **Anabelle Rosseto** | RM 564526 |

## 

## **🔗 Links Úteis**

Repositório github java:   [https://github.com/pedromariutti/Global-Solution-2-Java](https://github.com/pedromariutti/Global-Solution-2-Java)

Repositório github front:  [https://github.com/pedromariutti/Global-Solution-2-Front](https://github.com/pedromariutti/Global-Solution-2-Front) 

video demonstração: [https://youtu.be/aoMIAwiSpRo](https://youtu.be/aoMIAwiSpRo)

video pitch: [https://youtu.be/UoC0yw2Kg9o](https://youtu.be/UoC0yw2Kg9o)

link aplicação: [https://global-solution-2-front.vercel.app](https://global-solution-2-front.vercel.app)

