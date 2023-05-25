package com.raywenderlich.android.lab1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.lab1.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Modifier
import com.raywenderlich.android.lab1.router.BackButtonHandler
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.raywenderlich.android.lab1.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()

        BackButtonHandler {
            FundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}

@Composable
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue)),
        border = BorderStroke(
            1.dp,
            colorResource(id = R.color.black)
        )
    ) {
        Text(
            text = stringResource(id = R.string.set_button),
            color = Color.White
        )
    }
}

@Composable
fun MyRadioGroup() {
    val radioButtons  = listOf(0,1,2,3) // 1

    val selectedButton = remember { mutableStateOf(radioButtons.first()) } // 2

    Column {
        radioButtons.forEach {index -> // 3
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors( // 4
                selectedColor = colorResource(id = R.color.blue),
                unselectedColor = colorResource(id = R.color.black),
                disabledColor = Color.LightGray
            )

            RadioButton(
                colors = colors,
                selected = isSelected,
                onClick = {
                    selectedButton.value = index // 6
                }
            )
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = colorResource(id = R.color.blue),
        contentColor = Color.White,
        content = {
            Icon(Icons.Filled.Call, contentDescription = "Test FAB")
        }
    )
}