package org.example.ekspect


abstract class Expectation<T : Any>(val context: Context) {
    abstract fun check(actual: () -> T)

    val assert: Assert
        get() = Assert(context)
}
