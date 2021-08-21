package com.example.dencheck2.network

import com.squareup.moshi.Json

data class UserDetailsObject(
    val user : User,
    val bio : String,
    val image : String,
    val id : Int
)

data class User (

    val username : String,
    val phone : Int,
    val full_name : String,
    val id : Int,
    val clubs_joined_by_user : String,
    val number_of_clubs_joined : Int,
    val contact_list : String,
    val total_frames_participation : Int,
    val country_code_of_user : String,
    val contact_list_sync_status : Boolean
)

//{
//    "user": {
//    "username": "Ag209",
//    "phone": "+918130491283",
//    "full_name": "Ananya Garg",
//    "id": 83,
//    "clubs_joined_by_user": "77,80",
//    "number_of_clubs_joined": 2,
//    "contact_list": "",
//    "total_frames_participation": 15,
//    "country_code_of_user": "IN",
//    "contact_list_sync_status": false
//},
//    "bio": "blahed",
//    "image": "https://aye-media-bucket.s3.amazonaws.com/media/profile_pics/photo_2021-07-13_22.43.37.jpeg",
//    "id": 85
//}