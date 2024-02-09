package com.krvperera.nordicnest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.krvperera.nordicnest.ui.theme.NordicNestTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn (modifier = Modifier.fillMaxSize(0.9f)) {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    NordicNestTheme {
        Conversation(SampleData.conversationSample)
    }
}