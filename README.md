# 📦 Sistema Modular com Submenu

Este projeto consiste em um sistema de gerenciamento modular desenvolvido em **Java**, com o objetivo de praticar conceitos de **modularização, reutilização de código, validações básicas, tratamento de erros** e uso de **coleções (ArrayList)**.

## 🎯 Objetivo

Criar um sistema com um **menu principal** que permite navegar entre diferentes módulos (EPIs, Funcionários, Empréstimos), cada um operando com um **submenu CRUD reutilizável** para **Cadastrar, Listar, Atualizar e Remover** registros de forma dinâmica e validada.

## 🧩 Funcionalidades

- Menu principal com as opções:
  - Módulo de EPIs
  - Módulo de Funcionários
  - Módulo de Empréstimos
  - Visualização do Log de Operações
- Submenu CRUD genérico:
  - **Cadastrar:** Insere um novo registro na lista.
  - **Listar:** Exibe todos os registros da lista atual.
  - **Atualizar:** Atualiza um registro com base no índice.
  - **Remover:** Remove um registro com base no índice.
- Submenu reutilizável para todos os módulos via passagem de parâmetros.
- Exibição de mensagens claras e amigáveis ao usuário.
- Registro e exibição do **log de operações realizadas**.

## ✅ Validações

- Validação de **formato e campos vazios** no momento do cadastro e atualização:
  - O sistema exige que todos os campos estejam preenchidos.
  - Campos vazios são rejeitados com uma mensagem adequada.
- Validação de **índice informado**:
  - O índice deve estar dentro do intervalo da lista.
  - Índices inválidos não executam a ação e informam o erro ao usuário.

## ⚠️ Tratamento de Erros

- Uso de `try-catch` para capturar **InputMismatchException**:
  - Garante que apenas números inteiros sejam aceitos nas opções do menu e nos índices.
  - Evita o encerramento abrupto do programa por entradas inválidas.
- Mensagens amigáveis ajudam o usuário a corrigir suas ações.

## 📜 Log de Operações

- Toda operação de **cadastro, atualização ou remoção** é registrada em uma `ArrayList<String>`.
- O usuário pode visualizar todo o **histórico de ações** realizadas ao acessar a opção **"Log de Operações"** no menu principal.
- Exemplo de entradas no log:
  - `Cadastrado: Capacete - 20 unidades - Proteção para a cabeça`
  - `Atualizado: Bota - 10 unidades - Proteção para os pés`
  - `Removido: Luvas - 15 unidades - Proteção para as mãos`

## 🛠️ Tecnologias Utilizadas

- Java 17+
- IDE recomendada: IntelliJ IDEA ou Eclipse
- Console para entrada e saída de dados

## 📁 Estrutura do Projeto

Organizado em pacotes para modularidade e clareza:
```
  SistemaModular 
    ├── Main.java       // Classe principal com o menu
    ├── MenuCrud.java   // Classe responsável pelo submenu CRUD reutilizável 
    └── README.md       // Documentação do projeto
```

## 🚀 Como Executar

1. Clone este repositório:
   ```bash
   https://github.com/tainaestefani/sistema-modular.git

## 👩‍💻 Autor
<div align="left">
  <a href="https://github.com/tainaestefani">
    <img alt="Tainá Estefani Martins" src="https://avatars.githubusercontent.com/u/154456749?v=4" width="115" style="border-radius:50%">
  </a>
  <br>
  <sub><b>Tainá Estefani Martins</b></sub><br>
  <sub>RA: 1778354</sub><br>
</div>
