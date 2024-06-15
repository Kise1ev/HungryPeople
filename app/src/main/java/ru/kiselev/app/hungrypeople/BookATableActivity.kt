package ru.kiselev.app.hungrypeople

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BookATableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BookATableScreen()
        }
    }

    data class ReservationFormData(
        var name: String = "",
        var email: String = "",
        var phone: String = "",
        var people: String = "",
        var date: String = "",
        var time: String = ""
    )

    @Preview(showBackground = true)
    @Composable
    fun BookATableScreen() {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var people by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var time by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_anchor),
                    contentDescription = "Anchor Icon",
                    modifier = Modifier
                        .size(150.dp)
                )

                Text(
                    text = "BOOK A TABLE",
                    textAlign = TextAlign.Center,
                    fontSize = 60.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans_regular))
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(10.dp)
                        .clip(RoundedCornerShape(50))
                        .background(colorResource(id = R.color.bright_yellow))
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        singleLine = true,
                        label = {
                            Text(
                                text = "Name",
                                color = colorResource(id = R.color.dark_gray)
                            )
                        },
                        modifier = Modifier.width(200.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        singleLine = true,
                        label = {
                            Text(
                                text = "Email",
                                color = colorResource(id = R.color.dark_gray)
                            )
                        },
                        modifier = Modifier.width(200.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        singleLine = true,
                        label = {
                            Text(
                                text = "Phone",
                                color = colorResource(id = R.color.dark_gray)
                            )
                        },
                        modifier = Modifier.width(200.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    OutlinedTextField(
                        value = people,
                        onValueChange = { people = it },
                        singleLine = true,
                        label = {
                            Text(
                                text = "People",
                                color = colorResource(id = R.color.dark_gray)
                            )
                        },
                        modifier = Modifier.width(200.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    OutlinedTextField(
                        value = date,
                        onValueChange = { date = it },
                        singleLine = true,
                        label = {
                            Text(
                                text = "Date",
                                color = colorResource(id = R.color.dark_gray)
                            )
                        },
                        modifier = Modifier.width(200.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    OutlinedTextField(
                        value = time,
                        onValueChange = { time = it },
                        singleLine = true,
                        label = {
                            Text(
                                text = "Time",
                                color = colorResource(id = R.color.dark_gray)
                            )
                        },
                        modifier = Modifier.width(200.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(onClick = {
                },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.bright_yellow)),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .size(width = 400.dp, height = 60.dp)) {
                    Text(
                        text = "BOOK NOW",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Mon - Fri: 8PM - 10PM\nSat - Sun: 8PM - 3AM\nPhone: +40 729 131 637/+40 726 458 782",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
        }
    }
}