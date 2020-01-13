package org.example.ekspect.expectations

import org.example.ekspect.Context
import org.example.ekspect.Expectation

class Be<T : Any>(private val expectedValue: T, context: Context) : Expectation<T>(context) {
    override fun check(actual: () -> T) {
        val actualValue = actual()
        assert.equals(expectedValue, actualValue)
    }
}
