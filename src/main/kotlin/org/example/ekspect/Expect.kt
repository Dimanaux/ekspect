package org.example.ekspect

class Expect<T : Any>(
    private val context: Context,
    private val actual: () -> T
) {
    infix fun to(expectation: Expectation<T>) {
        expectation.check(actual)
    }

    infix fun toBe(expectation: Expectation<T>) = to(expectation)

    infix fun to(expectation: Any) {
        throw NotImplementedError(
            "Use only expectation object with `to`. " +
                    "This was called with ${expectation.javaClass}"
        )
    }
}
