package com.mspark.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mspark.composetest.ui.theme.ComposeTestTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListApp()
        }
    }
}

@Composable
fun ListApp() {
    val myBlue = Color(0xFF_0000FF)

    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = myBlue
        ) {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ListApp()
}