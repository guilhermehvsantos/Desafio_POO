# Desafio POO - Sistema de Corretora Imobiliária

Este repositório contém a solução para o desafio de **Programação Orientada a Objetos (POO)**.  
O projeto implementa um sistema completo de gestão de aluguel de imóveis (casas e apartamentos) aplicando os **pilares da POO** e lógica de programação.

---

## 📁 Estrutura do Projeto

```
Corretora-Imobiliaria/
├─ src/
│  └─ org/
│     └─ example/
│        ├─ Main.java              # Programa principal com menu interativo
│        ├─ Imovel.java             # Classe abstrata base para imóveis
│        ├─ Casa.java               # Subclasse de Imovel
│        ├─ Apartamento.java        # Subclasse de Imovel
│        ├─ Proprietario.java       # Classe para proprietário
│        └─ Inquilino.java          # Classe para inquilino
├─ .gitignore
└─ README.md
```

---

## 🎯 Funcionalidades

O sistema oferece um menu interativo com as seguintes opções:

1. **Cadastrar imóvel** - Cadastro de casas ou apartamentos com dados do proprietário
2. **Listar imóveis** - Exibe todos os imóveis cadastrados com seus status
3. **Alugar imóvel** - Registra inquilino e aplica descontos progressivos (5%, 10%, 15%)
4. **Disponibilizar imóvel** - Libera imóvel alugado
5. **Calcular valor do aluguel** - Simula aluguel com descontos por período
6. **Remover imóvel** - Remove imóveis disponíveis do sistema
7. **Sair** - Encerra o sistema

---

## 🏗️ Conceitos de POO

- **Encapsulamento**: Atributos protected/private com getters/setters
- **Herança**: Casa e Apartamento estendem Imovel
- **Polimorfismo**: Método `estaAlugado()` sobrescrito em cada subclasse
- **Abstração**: Classe abstrata Imovel com métodos abstratos

---

## 🖋 Autor

**Guilherme Santos**  
 [Linkedin](https://www.linkedin.com/in/guilhermehvs/)  | [GitHub](https://github.com/guilhermehvsantos) | [GitGFT](https://git.gft.com/guss)

