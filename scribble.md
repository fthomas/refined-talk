simple refinement types
-----------------------
refinement types = types + (logical) predicates

refined base - ok
refined function ???

liquid haskell is only in comments

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
