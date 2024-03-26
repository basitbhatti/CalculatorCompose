package com.newproject.calculator.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val BG = Color(0xFFF5F6F8)
val BG_DARK = Color(0xFF4C4D6B)

val ButtonBGNum = Color(0xFFE4E5E7)
val ButtonBGNumDark = Color(0xFF474866)

val ButtonBGClear = Color(0xFFD9D7EE)
val ButtonBGClearDark = Color(0xFF5D5C7C)

val TextColor = Color(0xFF5A5A66)
val TextColorDark = Color(0xFFF5F6F8)

val ButtonBGOp = Color(0xFF8E84CC)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


sealed class ThemeColors(
    val background : Color,
    val text : Color,
    val numberBg : Color,
    val clearBg : Color
) {

    object Dark : ThemeColors(
        background = BG_DARK,
        text = TextColorDark,
        numberBg = ButtonBGNumDark,
        clearBg = ButtonBGClearDark
    )

    object Light : ThemeColors(
        background = BG,
        text = TextColor,
        numberBg = ButtonBGNum,
        clearBg = ButtonBGClear
    )
}






