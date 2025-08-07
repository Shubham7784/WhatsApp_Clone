package com.app.whatsappclone.presentation.welcomeScreen

import android.R.attr.onClick
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.whatsappclone.R
@Composable
@Preview(showSystemUi = true)
fun welcomScreen()
{
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.whatsapp_sticker), contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        Text(text = "Welcome To WhatsApp", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "Read our", color = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Privacy Policy", color = Color.Blue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Tap 'Agree and Continue' to", color = Color.Gray)
        }
        Row {
            Text(text = "accept the", color = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Term of Services ", color = Color.Blue)
        }

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {/*TODO*/},
            modifier = Modifier.size(300.dp,50.dp)
                .padding(5.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.dark_green),
                contentColor = Color.White )
            )
        {
            Text(text = "Agree and Continue", fontSize = 16.sp)
        }
    }
}