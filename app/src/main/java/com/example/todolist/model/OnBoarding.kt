package com.example.todolist.model

import java.io.Serializable

data class OnBoarding(
    val image : String,
    val title : String,
    val desc : String
) : Serializable