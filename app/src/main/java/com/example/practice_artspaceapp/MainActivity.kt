package com.example.practice_artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_artspaceapp.ui.theme.Practice_ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_ArtSpaceAppTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE8F3F3)) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

data class SpaceArtImage(
    val image: Int,
    val description: String,
    val artist: String,
    val year: Int)

val images = listOf(
    SpaceArtImage(
        R.drawable.forest,
        "Forest",
        "Mario",
        1994),
    SpaceArtImage(
        R.drawable.bakery,
        "Bakery",
        "Luca",
        1633),
    SpaceArtImage(
        R.drawable.sawmill,
        "Sawmill",
        "Alexialita",
        2000),
    SpaceArtImage(
        R.drawable.windmill,
        "Windmill",
        "Panda",
        1993)
)


@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    var imageId by remember { mutableIntStateOf(0) }
    val selectedImage = images[imageId]

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        ArtSpaceImage(image = selectedImage.image, description = selectedImage.description)
        Spacer(modifier = Modifier.height(128.dp))
        ImageInfo(
            Modifier
                .align(Alignment.CenterHorizontally)
                .background(Color.LightGray)
                .widthIn(64.dp, 320.dp),
            selectedImage
        )

        Spacer(modifier = Modifier.height(63.dp))
        NavigationButtons(previousOnClick =  {
            imageId--
            if(imageId < 0) imageId = images.lastIndex
        }, nextOnClick =  {
            imageId++
            if(imageId > images.lastIndex) imageId = 0
        })
    }
}

@Composable
fun ArtSpaceImage(modifier: Modifier = Modifier, image: Int, description: String){
    Box(modifier = modifier
        .background(Color.White)
        .wrapContentSize(Alignment.Center)
        .padding(20.dp)
    ){
        Image(
            painter = painterResource(image),
            contentDescription = description,
            modifier = Modifier.size(256.dp)
        )
    }
}

@Composable
fun ImageInfo(modifier: Modifier = Modifier, imageInfo: SpaceArtImage){
    Column(modifier = modifier.padding(20.dp)){
        Text(
            text = imageInfo.description,
            textAlign = TextAlign.Left,
        )
        Text(
            text = imageInfo.artist + " (${imageInfo.year})",
            textAlign = TextAlign.Left,
        )
    }
}

@Composable
fun NavigationButtons(
    modifier: Modifier = Modifier,
    previousOnClick: () -> Unit,
    nextOnClick: () -> Unit
){
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Button(onClick = previousOnClick) {
            Text(
                text = stringResource(R.string.previous)
            )
        }

        Button(onClick = nextOnClick) {
            Text(
                text = stringResource(R.string.next)
            )
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun ArtSpaceAppPreview(){
    Practice_ArtSpaceAppTheme {
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFFE8F3F3)
        ){
            ArtSpaceApp()
        }
    }
}