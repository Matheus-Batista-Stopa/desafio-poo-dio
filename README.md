# Desafio de POO em Java - Refatorado para Java 21

Este projeto é uma versão refatorada do desafio **"Abstraindo um Bootcamp Usando Orientação a Objetos em Java"** da DIO (Digital Innovation One).

O objetivo desta refatoração foi modernizar a implementação original, melhorar a modelagem orientada a objetos, corrigir problemas de encapsulamento e atualizar o projeto para recursos mais recentes da linguagem Java.

---

## Tecnologias

* Java 21
* Programação Orientada a Objetos (POO)
* Collections Framework
* Streams API
* Optional
* Sealed Classes
* Pattern Matching
* API moderna de Data e Hora (`java.time`)

---

## Principais Melhorias

### 1. Atualização para Java 21

O projeto original utilizava Java 11.

Nesta versão foram adotados recursos mais modernos da linguagem para tornar o código mais seguro, expressivo e alinhado às práticas atuais do ecossistema Java.

---

### 2. Refatoração da Modelagem de Domínio

As entidades principais passaram a possuir identidade própria através de IDs internos:

* Bootcamp
* Dev
* Conteúdo

Isso permitiu implementar `equals()` e `hashCode()` de forma consistente, evitando problemas comuns envolvendo coleções como `HashSet`.

---

### 3. Encapsulamento das Coleções

Na implementação original era possível modificar diretamente as coleções internas das entidades através dos getters.

Exemplo do projeto original:

```java
bootcamp.getConteudos().add(curso);
```

Na versão refatorada, os conjuntos são protegidos através de coleções imutáveis:

```java
public Set<Conteudo> getConteudos() {
    return Collections.unmodifiableSet(conteudos);
}
```

Dessa forma, as regras de negócio permanecem centralizadas dentro das próprias entidades.

---

### 4. Construtores Obrigatórios

O projeto original utilizava construtores vazios combinados com diversos setters.

Essa abordagem garante que os objetos sejam criados sempre em estado válido.

---

### 5. Uso de Sealed Classes

A classe abstrata `Conteudo` foi transformada em uma Sealed Class:

Isso deixa explícito quais tipos podem herdar da classe base.

---

### 6. Responsabilidades Redistribuídas

A lógica de inscrição foi movida para a entidade `Bootcamp`, deixando o modelo mais orientado a objetos.

O próprio Bootcamp passa a controlar seu processo de inscrição.

---

### 7. Prevenção de Conteúdos Duplicados

Foi adicionada uma regra que impede que conteúdos já concluídos sejam reinseridos na lista de conteúdos inscritos.

Isso permite cenários como:

* Um desenvolvedor conclui conteúdos de um bootcamp.
* Posteriormente se inscreve em outro bootcamp.
* Conteúdos já concluídos não são adicionados novamente.

---

### 8. API Moderna de Datas

O projeto original utilizava `LocalDate`.

Nesta versão foram adotados tipos mais completos da API `java.time`, como:

```java
OffsetDateTime
```

e conversões utilizando:

```java
LocalDateTime
ZoneId
DateTimeFormatter
```

permitindo representar data e horário com fuso horário associado.

---

### 9. Melhor Legibilidade e Manutenção

Diversos trechos foram simplificados utilizando recursos modernos do Java:

Exemplo com `Optional`:

```java
conteudosInscritos.stream()
    .findFirst()
    .ifPresentOrElse(
        this::concluirConteudo,
        () -> System.err.println(
            "Você não está matriculado em nenhum conteúdo!"
        )
    );
```

---

## Estrutura do Projeto

```text
src
├── Main.java
└── br
    └── com
        └── dio
            └── desafio
                └── dominio
                    ├── Bootcamp.java
                    ├── Conteudo.java
                    ├── Curso.java
                    ├── Mentoria.java
                    └── Dev.java
```

---

## Conceitos de POO Aplicados

* Abstração
* Encapsulamento
* Herança
* Polimorfismo
* Composição
* Imutabilidade parcial
* Identidade de entidades
* Separação de responsabilidades

---

## Comparação com o Projeto Original

| Aspecto                      | Original  | Refatorado     |
| ---------------------------- | --------- | -------------- |
| Java                         | 11        | 21             |
| Construtores obrigatórios    | ❌         | ✅              |
| Sealed Classes               | ❌         | ✅              |
| Encapsulamento das coleções  | ❌         | ✅              |
| IDs de entidades             | ❌         | ✅              |
| Equals/HashCode consistentes | ❌         | ✅              |
| Uso de Optional              | Básico    | Melhorado      |
| Modelagem OO                 | Básica    | Refatorada     |
| API de Datas                 | LocalDate | OffsetDateTime |

---

## Objetivo da Refatoração

Além de reproduzir o desafio proposto pela DIO, este projeto teve como objetivo praticar:

* Refatoração de código legado
* Evolução de uma modelagem orientada a objetos
* Boas práticas de encapsulamento
* Recursos modernos do Java
* Design de entidades e coleções

---

## Autor

Projeto original proposto pela DIO.

Refatoração, modernização da arquitetura e atualização para Java 21 realizadas por **Matheus Batista Stopa**.
