package com.newproject.calculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.newproject.calculator.room.Calculation
import com.newproject.calculator.viewModel.CalculatorViewModel

@Composable
fun HistoryScreen(viewModel: CalculatorViewModel) {

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "This screen is not completed yet.")

//        scope.launch {
//            if (viewModel.list() != null){
//                val calc = viewModel.list().get(0)
//                Log.d("TAGDBB", "${calc.number1} ${calc.operation} ${calc.number2}")
//            }
//
//        }
    }
}

@Composable
fun HistoryItem(
    calculation: Calculation
) {

    val isExpanded by remember {
        mutableStateOf(false)
    }

    Card(
        shape = RoundedCornerShape(10.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(15.dp)
            )
            Text(
                text = calculation.number1 + calculation.operation.toString() + calculation.number2,
                fontSize = 18.sp,
                color = Color.Black
            )

        }


    }

}