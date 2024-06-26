package com.newproject.calculator.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newproject.calculator.room.Calculation
import com.newproject.calculator.room.CalculationDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CalculatorViewModel(
    val dao: CalculationDao
) : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

//    suspend fun list(): List<Calculation> {
//        return withContext(Dispatchers.IO) {
//            dao.getCalculations()
//        }
//    }

    private val _calculations = mutableStateOf<List<Calculation>>(emptyList())
    val calculations: State<List<Calculation>> = _calculations

    // Your existing suspend function
    suspend fun list(): List<Calculation> {
        return withContext(Dispatchers.IO) {
            dao.getCalculations()
        }
    }

    // Function to fetch and update the calculations
    fun fetchCalculations() {
        viewModelScope.launch {
            _calculations.value = list() // Use your suspend function here
        }
    }

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (state.operation) {

                is CalculatorOperation.Add -> number1 + number2

                is CalculatorOperation.Subtract -> number1 - number2

                is CalculatorOperation.Multiply -> number1 * number2

                is CalculatorOperation.Divide -> number1 / number2

                null -> return
            }

            val calculation = Calculation(
                number1 = number1.toString(),
                number2 = number2.toString(),
                operation = state.operation!!.symbol,
                answer = result.toString()
            )

            viewModelScope.launch {
                Log.d(
                    "InsertingCalc",
                    calculation.number1 + calculation.operation + calculation.number2
                )
                dao.upsert(calculation)
            }

            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )


        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation != null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
            return
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {

            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }

            state = state.copy(
                number1 = state.number1 + number
            )

            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }

        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}