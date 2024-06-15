package ru.kiselev.app.hungrypeople

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            HomeScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun HomeScreen() {
        val context = LocalContext.current

        Image(
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(50.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_anchor),
                    contentDescription = "Anchor Icon",
                    modifier = Modifier
                        .size(170.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "RESTAURANT",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular))
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "HUNGRY",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 80.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular))
                )

                Text(
                    text = "PEOPLE",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 80.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular))
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(10.dp)
                        .clip(RoundedCornerShape(50))
                        .background(colorResource(id = R.color.bright_yellow))
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Mon - Fri: 8PM - 10PM",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular))
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Sat - Sun: 8PM - 3AM",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular))
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.bright_yellow)),
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .size(width = 200.dp, height = 60.dp)) {
                        Text(
                            text = "BOOK TABLE",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(2.dp, Color.White),
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .size(width = 200.dp, height = 60.dp)) {
                        Text(
                            text = "EXPLORE",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btn_facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp)
                    )

                    Spacer(modifier = Modifier.width(60.dp))

                    Image(
                        painter = painterResource(id = R.drawable.btn_twitter),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp)
                    )

                    Spacer(modifier = Modifier.width(60.dp))

                    Image(
                        painter = painterResource(id = R.drawable.btn_instagram),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = R.drawable.btn_down),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(onPress = {
                                context.startActivity(Intent(context, AboutUsActivity::class.java))
                            })
                        }
                )
            }
        }
    }
}