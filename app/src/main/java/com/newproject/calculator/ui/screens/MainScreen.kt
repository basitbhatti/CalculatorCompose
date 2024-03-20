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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.newproject.calculator.ui.theme.BG
import com.newproject.calculator.ui.theme.ButtonBGClear
import com.newproject.calculator.ui.theme.ButtonBGNum
import com.newproject.calculator.ui.theme.ButtonBGOp
import com.newproject.calculator.ui.theme.TextColor

@Composable
fun MainScreen() {

    val context = LocalContext.current

    val (text, setText) = remember { mutableStateOf("") }

    var isOperatorInLast by remember {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(BG), verticalArrangement = Arrangement.Bottom
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
                text = text,
                fontSize = 38.sp,
                lineHeight = 35.sp,
                color = TextColor,
                textAlign = TextAlign.End
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(BG),
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
                    .weight(0.25f),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonBGClear),
                    onClick = {
                        setText("")
                    }) {
                    Text(
                        text = "AC",
                        fontSize = 22.sp,
                        color = TextColor,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "±",
                    bg = ButtonBGClear,
                    color = TextColor,
                    onClick = {

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "%",
                    bg = ButtonBGClear,
                    color = TextColor,
                    onClick = {

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "÷",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        if (isOperatorInLast) {
                            val newText =
                                text.substring(0, text.length - 1) + "÷" // Replace last char
                            setText(newText)
                        } else {
                            setText(text + "÷")
                        }
                        isOperatorInLast = true

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
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {

                        isOperatorInLast = false;
                        setText(text + "7")


                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "8",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        isOperatorInLast = false;
                        setText(text + "8")


                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "9",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        isOperatorInLast = false;
                        setText(text + "9")


                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "x",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        if (isOperatorInLast) {
                            val newText = text.substring(0, text.length - 1) + "x"
                            setText(newText)
                        } else {
                            setText(text + "x")
                        }
                        isOperatorInLast = true

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
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        isOperatorInLast = false
                        setText(text + "4")
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "5",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        setText(text + "5")

                        isOperatorInLast = false

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "6",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        setText(text + "6")

                        isOperatorInLast = false
                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "-",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        if (isOperatorInLast) {
                            val newText =
                                text.substring(0, text.length - 1) + "-" // Replace last char
                            setText(newText)
                        } else {
                            setText(text + "-")
                        }
                        isOperatorInLast = true

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
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        setText(text + "1")
                        isOperatorInLast = false

                    })

                Spacer(modifier = Modifier.width(15.dp))


                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "2",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        setText(text + "2")

                        isOperatorInLast = false

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "3",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        setText(text + "3")

                        isOperatorInLast = false

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "+",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {
                        if (isOperatorInLast) {
                            val newText =
                                text.substring(0, text.length - 1) + "+" // Replace last char
                            setText(newText)
                        } else {
                            setText(text + "+")
                        }
                        isOperatorInLast = true

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
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        setText(text + "0")

                        isOperatorInLast = false

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = ".",
                    bg = ButtonBGNum,
                    color = TextColor,
                    onClick = {
                        if (isOperatorInLast) {
                            val newText = text.substring(0, text.length - 1) + "."
                            setText(newText)
                        } else {
                            setText(text + ".")
                        }
                        isOperatorInLast = true

                    })

                Spacer(modifier = Modifier.width(15.dp))

                CalcButton(modifier = Modifier.weight(0.25f),
                    text = "=",
                    bg = ButtonBGOp,
                    color = BG,
                    onClick = {})
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