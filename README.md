# Gestão de Ativos Corpóreos (Tangible Asset Management)

O presente projeto tem como objetivo o desenvolvimento de um sistema de Gestão de Ativos Corpóreos (Tangible Asset Management) digital, voltado para empresas que possuem grande volume de ativos, como frotas e equipamentos de pequeno, médio e grande porte, podendo ser adequado a empresas de médio e pequeno porte. A iniciativa busca oferecer uma solução digital para cálculo automatizado do valor justo de ativos imobilizados, alinhada às Normas Internacionais de Contabilidade (IFRS), proporcionando um contr...

---

## Tecnologias Utilizadas

- **Linguagem:** Java 17  
- **IDE:** Apache Eclipse  
- **Frameworks previstos:** Spring Boot, JPA/Hibernate  
- **Banco de dados:** H2 (desenvolvimento), expansível para MySQL/PostgreSQL  

---

## Estrutura do Projeto

### Herança (Principais Entidades)

| Classe Mãe / Interface | Classe Filha (ou Implementação) | Tipo de relação | Descrição |
|---|---|---|---|
| `AssetRegistration` (abstract) | `AssetCategory` | Herança (extends) | Categoria de ativos (ex.: frota, grupo de equipamentos) |
| `AssetRegistration` (abstract) | `AssetDepreciation` | Herança (extends) | Regras de depreciação do ativo |
| `RuntimeException` | `AssetInvalidException` | Herança (extends) | Exceção para ativo inválido |
| `RuntimeException` | `AssetNotFoundException` | Herança (extends) | Exceção para ativo não encontrado |
| `ApplicationRunner` | `AssetCategoryLoader` | Implementa (implements) | Loader inicial para categorias |
| `ApplicationRunner` | `AssetItemLoader` | Implementa (implements) | Loader inicial para itens |
| `ApplicationRunner` | `AssetDepreciationLoader` | Implementa (implements) | Loader inicial para depreciação |
| `CrudService<T, ID>` | `AssetCategoryService` | Implementa (implements) | Serviço de regras para categorias |
| `CrudService<T, ID>` | `AssetItemService` | Implementa (implements) | Serviço de regras para itens |
| `CrudService<T, ID>` | `AssetDepreciationService` | Implementa (implements) | Serviço de regras para depreciação |
| `JpaRepository<Entidade, ID>` | `AssetCategoryRepository` | Estende (extends) | Repositório JPA de categorias |
| `JpaRepository<Entidade, ID>` | `AssetItemRepository` | Estende (extends) | Repositório JPA de itens |
| `JpaRepository<Entidade, ID>` | `AssetDepreciationRepository` | Estende (extends) | Repositório JPA de depreciações |

---

### Associações (com cardinalidade e JPA)

| Origem | Cardinalidade | Destino | JPA principal | Observações |
|---|---|---|---|---|
| `AssetCategory` | **1 → N** | `AssetItem` | `@OneToMany(mappedBy="assetCategory", cascade=ALL, orphanRemoval=true, fetch=LAZY)` | Coleção de itens por categoria |
| `AssetItem` | **N → 1** | `AssetCategory` | `@ManyToOne(fetch=EAGER) @JoinColumn(name="assetcategory_id", nullable=false)` | Item pertence a 1 categoria |
| `AssetCategory` | **N → 1** | `Address` | `@ManyToOne(cascade=ALL) @JoinColumn(name="address_id")` | Associação de endereço |
| `AssetItem` | — | `AssetItemType` (enum) | `@Enumerated(EnumType.STRING)` | Tipagem do item |
| `AssetDepreciation` | — | `AssetDepreciationType` (enum) | `@Enumerated(EnumType.STRING)` | Tipo de depreciação |

---

### Polimorfismo

| Entidade/Contrato | Método/Conceito | Implementações / Efeito |
|---|---|---|
| `AssetRegistration` (abstract) | `obtainVisa()` | `AssetCategory#obtainVisa()` / `AssetDepreciation#obtainVisa()` (sobrescrita) |
| `CrudService<T, ID>` | Operações CRUD genéricas | Implementado por `AssetCategoryService`, `AssetItemService`, `AssetDepreciationService` |
| `RuntimeException` | Tratamento centralizado | Exceções `AssetInvalidException`, `AssetNotFoundException` tratadas no `GlobalExceptionHandler` |

---

### Pacotes e Papéis

| Pacote | Conteúdo (principais classes) | Papel |
|---|---|---|
| `model.domain` | `AssetRegistration`, `AssetCategory`, `AssetDepreciation`, `AssetItem`, `Address`, enums, exceções | Modelo de domínio |
| `model.repository` | `AssetCategoryRepository`, `AssetItemRepository`, `AssetDepreciationRepository` | Acesso a dados |
| `model.service` | `CrudService<T, ID>`, `AssetCategoryService`, `AssetItemService`, `AssetDepreciationService` | Regras de negócio |
| `controller` | `AssetCategoryController`, `AssetItemController`, `AssetDepreciationController`, `GlobalExceptionHandler` | API REST |
| raiz/app | `ClaudioapiApplication`, `AssetCategoryLoader`, `AssetItemLoader`, `AssetDepreciationLoader` | Inicialização e carga inicial |

---

### Repositórios e Serviços

| Entidade | Repositório | Serviço |
|---|---|---|
| `AssetCategory` | `AssetCategoryRepository` | `AssetCategoryService` |
| `AssetItem` | `AssetItemRepository` | `AssetItemService` |
| `AssetDepreciation` | `AssetDepreciationRepository` | `AssetDepreciationService` |

---

### Loaders (execução ao subir a aplicação)

| Loader | Implementa | Usa | Função |
|---|---|---|---|
| `AssetCategoryLoader` | `ApplicationRunner` | `AssetCategoryService` | Popular categorias |
| `AssetItemLoader` | `ApplicationRunner` | `AssetItemService`, `AssetCategoryService` | Popular itens vinculados |
| `AssetDepreciationLoader` | `ApplicationRunner` | `AssetDepreciationService` | Popular depreciações |

---

## Público-Alvo

- Empresas de logística e transporte  
- Construtoras e indústrias com grande parque de máquinas  
- Hospitais e clínicas com ativos de alto valor  
- Empresas multinacionais sujeitas a auditorias internacionais  

---

## Status do Projeto

Em **Pronto para avaliação**

---

## Contribuições

Sugestões e melhorias são bem-vindas!  
Abra uma *issue* ou envie um *pull request*.

---

## Licença

Este projeto é distribuído sob a licença **MIT**.  
Consulte o arquivo `LICENSE` para mais detalhes.  
