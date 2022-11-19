package com.withjetpack.imagecardwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.withjetpack.imagecardwithjetpackcompose.ui.theme.ImageCardWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageCardWithJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                val painter = painterResource(id = R.drawable.image)
                val title = "ImageCard"
                val description = "This is sunflower"
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp)
                ) {
                    ImageCard(painter = painter, contentDescription = description, title = title)
                }
            }
        }
    }


}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {

    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(5.dp), elevation = 5.dp) {
        Box(modifier = Modifier.height(125.dp)) {

            Image(
                painter = painter,
                contentDescription = null
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 100f
                        )
                    )
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.BottomStart
            ) {
                Column() {
                    Text(title, style = TextStyle(color = Color.White))
                    Text(contentDescription, style = TextStyle(color = Color.White))
                }

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageCardWithJetpackComposeTheme {

    }
}