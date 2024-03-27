package com.newproject.calculator.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val name : String,
    val icon : ImageVector
) {
    object Home : NavigationItem("Home", Icons.Default.Home)
    object History : NavigationItem("History", Icons.Default.History)


}