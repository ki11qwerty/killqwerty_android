package com.killqwerty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.killqwerty.android.ui.theme.KillqwertyAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KillqwertyAndroidTheme {
                val listOfStr = remember {
                    listOf<String>(
                        "A",
                        "B",
                        "C",
                        "D",
                        "F",
                        "G",
                        "H",
                        "I",
                        "Q",
                        "R",
                        "A",
                        "B",
                        "C",
                        "D",
                        "F",
                        "G",
                        "H",
                        "I",
                        "Q",
                        "R",
                        "A",
                        "B",
                        "C",
                        "D",
                        "F",
                        "G",
                        "H",
                        "I",
                        "Q",
                        "R"
                    )
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListItems(listOfStr, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListItems(list: List<String>, modifier: Modifier) {
    LazyColumn(modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list) { item ->
            Item(item)
        }
    }
}

@Composable
fun Item(item: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(100.dp),
        ) {
            Text(text = item, modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 16.dp), textAlign = TextAlign.Center)
            Column() {
                Text("ебать того рот тайтл")
                Text("ебать того рот описание")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KillqwertyAndroidTheme {
        ListItems(listOf("1"), Modifier)
    }
}