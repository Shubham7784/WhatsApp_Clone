package com.app.whatsappclone.presentation.communityScreen

import com.app.whatsappclone.presentation.chatListDesign.ChatListModel

data class CommunityModel(
    val communityImage : Int,
    val communityName : String,
    val announcementModel: AnnouncementModel,
    val groupModel : ArrayList<ChatListModel>
)