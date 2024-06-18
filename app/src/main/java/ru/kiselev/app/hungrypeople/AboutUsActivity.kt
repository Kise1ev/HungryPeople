package ru.kiselev.app.hungrypeople

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import ru.kiselev.app.hungrypeople.data.ProductData
import ru.kiselev.app.hungrypeople.models.Product
import ru.kiselev.app.hungrypeople.models.Speciality
import kotlin.math.absoluteValue

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
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp + 100.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AboutUsSection(screenHeight)
            OurTeamSection(screenHeight)
            DeliciousMenuSection(screenHeight)
            SpecialitiesSection(screenHeight)
            GallerySection(screenHeight)
            PrivateEventsSection(screenHeight)
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

                BodyText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at velit maximus, molestie est a, tempor magna.",
                    fontWeight = FontWeight.Bold
                )

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
    fun OurTeamSection(screenHeight: Dp) {
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
                        text = "OUR TEAM",
                        fontSize = 60,
                        textColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    ColoredBox()

                    Spacer(modifier = Modifier.height(20.dp))

                    BodyText(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at velit maximus, molestie est a, tempor magna.",
                        textColor = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    BodyText(
                        text = "Integer ullamcorper neque eu purus euismod, ac faucibus mauris posuere. Morbi non ultrices ligula. Sed dictum, enim sed ullamcorper feugiat, dui odio vehicula eros, a sollicitudin lorem quam nec sem. Mauris tincidunt feugiat diam convallis pharetra. Nulla facilisis semper laoreet.",
                        textColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_our_team),
                        contentDescription = "Master Chief Container Image",
                        modifier = Modifier.size(400.dp)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun SpecialitiesSection(screenHeight: Dp) {
        val specialities = listOf(
            Speciality(
                imageResId = R.drawable.img_speciality,
                title = "VANILLA PANCAKES",
                description = "Delicious vanilla flavored pancakes served with fresh berries and a drizzle of maple syrup."
            ),
            Speciality(
                imageResId = R.drawable.img_speciality,
                title = "CHOCOLATE PANCAKES",
                description = "Rich chocolate pancakes topped with whipped cream and chocolate shavings."
            ),
            Speciality(
                imageResId = R.drawable.img_speciality,
                title = "HAZELNUT PANCAKES",
                description = "Pancakes infused with hazelnut flavor, served with a dollop of hazelnut spread."
            )
        )

        val pagerState = rememberPagerState()
        var selectedImage: Speciality? by remember { mutableStateOf(null) }
        var showDialog by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(screenHeight)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_slider),
                contentDescription = "Slider Container Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconWithText(
                        imageResId = 0,
                        text = "SPECIALITIES",
                        fontSize = 50,
                        textColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    ColoredBox()

                    Spacer(modifier = Modifier.height(20.dp))

                    HorizontalPager(
                        count = specialities.size,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp)
                            .background(Color.Black.copy(alpha = 0.5f)),
                        state = pagerState
                    ) { page ->
                        val imageWithText = specialities[page]

                        Box(
                            modifier = Modifier
                                .graphicsLayer {
                                    val pageOffset =
                                        calculateCurrentOffsetForPage(page).absoluteValue
                                    alpha = 1f - pageOffset.coerceIn(0f, 1f)
                                    translationX = pageOffset * 100f
                                }
                                .clickable {
                                    selectedImage = imageWithText
                                    showDialog = true
                                }
                                .pointerInput(Unit) {
                                    detectTapGestures {
                                        selectedImage = imageWithText
                                        showDialog = true
                                    }
                                }
                        ) {
                            PulseAnimation {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = imageWithText.imageResId),
                                        contentDescription = "Gallery Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = imageWithText.title,
                                        textAlign = TextAlign.Center,
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontFamily = FontFamily(Font(R.font.tenorsans_regular)),
                                        modifier = Modifier.padding(horizontal = 16.dp)
                                    )
                                }
                            }
                        }
                    }

                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                        activeColor = Color.White,
                        inactiveColor = Color.Gray,
                        indicatorWidth = 16.dp,
                        indicatorHeight = 16.dp,
                        spacing = 16.dp
                    )
                }

                AnimatedVisibility(
                    visible = showDialog && selectedImage != null,
                    enter = fadeIn() + expandIn(),
                    exit = fadeOut() + shrinkOut()
                ) {
                    ImageDialog(
                        speciality = selectedImage!!,
                        onClose = { showDialog = false }
                    )
                }
            }
        }
    }

    @Composable
    fun PulseAnimation(content: @Composable () -> Unit) {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val scale by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )

        Box(
            modifier = Modifier.scale(scale)
        ) {
            content()
        }
    }

    @Composable
    fun ImageDialog(speciality: Speciality, onClose: () -> Unit) {
        var showDialog by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.8f))
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = speciality.imageResId),
                    contentDescription = "Selected Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp)
                        .clickable { showDialog = false }
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = speciality.description,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))

                CustomButton(
                    text = "CLOSE",
                    backgroundColor = Color.Transparent,
                    textColor = Color.White,
                    border = BorderStroke(2.dp, Color.White)
                ) {
                    onClose()
                }
            }
        }
    }

    @Composable
    fun DeliciousMenuSection(screenHeight: Dp) {
        var selectedCategory by remember { mutableStateOf<String?>(null) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(screenHeight),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                IconWithText(
                    imageResId = 0,
                    text = "DELICIOUS MENU",
                    fontSize = 50,
                    textColor = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                ColoredBox()

                Spacer(modifier = Modifier.height(20.dp))

                BodyText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at velit maximus, molestie est a, tempor magna.",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomButton(
                        text = "SOUPE",
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black,
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        selectedCategory = "SOUPE"
                    }

                    CustomButton(
                        text = "PIZZA",
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black,
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        selectedCategory = "PIZZA"
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomButton(
                        text = "PASTA",
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black,
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        selectedCategory = "PASTA"
                    }

                    CustomButton(
                        text = "DESERT",
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black,
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        selectedCategory = "DESERT"
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomButton(
                        text = "WINE",
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black,
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        selectedCategory = "WINE"
                    }

                    CustomButton(
                        text = "BEER",
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black,
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        selectedCategory = "BEER"
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomButton(
                    text = "DRINKS",
                    backgroundColor = Color.Transparent,
                    textColor = Color.Black,
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    selectedCategory = "DRINKS"
                }
            }

            AnimatedVisibility(
                visible = selectedCategory != null,
                enter = fadeIn() + expandIn(),
                exit = fadeOut() + shrinkOut()
            ) {
                selectedCategory?.let { category ->
                    val products = ProductData.productsByCategory[category] ?: emptyList()
                    ProductDialog(
                        selectedCategory = category,
                        products = products,
                        onClose = { selectedCategory = null }
                    )
                }
            }
        }
    }

    @Composable
    fun ProductDialog(selectedCategory: String, products: List<Product>, onClose: () -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.8f))
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                IconWithText(
                    imageResId = 0,
                    text = selectedCategory,
                    fontSize = 60,
                    textColor = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                ColoredBox()

                Spacer(modifier = Modifier.height(20.dp))

                products.forEach { product ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = product.title,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Price: ${product.price}",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = product.description,
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                CustomButton(
                    text = "CLOSE",
                    backgroundColor = Color.Transparent,
                    textColor = Color.White,
                    border = BorderStroke(2.dp, Color.White)
                ) {
                    onClose()
                }
            }
        }
    }

    @Composable
    fun PrivateEventsSection(screenHeight: Dp) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(screenHeight)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_slider),
                contentDescription = "Private Events Container Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconWithText(
                        imageResId = 0,
                        text = "PRIVATE EVENTS",
                        fontSize = 60,
                        textColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    ColoredBox()

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_private_events_1),
                        contentDescription = "First Private Events Container Image",
                        modifier = Modifier.size(350.dp)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_private_events_2),
                        contentDescription = "Second Private Events Container Image",
                        modifier = Modifier.size(350.dp)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun GallerySection(screenHeight: Dp) {
        val images = listOf(
            R.drawable.img_slider_1,
            R.drawable.img_slider_2,
            R.drawable.img_slider_3,
            R.drawable.img_slider_4
        )
        val pagerState = rememberPagerState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(screenHeight)
                .background(Brush.verticalGradient(listOf(Color.DarkGray, Color.White))),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                IconWithText(
                    imageResId = 0,
                    text = "GALLERY",
                    fontSize = 60,
                    textColor = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                ColoredBox()

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalPager(
                    count = images.size,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Brush.verticalGradient(listOf(Color.White, Color.DarkGray))),
                    state = pagerState
                ) { page ->
                    val image = images[page]

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .shadow(elevation = 12.dp, shape = RoundedCornerShape(16.dp))
                    ) {
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "Slider Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp),
                    activeColor = Color.Black,
                    inactiveColor = Color.Gray,
                    indicatorWidth = 16.dp,
                    indicatorHeight = 16.dp,
                    spacing = 16.dp
                )
            }
        }
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
            modifier = Modifier.size(
                width = 150.dp,
                height = 60.dp
            )
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
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
                modifier = Modifier.size(170.dp)
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