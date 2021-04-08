package com.example.kotlinyoutubelbta

// Models after https://api.letsbuildthatapp.com/youtube/home_feed
// Snippet from the API:
// "id": 1,
// "name": "Instagram Firebase - Learn How to Create Users, Follow, and Send Push Notifications",
// "link": "https://www.letsbuildthatapp.com/course/instagram-firebase",
// "imageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/04782e30-d72a-4917-9d7a-c862226e0a93",
// "channel": {
//   "name": "Lets Build That App",
//   "profileimageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf",
//   "numberOfSubscribers": 100000
// }
//


class HomeFeed(val videos: List<Video>)

class Video(
    val id: Int,
    val name: String,
    val link: String,
    val imageUrl: String,
    val numberOfViews: Int,
    val channel: Channel
)

class Channel(
    val name: String,
    val profileimageUrl: String // the i in image has to be lowercase so it matches the variable name in the API
)

class CourseLesson(
    val name: String,
    val number: Int,
    val duration: String,
    val imageUrl: String,
    val link: String
)