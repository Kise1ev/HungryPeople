package ru.kiselev.app.hungrypeople

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kiselev.app.hungrypeople.helpers.DateTimeHelper.getCurrentDate
import ru.kiselev.app.hungrypeople.helpers.DateTimeHelper.getCurrentTime
import ru.kiselev.app.hungrypeople.helpers.Validator.isValidEmail
import ru.kiselev.app.hungrypeople.helpers.Validator.isValidPeopleCount
import ru.kiselev.app.hungrypeople.helpers.Validator.isValidPhone
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class BookATableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BookATableScreen()
        }
    }

    @Composable
    fun BookATableScreen() {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var people by remember { mutableStateOf("") }
        var date by remember { mutableStateOf(getCurrentDate()) }
        var time by remember { mutableStateOf(getCurrentTime()) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Header()
                Spacer(modifier = Modifier.height(20.dp))
                InputFields(name, email, phone, people, date, time) { newName, newEmail, newPhone, newPeople, newDate, newTime ->
                    name = newName
                    email = newEmail
                    phone = newPhone
                    people = newPeople
                    date = newDate
                    time = newTime
                }
                Spacer(modifier = Modifier.height(30.dp))
                BookButton {
                    createBook(name, email, phone, people, date, time)
                }
                Spacer(modifier = Modifier.height(30.dp))
                WorkingHoursInfo()
            }
        }
    }

    @Composable
    fun Header() {
        Image(
            painter = painterResource(id = R.drawable.ic_anchor),
            contentDescription = "Anchor Icon",
            modifier = Modifier.size(170.dp)
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
    }

    @Composable
    fun InputFields(
        name: String,
        email: String,
        phone: String,
        people: String,
        date: String,
        time: String,
        onValueChange: (String, String, String, String, String, String) -> Unit
    ) {
        Row {
            CustomTextField(
                value = name,
                onValueChange = { onValueChange(it, email, phone, people, date, time) },
                label = "Name",
                placeholder = "Dmitry"
            )
            Spacer(modifier = Modifier.width(20.dp))
            CustomTextField(
                value = email,
                onValueChange = { onValueChange(name, it, phone, people, date, time) },
                label = "Email",
                placeholder = "example@mail.ru",
                isValid = isValidEmail(email),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            CustomTextField(
                value = phone,
                onValueChange = { onValueChange(name, email, it, people, date, time) },
                label = "Phone",
                placeholder = "+7-999-999-99-99",
                isValid = isValidPhone(phone),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )
            Spacer(modifier = Modifier.width(20.dp))
            CustomTextField(
                value = people,
                onValueChange = { onValueChange(name, email, phone, it, date, time) },
                label = "People",
                placeholder = "4",
                isValid = isValidPeopleCount(people),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            DatePickerField(
                value = date,
                onValueChange = { onValueChange(name, email, phone, people, it, time) }
            )
            Spacer(modifier = Modifier.width(20.dp))
            TimePickerField(
                value = time,
                onValueChange = { onValueChange(name, email, phone, people, date, it) }
            )
        }
    }

    @Composable
    fun BookButton(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.bright_yellow)),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.size(width = 400.dp, height = 60.dp)
        ) {
            Text(
                text = "BOOK NOW",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun WorkingHoursInfo() {
        Text(
            text = "Mon - Fri: 8PM - 10PM\nSat - Sun: 8PM - 3AM\nPhone: +40 729 131 637/+40 726 458 782",
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }

    @Composable
    fun CustomTextField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        placeholder: String,
        isValid: Boolean = true,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            label = {
                Text(
                    text = label,
                    color = colorResource(id = R.color.dark_gray)
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
                    color = colorResource(id = R.color.dark_gray)
                )
            },
            singleLine = true,
            modifier = Modifier.width(170.dp),
            keyboardOptions = keyboardOptions,
            isError = !isValid
        )
    }

    @Composable
    fun DatePickerField(
        value: String,
        onValueChange: (String) -> Unit
    ) {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()

        OutlinedTextField(
            value = value,
            onValueChange = { },
            label = {
                Text(
                    text = "Date",
                    color = colorResource(id = R.color.dark_gray)
                )
            },
            modifier = Modifier.width(170.dp),
            readOnly = true,
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "Calendar Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp)
                        .clickable {
                            val datePicker = DatePickerDialog(
                                context,
                                { _, year, month, dayOfMonth ->
                                    onValueChange("$dayOfMonth/${month + 1}/$year")
                                },
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH)
                            )
                            datePicker.show()
                        }
                )
            }
        )
    }

    @Composable
    fun TimePickerField(
        value: String,
        onValueChange: (String) -> Unit
    ) {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()

        val validateWorkingHours: (Int, Int) -> Boolean = { dayOfWeek, hour ->
            when (dayOfWeek) {
                Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY,
                Calendar.THURSDAY, Calendar.FRIDAY -> {
                    hour in 20..21
                }
                Calendar.SATURDAY -> {
                    hour in 20..23 || hour in 0..2
                }
                Calendar.SUNDAY -> {
                    hour in 0..2 || hour in 20..23
                }
                else -> false
            }
        }

        OutlinedTextField(
            value = value,
            onValueChange = { },
            label = {
                Text(
                    text = "Time",
                    color = colorResource(id = R.color.dark_gray)
                )
            },
            modifier = Modifier.width(170.dp),
            singleLine = true,
            readOnly = true,
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "Clock Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp)
                        .clickable {
                            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
                            val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

                            val timePicker = TimePickerDialog(
                                context,
                                { _, hourOfDay, _ ->
                                    if (validateWorkingHours(currentDayOfWeek, hourOfDay)) {
                                        onValueChange(
                                            String.format(
                                                Locale.getDefault(),
                                                "%02d:00",
                                                hourOfDay
                                            )
                                        )
                                    } else {
                                        Toast
                                            .makeText(
                                                context,
                                                "Selected time is not included in working hours!",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                    }
                                },
                                currentHour,
                                0,
                                true
                            )

                            timePicker.show()
                        }
                )
            }
        )
    }

    private fun createBook(name: String, email: String, phone: String, people: String, date: String, time: String) {
        if (name.isEmpty()) {
            sendToast(
                "Please, enter your name!",
                0
            )
            return
        }

        if (!isValidEmail(email)) {
            sendToast(
                "Please, enter your email!",
                0
            )
            return
        }

        if (!isValidPhone(phone)) {
            sendToast(
                "Please, enter your phone!",
                0
            )
            return
        }

        if (isValidPeopleCount(people)) {
            sendToast(
                "Please, enter people count!",
                0
            )
            return
        }


        sendToast(
            "Booking successful for $people people on $date at $time!",
            1
        )
        finish()
    }

    private fun sendToast(text: String, toast: Int) {
        Toast.makeText(
            this,
            text,
            toast
        ).show()
    }
}