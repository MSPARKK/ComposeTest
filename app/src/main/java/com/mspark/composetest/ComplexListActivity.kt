package com.mspark.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mspark.composetest.ui.theme.ComposeTestTheme

class ComplexListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComplexListScreen()
        }
    }
}

@Composable
fun ComplexListScreen() {
    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            TeamRow()
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}


@Composable
fun TeamElement(
    name: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = name,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 24.dp, bottom = 8.dp
                )
                .width(150.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

        )
    }
}


@Composable
fun PlayerElement(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .width(192.dp)
            .height(56.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = "https://play-lh.googleusercontent.com/6uGXtLSAcjhTevejcyHTFPGFTXybtkjezJhnla8jUfxMAdoTMPpyxrdwrNJmLJGQRw=w480-h960-rw"),
            contentDescription = null,
            modifier = Modifier
                .size(56.dp)
                .border(1.dp, Color.Black),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "hi",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .align(CenterVertically)
                .padding(6.dp)

        )
    }
}

@Composable
fun TeamRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
    ) {

        items(getTeamData()) { item ->
            TeamElement(item.name, item.imageUrl)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComplexListPreView() {
    ComplexListScreen()
}


@Preview()
@Composable
fun SearchBarPreview() {
    SearchBar()
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TeamElementPreview() {
    TeamElement("테스트 팀", "")
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PlayerElementPreview() {
    PlayerElement()
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TeamRowPreview() {
    TeamRow()
}

private fun getTeamData(): List<Teamdata> {
    return listOf(
        Teamdata(
            name = "San Antonio Spurs",
            imageUrl = "https://yt3.googleusercontent.com/44J4s0uHKThUIFJPZuiaDbg8aL9e5tMQlG2GSvQbKynEvUPbeDXrFYkKcLaf6p__F-7iNjk3=s900-c-k-c0x00ffffff-no-rj"
        ),
        Teamdata(
            name = "LA Lakers",
            imageUrl = "https://m.media-amazon.com/images/M/MV5BMTNiMTRmOTgtMmNmMC00NDU5LWI0N2ItNzljNDA4Y2E5NGRjXkEyXkFqcGdeQXVyNTAyMjQyMDE@._V1_.jpg"
        ),
        Teamdata(
            name = "LA Clippers",
            imageUrl = "https://content.sportslogos.net/news/2019/07/los-angeles-clippers-logo.png"
        ),
        Teamdata(
            name = "Maiami Heat",
            imageUrl = "https://cdn.nba.com/teams/static/heat/imgs/global/social-og/miami-heat-logo.jpg"
        ),
        Teamdata(
            name = "Boston Celtics",
            imageUrl = "https://yt3.googleusercontent.com/kUSYdmbDFsc5UPiCdvSMC64WBIyRgQUG6Kmobo2ItTBz-IvJPI3POduVqI_3aj88ydPvVU0Xc9k=s900-c-k-c0x00ffffff-no-rj"
        ),Teamdata(
            name = "Cicago Bulls",
            imageUrl = "https://cdn.nba.com/teams/uploads/sites/1610612741/2023/07/16x9_.png"
        ),
        Teamdata(
            name = "New York Knicks",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhBToWKRkYKhySHbugShQp2yMThwy51qxkxQ&usqp=CAU"
        ),
        Teamdata(
            name = "Golden State Warriors",
            imageUrl = "https://imageio.forbes.com/i-forbesimg/media/lists/teams/golden-state-warriors_416x416.jpg?format=jpg"
        ),

    )
}

data class Teamdata(
    val name: String,
    val imageUrl: String
)
