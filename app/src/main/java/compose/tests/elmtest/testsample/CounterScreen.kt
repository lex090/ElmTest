package compose.tests.elmtest.testsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterScreen(
    counterStore: CounterStore,
) {
    val counterState by counterStore.state.collectAsState()
    val effects by counterStore.effects.collectAsState()

    if (effects is CounterEffect.ShowGracia) {
        Snackbar {
            Text("ShowGracia!")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter ${counterState.count}")
        Row {
            Button(onClick = { counterStore.dispatch(CounterEvent.UI.Inc) }) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.size(4.dp))
            Button(onClick = { counterStore.dispatch(CounterEvent.UI.Dec) }) {
                Text(text = "-")
            }
        }
    }
}