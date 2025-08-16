package com.app.whatsappclone.presentation.callsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.whatsappclone.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.TemporalAmount
import java.util.Date

@Composable
@Preview(showSystemUi = true)
fun CallDesign() {

    val isMultiple = true
    val isOutgoing = false
    val isMissed = true
    val dateTime = LocalDateTime.of(2025, 8, 15, 21, 0, 0)
    val isVideo = false

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(R.drawable.profile_placeholder),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .clickable(enabled = true, onClick = {}),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(start = 10.dp).align(Alignment.CenterVertically)) {
            Row() {
                Text(
                    text = "Name",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    color = if (isMissed) Color.Red else Color.Black
                )
                if (isMultiple) {
                    Text(
                        "(" + "Multiple" + ")", modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 6.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1,
                        color = if (isMissed) Color.Red else Color.Black
                    )
                }
            }
            Row {
                if (isOutgoing) {
                    Icon(
                        Icons.AutoMirrored.Default.ArrowForward,
                        contentDescription = "Call Sign",
                        Modifier.rotate(-45f),
                        tint = colorResource(R.color.light_green)
                    )
                } else {
                    Icon(
                        Icons.AutoMirrored.Default.ArrowForward,
                        contentDescription = "Call Sign",
                        Modifier.rotate(135f),
                        tint = Color.Red
                    )
                }
                var dateText = ""
                if (LocalDateTime.now().month == dateTime.month && LocalDateTime.now().year == dateTime.year) {
                    if (LocalDateTime.now().dayOfMonth == dateTime.dayOfMonth) {
                        dateText = "Today"
                    } else if (LocalDateTime.now().dayOfMonth - dateTime.dayOfMonth == 1) {
                        dateText = "Yesterday"
                    }
                } else {
                    dateText = dateTime.month.toString() + " " + dateTime.dayOfMonth.toString()
                }
                dateText += ", " + if (dateTime.hour >= 12) dateTime.hour - 12 else dateTime.hour
                dateText += ":" + dateTime.minute.toString()
                dateText += " " + if (dateTime.hour >= 12) "PM" else "AM"

                Text(
                    text = dateText,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
        Spacer(modifier = Modifier.width(140.dp))
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            if (isVideo) {
                Icon(
                    painter = painterResource(R.drawable.videocall_icon),
                    contentDescription = "Calling Icon",
                    modifier = Modifier.size(20.dp)
                )
            }
            else
            {
                Icon(
                    painter = painterResource(R.drawable.outline_phone_24),
                    contentDescription = "Calling Icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
