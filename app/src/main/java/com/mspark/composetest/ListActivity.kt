package com.mspark.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
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

//    val names: List<String> = listOf("World", "Compose", "한서", "한이", "마음을 담아")
    val testDataList: List<TestData> = listOf(
        TestData("Kobe","https://hips.hearstapps.com/hmg-prod/images/gettyimages-159141331-1580077058.jpg?crop=0.5446666666666666xw:1xh;center,top&resize=1200:*"),
        TestData("Lebron", "https://media.cnn.com/api/v1/images/stellar/prod/230523093708-01-lebron-james-052223.jpg?c=9x16"),
        TestData("Wembanyama", "https://s.hdnux.com/photos/01/33/70/11/24085095/3/1200x0.jpg"),
        TestData("Sochan", "https://images2.minutemediacdn.com/image/upload/c_crop,w_4656,h_2619,x_0,y_41/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/29/01gr2smda6b9877kawpt.jpg"),
        TestData("Pop", "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iKq.WwqakWoQ/v2/1200x-1.jpg")
    )

    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.onBackground
        ) {

            Column(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                for (testData in testDataList) {
                    Greeting(testData = testData)
                }
            }
        }
    }


}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun Greeting(testData: TestData) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(62.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(data = testData.imageUrl),
                    contentDescription = "My image description",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
//                        .clip(
//                            CutCornerShape(
//                                topStart = 4.dp,
//                                topEnd = 8.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 8.dp
//                            )
//                        )
                        .border(1.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }
            
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)) {
                Text(text = "Hello,")
                Text(text = testData.name)
            }
        } 
       
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ListApp()
}

data class TestData(
    val name: String,
    val imageUrl: String
)