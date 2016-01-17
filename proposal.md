* title: Decorate your types with refined
* length: 30 minutes
* target audience: advanced

Scala has a powerful type system that allows to create very expressive
types. But sometimes we need guarantees about our values beyond what the
type system can usually check, for example integers in the range from
zero to fifty-nine, or chars that are either a letter or a digit. One
way to realize these constraints is known as *smart constructors* where
the construction mechanism validates at runtime that our values satisfy
the constraint. Unfortunately this technique requires some boilerplate
and always incur runtime checks even if the values are kown at
compile-time.

This talk will introduce [refined](https://github.com/fthomas/refined),
a library for refining types with type-level predicates, which abstracts
over smart constructors. We'll go from the idea of refinement types to
examples of the library using the rich set of predicates it provides,
and show how it can be used at compile- and runtime alike. On that way
we'll see how we can make use of literal-based singleton types as
described in [SIP-23](http://docs.scala-lang.org/sips/pending/42.type.html).
I'll also demonstrate how refined integrates with other libraries like
[circe](https://github.com/travisbrown/circe),
[Monocle](https://github.com/julien-truffaut/Monocle),
or [scodec](http://scodec.org/).
