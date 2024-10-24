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


@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
        Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            ArtSpaceImage()
            Spacer(modifier = Modifier.height(128.dp))
            ImageInfo(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray)
                    .widthIn(64.dp, 320.dp)
            )

            Spacer(modifier = Modifier.height(63.dp))
            NavigationButtons(previousOnClick =  {}, nextOnClick =  {})
        }
}

@Composable
fun ArtSpaceImage(modifier: Modifier = Modifier){
    Box(modifier = modifier
        .background(Color.White)
        .wrapContentSize(Alignment.Center)
        .padding(20.dp)
    ){
        Image(
            painter = painterResource(R.drawable.forest),
            contentDescription = null,
            modifier = Modifier.size(256.dp)
        )
    }
}

@Composable
fun ImageInfo(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(20.dp)){
        Text(
            text = "Arbolitos arbolitos arbolitos",
            textAlign = TextAlign.Left,
        )
        Text(
            text = "Artist",
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