package org.example.ekspect

fun main() {
    val context = Context("Examples") {
        val v = Var(20)

        describe("holds given value") {
            expect { v.value } to be(20)
        }
        describe("increments value") {
            expect { v.increment() } to increase { v.value }.by(1)
        }
        describe("division by 0") {
            expect { v.divide(0) } to throwError<ArithmeticException>()
        }
        describe("list") {
            expect { 1 } to presentIn { listOf(1, 2, 3) }
        }

    }
    println(context.toJson())
}

data class Var(var value: Int) {
    fun increment() {
        value += 0
    }

    fun divide(by: Int) {
        value /= by
    }
}
