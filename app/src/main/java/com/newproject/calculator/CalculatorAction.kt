package com.newproject.calculator

sealed class CalculatorAction() {

    data class Number (val number : Int) : CalculatorAction()

    object Clear : CalculatorAction()

    object Decimal : CalculatorAction()

    object Delete : CalculatorAction()

    object Calculate : CalculatorAction()

    data class Operation (val operation: CalculatorOperation) : CalculatorAction()

}