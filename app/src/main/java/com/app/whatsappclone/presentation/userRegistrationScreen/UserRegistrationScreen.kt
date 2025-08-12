package com.app.whatsappclone.presentation.userRegistrationScreen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.whatsappclone.R
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun userRegistrationScreen()
{
    var expanded = remember { mutableStateOf(false) }
    var selectedCountry = remember { mutableStateOf("India") }
    var countryCode = remember { mutableStateOf("+91") }
    var phoneNumber = remember { mutableStateOf("") }

    val countryCodeMap = mapOf(
        "India" to "+91",
        "United States" to "+1",
        "United Kingdom" to "+44",
        "Canada" to "+1",
        "Australia" to "+61",
        "Germany" to "+49",
        "France" to "+33",
        "Japan" to "+81",
        "China" to "+86",
        "Brazil" to "+55",
        "South Africa" to "+27",
        "Russia" to "+7",
        "Mexico" to "+52",
        "Italy" to "+39",
        "Spain" to "+34"
    )
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Enter your Phone Number", fontSize = 20.sp, modifier = Modifier.padding(16.dp),
            color = colorResource(id = R.color.dark_green),
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(14.dp))

        Text(text = "WhatsApp will need to verify your phone number", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "What's my number?", fontSize = 14.sp, color = colorResource(id = R.color.dark_green))

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {expanded.value = true}, modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.width(230.dp)){
                Text(text = selectedCountry.value,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 16.sp,
                    color = Color.Black)

                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    tint = colorResource(id = R.color.light_green))
            }
        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 66.dp),
            thickness = 2.dp,
            color = colorResource(R.color.dark_green))

        DropdownMenu(expanded = expanded.value, onDismissRequest = {expanded.value = false},
            modifier = Modifier.width(230.dp)
                .align(Alignment.CenterHorizontally)){
            countryCodeMap.keys.forEach {
                country ->
                DropdownMenuItem(text = {
                    Text(text = country)
                }, onClick = {selectedCountry.value = country
                    countryCode.value = countryCodeMap[country] ?: "+91"
                    expanded.value = false
                })
            }
        }

        Column(modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row {
                TextField(value = countryCode.value, onValueChange = {},
                    modifier = Modifier.width(70.dp), singleLine = true,
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = colorResource(R.color.light_green),
                        focusedIndicatorColor = colorResource(R.color.light_green)
                    )
                )
                TextField(value = phoneNumber.value, onValueChange =
                {
                    phoneNumber.value = it
                },
                    placeholder = {Text(text = "Phone Number")},
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = colorResource(R.color.light_green),
                        focusedIndicatorColor = colorResource(R.color.light_green)))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text="Carrier charges may apply", fontSize = 14.sp,color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))

            Spacer(modifier = Modifier.height(26.dp))

            Button(onClick = {}, shape = RoundedCornerShape(6.dp), colors = ButtonDefaults.buttonColors(colorResource(R.color.dark_green))) {
                Text(text = "Next", fontSize = 16.sp)
            }
        }
    }

}