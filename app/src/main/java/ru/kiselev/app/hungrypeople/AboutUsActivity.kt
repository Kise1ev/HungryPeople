package ru.kiselev.app.hungrypeople

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AboutUsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AboutUsScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AboutUsScreen() {
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp + 50.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AboutUsSection(screenHeight)
            SpecialitySection(screenHeight)
        }
    }

    @Composable
    fun AboutUsSection(screenHeight: Dp) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .height(screenHeight),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconWithText(
                    imageResId = R.drawable.ic_anchor,
                    text = "ABOUT US",
                    fontSize = 60,
                    textColor = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                ColoredBox()
                Spacer(modifier = Modifier.height(20.dp))
                BodyText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at velit maximus, molestie est a, tempor magna.", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                BodyText("Integer ullamcorper neque eu purus euismod, ac faucibus mauris posuere. Morbi non ultrices ligula. Sed dictum, enim sed ullamcorper feugiat, dui odio vehicula eros, a sollicitudin lorem quam nec sem. Mauris tincidunt feugiat diam convallis pharetra. Nulla facilisis semper laoreet.")
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.img_about),
                    contentDescription = "About Us Container Image",
                    modifier = Modifier.size(400.dp)
                )
            }
        }
    }

    @Composable
    fun SpecialitySection(screenHeight: Dp) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(screenHeight)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_speciality),
                contentDescription = "Speciality Container Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconWithText(
                        imageResId = 0,
                        text = "MASTER CHIEF",
                        fontSize = 60,
                        textColor = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    ColoredBox()
                    Spacer(modifier = Modifier.height(20.dp))
                    BodyText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at velit maximus, molestie est a, tempor magna.", textColor = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    BodyText("Integer ullamcorper neque eu purus euismod, ac faucibus mauris posuere. Morbi non ultrices ligula. Sed dictum, enim sed ullamcorper feugiat, dui odio vehicula eros, a sollicitudin lorem quam nec sem. Mauris tincidunt feugiat diam convallis pharetra. Nulla facilisis semper laoreet.", textColor = Color.White)
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img_master_chief),
                        contentDescription = "Master Chief Container Image",
                        modifier = Modifier.size(400.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun BodyText(text: String, textColor: Color = Color.Black, fontWeight: FontWeight = FontWeight.Normal) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = fontWeight,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = textColor
        )
    }

    @Composable
    fun ColoredBox() {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(10.dp)
                .clip(RoundedCornerShape(50))
                .background(colorResource(id = R.color.bright_yellow))
        )
    }

    @Composable
    fun IconWithText(imageResId: Int, text: String, fontSize: Int, textColor: Color) {
        if (imageResId != 0) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Icon",
                modifier = Modifier.size(150.dp)
            )
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = fontSize.sp,
            fontFamily = FontFamily(Font(R.font.tenorsans_regular)),
            color = textColor
        )
    }
}