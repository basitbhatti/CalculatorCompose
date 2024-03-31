package com.newproject.calculator.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.newproject.calculator.viewModel.CalculatorOperation

@Entity(tableName = "calculations_table")
data class Calculation(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val number1: String = "",
    val number2: String = "",
    val operation: String = "",
    val answer: String = ""
) {
}