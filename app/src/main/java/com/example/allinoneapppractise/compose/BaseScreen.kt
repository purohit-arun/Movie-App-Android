package com.example.allinoneapppractise.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    convertorViewModel: ConvertorViewModel = viewModel()
) {
    val list = convertorViewModel.getConversion()
    Column(
        modifier = modifier.padding(30.dp)
    ) {
        TopScreen(list)
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
    }
}