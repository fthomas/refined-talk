* title: Decorate your types with refined
* length: 30 minutes
* target audience: advanced

Scala has a powerful type system that allows to create very expressive
types. But sometimes we just want to have simple types with an additional
constraint, like an integer in the range from zero to fifty-nine, or a
string that is at least *n* characters long, or a char that is either a
letter or a digit. One way to realize these constraints is known as
*smart constructors* where the construction mechanism validates at
runtime that our value satisfies the constraint. Unfortunately smart
constructors require some boilerplate and always incur a runtime check
even if the value is known at compile-time.

This talk will introduce [refined](https://github.com/fthomas/refined),
a library for refining types with type-level predicates, which abstracts
over smart constructors. We'll go from the idea of refinement types to
examples of the library using the rich set of predicates it provides,
and show how it can be used at compile- and runtime alike. I'll also
demonstrate how refined integrates with other libraries like
[circe](https://github.com/travisbrown/circe),
[Monocle](https://github.com/julien-truffaut/Monocle),
or [scodec](http://scodec.org/).
