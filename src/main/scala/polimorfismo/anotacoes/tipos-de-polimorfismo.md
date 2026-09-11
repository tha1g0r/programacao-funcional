# Resumo dos Tipos de Polimorfismo

| Tipo | Categoria | Quando o comportamento é decidido | Uniformidade | Exemplo no capítulo |
|---|---|---|---|---|
| **Subtipos** (inclusão) | Universal | Runtime (despacho dinâmico) | Comportamento varia por tipo concreto | `Notifier`, `EmailNotifier`/`SmsNotifier` |
| **Paramétrico** | Universal | Compile-time (tipo genérico `T`) | Comportamento **uniforme** para qualquer tipo | `firstOrNone[A]`, `largest[T <: Shape]` |
| **Sobrecarga** (overloading) | Ad-hoc | Compile-time (tipo estático do argumento) | Comportamento varia por tipo, implementações fixas e separadas | `max(Int,Int)` vs `max(String,String)` |
| **Coerção** | Ad-hoc | Compile-time (conversão implícita) | Adapta um tipo para "se passar" por outro | `Int` → `Double` |
| **Type classes** | Ad-hoc (estruturado) | Compile-time, via resolução de `given`/`using` | Comportamento varia por tipo, mas desacoplado dos dados | `Describable[A]`, `Area[A]`, `Ordering[T]` |

Ponto-chave para fixar a diferença mais sutil (subtipos vs. paramétrico vs. type classes): todos os três permitem que uma função opere sobre vários tipos, mas:
- **Subtipos**: o tipo precisa herdar de algo — acoplamento forte, extensão retroativa impossível.
- **Paramétrico**: a função não sabe nada sobre `T`, então o comportamento é sempre o mesmo.
- **Type classes**: junta o melhor dos dois — comportamento específico por tipo (como subtipos), mas sem herança e com extensibilidade retroativa (resolve o problema da expressão).
