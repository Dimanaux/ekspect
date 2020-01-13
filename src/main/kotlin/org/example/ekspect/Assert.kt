package org.example.ekspect

import kotlin.reflect.KClass

class Assert(private val context: Context) {
    fun equals(expected: Any, actual: Any) {
        if (expected != actual) {
            context.fail("Expected $expected, but got $actual.")
        }
    }

    fun <T : Any> instanceOf(kClass: KClass<T>, obj: Any?) {
        if (!kClass.java.isInstance(obj)) {
            context.fail(
                "Expected a ${kClass.java} instance, instead got '$obj'" +
                        (if (obj != null) " of ${obj.javaClass} type." else ".")
            )
        }
    }

    fun <T : Any> includes(expectedItems: Iterable<T>, actual: T) {
        expectedItems.forEach {
            if (it == actual) return
        }
        context.fail("Expected $actual to be in $expectedItems.")
    }
}
