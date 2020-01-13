package org.example.ekspect

fun Context.toJson(): String {
    val childrenJson = children.map(Context::toJson).joinToString(",")
    return """{"description":"$description","status":"$status","error":"$error","children":[$childrenJson]}"""
}
