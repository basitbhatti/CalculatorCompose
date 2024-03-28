package com.newproject.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.newproject.calculator.navigation.NavigationItem
import com.newproject.calculator.room.CalculationDatabase
import com.newproject.calculator.ui.screens.HistoryScreen
import com.newproject.calculator.ui.screens.MainScreen
import com.newproject.calculator.ui.theme.CalculatorTheme
import com.newproject.calculator.viewModel.CalculatorViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            CalculationDatabase::class.java,
            "calculations.db"
        ).build()
    }

    private val viewModel by viewModels<CalculatorViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CalculatorViewModel(db.dao) as T
                }
            }
        }
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalculatorTheme {

                val list = listOf(
                    NavigationItem.Home, NavigationItem.History
                )
                Column(modifier = Modifier.fillMaxSize()) {

                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background),
                    ) {
                        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                        var selectedIndex by rememberSaveable {
                            mutableStateOf(0)
                        }

                        val scope = rememberCoroutineScope()

                        ModalNavigationDrawer(
                            drawerContent = {
                                ModalDrawerSheet {
                                    list.forEachIndexed { index, item ->
                                        NavigationDrawerItem(
                                            label = { Text(text = item.name) },
                                            selected = index == selectedIndex,
                                            onClick = {
                                                selectedIndex = index
                                                scope.launch {
                                                    drawerState.close()
                                                }
                                            },
                                            icon = {
                                                Icon(
                                                    imageVector = item.icon,
                                                    contentDescription = item.name
                                                )
                                            },
                                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                        )
                                    }
                                }
                            }, drawerState = drawerState
                        ) {

                            Scaffold(topBar = {
                                TopAppBar(title = { Text(text = "Calculator") }, navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Menu"
                                        )
                                    }
                                })
                            }) {
                                if (selectedIndex == 0) {
                                    MainScreen(viewModel = viewModel)
                                } else if (selectedIndex == 1) {
                                    HistoryScreen(viewModel)
                                }

                            }
                        }


                    }

                }

            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPrev() {
}