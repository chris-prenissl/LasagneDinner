package com.dinner.lasagnedinner.domain.model

open class Ingredient<T : Number>(
    open val title: String,
    open val value: T,
)
