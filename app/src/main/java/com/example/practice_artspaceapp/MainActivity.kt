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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_artspaceapp.ui.theme.Practice_ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_ArtSpaceAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    Box(modifier = modifier.wrapContentSize(Alignment.Center)){
        ArtSpaceImage()
    }
}

@Composable
fun ArtSpaceImage(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(20.dp)
        .background(Color.White
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.forest),
            contentDescription = null,
            modifier = Modifier.padding(20.dp).size(256.dp)
        )
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