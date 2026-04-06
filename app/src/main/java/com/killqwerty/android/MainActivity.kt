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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.killqwerty.android.ui.theme.KillqwertyAndroidTheme
import com.killqwerty.android.ui.theme.someTestTextColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KillqwertyAndroidTheme {
                val listOfStr by remember {
                    mutableStateOf(
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
        ) {
            Text(text = item, modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(start = 16.dp), textAlign = TextAlign.Center)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("ебать того рот тайтл",color = MaterialTheme.colorScheme.someTestTextColor)
                Text("ебать того рот описание",color = MaterialTheme.colorScheme.someTestTextColor)
                Button(onClick = {}) {
                    Text("Ебать того рот кнопка")
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = Icons.TwoTone.Favorite,
                        tint = Color(MaterialTheme.colorScheme.someTestTextColor.value),
                        contentDescription = ""
                    )
                    Icon(
                        imageVector = Icons.TwoTone.Favorite,
                        tint = Color(MaterialTheme.colorScheme.someTestTextColor.value),
                        contentDescription = ""
                    )
                    Icon(
                        imageVector = Icons.TwoTone.Favorite,
                        tint = Color(MaterialTheme.colorScheme.someTestTextColor.value),
                        contentDescription = ""
                    )
                    Icon(
                        imageVector = Icons.TwoTone.Favorite,
                        tint = Color(MaterialTheme.colorScheme.someTestTextColor.value),
                        contentDescription = ""
                    )
                    Icon(
                        imageVector = Icons.TwoTone.Favorite,
                        tint = Color(MaterialTheme.colorScheme.someTestTextColor.value),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KillqwertyAndroidTheme(darkTheme = false) {
        ListItems(listOf("1"), Modifier)
    }
}