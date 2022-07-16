package com.example.allinoneapppractise.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.allinoneapppractise.compose.ui.theme.AllInOneAppPractiseTheme

class ComposeStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*AllInOneAppPractiseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }*/
            AllInOneAppPractiseTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var count by remember { mutableStateOf(0) }
                    MyButton(count) {
                        count = it + 1
                    }
                }
            }

        }
    }
}

/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AllInOneAppPractiseTheme {
        Greeting("Android")
    }
}*/

@Composable
fun MyButton(currentCount: Int, updateCount: (Int) -> Unit) {
    val context = LocalContext.current
    Button(
        onClick = {
            updateCount(currentCount)
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(width = 1.dp, color = Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = DarkGray,
            contentColor = White
        ),
    )
    {
        Text(
            "Count is $currentCount",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp)
        )

    }
}
