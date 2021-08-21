package com.example.dencheck2.network

data class ClansItem(
    val club_profile_pic: String,
    val club_name: String,
    val club_id: Int,
    val pn_channel_id: String,
    val club_members: String,
    val frame_total: Int,
    val ongoing_frame: Boolean,
    val start_time: String,
    val end_time: String,
    val display_photos: List<DisplayPhotos>
)

data class DisplayPhotos(
    val user_id: Int,
    val display_pic: String
)