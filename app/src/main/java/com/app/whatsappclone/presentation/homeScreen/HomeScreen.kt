package com.app.whatsappclone.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.whatsappclone.R
import com.app.whatsappclone.presentation.bottomNavigation.BottomNavigation
import com.app.whatsappclone.presentation.chatDesign.ChatDesign
import com.app.whatsappclone.presentation.chatDesign.ChatListModel
import kotlinx.serialization.builtins.serializer

@Composable
@Preview(showSystemUi = true)
fun HomeScreen()
{
    val chatData = listOf(ChatListModel(R.drawable.salman_khan,"Salman Bhoi","10:00 AM","Hello"),
        ChatListModel(R.drawable.sharukh_khan,"Shahrukh Bhoi","01:00 AM","Kyaa haal hai ?"),
        ChatListModel(R.drawable.ajay_devgn,"Ajay Devgan","07:00 PM","Bolo zubaan kesri"),
        ChatListModel(R.drawable.akshay_kumar,"Akshay Kumar","05:00 AM","Aaaeeee"),
        ChatListModel(R.drawable.carryminati,"Carry Bhai","02:00 AM","To kaise hai aap log ?"),
        ChatListModel(R.drawable.hrithik_roshan,"Hritik Roshan","06:30 PM","Aaila Jaadu"))

    var searchText = remember { mutableStateOf("Ask Meta AI or Search") }

    var moreExpanded = remember { mutableStateOf(false) }

    var moreSelectedOption = remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = {},
                    modifier = Modifier.size(55.dp)
                        .align(Alignment.CenterHorizontally)) {
                    Image(painter = painterResource(R.drawable.meta_ai_logo),contentDescription = null,
                        modifier = Modifier.size(40.dp))
                }
                Spacer(modifier = Modifier.height(18.dp))
                FloatingActionButton(onClick = {},
                    containerColor = colorResource(R.color.light_green),
                    modifier = Modifier.size(65.dp)
                )
                {
                    Icon(painter = painterResource(R.drawable.chat_icon), contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                            .size(30.dp),
                        tint = colorResource(R.color.white)
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigation()
        }
    )
    {
        Column(modifier = Modifier.padding(it)) {
            Box(modifier = Modifier.fillMaxWidth())
            {
                Text(text = "WhatsApp", fontSize = 26.sp,
                    color = colorResource(R.color.light_green),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                        .align(Alignment.CenterStart))

                Row(modifier = Modifier.align(Alignment.CenterEnd)) {

                    Icon(painter = painterResource(R.drawable.qr_scanner),contentDescription = null,
                        modifier = Modifier.size(30.dp))

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(painter = painterResource(R.drawable.camera),contentDescription = null,
                        modifier = Modifier.size(26.dp))

                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {moreExpanded.value = true},
                        modifier = Modifier.size(26.dp)) {
                        Icon(painter = painterResource(R.drawable.more),contentDescription = "More")
                        DropdownMenu(expanded = moreExpanded.value, onDismissRequest = {moreExpanded.value = false}) {
                            listOf("New group","New community","New broadcast","Linked devices","Starred","Payments","Settings").forEach { option ->
                                DropdownMenuItem(text = {
                                    Text(text = option)
                                }, onClick = {
                                    moreExpanded.value = false
                                    moreSelectedOption.value = option
                                })
                            }
                        }
                    }


                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(4.dp))

            Column {
                WhatsAppSearchBar(
                    query = searchText.value,
                    onQueryChange = {searchText.value = it}
                )
            }

            LazyColumn {
                items(chatData){
                    ChatDesign(chatListModel = it)
                }
            }

        }
    }
}