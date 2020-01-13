package org.example.ekspect

import org.example.ekspect.expectations.Be
import org.example.ekspect.expectations.Increase
import org.example.ekspect.expectations.Present
import org.example.ekspect.expectations.Throw

fun <T : Any> Context.expect(what: () -> T) = Expect(this, what)

fun <T : Any> Context.expect(what: T) = Expect(this) { what }

fun Context.describe(description: String, actions: Context.() -> Unit) =
    this.context(description, actions)


fun <T : Any> Context.be(expectedValue: T) = Be(expectedValue, this)

inline fun <reified E : Throwable> Context.throwError() = Throw(E::class, this)

fun Context.increase(what: () -> Int) = Increase(what, this)

fun <T : Any> Context.presentIn(items: () -> Iterable<T>) = Present(items, this)
