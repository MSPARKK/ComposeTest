package com.mspark.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mspark.composetest.ui.theme.ComposeTestTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsApp()
        }
    }
}


@Composable
fun SettingsApp() {
    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            TopBar(name = "세팅")
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(14.dp)
                )
            }

            Text(
                text = name,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .weight(1f)
            )
        }
    }

}


@Preview
@Composable
fun TopBarPreview() {
    TopBar("세팅")
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    SettingsApp()
}