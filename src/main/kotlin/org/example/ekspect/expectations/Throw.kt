package org.example.ekspect.expectations

import org.example.ekspect.Context
import org.example.ekspect.Expectation
import kotlin.reflect.KClass

class Throw<T : Throwable>(
    private val errorType: KClass<T>,
    context: Context
) : Expectation<Unit>(context) {
    override fun check(actual: () -> Unit) {
        var error: Throwable? = null
        try {
            actual()
        } catch (e: Throwable) {
            error = e
        }
        assert.instanceOf(errorType, error)
    }
}
