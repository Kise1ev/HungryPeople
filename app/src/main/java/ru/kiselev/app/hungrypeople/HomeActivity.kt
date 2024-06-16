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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.layoutId
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            val constraints = ConstraintSet {
                val iconWithText = createRefFor("iconWithText")
                val title = createRefFor("title")
                val coloredBox = createRefFor("coloredBox")
                val timings = createRefFor("timings")
                val buttons = createRefFor("buttons")
                val socialMediaRow = createRefFor("socialMediaRow")
                val downArrow = createRefFor("downArrow")

                constrain(iconWithText) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                constrain(title) {
                    top.linkTo(iconWithText.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                constrain(coloredBox) {
                    top.linkTo(title.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                constrain(timings) {
                    top.linkTo(coloredBox.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                constrain(buttons) {
                    top.linkTo(timings.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                constrain(socialMediaRow) {
                    top.linkTo(buttons.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                constrain(downArrow) {
                    top.linkTo(socialMediaRow.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            }

            ConstraintLayout(
                constraintSet = constraints,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                IconWithText(
                    imageResId = R.drawable.ic_anchor,
                    text = "RESTAURANT",
                    fontSize = 30,
                    textColor = Color.White,
                    modifier = Modifier.layoutId("iconWithText")
                )

                Text(
                    text = "HUNGRY PEOPLE",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 70.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular)),
                    modifier = Modifier.layoutId("title")
                )

                ColoredBox(modifier = Modifier.layoutId("coloredBox"))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.layoutId("timings")
                ) {
                    BodyText("Mon - Fri: 8PM - 10PM", textColor = Color.White)

                    Spacer(modifier = Modifier.height(5.dp))

                    BodyText("Sat - Sun: 8PM - 3AM", textColor = Color.White)
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.layoutId("buttons")
                ) {
                    CustomButton(
                        text = "BOOK TABLE",
                        backgroundColor = colorResource(id = R.color.bright_yellow),
                        textColor = Color.White
                    ) {
                        context.startActivity(Intent(context, BookATableActivity::class.java))
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    CustomButton(
                        text = "EXPLORE",
                        backgroundColor = Color.Transparent,
                        textColor = Color.White,
                        border = BorderStroke(2.dp, Color.White)
                    ) {
                        // TODO: Add action for Explore button
                    }
                }

                SocialMediaRow(modifier = Modifier.layoutId("socialMediaRow"))

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
                        .layoutId("downArrow")
                )
            }
        }
    }

    @Composable
    fun IconWithText(imageResId: Int, text: String, fontSize: Int, textColor: Color, modifier: Modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Icon",
                modifier = Modifier.size(170.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = text,
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = fontSize.sp,
                fontFamily = FontFamily(Font(R.font.tenorsans_regular))
            )
        }
    }

    @Composable
    fun BodyText(text: String, textColor: Color = Color.Black) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.tenorsans_regular)),
            color = textColor
        )
    }

    @Composable
    fun ColoredBox(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .width(100.dp)
                .height(10.dp)
                .clip(RoundedCornerShape(50))
                .background(colorResource(id = R.color.bright_yellow))
        )
    }

    @Composable
    fun CustomButton(
        text: String,
        backgroundColor: Color,
        textColor: Color,
        border: BorderStroke? = null,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
            shape = RoundedCornerShape(5.dp),
            border = border,
            modifier = Modifier.size(width = 170.dp, height = 60.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun SocialMediaRow(modifier: Modifier = Modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            SocialMediaIcon(R.drawable.btn_facebook)

            Spacer(modifier = Modifier.width(60.dp))

            SocialMediaIcon(R.drawable.btn_twitter)

            Spacer(modifier = Modifier.width(60.dp))

            SocialMediaIcon(R.drawable.btn_instagram)
        }
    }

    @Composable
    fun SocialMediaIcon(iconResId: Int) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
    }
}