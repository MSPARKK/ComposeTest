package com.mspark.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

    val testDataList: List<TestData> = listOf(
        TestData("Kobe","https://hips.hearstapps.com/hmg-prod/images/gettyimages-159141331-1580077058.jpg?crop=0.5446666666666666xw:1xh;center,top&resize=1200:*"),
        TestData("Lebron", "https://media.cnn.com/api/v1/images/stellar/prod/230523093708-01-lebron-james-052223.jpg?c=9x16"),
        TestData("Wembanyama", "https://s.hdnux.com/photos/01/33/70/11/24085095/3/1200x0.jpg"),
        TestData("Sochan", "https://images2.minutemediacdn.com/image/upload/c_crop,w_4656,h_2619,x_0,y_41/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/29/01gr2smda6b9877kawpt.jpg"),
        TestData("Pop", "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iKq.WwqakWoQ/v2/1200x-1.jpg"),

        TestData("Kobe","https://hips.hearstapps.com/hmg-prod/images/gettyimages-159141331-1580077058.jpg?crop=0.5446666666666666xw:1xh;center,top&resize=1200:*"),
        TestData("Lebron", "https://media.cnn.com/api/v1/images/stellar/prod/230523093708-01-lebron-james-052223.jpg?c=9x16"),
        TestData("Wembanyama", "https://s.hdnux.com/photos/01/33/70/11/24085095/3/1200x0.jpg"),
        TestData("Sochan", "https://images2.minutemediacdn.com/image/upload/c_crop,w_4656,h_2619,x_0,y_41/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/29/01gr2smda6b9877kawpt.jpg"),
        TestData("Pop", "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iKq.WwqakWoQ/v2/1200x-1.jpg"),

        TestData("Kobe","https://hips.hearstapps.com/hmg-prod/images/gettyimages-159141331-1580077058.jpg?crop=0.5446666666666666xw:1xh;center,top&resize=1200:*"),
        TestData("Lebron", "https://media.cnn.com/api/v1/images/stellar/prod/230523093708-01-lebron-james-052223.jpg?c=9x16"),
        TestData("Wembanyama", "https://s.hdnux.com/photos/01/33/70/11/24085095/3/1200x0.jpg"),
        TestData("Sochan", "https://images2.minutemediacdn.com/image/upload/c_crop,w_4656,h_2619,x_0,y_41/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/29/01gr2smda6b9877kawpt.jpg"),
        TestData("Pop", "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iKq.WwqakWoQ/v2/1200x-1.jpg"),

        TestData("Kobe","https://hips.hearstapps.com/hmg-prod/images/gettyimages-159141331-1580077058.jpg?crop=0.5446666666666666xw:1xh;center,top&resize=1200:*"),
        TestData("Lebron", "https://media.cnn.com/api/v1/images/stellar/prod/230523093708-01-lebron-james-052223.jpg?c=9x16"),
        TestData("Wembanyama", "https://s.hdnux.com/photos/01/33/70/11/24085095/3/1200x0.jpg"),
        TestData("Sochan", "https://images2.minutemediacdn.com/image/upload/c_crop,w_4656,h_2619,x_0,y_41/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/images/GettyImages/mmsport/29/01gr2smda6b9877kawpt.jpg"),
        TestData("Pop", "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iKq.WwqakWoQ/v2/1200x-1.jpg")
    )

    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {

            LazyColumn(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                items(testDataList) { testData ->
                    Greeting(testData = testData)
                }
            }
        }
    }


}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun Greeting(testData: TestData) {
    val expanded = rememberSaveable { mutableStateOf(false) }

    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(16.dp)
            )
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)), // 그림자가 안생기는 거 같다?
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(62.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(data = testData.imageUrl),
                        contentDescription = "My image description",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .border(1.dp, Color.Black, CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(modifier = Modifier
                    .weight(1f)
                    .padding(24.dp)
                ) {
                    Text(text = "Hello,", color = Color.Black)
                    Text(text = testData.name, color = Color.Black)
                }


                Box(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(60.dp)
                ) {
                    IconButton(onClick = {
                        expanded.value = !expanded.value
                    }) {
                        Icon(
                            imageVector = if (expanded.value) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(14.dp)
                        )
                    }
                }

            }

            AnimatedVisibility(
                visible = expanded.value,
            ) {
                Text(
                    text = testData.detail,
                    modifier = Modifier.padding(
                        top = 6.dp,
                        bottom = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
                )
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
    val imageUrl: String,
    val detail: String = "어쩌구 저쩌구 블라블라 Jetpack Compose로\n" +
            "더 빠르게 더 나은 Android 앱 빌드\n" +
            "Jetpack Compose는 네이티브 UI를 빌드하기 위한 Android의 최신 권장 도구 키트입니다. Jetpack Compose는 Android에서의 UI 개발을 간소화하고 가속화합니다. 간단한 코드, 강력한 도구, 직관적인 Kotlin API를 사용하여 앱을 빠르고 생동감 있게 구현하세요.\n 직관적\n" +
            "Compose는 선언적 API를 사용합니다. 즉, Compose가 나머지를 처리하므로 UI를 설명하기만 하면 됩니다. API는 직관적이므로 찾아서 사용하기가 쉽습니다. \"테마 레이어가 훨씬 더 직관적이고 읽기 쉽습니다. 멀티 레이어 테마 오버레이를 통해 속성을 정의하고 할당하는 여러 XML 파일로 확장해야 했을 일을 단일한 Kotlin 파일 내에서 달성할 수 있었습니다.” (Twitter)\n" +
            "\n" +
            "Compose를 사용하면 특정 활동이나 프래그먼트에 종속되지 않는 작은 스테이트리스(Stateless) 구성요소를 빌드합니다. 이를 통해 재사용하고 테스트하기가 쉬워집니다. \"사용 및 유지관리가 쉽고 구현/확장/맞춤설정이 직관적인 스테이트리스 UI 구성요소의 새로운 세트를 제공하겠다는 목표를 세웠습니다. Compose는 이를 위한 좋은 해답이었습니다.” (Twitter)\n" +
            "\n" +
            "Compose에서는 상태가 명시적이며 컴포저블로 전달됩니다. 이렇게 하면 상태에 관한 정보 출처가 하나이므로 캡슐화되고 분리됩니다. 그런 다음 앱 상태가 변경되면 UI가 자동으로 업데이트됩니다. “추론하는 동안 기억해야 하는 사항이 줄어들고 통제를 벗어나거나 제대로 이해하지 못하는 행동도 적어집니다.” (Cuvva)"
)