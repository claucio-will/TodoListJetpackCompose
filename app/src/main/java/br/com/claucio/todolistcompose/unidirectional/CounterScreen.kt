package br.com.claucio.todolistcompose.unidirectional

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {

    //Essa é variavél que tem o estado atual do contador
    val count by viewModel.count.collectAsState()

    CounterView(count = count, onIncrement = {viewModel.increment()},onDecrement = {viewModel.decrement()})


}

@Composable
fun CounterView(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Count: $count")
        Row {
            Button(onClick = onIncrement) {
                Text("Increment")
            }
            Button(onClick = onDecrement) {
                Text("Decrement")
            }
        }
    }
}