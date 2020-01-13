package org.example.ekspect

class Context(
    val description: String,
    actions: Context.() -> Unit
) {
    var status = "passed"
    var error: String = ""
    val children = mutableListOf<Context>()

    init {
        actions()
    }

    fun context(description: String, actions: Context.() -> Unit): Context {
        return Context(description, actions).also { children.add(it) }
    }

    fun fail(errorMessage: String) {
        status = "failed"
        error = errorMessage
    }
}
