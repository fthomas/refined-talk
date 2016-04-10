simple refinement types
-----------------------
refinement types = types + (logical) predicates

refined base - ok
refined function ???

liquid haskell is only in comments

---
implementation:
* type `Refined[T, P]` that wraps a value of type `T` and associates the predicate `P` with the base type
* type level predicates like `Letter`, `Greater[_]`, `And[_,_]`
* type class Validate[T, P] 

----

beispiel für refined

type Nat = Int Refined Greater[W.`0`.T]

val xs: List[Nat] = List(1, 2, 3)
xs = List(1,2,3)


List(-1, -2)

---

refinement typechecking

how does it work?

predicate subtyping

---

refined input and output types -- show examples

example safeDiv with user inputs

avg function with nonempty lists

---

type NonEmptyList = List Refined Size[Positive]


---

"make illegal states unrepresentable"

http://stackoverflow.com/questions/35903100/what-does-t-do-in-scala

---

Datenmodellierung
- Wir bauen unsere Datentypen aus Primitiven & Strings, vorgegebenen
  Datenstrukturen, oder Kombination von eigenen Datentypen zusammen
- Wenn wir Int, String oder Double nehmen, dann gibt es viel viel mehr
  Zustände als in unserer Domain eigentlich sinnvoll ist

Smart constructors 2
- Vorteile we can only create valid HexStrings with this constructor
- Nachteile: Wiederholungen, keine Literale (auch wenn zur Compilezeit
  feststeht, dass es ein valider HexString ist, wird die Validierung
 zur Laufzeit wiederholt)

Refinement Types:
- Idee: wir haben einen Basis-Type der mit einem  Prädikat auf Typebene
  angereichert wird
- alle Werte dieses verfeinerten Typen genügem dem Prädikat
- die runtime repräsentation entspricht immer noch dem base type
- subtyping relations T <: (T @@ P) und (T @@ P) <: (T @@ Q)
  if forall x P(X) == true => Q(x) == true

refined the library:
- implements refinement types
- uses macro for validating literals at compile time
- uses macro for implementing refinement subtyping
- provides a wealth of type-level predicate that can be combined
  to express sophisticated predicates
