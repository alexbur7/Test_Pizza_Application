package com.example.testpizzaapplication.presentation.menu.entity

import androidx.annotation.StringRes

data class TypeEntity(
    var isActivated: Boolean = false,
    @StringRes
    val textId: Int
)
