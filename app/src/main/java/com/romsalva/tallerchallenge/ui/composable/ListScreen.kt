package com.romsalva.tallerchallenge.ui.composable

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romsalva.tallerchallenge.ui.stateholder.Item
import com.romsalva.tallerchallenge.ui.stateholder.ListViewModel
import com.romsalva.tallerchallenge.ui.theme.TallerChallengeTheme

@Composable
fun ListScreen(
    viewModel: ListViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    ListScreen(
        items = uiState.items,
        { Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show() },
        modifier = modifier
    )
}

@Composable
fun ListScreen(
    items: List<Item>,
    onItemClicked: (Item) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(items) {
                ListItem(it.title, it.description, { onItemClicked(it) })
            }
        }
    }
}

@Composable
fun ListItem(
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .clickable { onClick() }) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewListScreen() {
    TallerChallengeTheme {
        ListScreen(
            items = (1..5).map { Item(it, "Title $it", "Description $it") },
            onItemClicked = {}
        )
    }
}