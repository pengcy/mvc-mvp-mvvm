package com.example.mvcmvpmvvm.model

enum class Player {
    X, O;

    override fun toString(): String {
        when(this) {
            X -> return "X"
            O -> return "O"
            else -> return super.toString()
        }
    }
}
