package com.newproject.calculator

sealed class CalculatorOperation (val symbol : String){
    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Divide : CalculatorOperation("/")
    object Multiply : CalculatorOperation("x")

}