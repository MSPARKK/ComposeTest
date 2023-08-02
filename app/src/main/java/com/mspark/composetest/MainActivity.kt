package com.mspark.composetest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mspark.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}



@Composable
fun MainApp() {
    val myRed = Color(0xFF_FF0000)

    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = myRed
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Greeting("Android Android Android Android")
                    SetButton("버튼 버튼")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
//        Text(text = "Hello $name!")
//        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        Text(
            text = "Hello $name!",
//            style = MaterialTheme.typography.h6,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.Bold
            ),  // 커스텀 텍스트 스타일
            modifier = Modifier.padding(32.dp)
        )
    }

}

@Composable
fun SetButton(text: String) {
    val context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, "버튼 클릭!", Toast.LENGTH_SHORT).show()
        context.startActivity(Intent(context, ListActivity::class.java))
        // todo : StartActivityForResult
    }) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MainApp()
}