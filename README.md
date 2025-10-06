# Grupo: JUnit 5 Framework

**Integrantes:**
- Gabriel Ramos
- João Pedro Braga
- João Vitor Romero  
- Lucas Randazzo
- Lúcio Neto

---

## 1. Descrição do Framework Selecionado

O **JUnit** é o framework de teste mais popular para a linguagem Java. Sua versão atual, jUnit 5, representa uma evolução significativa em relação ao JUnit 4. Ele foi atualizado para suportar os novos recursos do Java e as práticas modernas de desenvolvimento, agora apresenta uma estrutura composta por três subprojetos principais:

- **JUnit Platform**: Serve como base para execução de testes em diferentes ferramentas
- **JUnit Jupiter**: Nova API de programação e extensão para escrever testes na versão 5 do framework
- **JUnit Vintage**: Suporte para execução de testes JUnit 3 e 4

Principais características:
- Suporte a lambdas e programação funcional
- Anotações mais expressivas e flexíveis
- Modelo de extensão mais poderoso
- Melhor suporte para testes parametrizados
- Compatibilidade com IDEs modernas e ferramentas de build

---

## 2. Categorização do Framework

### i) Técnicas de Teste
O JUnit 5 suporta múltiplas técnicas de teste:
- **Teste de Unidade**: Foco principal do framework
- **Teste Funcional**: Através de testes baseados em comportamento
- **Teste Baseado em Estados**: Verificação de mudanças de estado do objeto
- **Teste Parametrizado**: Múltiplas entradas para o mesmo teste

### ii) Níveis de Teste
- **Teste de Unidade**: Nível primário de aplicação
- **Teste de Integração**: Através de extensões e testes com dependências
- **Teste de Sistema**: Quando combinado com outras ferramentas do ecossistema

### iii) Tipos de Teste
- **Teste Estrutural (Caixa Branca)**: Conhecimento interno da implementação
- **Teste Funcional (Caixa Preta)**: Baseado na especificação do software (no caso do nosso grupo, a calculadora)
- **Teste de Regressão**: Garantia que novas modificações não quebram funcionalidades existentes

---

## 3. Forma de Instalação/Integração

### Em um projeto maven, insira a dependência abaixo:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
</dependency>
```

---

## 4. Estratégia de Teste para Derivação de Casos de Teste

### Técnicas Utilizadas

#### **4.1 Particionamento de Equivalência**
Dividimos o domínio de entrada em partições onde elementos da mesma classe revelam os mesmos defeitos:

**Operação de Divisão:**
- **Partição Válida**: Denominador ≠ 0 → `divisao(10, 2)`
- **Partição Inválida**: Denominador = 0 → `divisao(10, 0)` → Exceção esperada
- **Caso Especial**: Numerador = 0 → `divisao(0, 5)`

**Operação de Soma:**
- **Partição Positivos**: `soma(5, 3)`
- **Partição Negativos**: `soma(-2, -3)`
- **Partição Mista**: `soma(5, -3)`

#### **4.2 Análise do Valor Limite**
Testamos valores nos limites das partições, onde defeitos são mais prováveis:

**Valores Críticos para Divisão:**
- Próximo de zero: `divisao(1, Integer.MAX_VALUE)`
- Zero exato: `divisao(10, 0)` → Exceção
- Precisão decimal: `divisao(0.6, 0.2)`

### Casos de Teste Implementados

| Operação | Técnica | Caso de Teste | Valor de Entrada | Resultado Esperado |
|----------|---------|---------------|------------------|-------------------|
| Divisão | Particionamento | Divisão normal | (10, 5) | 2 |
| Divisão | Particionamento | Divisão por zero | (10, 0) | Exception |
| Divisão | Valor Limite | Precisão decimal | (0.6, 0.2) | 3.0 |
| Soma | Particionamento | Positivos + Negativos | (5, -3) | 2 |
| Soma | Valor Limite | Overflow | (MAX_VALUE, MIN_VALUE) | -1 |

### Exemplo de Mapeamento para Código

```java
// Particionamento de Equivalência - Partição Inválida
@Test
void testDivisaoPorZero() {
    assertThrows(ArithmeticException.class, () -> {
        Calculadora.divisao(10, 0);
    });
}

// Análise do Valor Limite - Precisão Decimal  
@Test
void testDivisaoDecimalPrecisao() {
    assertEquals(3, Calculadora.divisao(0.6, 0.2));
}
```

---
