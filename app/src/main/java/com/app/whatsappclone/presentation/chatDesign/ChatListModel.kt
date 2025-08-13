package com.app.whatsappclone.presentation.chatDesign

data class ChatListModel(
    val image: Int,
    val name : String,
    val time : String,
    val message : String,
    val isUnread : Boolean,
    val unreadCount : Int,
    val isMuted : Boolean = false
)