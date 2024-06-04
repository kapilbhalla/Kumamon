package com.example.kumamon.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class Chat(val message: String, val fromUser: Boolean)

@Composable
fun Conversation(
    modifier: Modifier = Modifier,
    messages: List<Chat>
    ) {
    LazyColumn {
        items(items = messages)  { singleMsg ->
            ChatBubble(singleMsg)
        }
    }
}

@Composable
fun ChatBubble(chat: Chat) {
    val backgroundColor = if (chat.fromUser) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.surface
    val alignment = if (chat.fromUser) Arrangement.End else Arrangement.Start

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = alignment
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = backgroundColor,
            shadowElevation = 4.dp,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = chat.message,
                color = if (chat.fromUser) Color.White else Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}