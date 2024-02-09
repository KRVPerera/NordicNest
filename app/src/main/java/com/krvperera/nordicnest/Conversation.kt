package com.krvperera.nordicnest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import com.krvperera.nordicnest.ui.theme.NordicNestTheme

// This is from https://www.youtube.com/watch?v=1ANt65eoNhQ&t=266s
object TopWithFooter : Arrangement.Vertical {
    override fun Density.arrange(totalSize: Int, sizes: IntArray, outPositions: IntArray) {
        var y = 0;
        sizes.forEachIndexed { index, size ->
            outPositions[index] = y
            y += size
        }
        if (y < totalSize) {
            val lastIndex = outPositions.lastIndex
            outPositions[lastIndex-1] = totalSize - sizes.last()
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn (
        modifier = Modifier.fillMaxSize(0.9f),
        verticalArrangement = TopWithFooter
    ) {
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