# Scala supports the following three kinds of Variance.

1. Covariant
2. Invariant
3. Contravariant

# Covariant in Scala
1.   If “S” is subtype of “T” then List[S] is is a subtype of List[T].
1.   To represent Covariance relationship between two Parameterized Types, Scala uses the following syntax:
     Prefixing Type Parameter with “+” symbol defines Covariance in Scala.
# Contravariant IN Scala


# Invarient
If “S” is subtype of “T” then List[S] and List[T] don’t have Inheritance Relationship or Sub-Typing. That means both are unrelated.

This kind of Relationship between two Parameterized Types is known as “Invariant or Non-Variant”
In Scala, by default Generic Types have Non-Variant relationship. If we define Parameterized Types without using “+’ or “-” symbols, then they are known as Invariants.

# Variance Summary

|  Scala Variance Type	|    Syntax   |  Description |
| --------------------- | ----------- | -------------------------------- |
| Covariant | [+T] | If S is subtype of T, then List[S] is also subtype of List[T] |
| Contravariant | [-T] | If S is subtype of T, then List[T] is also subtype of List[S] |
| Invariant | [T] | If S is subtype of T, then List[S] and List[T] are unrelated. |

