package org.example.ekspect.expectations

import org.example.ekspect.Context
import org.example.ekspect.Expectation

class Increase(private val what: () -> Int, val context: Context) {
    fun by(delta: Int): IncreaseExpectation {
        return IncreaseExpectation(what, delta, context)
    }
}

class IncreaseExpectation(
    private val what: () -> Int,
    private val delta: Int,
    context: Context
) : Expectation<Unit>(context) {
    override fun check(actual: () -> Unit) {
        val beforeIncrease = what()
        actual.invoke()
        val afterIncrease = what()
        assert.equals(beforeIncrease + delta, afterIncrease)
    }
}
