package com.newproject.calculator.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.newproject.calculator.ui.theme.BG
import com.newproject.calculator.ui.theme.ButtonBGOp
import com.newproject.calculator.viewModel.CalculatorAction
import com.newproject.calculator.viewModel.CalculatorOperation
import com.newproject.calculator.viewModel.CalculatorViewModel

@Composable
fun MainScreen() {

    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Bottom
    ) {

        Column(
            Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .weight(0.3f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                fontSize = 38.sp,
                maxLines = 2,
                lineHeight = 35.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.End
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .weight(0.15f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiary),
                    onClick = {
                        viewModel.onAction(CalculatorAction.Clear)
                    }) {
                    Text(
                        text = "AC",
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Button(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.25f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiary),
                    onClick = {
                        viewModel.onAction(CalculatorAction.Delete)
                    }) {
                    Text(
                        text = "Del",
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "÷",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    })

            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .weight(0.15f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "7",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(7))

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "8",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(8))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "9",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(9))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "x",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    })
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .weight(0.15f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "4",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(4))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "5",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(5))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "6",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(6))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "-",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    })

            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .weight(0.15f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "1",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(1))
                    })

                Spacer(modifier = Modifier.width(15.dp))


                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "2",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(2))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "3",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(3))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "+",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    })

            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .weight(0.15f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CalcButton(modifier = Modifier.weight(0.5f),
                    text = "0",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Number(0))
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = ".",
                    bg = MaterialTheme.colorScheme.primary,
                    color = MaterialTheme.colorScheme.onPrimary,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Decimal)
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "=",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        viewModel.onAction(CalculatorAction.Calculate)
                    })
            }

            Spacer(modifier = Modifier.height(15.dp))
        }

    }

}

@Composable
fun CalcButton(
    modifier: Modifier, text: String, bg: Color, color: Color, onClick: () -> Unit
) {

    Button(modifier = modifier.fillMaxHeight(),
        colors = ButtonDefaults.buttonColors(containerColor = bg),
        onClick = {
            onClick()
        }) {

        Text(
            text = text, fontSize = 32.sp, color = color, fontWeight = FontWeight.Bold
        )
    }

}


@Preview
@Composable
private fun MainPreview() {
    MainScreen()
}