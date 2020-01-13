package org.example.ekspect.expectations

import org.example.ekspect.Context
import org.example.ekspect.Expectation

class Present<T : Any>(
    val expectedItems: () -> Iterable<T>,
    context: Context
) : Expectation<T>(context) {
    override fun check(actual: () -> T) {
        assert.includes(expectedItems(), actual)
    }
}
