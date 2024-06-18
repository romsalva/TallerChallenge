package com.romsalva.tallerchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.romsalva.tallerchallenge.ui.composable.ListScreen
import com.romsalva.tallerchallenge.ui.stateholder.ListViewModel
import com.romsalva.tallerchallenge.ui.theme.TallerChallengeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TallerChallengeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val viewModel by viewModels<ListViewModel>()
                    ListScreen(
                        viewModel,
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}