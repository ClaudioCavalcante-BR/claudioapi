# 📊 Gestão de Ativos Corpóreos (Tangible Asset Management)

## 📌 Descrição
O projeto **Gestão de Ativos Corpóreos** tem como objetivo o desenvolvimento de um sistema que aplica um modelo de cálculo baseado em premissas e diretrizes objetivas, com foco na **apuração do valor justo dos ativos imobilizados**, em conformidade com normas internacionais de contabilidade (IFRS).

A solução será voltada para empresas com grande volume de ativos — como **frotas, máquinas e equipamentos** — permitindo um **controle patrimonial mais preciso, transparente e automatizado**.

---

## 🚀 Tecnologias Utilizadas
- **Linguagem**: Java 17  
- **IDE**: Apache Eclipse  
- **Frameworks previstos**: Spring Boot, JPA/Hibernate  
- **Banco de dados**: H2 (desenvolvimento), expansível para MySQL/PostgreSQL  

---

## 🏗️ Estrutura do Projeto

### Principais Entidades
| Entidade            | Papel     | Descrição |
|---------------------|----------|-----------|
| **AssetRegistration** | Mãe       | Representa o ativo em si. Cadastro e informações detalhadas de ativos no inventário. |
| **Address**          | Filha (composição) | Cadastro de localização do ativo, associada a `AssetRegistration`. |
| **AccountingInterface** | Filha (funcional) | Interface para padronizar integração contábil (classe a ser criada). |
| **AssetDepreciation** | Filha (funcional) | Histórico e cálculos de depreciação vinculados ao ativo. |
| **AssetCategory**     | Filha (herança)   | Classificação e agrupamento de ativos por categoria. |
| **FinancialReport**   | Filha (associação) | Representação de relatórios financeiros consolidados (classe a ser criada). |

---

### Relacionamentos
- **AssetRegistration ↔ AssetCategory** → Many-to-One (muitos ativos em uma categoria)  
- **AssetRegistration ↔ Address** → One-to-One (um ativo tem um endereço principal)  
- **AssetRegistration ↔ AssetDepreciation** → One-to-Many (um ativo tem vários registros de depreciação)  
- **AssetRegistration ↔ AccountingInterface** → One-to-One (um ativo vinculado a uma integração contábil)  
- **AssetRegistration ↔ FinancialReport** → One-to-Many (um ativo gera vários relatórios financeiros)  

---

## 🎯 Objetivos do Projeto
- Automatizar o cálculo do valor justo de ativos corpóreos.  
- Garantir aderência às normas internacionais de contabilidade.  
- Reduzir riscos de inconsistências em auditorias.  
- Gerar relatórios financeiros consolidados para apoio à decisão.  
- Permitir integração com sistemas contábeis e ERPs.  

---

## 👥 Público-Alvo
- Empresas de **logística e transporte**  
- **Construtoras e indústrias** com grande parque de máquinas  
- **Hospitais e clínicas** com ativos de alto valor  
- Empresas multinacionais sujeitas a auditorias internacionais  

---

## 📌 Status do Projeto
🚧 Em desenvolvimento 🚧  

---

## 📢 Contribuições
Sugestões e melhorias são bem-vindas!  
Abra uma **issue** ou envie um **pull request**.  

---

## 📄 Licença
Este projeto é distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.
