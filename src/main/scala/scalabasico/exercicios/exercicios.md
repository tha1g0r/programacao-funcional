# Exercícios — Scala, Recursos Básicos

**Restrições (valem para todos os exercícios):**
- Solução estritamente funcional.
- Proibido `for` / `while` (estruturas imperativas).
- Proibido `var` (variáveis mutáveis).
- Apenas funções puras, sem efeitos colaterais.

---

## Exercício 2.1 — [Conceito por nota](ConceitoNota.scala)

Defina uma função que receba uma nota $N \in [0, 10]$ e retorne uma `String` com o conceito correspondente:

| Nota        | Conceito |
|-------------|----------|
| 0 a 5.0     | F        |
| 5.1 a 6.9   | D        |
| 7.0 a 8.9   | C        |
| 9.0 a 9.9   | B        |
| 10.0        | A        |

---

## Exercício 2.2 — Comissão de vendedor

Uma empresa paga R$1,00 de comissão por produto vendido. Se forem vendidos **mais de 250** produtos, o valor sobe para R$1,50/produto. Se forem **mais de 500**, sobe para R$2,00/produto.

Defina uma função que receba a quantidade de produtos vendidos e retorne a comissão total.

**Atenção:** o cálculo é sempre feito com a maior faixa atingida aplicada a *todos* os produtos (ex.: 600 produtos → R$2,00 × 600, não uma soma por faixas).

---

## Exercício 2.3 — Classificação de temperatura

Defina uma função que receba um número real (temperatura em Celsius) e retorne uma **lista** com todas as classificações aplicáveis, na ordem da tabela (alguns intervalos se sobrepõem nas fronteiras):

| Temperatura      | Classificação |
|------------------|----------------|
| Inferior a -10   | Congelante     |
| -10 a 0          | Muito Frio     |
| 0 a 10           | Frio           |
| 10 a 20          | Fresco         |
| 20 a 30          | Agradável      |
| 30 a 40          | Quente         |
| Superior a 40    | Muito Quente   |

*Ex.: 10.0 → pertence a "Frio" e "Fresco" simultaneamente.*

---

## Exercício 2.4 — Faixa etária

Defina uma função que receba uma idade inteira e retorne uma `String`:

- 0 a 12 anos → criança
- 13 a 17 anos → adolescente
- 18 a 59 anos → adulto
- 60 anos ou mais → idoso
- idade negativa → string vazia

---

## Exercício 2.5 — Decomposição em dígitos

Defina uma função que receba um inteiro e retorne uma lista de 4 elementos `(m, c, d, u)`:

- `m`: milhares
- `c`: centenas
- `d`: dezenas
- `u`: unidades

Exemplos:
- `1234` → `List(1, 2, 3, 4)`
- `123456` → `List(123, 4, 5, 6)`
- número negativo → lista vazia

---

## Exercício 2.6 — Palíndromo aritmético

Um número é palíndromo quando lido da esquerda para a direita é igual ao lido da direita para a esquerda (ex.: `12321` é palíndromo, `45534` não é).

Defina um **predicado** (função que retorna `Boolean`) que recebe um inteiro de **5 dígitos** e determina se é palíndromo.

- Mais de 5 dígitos ou negativo → `false`.
- **Importante:** proibido converter para `String` ou lista — use apenas operações aritméticas.

---

## Exercício 2.7 — Conta de energia elétrica

Defina uma função que calcule o valor total de uma conta de energia, recebendo:
- consumo em kWh (`Double`)
- bandeira tarifária (`String`: `"Verde"`, `"Amarela"` ou `"Vermelha"`)

Regras:
- Tarifa base: R$0,65/kWh
- Bandeira "Amarela": +R$0,02/kWh
- Bandeira "Vermelha": +R$0,05/kWh
- Sobre o total (consumo + adicional de bandeira) incide ICMS de 25% (fator 1,25)

Use uma expressão de bloco. Consumo negativo deve retornar R$0,00.

---

## Exercício 2.8 — Tendência de uma sequência

Defina uma função que recebe uma lista de números reais com **exatamente 3 elementos** e, usando apenas `head` e `tail`, retorna:

- `"Crescente"` se `a < b < c`
- `"Decrescente"` se `a > b > c`
- `"Oscilante"` para qualquer outro arranjo
- `"Inválido"` se a lista não tiver exatamente 3 elementos

---

## Exercício 2.9 — [Conversor de câmbio formatado](ConversorCambio.scala)

Usando interpolação de strings (interpolador `f`), defina uma função que recebe um valor em Reais e uma taxa de câmbio, retornando uma string no formato:

```
"R$ XXX.XX equivalem a US$ YYY.YY"
```

Ambos os valores devem ter exatamente 2 casas decimais.

---

## Exercício 2.10 — Rotação circular à direita

Defina uma função que recebe uma lista de inteiros com **exatamente 3 elementos** e realiza uma rotação circular à direita:

```
List(a, b, c) → List(c, a, b)
```

Se a lista não tiver exatamente 3 elementos, retorne a lista original sem modificações.

---

## Exercício 2.11 — Classificação de triângulo

Defina uma função que recebe três números reais (lados de um triângulo). Primeiro, verifique a **desigualdade triangular** (soma de quaisquer dois lados > o terceiro). Se válido, classifique:

- `"Equilátero"` — três lados iguais
- `"Isósceles"` — dois lados iguais
- `"Escaleno"` — todos diferentes

Se não formar um triângulo válido, retorne `"Não é um triângulo"`.
